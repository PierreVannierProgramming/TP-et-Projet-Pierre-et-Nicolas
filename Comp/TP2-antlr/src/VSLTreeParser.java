// $ANTLR 3.5 ./src/VSLTreeParser.g 2013-12-06 19:47:43

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class VSLTreeParser extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASCII", "ASSIGN_KW", "COM", "COMMENT", 
		"DIGIT", "DIV", "DO_KW", "ELSE_KW", "FI_KW", "FUNC_KW", "IDENT", "IF_KW", 
		"INTEGER", "INT_KW", "LB", "LC", "LETTER", "LP", "MINUS", "MUL", "OD_KW", 
		"PLUS", "PRINT_KW", "PROTO_KW", "RB", "RC", "READ_KW", "RETURN_KW", "RP", 
		"TEXT", "THEN_KW", "VOID_KW", "WHILE_KW", "WS", "ARDECL", "ARELEM", "ARRAY", 
		"BLOCK", "BODY", "DECL", "FCALL", "FCALL_S", "INST", "PARAM", "PROG"
	};
	public static final int EOF=-1;
	public static final int ASCII=4;
	public static final int ASSIGN_KW=5;
	public static final int COM=6;
	public static final int COMMENT=7;
	public static final int DIGIT=8;
	public static final int DIV=9;
	public static final int DO_KW=10;
	public static final int ELSE_KW=11;
	public static final int FI_KW=12;
	public static final int FUNC_KW=13;
	public static final int IDENT=14;
	public static final int IF_KW=15;
	public static final int INTEGER=16;
	public static final int INT_KW=17;
	public static final int LB=18;
	public static final int LC=19;
	public static final int LETTER=20;
	public static final int LP=21;
	public static final int MINUS=22;
	public static final int MUL=23;
	public static final int OD_KW=24;
	public static final int PLUS=25;
	public static final int PRINT_KW=26;
	public static final int PROTO_KW=27;
	public static final int RB=28;
	public static final int RC=29;
	public static final int READ_KW=30;
	public static final int RETURN_KW=31;
	public static final int RP=32;
	public static final int TEXT=33;
	public static final int THEN_KW=34;
	public static final int VOID_KW=35;
	public static final int WHILE_KW=36;
	public static final int WS=37;
	public static final int ARDECL=38;
	public static final int ARELEM=39;
	public static final int ARRAY=40;
	public static final int BLOCK=41;
	public static final int BODY=42;
	public static final int DECL=43;
	public static final int FCALL=44;
	public static final int FCALL_S=45;
	public static final int INST=46;
	public static final int PARAM=47;
	public static final int PROG=48;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public VSLTreeParser(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public VSLTreeParser(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return VSLTreeParser.tokenNames; }
	@Override public String getGrammarFileName() { return "./src/VSLTreeParser.g"; }



	// $ANTLR start "s"
	// ./src/VSLTreeParser.g:9:1: s[SymbolTable symTab] returns [Code3a code] : p= program[symTab] ;
	public final Code3a s(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a p =null;

		try {
			// ./src/VSLTreeParser.g:10:3: (p= program[symTab] )
			// ./src/VSLTreeParser.g:10:5: p= program[symTab]
			{
			pushFollow(FOLLOW_program_in_s60);
			p=program(symTab);
			state._fsp--;

			 code = p; 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "s"



	// $ANTLR start "expression"
	// ./src/VSLTreeParser.g:13:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// ./src/VSLTreeParser.g:14:3: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt1=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt1=1;
				}
				break;
			case MINUS:
				{
				alt1=2;
				}
				break;
			case MUL:
				{
				alt1=3;
				}
				break;
			case DIV:
				{
				alt1=4;
				}
				break;
			case IDENT:
			case INTEGER:
			case ARELEM:
			case FCALL:
				{
				alt1=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// ./src/VSLTreeParser.g:14:5: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression83); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression87);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression92);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, e1, e2, temp);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:21:5: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression108); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression112);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression117);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, e1, e2, temp);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:28:5: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression133); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression137);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression142);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, e1, e2, temp);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 4 :
					// ./src/VSLTreeParser.g:35:5: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression158); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression162);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression167);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, e1, e2, temp);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 5 :
					// ./src/VSLTreeParser.g:42:5: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression184);
					pe=primary_exp(symTab);
					state._fsp--;

					 expAtt = pe; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expAtt;
	}
	// $ANTLR end "expression"



	// $ANTLR start "primary_exp"
	// ./src/VSLTreeParser.g:46:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT | ^( FCALL IDENT (al= argument_list[symTab, funTy] )? ) |a= array_elem[symTab, tab, op] );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER1=null;
		CommonTree IDENT2=null;
		CommonTree IDENT3=null;
		Code3a al =null;
		ExpAttribute a =null;

		try {
			// ./src/VSLTreeParser.g:48:3: ( INTEGER | IDENT | ^( FCALL IDENT (al= argument_list[symTab, funTy] )? ) |a= array_elem[symTab, tab, op] )
			int alt3=4;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt3=1;
				}
				break;
			case IDENT:
				{
				alt3=2;
				}
				break;
			case FCALL:
				{
				alt3=3;
				}
				break;
			case ARELEM:
				{
				alt3=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// ./src/VSLTreeParser.g:48:5: INTEGER
					{
					INTEGER1=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp214); 

					      ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER1!=null?INTEGER1.getText():null)));
					      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:53:5: IDENT
					{
					IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp226); 

					      Operand3a id = symTab.lookup((IDENT2!=null?IDENT2.getText():null));
						  if (id!=null){
							expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup((IDENT2!=null?IDENT2.getText():null)));
							}
						  else{System.out.println("attention la variable " + (IDENT2!=null?IDENT2.getText():null)+ " n'est pas déclarée");}
						
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:61:5: ^( FCALL IDENT (al= argument_list[symTab, funTy] )? )
					{
					match(input,FCALL,FOLLOW_FCALL_in_primary_exp239); 
					match(input, Token.DOWN, null); 
					IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp241); 
					FunctionType funTy = new FunctionType(Type.INT, false);
					// ./src/VSLTreeParser.g:61:76: (al= argument_list[symTab, funTy] )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==DIV||LA2_0==IDENT||LA2_0==INTEGER||(LA2_0 >= MINUS && LA2_0 <= MUL)||LA2_0==PLUS||LA2_0==ARELEM||LA2_0==FCALL) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// ./src/VSLTreeParser.g:61:77: al= argument_list[symTab, funTy]
							{
							pushFollow(FOLLOW_argument_list_in_primary_exp247);
							al=argument_list(symTab, funTy);
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					  	  Operand3a id = symTab.lookup((IDENT3!=null?IDENT3.getText():null));
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
							else {System.out.println("attention la fonction " + (IDENT3!=null?IDENT3.getText():null)+ " n'a pas le même nombre d'arguments");}
							}
						  else {System.out.println("attention la fonction " + (IDENT3!=null?IDENT3.getText():null)+ " n'est pas déclarée");}
					    
					}
					break;
				case 4 :
					// ./src/VSLTreeParser.g:78:6: a= array_elem[symTab, tab, op]
					{
					int tab = 0; Operand3a op = symTab.lookup("");
					pushFollow(FOLLOW_array_elem_in_primary_exp266);
					a=array_elem(symTab, tab, op);
					state._fsp--;

						
					    	expAtt = a;
					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expAtt;
	}
	// $ANTLR end "primary_exp"



	// $ANTLR start "argument_list"
	// ./src/VSLTreeParser.g:84:1: argument_list[SymbolTable symTab, FunctionType funTy] returns [Code3a cod] : (e= expression[symTab] )+ ;
	public final Code3a argument_list(SymbolTable symTab, FunctionType funTy) throws RecognitionException {
		Code3a cod = null;


		ExpAttribute e =null;

		cod = new Code3a();
		try {
			// ./src/VSLTreeParser.g:86:5: ( (e= expression[symTab] )+ )
			// ./src/VSLTreeParser.g:86:7: (e= expression[symTab] )+
			{
			// ./src/VSLTreeParser.g:86:7: (e= expression[symTab] )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==DIV||LA4_0==IDENT||LA4_0==INTEGER||(LA4_0 >= MINUS && LA4_0 <= MUL)||LA4_0==PLUS||LA4_0==ARELEM||LA4_0==FCALL) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// ./src/VSLTreeParser.g:86:8: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_argument_list302);
					e=expression(symTab);
					state._fsp--;


							cod.append(e.code);
					        cod.append(Code3aGenerator.genArg(e.place));
					        funTy.extend(Type.INT);
							
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "argument_list"



	// $ANTLR start "array_elem"
	// ./src/VSLTreeParser.g:93:1: array_elem[SymbolTable symTab, int tab,Operand3a op] returns [ExpAttribute expAtt ] : ^( ARELEM IDENT e= expression[symTab] ) ;
	public final ExpAttribute array_elem(SymbolTable symTab, int tab, Operand3a op) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree IDENT4=null;
		ExpAttribute e =null;

		try {
			// ./src/VSLTreeParser.g:94:5: ( ^( ARELEM IDENT e= expression[symTab] ) )
			// ./src/VSLTreeParser.g:94:7: ^( ARELEM IDENT e= expression[symTab] )
			{
			match(input,ARELEM,FOLLOW_ARELEM_in_array_elem339); 
			match(input, Token.DOWN, null); 
			IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_array_elem342); 
			pushFollow(FOLLOW_expression_in_array_elem346);
			e=expression(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


			        if (tab==0)
			        {
			        	Operand3a id = symTab.lookup((IDENT4!=null?IDENT4.getText():null));
				    	if (id!=null){ 
				      		Type ty;
							ty = id.type;
			        		Code3a cod;
			        		cod = e.code;
			        		VarSymbol temp = SymbDistrib.newTemp();
			        		cod.append(new Inst3a(Inst3a.TAC.TABVAR, temp, id, e.place));
			        		expAtt = new ExpAttribute(ty, cod, temp);
			        	}
			        	else {System.out.println("attention le tableau " + (IDENT4!=null?IDENT4.getText():null)+ " n'est pas déclarée");}
			        }
			        else if(tab==1)
			        {
			        	Operand3a id = symTab.lookup((IDENT4!=null?IDENT4.getText():null));
				    	if (id!=null){ 
				      		Type ty;
							ty = id.type;
			        		Code3a cod;
			        		cod = e.code;
			        		cod.append(new Inst3a(Inst3a.TAC.VARTAB, id, e.place, op));
			        		expAtt = new ExpAttribute(ty, cod, e.place);
			        	}
			        	else {System.out.println("attention le tableau " + (IDENT4!=null?IDENT4.getText():null)+ " n'est pas déclarée");}
			        }
			        else if(tab==2)
			        {
			        	Operand3a id = symTab.lookup((IDENT4!=null?IDENT4.getText():null));
				  		if (id!=null){
				  			Type ty;
							ty = id.type;
				  			Code3a cod;
							cod = Code3aGenerator.genArg(id);
							cod.append(new Inst3a(Inst3a.TAC.CALL, null, SymbDistrib.builtinRead, null));
							expAtt = new ExpAttribute(ty, cod, id);
							}
				 		else {System.out.println("attention le tableau " + (IDENT4!=null?IDENT4.getText():null)+ " n'est pas déclarée");}
			        }
			      
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expAtt;
	}
	// $ANTLR end "array_elem"



	// $ANTLR start "statement"
	// ./src/VSLTreeParser.g:141:1: statement[SymbolTable symTab] returns [Code3a cod] : ( ^( ASSIGN_KW e= expression[symTab] ( IDENT |a= array_elem[symTab, tab, e.place] ) ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) |b= block[symTab] | ^( FCALL_S IDENT (al= argument_list[symTab, funTy] )? ) | ^( RETURN_KW e= expression[symTab] ) | ^( READ_KW rl= read_list[symTab] ) | ^( PRINT_KW pl= print_list[symTab] ) );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		CommonTree IDENT5=null;
		CommonTree IDENT6=null;
		ExpAttribute e =null;
		ExpAttribute a =null;
		Code3a s1 =null;
		Code3a s2 =null;
		Code3a st =null;
		Code3a b =null;
		Code3a al =null;
		Code3a rl =null;
		Code3a pl =null;

		try {
			// ./src/VSLTreeParser.g:142:3: ( ^( ASSIGN_KW e= expression[symTab] ( IDENT |a= array_elem[symTab, tab, e.place] ) ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) |b= block[symTab] | ^( FCALL_S IDENT (al= argument_list[symTab, funTy] )? ) | ^( RETURN_KW e= expression[symTab] ) | ^( READ_KW rl= read_list[symTab] ) | ^( PRINT_KW pl= print_list[symTab] ) )
			int alt8=8;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt8=1;
				}
				break;
			case IF_KW:
				{
				alt8=2;
				}
				break;
			case WHILE_KW:
				{
				alt8=3;
				}
				break;
			case BLOCK:
				{
				alt8=4;
				}
				break;
			case FCALL_S:
				{
				alt8=5;
				}
				break;
			case RETURN_KW:
				{
				alt8=6;
				}
				break;
			case READ_KW:
				{
				alt8=7;
				}
				break;
			case PRINT_KW:
				{
				alt8=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// ./src/VSLTreeParser.g:142:5: ^( ASSIGN_KW e= expression[symTab] ( IDENT |a= array_elem[symTab, tab, e.place] ) )
					{
					match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement381); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement385);
					e=expression(symTab);
					state._fsp--;

					// ./src/VSLTreeParser.g:142:38: ( IDENT |a= array_elem[symTab, tab, e.place] )
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==IDENT) ) {
						alt5=1;
					}
					else if ( (LA5_0==ARELEM) ) {
						alt5=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 5, 0, input);
						throw nvae;
					}

					switch (alt5) {
						case 1 :
							// ./src/VSLTreeParser.g:142:39: IDENT
							{
							IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement389); 
							 
							        Operand3a id = symTab.lookup((IDENT5!=null?IDENT5.getText():null));
							        if (id!=null)
							        {
							        	cod = e.code;
							        	cod.append(new Code3a(new Inst3a(Inst3a.TAC.COPY, id, e.place, null)));
							        }
							        else {System.out.println("attention la variable " + (IDENT5!=null?IDENT5.getText():null)+ " n'est pas déclarée");}
							      
							}
							break;
						case 2 :
							// ./src/VSLTreeParser.g:152:9: a= array_elem[symTab, tab, e.place]
							{
							int tab = 1; cod = e.code;
							pushFollow(FOLLOW_array_elem_in_statement410);
							a=array_elem(symTab, tab, e.place);
							state._fsp--;

							  
							        cod.append(a.code);
							        
							      
							}
							break;

					}

					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:157:6: ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
					{
					match(input,IF_KW,FOLLOW_IF_KW_in_statement432); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement436);
					e=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_statement_in_statement442);
					s1=statement(symTab);
					state._fsp--;

					// ./src/VSLTreeParser.g:157:57: (s2= statement[symTab] )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==ASSIGN_KW||LA6_0==IF_KW||LA6_0==PRINT_KW||(LA6_0 >= READ_KW && LA6_0 <= RETURN_KW)||LA6_0==WHILE_KW||LA6_0==BLOCK||LA6_0==FCALL_S) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// ./src/VSLTreeParser.g:157:59: s2= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement449);
							s2=statement(symTab);
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


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
					break;
				case 3 :
					// ./src/VSLTreeParser.g:169:6: ^( WHILE_KW e= expression[symTab] st= statement[symTab] )
					{
					match(input,WHILE_KW,FOLLOW_WHILE_KW_in_statement468); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement472);
					e=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_statement_in_statement477);
					st=statement(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					     LabelSymbol labelInWhile = SymbDistrib.newLabel();
					     cod = new Code3a(new Inst3a(Inst3a.TAC.LABEL,labelInWhile,null,null));
					     cod.append(e.code);
					     LabelSymbol labelEndWhile = SymbDistrib.newLabel();
					     cod.append(new Inst3a(Inst3a.TAC.IFZ,e.place,labelEndWhile,null));
					     cod.append(st);
					     cod.append(new Inst3a(Inst3a.TAC.GOTO,labelInWhile,null,null));
					     cod.append(new Inst3a(Inst3a.TAC.LABEL,labelEndWhile,null,null));
					    
					}
					break;
				case 4 :
					// ./src/VSLTreeParser.g:180:6: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement494);
					b=block(symTab);
					state._fsp--;

					cod=b;
					}
					break;
				case 5 :
					// ./src/VSLTreeParser.g:182:7: ^( FCALL_S IDENT (al= argument_list[symTab, funTy] )? )
					{
					match(input,FCALL_S,FOLLOW_FCALL_S_in_statement512); 
					match(input, Token.DOWN, null); 
					IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement514); 
					FunctionType funTy = new FunctionType(Type.INT, false);
					// ./src/VSLTreeParser.g:182:80: (al= argument_list[symTab, funTy] )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==DIV||LA7_0==IDENT||LA7_0==INTEGER||(LA7_0 >= MINUS && LA7_0 <= MUL)||LA7_0==PLUS||LA7_0==ARELEM||LA7_0==FCALL) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// ./src/VSLTreeParser.g:182:81: al= argument_list[symTab, funTy]
							{
							pushFollow(FOLLOW_argument_list_in_statement520);
							al=argument_list(symTab, funTy);
							state._fsp--;

							}
							break;

					}

					match(input, Token.UP, null); 


					  	  Operand3a id = symTab.lookup((IDENT6!=null?IDENT6.getText():null));
						  if (id!=null){
							if (((FunctionType) id.type).getArguments().size() == funTy.getArguments().size()){
								cod = al;
								cod.append(new Inst3a(Inst3a.TAC.CALL, null, id, null));
								}
							else {System.out.println("attention la fonction " + (IDENT6!=null?IDENT6.getText():null)+ " n'a pas le même nombre d'arguments");}
							}
						  else {System.out.println("attention la fonction " + (IDENT6!=null?IDENT6.getText():null)+ " n'est pas déclarée");}
					    
					}
					break;
				case 6 :
					// ./src/VSLTreeParser.g:194:7: ^( RETURN_KW e= expression[symTab] )
					{
					match(input,RETURN_KW,FOLLOW_RETURN_KW_in_statement538); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement542);
					e=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


						  cod = e.code;
						  cod.append(new Inst3a(Inst3a.TAC.RETURN, e.place, null, null));
						
					}
					break;
				case 7 :
					// ./src/VSLTreeParser.g:199:4: ^( READ_KW rl= read_list[symTab] )
					{
					match(input,READ_KW,FOLLOW_READ_KW_in_statement553); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_read_list_in_statement557);
					rl=read_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					cod = rl;
					}
					break;
				case 8 :
					// ./src/VSLTreeParser.g:200:4: ^( PRINT_KW pl= print_list[symTab] )
					{
					match(input,PRINT_KW,FOLLOW_PRINT_KW_in_statement567); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_print_list_in_statement571);
					pl=print_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					cod = pl;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "statement"



	// $ANTLR start "print_list"
	// ./src/VSLTreeParser.g:203:1: print_list[SymbolTable symTab] returns [Code3a cod] : (p= print_item[symTab] )+ ;
	public final Code3a print_list(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a p =null;

		cod = new Code3a();
		try {
			// ./src/VSLTreeParser.g:205:5: ( (p= print_item[symTab] )+ )
			// ./src/VSLTreeParser.g:205:7: (p= print_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:205:7: (p= print_item[symTab] )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==DIV||LA9_0==IDENT||LA9_0==INTEGER||(LA9_0 >= MINUS && LA9_0 <= MUL)||LA9_0==PLUS||LA9_0==TEXT||LA9_0==ARELEM||LA9_0==FCALL) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// ./src/VSLTreeParser.g:205:8: p= print_item[symTab]
					{
					pushFollow(FOLLOW_print_item_in_print_list603);
					p=print_item(symTab);
					state._fsp--;


						  cod.append(p);
						
					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "print_list"



	// $ANTLR start "print_item"
	// ./src/VSLTreeParser.g:211:1: print_item[SymbolTable symTab] returns [Code3a cod] : ( TEXT |e= expression[symTab] );
	public final Code3a print_item(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		CommonTree TEXT7=null;
		ExpAttribute e =null;

		cod = new Code3a();
		try {
			// ./src/VSLTreeParser.g:213:5: ( TEXT |e= expression[symTab] )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==TEXT) ) {
				alt10=1;
			}
			else if ( (LA10_0==DIV||LA10_0==IDENT||LA10_0==INTEGER||(LA10_0 >= MINUS && LA10_0 <= MUL)||LA10_0==PLUS||LA10_0==ARELEM||LA10_0==FCALL) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// ./src/VSLTreeParser.g:213:7: TEXT
					{
					TEXT7=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_print_item636); 

						  Data3a dat = new Data3a((TEXT7!=null?TEXT7.getText():null));
						  cod.appendData(dat);
					      cod.append(Code3aGenerator.genArg(dat.getLabel()));
						  cod.append(new Inst3a(Inst3a.TAC.CALL, null, SymbDistrib.builtinPrintS, null));
						
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:220:7: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_print_item649);
					e=expression(symTab);
					state._fsp--;


					      cod = e.code;
					      cod.append(Code3aGenerator.genArg(e.place));
						  cod.append(new Inst3a(Inst3a.TAC.CALL, null, SymbDistrib.builtinPrintN, null));
						
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "print_item"



	// $ANTLR start "read_list"
	// ./src/VSLTreeParser.g:228:1: read_list[SymbolTable symTab] returns [Code3a cod] : (r= read_item[symTab] )+ ;
	public final Code3a read_list(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a r =null;

		cod = new Code3a();
		try {
			// ./src/VSLTreeParser.g:230:5: ( (r= read_item[symTab] )+ )
			// ./src/VSLTreeParser.g:230:7: (r= read_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:230:7: (r= read_item[symTab] )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==IDENT||LA11_0==ARELEM) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// ./src/VSLTreeParser.g:230:8: r= read_item[symTab]
					{
					pushFollow(FOLLOW_read_item_in_read_list683);
					r=read_item(symTab);
					state._fsp--;


						  cod.append(r);
						
					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "read_list"



	// $ANTLR start "read_item"
	// ./src/VSLTreeParser.g:236:1: read_item[SymbolTable symTab] returns [Code3a cod] : ( IDENT |a= array_elem[symTab, tab, op] );
	public final Code3a read_item(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		CommonTree IDENT8=null;
		ExpAttribute a =null;

		try {
			// ./src/VSLTreeParser.g:237:5: ( IDENT |a= array_elem[symTab, tab, op] )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==IDENT) ) {
				alt12=1;
			}
			else if ( (LA12_0==ARELEM) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// ./src/VSLTreeParser.g:237:7: IDENT
					{
					IDENT8=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item712); 

						  Operand3a id = symTab.lookup((IDENT8!=null?IDENT8.getText():null));
						  if (id!=null){
							cod = Code3aGenerator.genArg(id);
							cod.append(new Inst3a(Inst3a.TAC.CALL, null, SymbDistrib.builtinRead, null));
							}
						  else {System.out.println("attention la variable " + (IDENT8!=null?IDENT8.getText():null)+ " n'est pas déclaré");}
						
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:246:5: a= array_elem[symTab, tab, op]
					{
					int tab = 2; Operand3a op = symTab.lookup("");
					pushFollow(FOLLOW_array_elem_in_read_item725);
					a=array_elem(symTab, tab, op);
					state._fsp--;

					cod = a.code;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "read_item"



	// $ANTLR start "type"
	// ./src/VSLTreeParser.g:250:1: type returns [Type ty] : ( INT_KW | VOID_KW );
	public final Type type() throws RecognitionException {
		Type ty = null;


		try {
			// ./src/VSLTreeParser.g:251:5: ( INT_KW | VOID_KW )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==INT_KW) ) {
				alt13=1;
			}
			else if ( (LA13_0==VOID_KW) ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// ./src/VSLTreeParser.g:251:7: INT_KW
					{
					match(input,INT_KW,FOLLOW_INT_KW_in_type756); 

					    	ty=Type.INT;
					    	
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:254:7: VOID_KW
					{
					match(input,VOID_KW,FOLLOW_VOID_KW_in_type766); 

					    	ty=Type.VOID;
					    	
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ty;
	}
	// $ANTLR end "type"



	// $ANTLR start "param"
	// ./src/VSLTreeParser.g:259:1: param[SymbolTable symTab, FunctionType funTy] returns [Code3a cod] : ( IDENT | ^( ARRAY IDENT ) );
	public final Code3a param(SymbolTable symTab, FunctionType funTy) throws RecognitionException {
		Code3a cod = null;


		CommonTree IDENT9=null;
		CommonTree IDENT10=null;

		try {
			// ./src/VSLTreeParser.g:260:5: ( IDENT | ^( ARRAY IDENT ) )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==IDENT) ) {
				alt14=1;
			}
			else if ( (LA14_0==ARRAY) ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// ./src/VSLTreeParser.g:260:7: IDENT
					{
					IDENT9=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param792); 

					      Operand3a id = symTab.lookup((IDENT9!=null?IDENT9.getText():null));
					        if (id == null || id.isParam()){
					        	VarSymbol vs = new VarSymbol(Type.INT, (IDENT9!=null?IDENT9.getText():null), symTab.getScope());
					        	vs.setParam();
					        	symTab.insert((IDENT9!=null?IDENT9.getText():null), vs);
					        	cod = Code3aGenerator.genVar(vs);
					        	funTy.extend(Type.INT);
					        	}
					        else {System.out.println("attention la variable " + (IDENT9!=null?IDENT9.getText():null)+ " est déclaré plusieurs fois");}
					      
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:272:7: ^( ARRAY IDENT )
					{
					match(input,ARRAY,FOLLOW_ARRAY_in_param809); 
					match(input, Token.DOWN, null); 
					IDENT10=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param811); 
					match(input, Token.UP, null); 


					      Operand3a id = symTab.lookup((IDENT10!=null?IDENT10.getText():null));
					        if (id == null){
					        	ArrayType aty = new ArrayType(Type.INT, 100);
					        	VarSymbol vs = new VarSymbol(aty, (IDENT10!=null?IDENT10.getText():null), symTab.getScope());
					        	vs.setParam();
					        	symTab.insert((IDENT10!=null?IDENT10.getText():null), vs);
					        	cod = Code3aGenerator.genVar(vs);
					        	funTy.extend(Type.INT);
					        	}
					        else {System.out.println("attention le tableau " + (IDENT10!=null?IDENT10.getText():null)+ " est déclaré plusieurs fois");}
					      
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "param"



	// $ANTLR start "param_list"
	// ./src/VSLTreeParser.g:287:1: param_list[SymbolTable symTab, FunctionType funTy] returns [Code3a cod] : ^( PARAM (p= param[symTab, funTy] )* ) ;
	public final Code3a param_list(SymbolTable symTab, FunctionType funTy) throws RecognitionException {
		Code3a cod = null;


		Code3a p =null;

		cod = new Code3a();
		try {
			// ./src/VSLTreeParser.g:289:5: ( ^( PARAM (p= param[symTab, funTy] )* ) )
			// ./src/VSLTreeParser.g:289:7: ^( PARAM (p= param[symTab, funTy] )* )
			{
			match(input,PARAM,FOLLOW_PARAM_in_param_list847); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// ./src/VSLTreeParser.g:289:15: (p= param[symTab, funTy] )*
				loop15:
				while (true) {
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==IDENT||LA15_0==ARRAY) ) {
						alt15=1;
					}

					switch (alt15) {
					case 1 :
						// ./src/VSLTreeParser.g:289:16: p= param[symTab, funTy]
						{
						pushFollow(FOLLOW_param_in_param_list852);
						p=param(symTab, funTy);
						state._fsp--;


						    cod.append(p);    
						    
						}
						break;

					default :
						break loop15;
					}
				}

				match(input, Token.UP, null); 
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "param_list"



	// $ANTLR start "function"
	// ./src/VSLTreeParser.g:295:1: function[SymbolTable symTab] returns [Code3a cod] : ^( FUNC_KW t= type IDENT pl= param_list[symTab, funTy] ^( BODY st= statement[symTab] ) ) ;
	public final Code3a function(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		CommonTree IDENT11=null;
		Type t =null;
		Code3a pl =null;
		Code3a st =null;

		try {
			// ./src/VSLTreeParser.g:296:5: ( ^( FUNC_KW t= type IDENT pl= param_list[symTab, funTy] ^( BODY st= statement[symTab] ) ) )
			// ./src/VSLTreeParser.g:296:7: ^( FUNC_KW t= type IDENT pl= param_list[symTab, funTy] ^( BODY st= statement[symTab] ) )
			{
			match(input,FUNC_KW,FOLLOW_FUNC_KW_in_function881); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_function885);
			t=type();
			state._fsp--;

			IDENT11=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_function887); 

			    	FunctionType funTy = new FunctionType(t, false);
			    	
			pushFollow(FOLLOW_param_list_in_function892);
			pl=param_list(symTab, funTy);
			state._fsp--;


			    	Operand3a id = symTab.lookup((IDENT11!=null?IDENT11.getText():null));
			        if (id == null || (
			        	((FunctionType) id.type).prototype &&
			        	(((FunctionType) id.type).getReturnType() == t) &&
			        	(((FunctionType) id.type).getArguments().equals(funTy.getArguments()))
			        	)
			        	){
			        	symTab.enterScope();
			        	LabelSymbol labelFunc = new LabelSymbol((IDENT11!=null?IDENT11.getText():null));
			        	cod = new Code3a(new Inst3a(Inst3a.TAC.LABEL,labelFunc,null,null));
			        	FunctionSymbol fs = new FunctionSymbol(labelFunc, funTy);
			        	symTab.insert((IDENT11!=null?IDENT11.getText():null), fs);
			        	cod.append(Code3aGenerator.genFunction());
			        	cod.append(pl);
			        	}
			        else {System.out.println("attention la fonction " + (IDENT11!=null?IDENT11.getText():null)+ " est déclarée plusieurs fois ou n'est pas conforme à son prototype");}
			    	
			match(input,BODY,FOLLOW_BODY_in_function909); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_statement_in_function913);
			st=statement(symTab);
			state._fsp--;

			match(input, Token.UP, null); 

			match(input, Token.UP, null); 


			    		cod.append(st);
			    		cod.append(new Code3a(new Inst3a(Inst3a.TAC.ENDFUNC,null,null,null)));
			    		
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "function"



	// $ANTLR start "proto"
	// ./src/VSLTreeParser.g:324:1: proto[SymbolTable symTab] returns [Code3a cod] : ^( PROTO_KW t= type IDENT pl= param_list[symTab, funTy] ) ;
	public final Code3a proto(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		CommonTree IDENT12=null;
		Type t =null;
		Code3a pl =null;

		try {
			// ./src/VSLTreeParser.g:325:5: ( ^( PROTO_KW t= type IDENT pl= param_list[symTab, funTy] ) )
			// ./src/VSLTreeParser.g:325:7: ^( PROTO_KW t= type IDENT pl= param_list[symTab, funTy] )
			{
			match(input,PROTO_KW,FOLLOW_PROTO_KW_in_proto952); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_proto956);
			t=type();
			state._fsp--;

			IDENT12=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_proto958); 

			    	FunctionType funTy = new FunctionType(t);
			    	
			pushFollow(FOLLOW_param_list_in_proto963);
			pl=param_list(symTab, funTy);
			state._fsp--;

			match(input, Token.UP, null); 


			    	Operand3a id = symTab.lookup((IDENT12!=null?IDENT12.getText():null));
			        if (id == null){
			        	LabelSymbol labelFunc = new LabelSymbol((IDENT12!=null?IDENT12.getText():null));
			        	FunctionSymbol fs = new FunctionSymbol(labelFunc, funTy);
			        	symTab.insert((IDENT12!=null?IDENT12.getText():null), fs);
			        	}
			        else {System.out.println("attention le proto " + (IDENT12!=null?IDENT12.getText():null)+ " est déclaré plusieurs fois");}
			        
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "proto"



	// $ANTLR start "unit"
	// ./src/VSLTreeParser.g:338:1: unit[SymbolTable symTab] returns [Code3a cod] : (f= function[symTab] |p= proto[symTab] );
	public final Code3a unit(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a f =null;
		Code3a p =null;

		try {
			// ./src/VSLTreeParser.g:339:5: (f= function[symTab] |p= proto[symTab] )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==FUNC_KW) ) {
				alt16=1;
			}
			else if ( (LA16_0==PROTO_KW) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// ./src/VSLTreeParser.g:339:7: f= function[symTab]
					{
					pushFollow(FOLLOW_function_in_unit995);
					f=function(symTab);
					state._fsp--;


					    	cod=f;
					    	
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:342:7: p= proto[symTab]
					{
					pushFollow(FOLLOW_proto_in_unit1007);
					p=proto(symTab);
					state._fsp--;


					    	cod=p;
					    	
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "unit"



	// $ANTLR start "program"
	// ./src/VSLTreeParser.g:347:1: program[SymbolTable symTab] returns [Code3a cod] : ^( PROG (u= unit[symTab] )+ ) ;
	public final Code3a program(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a u =null;

		cod = new Code3a();
		try {
			// ./src/VSLTreeParser.g:349:5: ( ^( PROG (u= unit[symTab] )+ ) )
			// ./src/VSLTreeParser.g:349:7: ^( PROG (u= unit[symTab] )+ )
			{
			match(input,PROG,FOLLOW_PROG_in_program1040); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:349:14: (u= unit[symTab] )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==FUNC_KW||LA17_0==PROTO_KW) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// ./src/VSLTreeParser.g:349:15: u= unit[symTab]
					{
					pushFollow(FOLLOW_unit_in_program1045);
					u=unit(symTab);
					state._fsp--;


					    	cod.append(u);
					    	
					}
					break;

				default :
					if ( cnt17 >= 1 ) break loop17;
					EarlyExitException eee = new EarlyExitException(17, input);
					throw eee;
				}
				cnt17++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "program"



	// $ANTLR start "inst_list"
	// ./src/VSLTreeParser.g:355:1: inst_list[SymbolTable symTab] returns [Code3a cod] : ^( INST (st= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a st =null;

		cod = new Code3a();
		try {
			// ./src/VSLTreeParser.g:357:5: ( ^( INST (st= statement[symTab] )+ ) )
			// ./src/VSLTreeParser.g:357:7: ^( INST (st= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list1084); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:357:14: (st= statement[symTab] )+
			int cnt18=0;
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==ASSIGN_KW||LA18_0==IF_KW||LA18_0==PRINT_KW||(LA18_0 >= READ_KW && LA18_0 <= RETURN_KW)||LA18_0==WHILE_KW||LA18_0==BLOCK||LA18_0==FCALL_S) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// ./src/VSLTreeParser.g:357:15: st= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list1089);
					st=statement(symTab);
					state._fsp--;


					    	cod.append(st) ;
					    
					}
					break;

				default :
					if ( cnt18 >= 1 ) break loop18;
					EarlyExitException eee = new EarlyExitException(18, input);
					throw eee;
				}
				cnt18++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "inst_list"



	// $ANTLR start "block"
	// ./src/VSLTreeParser.g:362:1: block[SymbolTable symTab] returns [Code3a cod] : ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a d =null;
		Code3a il =null;

		try {
			// ./src/VSLTreeParser.g:363:5: ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==BLOCK) ) {
				int LA19_1 = input.LA(2);
				if ( (LA19_1==DOWN) ) {
					int LA19_2 = input.LA(3);
					if ( (LA19_2==DECL) ) {
						alt19=1;
					}
					else if ( (LA19_2==INST) ) {
						alt19=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 19, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 19, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// ./src/VSLTreeParser.g:363:7: ^( BLOCK d= declaration[symTab] il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block1122); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block1126);
					d=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block1131);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					       symTab.enterScope();
					       cod = d;
					       cod.append(il);
					       symTab.leaveScope();
					     
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:370:7: ^( BLOCK il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block1149); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block1153);
					il=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					    	cod = il;
					   	 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "block"



	// $ANTLR start "declaration"
	// ./src/VSLTreeParser.g:376:1: declaration[SymbolTable symTab] returns [Code3a cod] : ^( DECL (dl= decl_list[symTab] ) ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a dl =null;

		try {
			// ./src/VSLTreeParser.g:377:5: ( ^( DECL (dl= decl_list[symTab] ) ) )
			// ./src/VSLTreeParser.g:377:7: ^( DECL (dl= decl_list[symTab] ) )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration1187); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:377:14: (dl= decl_list[symTab] )
			// ./src/VSLTreeParser.g:377:15: dl= decl_list[symTab]
			{
			pushFollow(FOLLOW_decl_list_in_declaration1192);
			dl=decl_list(symTab);
			state._fsp--;


			    	cod = dl ;
			    
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "declaration"



	// $ANTLR start "decl_list"
	// ./src/VSLTreeParser.g:382:1: decl_list[SymbolTable symTab] returns [Code3a cod] : (di= decl_item[symTab] )+ ;
	public final Code3a decl_list(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a di =null;

		cod = new Code3a();
		try {
			// ./src/VSLTreeParser.g:384:5: ( (di= decl_item[symTab] )+ )
			// ./src/VSLTreeParser.g:384:7: (di= decl_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:384:7: (di= decl_item[symTab] )+
			int cnt20=0;
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==IDENT||LA20_0==ARDECL) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// ./src/VSLTreeParser.g:384:8: di= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_decl_list1227);
					di=decl_item(symTab);
					state._fsp--;


					    	cod.append(di);
					    
					}
					break;

				default :
					if ( cnt20 >= 1 ) break loop20;
					EarlyExitException eee = new EarlyExitException(20, input);
					throw eee;
				}
				cnt20++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "decl_list"



	// $ANTLR start "decl_item"
	// ./src/VSLTreeParser.g:389:1: decl_item[SymbolTable symTab] returns [Code3a cod] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		CommonTree IDENT13=null;
		CommonTree IDENT14=null;
		CommonTree INTEGER15=null;

		try {
			// ./src/VSLTreeParser.g:390:5: ( IDENT | ^( ARDECL IDENT INTEGER ) )
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==IDENT) ) {
				alt21=1;
			}
			else if ( (LA21_0==ARDECL) ) {
				alt21=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// ./src/VSLTreeParser.g:390:7: IDENT
					{
					IDENT13=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1254); 
					  
					        Operand3a id = symTab.lookup((IDENT13!=null?IDENT13.getText():null));
					        if (id == null){
					        	VarSymbol vs = new VarSymbol(Type.INT, (IDENT13!=null?IDENT13.getText():null), symTab.getScope());
					        	symTab.insert((IDENT13!=null?IDENT13.getText():null), vs);
					        	cod = Code3aGenerator.genVar(vs);
					        	}
					        else {System.out.println("attention la variable " + (IDENT13!=null?IDENT13.getText():null)+ " est déclaré plusieurs fois");}
					     
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:400:7: ^( ARDECL IDENT INTEGER )
					{
					match(input,ARDECL,FOLLOW_ARDECL_in_decl_item1270); 
					match(input, Token.DOWN, null); 
					IDENT14=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1272); 
					INTEGER15=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_decl_item1274); 
					match(input, Token.UP, null); 


							Operand3a id = symTab.lookup((IDENT14!=null?IDENT14.getText():null));
							if (id == null){
								ArrayType aty = new ArrayType(Type.INT, Integer.parseInt((INTEGER15!=null?INTEGER15.getText():null)));
								VarSymbol vs = new VarSymbol(aty, (IDENT14!=null?IDENT14.getText():null), symTab.getScope());
					        	symTab.insert((IDENT14!=null?IDENT14.getText():null), vs);
					        	cod = Code3aGenerator.genVar(vs);
								}
							else {System.out.println("attention une variable de même nom est déja déclaré.");}
						  
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return cod;
	}
	// $ANTLR end "decl_item"

	// Delegated rules



	public static final BitSet FOLLOW_program_in_s60 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expression83 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression87 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression92 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression108 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression112 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression117 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression133 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression137 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression142 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression158 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression162 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_expression167 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FCALL_in_primary_exp239 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp241 = new BitSet(new long[]{0x0000108002C14208L});
	public static final BitSet FOLLOW_argument_list_in_primary_exp247 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_array_elem_in_primary_exp266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_argument_list302 = new BitSet(new long[]{0x0000108002C14202L});
	public static final BitSet FOLLOW_ARELEM_in_array_elem339 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_array_elem342 = new BitSet(new long[]{0x0000108002C14200L});
	public static final BitSet FOLLOW_expression_in_array_elem346 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement381 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement385 = new BitSet(new long[]{0x0000008000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement389 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_array_elem_in_statement410 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_KW_in_statement432 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement436 = new BitSet(new long[]{0x00002210C4008020L});
	public static final BitSet FOLLOW_statement_in_statement442 = new BitSet(new long[]{0x00002210C4008028L});
	public static final BitSet FOLLOW_statement_in_statement449 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_KW_in_statement468 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement472 = new BitSet(new long[]{0x00002210C4008020L});
	public static final BitSet FOLLOW_statement_in_statement477 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement494 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FCALL_S_in_statement512 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_statement514 = new BitSet(new long[]{0x0000108002C14208L});
	public static final BitSet FOLLOW_argument_list_in_statement520 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURN_KW_in_statement538 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement542 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_KW_in_statement553 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_read_list_in_statement557 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_KW_in_statement567 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_print_list_in_statement571 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_print_item_in_print_list603 = new BitSet(new long[]{0x0000108202C14202L});
	public static final BitSet FOLLOW_TEXT_in_print_item636 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_print_item649 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_item_in_read_list683 = new BitSet(new long[]{0x0000008000004002L});
	public static final BitSet FOLLOW_IDENT_in_read_item712 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_elem_in_read_item725 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_KW_in_type756 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KW_in_type766 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_param792 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_param809 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_param811 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PARAM_in_param_list847 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_param_list852 = new BitSet(new long[]{0x0000010000004008L});
	public static final BitSet FOLLOW_FUNC_KW_in_function881 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_function885 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_function887 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_param_list_in_function892 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_BODY_in_function909 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_function913 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PROTO_KW_in_proto952 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_proto956 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_proto958 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_param_list_in_proto963 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_function_in_unit995 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_proto_in_unit1007 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROG_in_program1040 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_unit_in_program1045 = new BitSet(new long[]{0x0000000008002008L});
	public static final BitSet FOLLOW_INST_in_inst_list1084 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list1089 = new BitSet(new long[]{0x00002210C4008028L});
	public static final BitSet FOLLOW_BLOCK_in_block1122 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block1126 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block1131 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block1149 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block1153 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECL_in_declaration1187 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_list_in_declaration1192 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_decl_item_in_decl_list1227 = new BitSet(new long[]{0x0000004000004002L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item1270 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1272 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item1274 = new BitSet(new long[]{0x0000000000000008L});
}
