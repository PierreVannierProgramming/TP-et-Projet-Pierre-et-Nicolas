tree grammar VSLTreeParser;

options {
  language     = Java;
  tokenVocab   = VSLParser;
  ASTLabelType = CommonTree;
}

s [SymbolTable symTab] returns [Code3a code]
  : p=program[symTab] { code = p; }
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
  
primary_exp [SymbolTable symTab] returns [ExpAttribute expAtt]

  : INTEGER
    {
      ConstSymbol cs = new ConstSymbol(Integer.parseInt($INTEGER.text));
      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
    }
  | IDENT
    {
      Operand3a id = symTab.lookup($IDENT.text);
	  if (id!=null){
		expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup($IDENT.text));
		}
	  else{System.out.println("attention la variable " + $IDENT.text+ " n'est pas déclarée");}
	}
  | ^(FCALL IDENT {FunctionType funTy = new FunctionType(Type.INT, false);}(al=argument_list[symTab, funTy])?)
  	{
  	  Operand3a id = symTab.lookup($IDENT.text);
	  if (id!=null){
		if (((FunctionType) id.type).getArguments().size() == funTy.getArguments().size()){
			Type ty;
			ty = id.type;
			VarSymbol temp = SymbDistrib.newTemp();
			Code3a cod;
			cod = al;
			cod.append(new Inst3a(Inst3a.TAC.CALL, temp, id, null));
			expAtt = new ExpAttribute(ty, cod, temp);
			}
		else {System.out.println("attention la fonction " + $IDENT.text+ " n'a pas le même nombre d'arguments");}
		}
	  else {System.out.println("attention la fonction " + $IDENT.text+ " n'est pas déclarée");}
    }
  |  {int tab = 0; Operand3a op = symTab.lookup("");}a=array_elem[symTab, tab, op] 
    {	
    	expAtt = a;
    }
  ;
 
argument_list[SymbolTable symTab, FunctionType funTy] returns [Code3a cod]
@init{cod = new Code3a();}
    : (e=expression[symTab]{
		cod.append(e.code);
        cod.append(Code3aGenerator.genArg(e.place));
        funTy.extend(Type.INT);
		})+
    ;        	

array_elem [SymbolTable symTab, int tab,Operand3a op] returns [ExpAttribute expAtt ]
    : ^(ARELEM  IDENT e=expression[symTab])
      {
        if (tab==0)
        {
        	Operand3a id = symTab.lookup($IDENT.text);
	    	if (id!=null){ 
	      		Type ty;
				ty = id.type;
        		Code3a cod;
        		cod = e.code;
        		VarSymbol temp = SymbDistrib.newTemp();
        		cod.append(new Inst3a(Inst3a.TAC.TABVAR, temp, id, e.place));
        		expAtt = new ExpAttribute(ty, cod, temp);
        	}
        	else {System.out.println("attention le tableau " + $IDENT.text+ " n'est pas déclarée");}
        }
        else if(tab==1)
        {
        	Operand3a id = symTab.lookup($IDENT.text);
	    	if (id!=null){ 
	      		Type ty;
				ty = id.type;
        		Code3a cod;
        		cod = e.code;
        		cod.append(new Inst3a(Inst3a.TAC.VARTAB, id, e.place, op));
        		expAtt = new ExpAttribute(ty, cod, e.place);
        	}
        	else {System.out.println("attention le tableau " + $IDENT.text+ " n'est pas déclarée");}
        }
        else if(tab==2)
        {
        	Operand3a id = symTab.lookup($IDENT.text);
	  		if (id!=null){
	  			Type ty;
				ty = id.type;
	  			Code3a cod;
				cod = Code3aGenerator.genArg(id);
				cod.append(new Inst3a(Inst3a.TAC.CALL, null, SymbDistrib.builtinRead, null));
				expAtt = new ExpAttribute(ty, cod, id);
				}
	 		else {System.out.println("attention le tableau " + $IDENT.text+ " n'est pas déclarée");}
        }
      }
    ; 



