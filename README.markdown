Running instructions:
---------------------
clone repo, download antlr executable jar into directory (built with antlr-3.2.jar)

build with:
java -cp antlr-3.2.jar org.antlr.Tool Calc.g
javac -cp .;antlr-3.2.jar CalcParser.java CalcLexer.java

run with Windows: java -cp .;antlr-3.2.jar CalcParser

run with Unix: java -cp .:antlr-3.2.jar CalcParser



Calc.g contains main java method, Parser and Lexer grammar rules, and comments.

Calc.g was started using the tutorial posted by Terence Parr as a foundation
available at http://www.antlr.org/wiki/display/ANTLR3/Expression+evaluator
and finished with lots of coffee.

Features:
* Non-significant whitespace
* Variables start with an upper or lower case letter follow by alphanumerics or underscores, 
* and are defined in the form: let <variable> = <expression>
* print <expression> prints the expression to the console instead of printing the evaluation.
* +,-,*,/ supported and left associative.
* (,) supported to override operator precedence.
* Trig functions sin, cos, and tan are evaluated in radians,
* e.g. sin(5) returns sine of 5 radians in radians.
* avg(exp1,exp2,...,expn) evaluates the average of the argument expressions.
* sum(exp1,exp2,...,expn) evaluates the sum of the argument expressions.

Screenshots:
![Screenshot1 (screenshot1)](https://github.com/cmhulett/ANTLR-java-calculator/raw/master/ScreenShot1.png "Screenshot1")

![Screenshot2 (screenshot2)](https://github.com/cmhulett/ANTLR-java-calculator/raw/master/ScreenShot2.png "Screenshot2")
