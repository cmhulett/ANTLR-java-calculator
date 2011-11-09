grammar Calc;

@header {
import java.util.HashMap;
import java.lang.Math;
import java.math.MathContext;
import java.math.BigDecimal;
import java.io.*;
}

/*Main java method & create HashMap for storage.
  Lines are read in and evaluated one at a time.
  Output is printed to console, then return to new line
  and wait for next command.*/

@members {
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
}

/*Parser rules
  ANTLR is left associated and default look ahead of 1,
  so recursive rules that start with the same characters
  are split at the difference in the rule, not at the 
  beginning of the rule. 

  BigDecimal was used primarily for formatting output
  and operations that may result in non-terminating
  decimal numbers are rounded to 15 places. Also
  some gnarly type conversions but the output is pretty.*/

prog:   stat+ ;

stat:   exp NEWLINE {System.out.println($exp.value);}
    |   letExp NEWLINE
    |   printExp NEWLINE
    |   sumExp NEWLINE {System.out.println($sumExp.value);}
    |   avgExp NEWLINE {System.out.println(memory.get("Avg"));}
    |   NEWLINE
    ;

letExp : LET VAR '=' exp
	{memory.put($VAR.text, $exp.value);
	System.out.println($VAR.text + " is set to " + $exp.value);}
    ;

sumExp returns [BigDecimal value]
    :   SUM '(' listExp ')' 
	{$value = $listExp.value;}
    ;

listExp returns [BigDecimal value]
    :   a=exp {$value = $a.value;}
        (',' b=listExp {$value = $value.add($b.value);}
	|
	)
    ;

avgExp returns [double value]
@init{
int counter = 0;
memory.put("Counter",counter);
}
    :   AVG '(' avgCalc ')' {MathContext mc = new MathContext(15);
	double dbl3 = Double.parseDouble($avgCalc.value.toPlainString());
	int int1 = (Integer)memory.get("Counter");
	dbl3 = dbl3/int1;
	memory.put("Avg",dbl3);}
    ;

avgCalc returns [BigDecimal value]
    :   a=exp {$value = $a.value;
	int counter = (Integer)memory.get("Counter");
	counter++;
	memory.put("Counter",counter);}
	(',' b=avgCalc {$value = $value.add($b.value);}
	|
	)
    ;

exp returns [BigDecimal value]
    :   a=multExp {$value = $a.value;}
        (   '+' b=multExp {$value = $value.add($b.value);}
        |   '-' b=multExp {$value = $value.subtract($b.value);}
        )*
    ;

multExp returns [BigDecimal value]
    :   a=atom {$value = $a.value;}
	(    '*' b=atom {$value = $value.multiply($b.value);}
	|    '/' b=atom {MathContext mc = new MathContext(15);
		 double dbl1 = Double.parseDouble($value.toPlainString());
		 double dbl2 = Double.parseDouble($b.value.toPlainString());
		 dbl1 = dbl1/dbl2;
		 $value = new BigDecimal(dbl1,mc);}
	)*
    ;

atom returns [BigDecimal value]
    :   BD {$value = new BigDecimal($BD.text);}
    |   VAR 
	{
	BigDecimal v = (BigDecimal)memory.get($VAR.text);
        if ( v!=null ) $value = v;
        else System.err.println("undefined variable "+$VAR.text);
        }
    |   TRIG '(' exp ')' {
	MathContext mc = new MathContext(15);
	if($TRIG.text.equals("sin") ) {
		double dbl = Math.sin(Double.parseDouble($exp.value.toPlainString()));
		$value = new BigDecimal(dbl,mc);}
	if($TRIG.text.equals("cos") ) {
		double dbl = Math.cos(Double.parseDouble($exp.value.toPlainString()));
		$value = new BigDecimal(dbl,mc);}
	if($TRIG.text.equals("tan") ) {
		double dbl = Math.tan(Double.parseDouble($exp.value.toPlainString()));
		$value = new BigDecimal(dbl,mc);}
	}
    |   '(' exp ')' {$value = $exp.value;}
    ;

printExp : PRINT
	(    exp {System.out.println($exp.text);}
	|    avgExp {System.out.println($avgExp.text);}
	|    sumExp {System.out.println($sumExp.text);}
	)    
    ;

/*Lexer rules*/

LET :   'let'|'LET'|'Let' ;
PRINT : 'print'|'PRINT'|'Print' ;
TRIG :  'sin'|'cos'|'tan'|'SIN'|'COS'|'TAN';
SUM :   'sum'|'SUM'|'Sum' ;
AVG :   'avg'|'AVG'|'Avg' ;
VAR :   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9')* ;
BD :   ('0'..'9')+ ('.' ('0'..'9')+)? ;
NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t')+ {skip();} ;