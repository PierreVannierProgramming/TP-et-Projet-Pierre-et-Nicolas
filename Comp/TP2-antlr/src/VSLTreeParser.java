// $ANTLR 3.5 ./src/VSLTreeParser.g 2013-11-29 16:15:36

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
	// ./src/VSLTreeParser.g:9:1: s[SymbolTable symTab] returns [Code3a code] : e= function[symTab] ;
	public final Code3a s(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a e =null;

		try {
			// ./src/VSLTreeParser.g:10:3: (e= function[symTab] )
			// ./src/VSLTreeParser.g:10:5: e= function[symTab]
			{
			pushFollow(FOLLOW_function_in_s60);
			e=function(symTab);
			state._fsp--;

			 code = e; 
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



	// $ANTLR start "statement"
	// ./src/VSLTreeParser.g:46:1: statement[SymbolTable symTab] returns [Code3a cod] : ( ^( ASSIGN_KW e= expression[symTab] IDENT ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) |b= block[symTab] );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		CommonTree IDENT1=null;
		ExpAttribute e =null;
		Code3a s1 =null;
		Code3a s2 =null;
		Code3a st =null;
		Code3a b =null;

		try {
			// ./src/VSLTreeParser.g:47:3: ( ^( ASSIGN_KW e= expression[symTab] IDENT ) | ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) | ^( WHILE_KW e= expression[symTab] st= statement[symTab] ) |b= block[symTab] )
			int alt3=4;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt3=1;
				}
				break;
			case IF_KW:
				{
				alt3=2;
				}
				break;
			case WHILE_KW:
				{
				alt3=3;
				}
				break;
			case BLOCK:
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
					// ./src/VSLTreeParser.g:47:5: ^( ASSIGN_KW e= expression[symTab] IDENT )
					{
					match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_statement214); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement218);
					e=expression(symTab);
					state._fsp--;

					IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_statement221); 
					match(input, Token.UP, null); 

					 
					      Type ty = e.type;
					      Operand3a id = symTab.lookup((IDENT1!=null?IDENT1.getText():null));
					      cod = e.code;
					      cod.append(new Code3a(new Inst3a(Inst3a.TAC.COPY, id, e.place, null)));
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:54:6: ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
					{
					match(input,IF_KW,FOLLOW_IF_KW_in_statement237); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement241);
					e=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_statement_in_statement247);
					s1=statement(symTab);
					state._fsp--;

					// ./src/VSLTreeParser.g:54:57: (s2= statement[symTab] )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==ASSIGN_KW||LA2_0==IF_KW||LA2_0==WHILE_KW||LA2_0==BLOCK) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// ./src/VSLTreeParser.g:54:59: s2= statement[symTab]
							{
							pushFollow(FOLLOW_statement_in_statement254);
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
					// ./src/VSLTreeParser.g:66:6: ^( WHILE_KW e= expression[symTab] st= statement[symTab] )
					{
					match(input,WHILE_KW,FOLLOW_WHILE_KW_in_statement273); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement277);
					e=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_statement_in_statement282);
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
					// ./src/VSLTreeParser.g:77:6: b= block[symTab]
					{
					pushFollow(FOLLOW_block_in_statement299);
					b=block(symTab);
					state._fsp--;

					cod=b;
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



	// $ANTLR start "type"
	// ./src/VSLTreeParser.g:81:1: type returns [FunctionType ty] : ( INT_KW | VOID_KW );
	public final FunctionType type() throws RecognitionException {
		FunctionType ty = null;


		try {
			// ./src/VSLTreeParser.g:82:5: ( INT_KW | VOID_KW )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==INT_KW) ) {
				alt4=1;
			}
			else if ( (LA4_0==VOID_KW) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// ./src/VSLTreeParser.g:82:7: INT_KW
					{
					match(input,INT_KW,FOLLOW_INT_KW_in_type329); 

					    	ty=new FunctionType(Type.INT);
					    	
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:85:7: VOID_KW
					{
					match(input,VOID_KW,FOLLOW_VOID_KW_in_type339); 

					    	ty=new FunctionType(Type.VOID);
					    	
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
	// ./src/VSLTreeParser.g:90:1: param[SymbolTable symTab] returns [Code3a cod] : ( IDENT | ^( ARRAY IDENT ) );
	public final Code3a param(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		CommonTree IDENT2=null;

		try {
			// ./src/VSLTreeParser.g:91:5: ( IDENT | ^( ARRAY IDENT ) )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==IDENT) ) {
				alt5=1;
			}
			else if ( (LA5_0==ARRAY) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// ./src/VSLTreeParser.g:91:7: IDENT
					{
					IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param365); 

					      Operand3a id = symTab.lookup((IDENT2!=null?IDENT2.getText():null));
					        if (id == null){
					        	VarSymbol vs = new VarSymbol(Type.INT, (IDENT2!=null?IDENT2.getText():null), symTab.getScope());
					        	symTab.insert((IDENT2!=null?IDENT2.getText():null), vs);
					        	cod = Code3aGenerator.genVar(vs);
					        	}
					        else {System.out.println("attention la variable " + (IDENT2!=null?IDENT2.getText():null)+ "est déclaré plusieurs fois");}
					      
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:101:7: ^( ARRAY IDENT )
					{
					match(input,ARRAY,FOLLOW_ARRAY_in_param382); 
					match(input, Token.DOWN, null); 
					match(input,IDENT,FOLLOW_IDENT_in_param384); 
					match(input, Token.UP, null); 

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
	// ./src/VSLTreeParser.g:104:1: param_list[SymbolTable symTab] returns [Code3a cod] : ^( PARAM (p= param[symTab] )* ) ;
	public final Code3a param_list(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a p =null;

		cod = new Code3a();
		try {
			// ./src/VSLTreeParser.g:106:5: ( ^( PARAM (p= param[symTab] )* ) )
			// ./src/VSLTreeParser.g:106:7: ^( PARAM (p= param[symTab] )* )
			{
			match(input,PARAM,FOLLOW_PARAM_in_param_list412); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// ./src/VSLTreeParser.g:106:15: (p= param[symTab] )*
				loop6:
				while (true) {
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==IDENT||LA6_0==ARRAY) ) {
						alt6=1;
					}

					switch (alt6) {
					case 1 :
						// ./src/VSLTreeParser.g:106:16: p= param[symTab]
						{
						pushFollow(FOLLOW_param_in_param_list417);
						p=param(symTab);
						state._fsp--;


						    cod.append(p);    
						    
						}
						break;

					default :
						break loop6;
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
	// ./src/VSLTreeParser.g:112:1: function[SymbolTable symTab] returns [Code3a cod] : ^( FUNC_KW t= type IDENT pl= param_list[symTab] ^( BODY st= statement[symTab] ) ) ;
	public final Code3a function(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		CommonTree IDENT3=null;
		FunctionType t =null;
		Code3a pl =null;
		Code3a st =null;

		cod = new Code3a();
		try {
			// ./src/VSLTreeParser.g:114:5: ( ^( FUNC_KW t= type IDENT pl= param_list[symTab] ^( BODY st= statement[symTab] ) ) )
			// ./src/VSLTreeParser.g:114:7: ^( FUNC_KW t= type IDENT pl= param_list[symTab] ^( BODY st= statement[symTab] ) )
			{
			match(input,FUNC_KW,FOLLOW_FUNC_KW_in_function450); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_function454);
			t=type();
			state._fsp--;

			IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_function456); 

			    	Operand3a id = symTab.lookup((IDENT3!=null?IDENT3.getText():null));
			        if (id == null){
			        	LabelSymbol labelFunc = new LabelSymbol((IDENT3!=null?IDENT3.getText():null));
			        	cod = new Code3a(new Inst3a(Inst3a.TAC.LABEL,labelFunc,null,null));
			        	FunctionSymbol fs = new FunctionSymbol(labelFunc,t);
			        	symTab.insert((IDENT3!=null?IDENT3.getText():null), fs);
			        	cod.append(Code3aGenerator.genFunction());
			        	}
			        else {System.out.println("attention la fonction " + (IDENT3!=null?IDENT3.getText():null)+ "est déclarée plusieurs fois");}

			        
			pushFollow(FOLLOW_param_list_in_function470);
			pl=param_list(symTab);
			state._fsp--;


			    		cod.append(pl);
			    	
			match(input,BODY,FOLLOW_BODY_in_function482); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_statement_in_function486);
			st=statement(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


			    		cod.append(st);
			    	
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
	// $ANTLR end "function"



	// $ANTLR start "inst_list"
	// ./src/VSLTreeParser.g:134:1: inst_list[SymbolTable symTab] returns [Code3a cod] : ^( INST (st= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a st =null;

		cod = new Code3a();
		try {
			// ./src/VSLTreeParser.g:136:5: ( ^( INST (st= statement[symTab] )+ ) )
			// ./src/VSLTreeParser.g:136:7: ^( INST (st= statement[symTab] )+ )
			{
			match(input,INST,FOLLOW_INST_in_inst_list519); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:136:14: (st= statement[symTab] )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==ASSIGN_KW||LA7_0==IF_KW||LA7_0==WHILE_KW||LA7_0==BLOCK) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// ./src/VSLTreeParser.g:136:15: st= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list524);
					st=statement(symTab);
					state._fsp--;


					    	cod.append(st) ;
					    
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
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
	// ./src/VSLTreeParser.g:141:1: block[SymbolTable symTab] returns [Code3a cod] : ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a d =null;
		Code3a il =null;

		try {
			// ./src/VSLTreeParser.g:142:5: ( ^( BLOCK d= declaration[symTab] il= inst_list[symTab] ) | ^( BLOCK il= inst_list[symTab] ) )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==BLOCK) ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1==DOWN) ) {
					int LA8_2 = input.LA(3);
					if ( (LA8_2==DECL) ) {
						alt8=1;
					}
					else if ( (LA8_2==INST) ) {
						alt8=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 8, 2, input);
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
							new NoViableAltException("", 8, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// ./src/VSLTreeParser.g:142:7: ^( BLOCK d= declaration[symTab] il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block557); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block561);
					d=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block566);
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
					// ./src/VSLTreeParser.g:149:7: ^( BLOCK il= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block584); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block588);
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
	// ./src/VSLTreeParser.g:155:1: declaration[SymbolTable symTab] returns [Code3a cod] : ^( DECL (dl= decl_list[symTab] ) ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a dl =null;

		try {
			// ./src/VSLTreeParser.g:156:5: ( ^( DECL (dl= decl_list[symTab] ) ) )
			// ./src/VSLTreeParser.g:156:7: ^( DECL (dl= decl_list[symTab] ) )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration622); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:156:14: (dl= decl_list[symTab] )
			// ./src/VSLTreeParser.g:156:15: dl= decl_list[symTab]
			{
			pushFollow(FOLLOW_decl_list_in_declaration627);
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
	// ./src/VSLTreeParser.g:161:1: decl_list[SymbolTable symTab] returns [Code3a cod] : (di= decl_item[symTab] )+ ;
	public final Code3a decl_list(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		Code3a di =null;

		cod = new Code3a();
		try {
			// ./src/VSLTreeParser.g:163:5: ( (di= decl_item[symTab] )+ )
			// ./src/VSLTreeParser.g:163:7: (di= decl_item[symTab] )+
			{
			// ./src/VSLTreeParser.g:163:7: (di= decl_item[symTab] )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==IDENT||LA9_0==ARDECL) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// ./src/VSLTreeParser.g:163:8: di= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_decl_list662);
					di=decl_item(symTab);
					state._fsp--;


					    	cod.append(di);
					    
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
	// $ANTLR end "decl_list"



	// $ANTLR start "decl_item"
	// ./src/VSLTreeParser.g:168:1: decl_item[SymbolTable symTab] returns [Code3a cod] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a cod = null;


		CommonTree IDENT4=null;

		try {
			// ./src/VSLTreeParser.g:169:5: ( IDENT | ^( ARDECL IDENT INTEGER ) )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==IDENT) ) {
				alt10=1;
			}
			else if ( (LA10_0==ARDECL) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// ./src/VSLTreeParser.g:169:7: IDENT
					{
					IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item689); 
					  
					        Operand3a id = symTab.lookup((IDENT4!=null?IDENT4.getText():null));
					        if (id == null){
					        	VarSymbol vs = new VarSymbol(Type.INT, (IDENT4!=null?IDENT4.getText():null), symTab.getScope());
					        	symTab.insert((IDENT4!=null?IDENT4.getText():null), vs);
					        	cod = Code3aGenerator.genVar(vs);
					        	}
					        else {System.out.println("attention la variable " + (IDENT4!=null?IDENT4.getText():null)+ "est déclaré plusieurs fois");}
					     
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:179:7: ^( ARDECL IDENT INTEGER )
					{
					match(input,ARDECL,FOLLOW_ARDECL_in_decl_item705); 
					match(input, Token.DOWN, null); 
					match(input,IDENT,FOLLOW_IDENT_in_decl_item707); 
					match(input,INTEGER,FOLLOW_INTEGER_in_decl_item709); 
					match(input, Token.UP, null); 

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



	// $ANTLR start "primary_exp"
	// ./src/VSLTreeParser.g:185:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER5=null;
		CommonTree IDENT6=null;

		try {
			// ./src/VSLTreeParser.g:186:3: ( INTEGER | IDENT )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==INTEGER) ) {
				alt11=1;
			}
			else if ( (LA11_0==IDENT) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// ./src/VSLTreeParser.g:186:5: INTEGER
					{
					INTEGER5=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp740); 

					      ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER5!=null?INTEGER5.getText():null)));
					      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:191:5: IDENT
					{
					IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp752); 

					      Operand3a id = symTab.lookup((IDENT6!=null?IDENT6.getText():null));
					      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup((IDENT6!=null?IDENT6.getText():null)));
					    
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

	// Delegated rules



	public static final BitSet FOLLOW_function_in_s60 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_expression83 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression87 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression92 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression108 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression112 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression117 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression133 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression137 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression142 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression158 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression162 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression167 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_statement214 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement218 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_statement221 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_KW_in_statement237 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement241 = new BitSet(new long[]{0x0000021000008020L});
	public static final BitSet FOLLOW_statement_in_statement247 = new BitSet(new long[]{0x0000021000008028L});
	public static final BitSet FOLLOW_statement_in_statement254 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_KW_in_statement273 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement277 = new BitSet(new long[]{0x0000021000008020L});
	public static final BitSet FOLLOW_statement_in_statement282 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_block_in_statement299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_KW_in_type329 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KW_in_type339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_param365 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_param382 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_param384 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PARAM_in_param_list412 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_param_list417 = new BitSet(new long[]{0x0000010000004008L});
	public static final BitSet FOLLOW_FUNC_KW_in_function450 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_function454 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_function456 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_param_list_in_function470 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_BODY_in_function482 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_function486 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list519 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list524 = new BitSet(new long[]{0x0000021000008028L});
	public static final BitSet FOLLOW_BLOCK_in_block557 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block561 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block566 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block584 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block588 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECL_in_declaration622 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_list_in_declaration627 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_decl_item_in_decl_list662 = new BitSet(new long[]{0x0000004000004002L});
	public static final BitSet FOLLOW_IDENT_in_decl_item689 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item705 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item707 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item709 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp740 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp752 = new BitSet(new long[]{0x0000000000000002L});
}
