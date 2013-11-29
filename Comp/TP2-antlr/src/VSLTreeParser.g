tree grammar VSLTreeParser;

options {
  language     = Java;
  tokenVocab   = VSLParser;
  ASTLabelType = CommonTree;
}

s [SymbolTable symTab] returns [Code3a code]
  : e=function[symTab] { code = e; }
  ;

expression [SymbolTable symTab] returns [ExpAttribute expAtt]
  : ^(PLUS e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, e1, e2, temp);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
  | ^(MINUS e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, e1, e2, temp);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
  | ^(MUL e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, e1, e2, temp);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
  | ^(DIV e1=expression[symTab] e2=expression[symTab]) 
    {
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, e1, e2, temp);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
  | pe=primary_exp[symTab] 
    { expAtt = pe; }
  ;
  
statement [SymbolTable symTab] returns [Code3a cod]
  : ^(ASSIGN_KW e=expression[symTab] IDENT) 
    { 
      Type ty = e.type;
      Operand3a id = symTab.lookup($IDENT.text);
      cod = e.code;
      cod.append(new Code3a(new Inst3a(Inst3a.TAC.COPY, id, e.place, null)));
    }
   | ^(IF_KW e=expression[symTab]  s1=statement[symTab] ( s2=statement[symTab])? )
    {
      cod=e.code;
      LabelSymbol labelElse = SymbDistrib.newLabel();
      cod.append(new Inst3a(Inst3a.TAC.IFZ,e.place,labelElse,null));
      cod.append(s1);
      LabelSymbol labelFinIf = SymbDistrib.newLabel();
      cod.append(new Inst3a(Inst3a.TAC.GOTO,labelFinIf,null,null));
      cod.append(new Inst3a(Inst3a.TAC.LABEL,labelElse,null,null));
      cod.append(s2);
      cod.append(new Inst3a(Inst3a.TAC.LABEL,labelFinIf,null,null));
    }
   | ^(WHILE_KW e=expression[symTab] st=statement[symTab])
    {
     LabelSymbol labelInWhile = SymbDistrib.newLabel();
     cod = new Code3a(new Inst3a(Inst3a.TAC.LABEL,labelInWhile,null,null));
     cod.append(e.code);
     LabelSymbol labelEndWhile = SymbDistrib.newLabel();
     cod.append(new Inst3a(Inst3a.TAC.IFZ,e.place,labelEndWhile,null));
     cod.append(st);
     cod.append(new Inst3a(Inst3a.TAC.GOTO,labelInWhile,null,null));
     cod.append(new Inst3a(Inst3a.TAC.LABEL,labelEndWhile,null,null));
    }
    |b=block[symTab] 
     {cod=b;}
  ;
  
type returns [FunctionType ty]
    : INT_KW {
    	ty=new FunctionType(Type.INT);
    	}
    | VOID_KW {
    	ty=new FunctionType(Type.VOID);
    	}
    ;
  
param[SymbolTable symTab] returns [Code3a cod]
    : IDENT
      {
      Operand3a id = symTab.lookup($IDENT.text);
        if (id == null){
        	VarSymbol vs = new VarSymbol(Type.INT, $IDENT.text, symTab.getScope());
        	symTab.insert($IDENT.text, vs);
        	cod = Code3aGenerator.genVar(vs);
        	}
        else {System.out.println("attention la variable " + $IDENT.text+ "est déclaré plusieurs fois");}
      }
    | ^(ARRAY IDENT)
    ;

param_list[SymbolTable symTab] returns [Code3a cod]
@init{cod = new Code3a();}
    : ^(PARAM (p=param[symTab]{
    cod.append(p);    
    })*)

    ;

function[SymbolTable symTab] returns [Code3a cod]
@init{cod = new Code3a();}
    : ^(FUNC_KW t=type IDENT {
    	Operand3a id = symTab.lookup($IDENT.text);
        if (id == null){
        	LabelSymbol labelFunc = new LabelSymbol($IDENT.text);
        	cod = new Code3a(new Inst3a(Inst3a.TAC.LABEL,labelFunc,null,null));
        	FunctionSymbol fs = new FunctionSymbol(labelFunc,t);
        	symTab.insert($IDENT.text, fs);
        	cod.append(Code3aGenerator.genFunction());
        	}
        else {System.out.println("attention la fonction " + $IDENT.text+ "est déclarée plusieurs fois");}

        }
        pl=param_list[symTab] {
    		cod.append(pl);
    	}
    	 ^(BODY st=statement[symTab]) {
    		cod.append(st);
    	})
    ;

inst_list [SymbolTable symTab] returns [Code3a cod]
@init{cod = new Code3a();}
    : ^(INST (st=statement[symTab]{
    	cod.append(st) ;
    })+)
    ;
    
block [SymbolTable symTab] returns [Code3a cod]
    : ^(BLOCK d=declaration[symTab] il=inst_list[symTab])
     {
       symTab.enterScope();
       cod = d;
       cod.append(il);
       symTab.leaveScope();
     }
    | ^(BLOCK il=inst_list[symTab])
     {
    	cod = il;
   	 } 
    ;

declaration [SymbolTable symTab] returns [Code3a cod]
    : ^(DECL (dl=decl_list[symTab]{
    	cod = dl ;
    }))
    ;
 
decl_list [SymbolTable symTab] returns [Code3a cod]
@init{cod = new Code3a();}
    : (di=decl_item[symTab]{
    	cod.append(di);
    })+
    ;

decl_item [SymbolTable symTab] returns [Code3a cod]
    : IDENT
     {  
        Operand3a id = symTab.lookup($IDENT.text);
        if (id == null){
        	VarSymbol vs = new VarSymbol(Type.INT, $IDENT.text, symTab.getScope());
        	symTab.insert($IDENT.text, vs);
        	cod = Code3aGenerator.genVar(vs);
        	}
        else {System.out.println("attention la variable " + $IDENT.text+ "est déclaré plusieurs fois");}
     }
    | ^(ARDECL IDENT INTEGER)

    ;

 	  
  
primary_exp [SymbolTable symTab] returns [ExpAttribute expAtt]
  : INTEGER
    {
      ConstSymbol cs = new ConstSymbol(Integer.parseInt($INTEGER.text));
      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
    }
  | IDENT
    {
      Operand3a id = symTab.lookup($IDENT.text);
      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup($IDENT.text));
    }
  ;
