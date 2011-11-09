// $ANTLR 3.2 Sep 23, 2009 12:02:23 Calc.g 2011-10-28 01:17:47

import java.util.HashMap;
import java.lang.Math;
import java.math.MathContext;
import java.math.BigDecimal;
import java.io.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CalcParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEWLINE", "LET", "VAR", "SUM", "AVG", "BD", "TRIG", "PRINT", "WS", "'='", "'('", "')'", "','", "'+'", "'-'", "'*'", "'/'"
    };
    public static final int T__20=20;
    public static final int TRIG=10;
    public static final int BD=9;
    public static final int SUM=7;
    public static final int EOF=-1;
    public static final int PRINT=11;
    public static final int T__19=19;
    public static final int WS=12;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int NEWLINE=4;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int AVG=8;
    public static final int VAR=6;
    public static final int LET=5;

    // delegates
    // delegators


        public CalcParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CalcParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CalcParser.tokenNames; }
    public String getGrammarFileName() { return "Calc.g"; }


    public static HashMap<String,Object> memory = new HashMap<String,Object>();
    public static void main(String[] args) throws Exception {	
    	System.out.println("Type 'exit' to quit");
    	String line = "";
    	InputStreamReader conv = new InputStreamReader(System.in);
    	BufferedReader in = new BufferedReader(conv);
    	while(!(line.equals("exit"))){

    		line = in.readLine();

    		if(!(line.equals("exit"))){
    			CalcLexer lexer = new CalcLexer(
    				new ANTLRStringStream(line+System.getProperty("line.separator")));
    			CommonTokenStream tokens = new CommonTokenStream(lexer);
    			CalcParser parser = new CalcParser(tokens);
    			parser.prog();
    		}
    		
    	}
            
         }



    // $ANTLR start "prog"
    // Calc.g:51:1: prog : ( stat )+ ;
    public final void prog() throws RecognitionException {
        try {
            // Calc.g:51:5: ( ( stat )+ )
            // Calc.g:51:9: ( stat )+
            {
            // Calc.g:51:9: ( stat )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=NEWLINE && LA1_0<=PRINT)||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Calc.g:51:9: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_prog29);
            	    stat();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "prog"


    // $ANTLR start "stat"
    // Calc.g:53:1: stat : ( exp NEWLINE | letExp NEWLINE | printExp NEWLINE | sumExp NEWLINE | avgExp NEWLINE | NEWLINE );
    public final void stat() throws RecognitionException {
        CalcParser.exp_return exp1 = null;

        CalcParser.sumExp_return sumExp2 = null;


        try {
            // Calc.g:53:5: ( exp NEWLINE | letExp NEWLINE | printExp NEWLINE | sumExp NEWLINE | avgExp NEWLINE | NEWLINE )
            int alt2=6;
            switch ( input.LA(1) ) {
            case VAR:
            case BD:
            case TRIG:
            case 14:
                {
                alt2=1;
                }
                break;
            case LET:
                {
                alt2=2;
                }
                break;
            case PRINT:
                {
                alt2=3;
                }
                break;
            case SUM:
                {
                alt2=4;
                }
                break;
            case AVG:
                {
                alt2=5;
                }
                break;
            case NEWLINE:
                {
                alt2=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // Calc.g:53:9: exp NEWLINE
                    {
                    pushFollow(FOLLOW_exp_in_stat40);
                    exp1=exp();

                    state._fsp--;

                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat42); 
                    System.out.println((exp1!=null?exp1.value:null));

                    }
                    break;
                case 2 :
                    // Calc.g:54:9: letExp NEWLINE
                    {
                    pushFollow(FOLLOW_letExp_in_stat54);
                    letExp();

                    state._fsp--;

                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat56); 

                    }
                    break;
                case 3 :
                    // Calc.g:55:9: printExp NEWLINE
                    {
                    pushFollow(FOLLOW_printExp_in_stat66);
                    printExp();

                    state._fsp--;

                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat68); 

                    }
                    break;
                case 4 :
                    // Calc.g:56:9: sumExp NEWLINE
                    {
                    pushFollow(FOLLOW_sumExp_in_stat78);
                    sumExp2=sumExp();

                    state._fsp--;

                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat80); 
                    System.out.println((sumExp2!=null?sumExp2.value:null));

                    }
                    break;
                case 5 :
                    // Calc.g:57:9: avgExp NEWLINE
                    {
                    pushFollow(FOLLOW_avgExp_in_stat92);
                    avgExp();

                    state._fsp--;

                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat94); 
                    System.out.println(memory.get("Avg"));

                    }
                    break;
                case 6 :
                    // Calc.g:58:9: NEWLINE
                    {
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat106); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "stat"


    // $ANTLR start "letExp"
    // Calc.g:61:1: letExp : LET VAR '=' exp ;
    public final void letExp() throws RecognitionException {
        Token VAR3=null;
        CalcParser.exp_return exp4 = null;


        try {
            // Calc.g:61:8: ( LET VAR '=' exp )
            // Calc.g:61:10: LET VAR '=' exp
            {
            match(input,LET,FOLLOW_LET_in_letExp119); 
            VAR3=(Token)match(input,VAR,FOLLOW_VAR_in_letExp121); 
            match(input,13,FOLLOW_13_in_letExp123); 
            pushFollow(FOLLOW_exp_in_letExp125);
            exp4=exp();

            state._fsp--;

            memory.put((VAR3!=null?VAR3.getText():null), (exp4!=null?exp4.value:null));
            	System.out.println((VAR3!=null?VAR3.getText():null) + " is set to " + (exp4!=null?exp4.value:null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "letExp"

    public static class sumExp_return extends ParserRuleReturnScope {
        public BigDecimal value;
    };

    // $ANTLR start "sumExp"
    // Calc.g:66:1: sumExp returns [BigDecimal value] : SUM '(' listExp ')' ;
    public final CalcParser.sumExp_return sumExp() throws RecognitionException {
        CalcParser.sumExp_return retval = new CalcParser.sumExp_return();
        retval.start = input.LT(1);

        BigDecimal listExp5 = null;


        try {
            // Calc.g:67:5: ( SUM '(' listExp ')' )
            // Calc.g:67:9: SUM '(' listExp ')'
            {
            match(input,SUM,FOLLOW_SUM_in_sumExp151); 
            match(input,14,FOLLOW_14_in_sumExp153); 
            pushFollow(FOLLOW_listExp_in_sumExp155);
            listExp5=listExp();

            state._fsp--;

            match(input,15,FOLLOW_15_in_sumExp157); 
            retval.value = listExp5;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sumExp"


    // $ANTLR start "listExp"
    // Calc.g:71:1: listExp returns [BigDecimal value] : a= exp ( ',' b= listExp | ) ;
    public final BigDecimal listExp() throws RecognitionException {
        BigDecimal value = null;

        CalcParser.exp_return a = null;

        BigDecimal b = null;


        try {
            // Calc.g:72:5: (a= exp ( ',' b= listExp | ) )
            // Calc.g:72:9: a= exp ( ',' b= listExp | )
            {
            pushFollow(FOLLOW_exp_in_listExp186);
            a=exp();

            state._fsp--;

            value = (a!=null?a.value:null);
            // Calc.g:73:9: ( ',' b= listExp | )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            else if ( (LA3_0==15) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // Calc.g:73:10: ',' b= listExp
                    {
                    match(input,16,FOLLOW_16_in_listExp199); 
                    pushFollow(FOLLOW_listExp_in_listExp203);
                    b=listExp();

                    state._fsp--;

                    value = value.add(b);

                    }
                    break;
                case 2 :
                    // Calc.g:75:2: 
                    {
                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "listExp"

    public static class avgExp_return extends ParserRuleReturnScope {
        public double value;
    };

    // $ANTLR start "avgExp"
    // Calc.g:78:1: avgExp returns [double value] : AVG '(' avgCalc ')' ;
    public final CalcParser.avgExp_return avgExp() throws RecognitionException {
        CalcParser.avgExp_return retval = new CalcParser.avgExp_return();
        retval.start = input.LT(1);

        BigDecimal avgCalc6 = null;



        int counter = 0;
        memory.put("Counter",counter);

        try {
            // Calc.g:83:5: ( AVG '(' avgCalc ')' )
            // Calc.g:83:9: AVG '(' avgCalc ')'
            {
            match(input,AVG,FOLLOW_AVG_in_avgExp238); 
            match(input,14,FOLLOW_14_in_avgExp240); 
            pushFollow(FOLLOW_avgCalc_in_avgExp242);
            avgCalc6=avgCalc();

            state._fsp--;

            match(input,15,FOLLOW_15_in_avgExp244); 
            MathContext mc = new MathContext(15);
            	double dbl3 = Double.parseDouble(avgCalc6.toPlainString());
            	int int1 = (Integer)memory.get("Counter");
            	dbl3 = dbl3/int1;
            	memory.put("Avg",dbl3);

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "avgExp"


    // $ANTLR start "avgCalc"
    // Calc.g:90:1: avgCalc returns [BigDecimal value] : a= exp ( ',' b= avgCalc | ) ;
    public final BigDecimal avgCalc() throws RecognitionException {
        BigDecimal value = null;

        CalcParser.exp_return a = null;

        BigDecimal b = null;


        try {
            // Calc.g:91:5: (a= exp ( ',' b= avgCalc | ) )
            // Calc.g:91:9: a= exp ( ',' b= avgCalc | )
            {
            pushFollow(FOLLOW_exp_in_avgCalc271);
            a=exp();

            state._fsp--;

            value = (a!=null?a.value:null);
            	int counter = (Integer)memory.get("Counter");
            	counter++;
            	memory.put("Counter",counter);
            // Calc.g:95:2: ( ',' b= avgCalc | )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // Calc.g:95:3: ',' b= avgCalc
                    {
                    match(input,16,FOLLOW_16_in_avgCalc277); 
                    pushFollow(FOLLOW_avgCalc_in_avgCalc281);
                    b=avgCalc();

                    state._fsp--;

                    value = value.add(b);

                    }
                    break;
                case 2 :
                    // Calc.g:97:2: 
                    {
                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "avgCalc"

    public static class exp_return extends ParserRuleReturnScope {
        public BigDecimal value;
    };

    // $ANTLR start "exp"
    // Calc.g:100:1: exp returns [BigDecimal value] : a= multExp ( '+' b= multExp | '-' b= multExp )* ;
    public final CalcParser.exp_return exp() throws RecognitionException {
        CalcParser.exp_return retval = new CalcParser.exp_return();
        retval.start = input.LT(1);

        BigDecimal a = null;

        BigDecimal b = null;


        try {
            // Calc.g:101:5: (a= multExp ( '+' b= multExp | '-' b= multExp )* )
            // Calc.g:101:9: a= multExp ( '+' b= multExp | '-' b= multExp )*
            {
            pushFollow(FOLLOW_multExp_in_exp314);
            a=multExp();

            state._fsp--;

            retval.value = a;
            // Calc.g:102:9: ( '+' b= multExp | '-' b= multExp )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }
                else if ( (LA5_0==18) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // Calc.g:102:13: '+' b= multExp
            	    {
            	    match(input,17,FOLLOW_17_in_exp330); 
            	    pushFollow(FOLLOW_multExp_in_exp334);
            	    b=multExp();

            	    state._fsp--;

            	    retval.value = retval.value.add(b);

            	    }
            	    break;
            	case 2 :
            	    // Calc.g:103:13: '-' b= multExp
            	    {
            	    match(input,18,FOLLOW_18_in_exp350); 
            	    pushFollow(FOLLOW_multExp_in_exp354);
            	    b=multExp();

            	    state._fsp--;

            	    retval.value = retval.value.subtract(b);

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exp"


    // $ANTLR start "multExp"
    // Calc.g:107:1: multExp returns [BigDecimal value] : a= atom ( '*' b= atom | '/' b= atom )* ;
    public final BigDecimal multExp() throws RecognitionException {
        BigDecimal value = null;

        BigDecimal a = null;

        BigDecimal b = null;


        try {
            // Calc.g:108:5: (a= atom ( '*' b= atom | '/' b= atom )* )
            // Calc.g:108:9: a= atom ( '*' b= atom | '/' b= atom )*
            {
            pushFollow(FOLLOW_atom_in_multExp392);
            a=atom();

            state._fsp--;

            value = a;
            // Calc.g:109:2: ( '*' b= atom | '/' b= atom )*
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }
                else if ( (LA6_0==20) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // Calc.g:109:7: '*' b= atom
            	    {
            	    match(input,19,FOLLOW_19_in_multExp402); 
            	    pushFollow(FOLLOW_atom_in_multExp406);
            	    b=atom();

            	    state._fsp--;

            	    value = value.multiply(b);

            	    }
            	    break;
            	case 2 :
            	    // Calc.g:110:7: '/' b= atom
            	    {
            	    match(input,20,FOLLOW_20_in_multExp416); 
            	    pushFollow(FOLLOW_atom_in_multExp420);
            	    b=atom();

            	    state._fsp--;

            	    MathContext mc = new MathContext(15);
            	    		 double dbl1 = Double.parseDouble(value.toPlainString());
            	    		 double dbl2 = Double.parseDouble(b.toPlainString());
            	    		 dbl1 = dbl1/dbl2;
            	    		 value = new BigDecimal(dbl1,mc);

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "multExp"


    // $ANTLR start "atom"
    // Calc.g:118:1: atom returns [BigDecimal value] : ( BD | VAR | TRIG '(' exp ')' | '(' exp ')' );
    public final BigDecimal atom() throws RecognitionException {
        BigDecimal value = null;

        Token BD7=null;
        Token VAR8=null;
        Token TRIG9=null;
        CalcParser.exp_return exp10 = null;

        CalcParser.exp_return exp11 = null;


        try {
            // Calc.g:119:5: ( BD | VAR | TRIG '(' exp ')' | '(' exp ')' )
            int alt7=4;
            switch ( input.LA(1) ) {
            case BD:
                {
                alt7=1;
                }
                break;
            case VAR:
                {
                alt7=2;
                }
                break;
            case TRIG:
                {
                alt7=3;
                }
                break;
            case 14:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // Calc.g:119:9: BD
                    {
                    BD7=(Token)match(input,BD,FOLLOW_BD_in_atom449); 
                    value = new BigDecimal((BD7!=null?BD7.getText():null));

                    }
                    break;
                case 2 :
                    // Calc.g:120:9: VAR
                    {
                    VAR8=(Token)match(input,VAR,FOLLOW_VAR_in_atom461); 

                    	BigDecimal v = (BigDecimal)memory.get((VAR8!=null?VAR8.getText():null));
                            if ( v!=null ) value = v;
                            else System.err.println("undefined variable "+(VAR8!=null?VAR8.getText():null));
                            

                    }
                    break;
                case 3 :
                    // Calc.g:126:9: TRIG '(' exp ')'
                    {
                    TRIG9=(Token)match(input,TRIG,FOLLOW_TRIG_in_atom475); 
                    match(input,14,FOLLOW_14_in_atom477); 
                    pushFollow(FOLLOW_exp_in_atom479);
                    exp10=exp();

                    state._fsp--;

                    match(input,15,FOLLOW_15_in_atom481); 

                    	MathContext mc = new MathContext(15);
                    	if((TRIG9!=null?TRIG9.getText():null).equals("sin") ) {
                    		double dbl = Math.sin(Double.parseDouble((exp10!=null?exp10.value:null).toPlainString()));
                    		value = new BigDecimal(dbl,mc);}
                    	if((TRIG9!=null?TRIG9.getText():null).equals("cos") ) {
                    		double dbl = Math.cos(Double.parseDouble((exp10!=null?exp10.value:null).toPlainString()));
                    		value = new BigDecimal(dbl,mc);}
                    	if((TRIG9!=null?TRIG9.getText():null).equals("tan") ) {
                    		double dbl = Math.tan(Double.parseDouble((exp10!=null?exp10.value:null).toPlainString()));
                    		value = new BigDecimal(dbl,mc);}
                    	

                    }
                    break;
                case 4 :
                    // Calc.g:138:9: '(' exp ')'
                    {
                    match(input,14,FOLLOW_14_in_atom493); 
                    pushFollow(FOLLOW_exp_in_atom495);
                    exp11=exp();

                    state._fsp--;

                    match(input,15,FOLLOW_15_in_atom497); 
                    value = (exp11!=null?exp11.value:null);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "atom"


    // $ANTLR start "printExp"
    // Calc.g:141:1: printExp : PRINT ( exp | avgExp | sumExp ) ;
    public final void printExp() throws RecognitionException {
        CalcParser.exp_return exp12 = null;

        CalcParser.avgExp_return avgExp13 = null;

        CalcParser.sumExp_return sumExp14 = null;


        try {
            // Calc.g:141:10: ( PRINT ( exp | avgExp | sumExp ) )
            // Calc.g:141:12: PRINT ( exp | avgExp | sumExp )
            {
            match(input,PRINT,FOLLOW_PRINT_in_printExp512); 
            // Calc.g:142:2: ( exp | avgExp | sumExp )
            int alt8=3;
            switch ( input.LA(1) ) {
            case VAR:
            case BD:
            case TRIG:
            case 14:
                {
                alt8=1;
                }
                break;
            case AVG:
                {
                alt8=2;
                }
                break;
            case SUM:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // Calc.g:142:7: exp
                    {
                    pushFollow(FOLLOW_exp_in_printExp520);
                    exp12=exp();

                    state._fsp--;

                    System.out.println((exp12!=null?input.toString(exp12.start,exp12.stop):null));

                    }
                    break;
                case 2 :
                    // Calc.g:143:7: avgExp
                    {
                    pushFollow(FOLLOW_avgExp_in_printExp530);
                    avgExp13=avgExp();

                    state._fsp--;

                    System.out.println((avgExp13!=null?input.toString(avgExp13.start,avgExp13.stop):null));

                    }
                    break;
                case 3 :
                    // Calc.g:144:7: sumExp
                    {
                    pushFollow(FOLLOW_sumExp_in_printExp540);
                    sumExp14=sumExp();

                    state._fsp--;

                    System.out.println((sumExp14!=null?input.toString(sumExp14.start,sumExp14.stop):null));

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "printExp"

    // Delegated rules


 

    public static final BitSet FOLLOW_stat_in_prog29 = new BitSet(new long[]{0x0000000000004FF2L});
    public static final BitSet FOLLOW_exp_in_stat40 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NEWLINE_in_stat42 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_letExp_in_stat54 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NEWLINE_in_stat56 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_printExp_in_stat66 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NEWLINE_in_stat68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sumExp_in_stat78 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NEWLINE_in_stat80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_avgExp_in_stat92 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NEWLINE_in_stat94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_stat106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LET_in_letExp119 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_VAR_in_letExp121 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_letExp123 = new BitSet(new long[]{0x0000000000004640L});
    public static final BitSet FOLLOW_exp_in_letExp125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUM_in_sumExp151 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_sumExp153 = new BitSet(new long[]{0x0000000000004640L});
    public static final BitSet FOLLOW_listExp_in_sumExp155 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_sumExp157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exp_in_listExp186 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_listExp199 = new BitSet(new long[]{0x0000000000004640L});
    public static final BitSet FOLLOW_listExp_in_listExp203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AVG_in_avgExp238 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_avgExp240 = new BitSet(new long[]{0x0000000000004640L});
    public static final BitSet FOLLOW_avgCalc_in_avgExp242 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_avgExp244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exp_in_avgCalc271 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_avgCalc277 = new BitSet(new long[]{0x0000000000004640L});
    public static final BitSet FOLLOW_avgCalc_in_avgCalc281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multExp_in_exp314 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_17_in_exp330 = new BitSet(new long[]{0x0000000000004640L});
    public static final BitSet FOLLOW_multExp_in_exp334 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_18_in_exp350 = new BitSet(new long[]{0x0000000000004640L});
    public static final BitSet FOLLOW_multExp_in_exp354 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_atom_in_multExp392 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_19_in_multExp402 = new BitSet(new long[]{0x0000000000004640L});
    public static final BitSet FOLLOW_atom_in_multExp406 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_20_in_multExp416 = new BitSet(new long[]{0x0000000000004640L});
    public static final BitSet FOLLOW_atom_in_multExp420 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_BD_in_atom449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_atom461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRIG_in_atom475 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_atom477 = new BitSet(new long[]{0x0000000000004640L});
    public static final BitSet FOLLOW_exp_in_atom479 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_atom481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_atom493 = new BitSet(new long[]{0x0000000000004640L});
    public static final BitSet FOLLOW_exp_in_atom495 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_atom497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_printExp512 = new BitSet(new long[]{0x00000000000047C0L});
    public static final BitSet FOLLOW_exp_in_printExp520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_avgExp_in_printExp530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sumExp_in_printExp540 = new BitSet(new long[]{0x0000000000000002L});

}