statement [SymbolTable symTab] returns [Code3a cod]
  : ^(ASSIGN_KW e=expression[symTab] (IDENT 
  	  { 
        Operand3a id = symTab.lookup($IDENT.text);
        if (id!=null)
        {
        	cod = e.code;
        	cod.append(new Code3a(new Inst3a(Inst3a.TAC.COPY, id, e.place, null)));
        }
        else {System.out.println("attention la variable " + $IDENT.text+ " n'est pas déclarée");}
      }
      | {int tab = 1; cod = e.code;}a=array_elem[symTab, tab, e.place]  
      {  
        cod.append(a.code);
        
      })) 
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
    | ^(FCALL_S IDENT {FunctionType funTy = new FunctionType(Type.INT, false);}(al=argument_list[symTab, funTy])?)
  	{
  	  Operand3a id = symTab.lookup($IDENT.text);
	  if (id!=null){
		if (((FunctionType) id.type).getArguments().size() == funTy.getArguments().size()){
			cod = al;
			cod.append(new Inst3a(Inst3a.TAC.CALL, null, id, null));
			}
		else {System.out.println("attention la fonction " + $IDENT.text+ " n'a pas le même nombre d'arguments");}
		}
	  else {System.out.println("attention la fonction " + $IDENT.text+ " n'est pas déclarée");}
    }
    | ^(RETURN_KW e=expression[symTab])
	{
	  cod = e.code;
	  cod.append(new Inst3a(Inst3a.TAC.RETURN, e.place, null, null));
	}
	| ^(READ_KW rl=read_list[symTab]) {cod = rl;}
	| ^(PRINT_KW pl=print_list[symTab]) {cod = pl;}
  ;

print_list [SymbolTable symTab] returns [Code3a cod]
@init{cod = new Code3a();}
    : (p=print_item[symTab]
	{
	  cod.append(p);
	})+
    ;

print_item [SymbolTable symTab] returns [Code3a cod]
@init{cod = new Code3a();}
    : TEXT
	{
	  Data3a dat = new Data3a($TEXT.text);
	  cod.appendData(dat);
      cod.append(Code3aGenerator.genArg(dat.getLabel()));
	  cod.append(new Inst3a(Inst3a.TAC.CALL, null, SymbDistrib.builtinPrintS, null));
	}
    | e=expression[symTab]
	{
      cod = e.code;
      cod.append(Code3aGenerator.genArg(e.place));
	  cod.append(new Inst3a(Inst3a.TAC.CALL, null, SymbDistrib.builtinPrintN, null));
	}
    ;

read_list [SymbolTable symTab] returns [Code3a cod]
@init{cod = new Code3a();}
    : (r=read_item[symTab]
	{
	  cod.append(r);
	})+
    ;

read_item [SymbolTable symTab] returns [Code3a cod]
    : IDENT
	{
	  Operand3a id = symTab.lookup($IDENT.text);
	  if (id!=null){
		cod = Code3aGenerator.genArg(id);
		cod.append(new Inst3a(Inst3a.TAC.CALL, null, SymbDistrib.builtinRead, null));
		}
	  else {System.out.println("attention la variable " + $IDENT.text+ " n'est pas déclaré");}
	}
	|  {int tab = 2; Operand3a op = symTab.lookup("");} a=array_elem[symTab, tab, op] {cod = a.code;}
    ;
    
  
type returns [Type ty]
    : INT_KW {
    	ty=Type.INT;
    	}
    | VOID_KW {
    	ty=Type.VOID;
    	}
    ;
  
param[SymbolTable symTab, FunctionType funTy] returns [Code3a cod]
    : IDENT
      {
      Operand3a id = symTab.lookup($IDENT.text);
        if (id == null || id.isParam()){
        	VarSymbol vs = new VarSymbol(Type.INT, $IDENT.text, symTab.getScope());
        	vs.setParam();
        	symTab.insert($IDENT.text, vs);
        	cod = Code3aGenerator.genVar(vs);
        	funTy.extend(Type.INT);
        	}
        else {System.out.println("attention la variable " + $IDENT.text+ " est déclaré plusieurs fois");}
      }
    | ^(ARRAY IDENT)
      {
      Operand3a id = symTab.lookup($IDENT.text);
        if (id == null){
        	ArrayType aty = new ArrayType(Type.INT, 100);
        	VarSymbol vs = new VarSymbol(aty, $IDENT.text, symTab.getScope());
        	vs.setParam();
        	symTab.insert($IDENT.text, vs);
        	cod = Code3aGenerator.genVar(vs);
        	funTy.extend(Type.INT);
        	}
        else {System.out.println("attention le tableau " + $IDENT.text+ " est déclaré plusieurs fois");}
      }
    ;

param_list[SymbolTable symTab, FunctionType funTy] returns [Code3a cod]
@init{cod = new Code3a();}
    : ^(PARAM (p=param[symTab, funTy]{
    cod.append(p);    
    })*)

    ;

function[SymbolTable symTab] returns [Code3a cod]
    : ^(FUNC_KW t=type IDENT {
    	FunctionType funTy = new FunctionType(t, false);
    	}pl=param_list[symTab, funTy] 
    	{
    	Operand3a id = symTab.lookup($IDENT.text);
        if (id == null || (
        	((FunctionType) id.type).prototype &&
        	(((FunctionType) id.type).getReturnType() == t) &&
        	(((FunctionType) id.type).getArguments().equals(funTy.getArguments()))
        	)
        	){
        	symTab.enterScope();
        	LabelSymbol labelFunc = new LabelSymbol($IDENT.text);
        	cod = new Code3a(new Inst3a(Inst3a.TAC.LABEL,labelFunc,null,null));
        	FunctionSymbol fs = new FunctionSymbol(labelFunc, funTy);
        	symTab.insert($IDENT.text, fs);
        	cod.append(Code3aGenerator.genFunction());
        	cod.append(pl);
        	}
        else {System.out.println("attention la fonction " + $IDENT.text+ " est déclarée plusieurs fois ou n'est pas conforme à son prototype");}
    	}
    	^(BODY st=statement[symTab])) 
    		{
    		cod.append(st);
    		cod.append(new Code3a(new Inst3a(Inst3a.TAC.ENDFUNC,null,null,null)));
    		}
    ;
    
proto[SymbolTable symTab] returns [Code3a cod]
    : ^(PROTO_KW t=type IDENT {
    	FunctionType funTy = new FunctionType(t);
    	}pl=param_list[symTab, funTy]) {
    	Operand3a id = symTab.lookup($IDENT.text);
        if (id == null){
        	LabelSymbol labelFunc = new LabelSymbol($IDENT.text);
        	FunctionSymbol fs = new FunctionSymbol(labelFunc, funTy);
        	symTab.insert($IDENT.text, fs);
        	}
        else {System.out.println("attention le proto " + $IDENT.text+ " est déclaré plusieurs fois");}
        }
    ;
    
unit[SymbolTable symTab] returns [Code3a cod]
    : f=function[symTab]{
    	cod=f;
    	}
    | p=proto[symTab]{
    	cod=p;
    	}
    ;
    
program[SymbolTable symTab] returns [Code3a cod]
@init{cod = new Code3a();}
    : ^(PROG (u=unit[symTab] {
    	cod.append(u);
    	})+)
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
        else {System.out.println("attention la variable " + $IDENT.text+ " est déclaré plusieurs fois");}
     }
    | ^(ARDECL IDENT INTEGER)
	  {
		Operand3a id = symTab.lookup($IDENT.text);
		if (id == null){
			ArrayType aty = new ArrayType(Type.INT, Integer.parseInt($INTEGER.text));
			VarSymbol vs = new VarSymbol(aty, $IDENT.text, symTab.getScope());
        	symTab.insert($IDENT.text, vs);
        	cod = Code3aGenerator.genVar(vs);
			}
		else {System.out.println("attention une variable de même nom est déja déclaré.");}
	  }

    ;
 	  
  