package edu.uelbosque.interprete.lexer;

import java_cup.runtime.Symbol;
import edu.uelbosque.interprete.parser.*;
import java.util.*;

%%

%class Lexer
%line
%column
%cup
%cupdebug

%implements sym

%standalone


%{ 
  private static final Logger log = LoggerFactory.getLogger(Lexer.class);

  public ArrayList<Token> tokens = new ArrayList<Token>();

  private Symbol sym(int sym) {
    return new Symbol(sym);
  }

  private Symbol sym(int sym, Object val) {
    return new Symbol(sym, val);
  }
  
  public void printData(String type, String text){
	log.info("[" + type + ": " + text + "  Line: " + yyline + " Column: " + yycolumn + "]");
  }
  
  public void loadData(String type, String text){
	tokens.add(new Token(type,text,yyline,yycolumn));
  }

%}
ModelName=Model_Name
ModelType=Model_Type
Inputs=Inputs
InputName=Input_Name
InputType=Input_Type
Outputs=Outputs
OutputName=Output_Name
OutputType=Output_Type
Layers=Layers
LayerName=Layer_Name
LayerParams=Layer_Params
Model=Model
Input=Input
Output=Output
Layer=Layer
OpenBracket=\{
CloseBracket=\}
WhiteSpace=[\ \t\b\f\r\n]+
OneLineComment=(#)[^\n]*
String=\"(.[^\"]*)\"
Number=[0-9]+(\.[0-9]+)?
OpenParams=\[
CloseParams=\]
Colon=\:
Comma=\,
Type=BINARY|NUMBER|CATEGORICAL
MType=ANN|Tree|RandomForest|SVM|DecisionTree
%%
<YYINITIAL> {
{WhiteSpace}             { loadData("WS", yytext());}
{OneLineComment}         { loadData("CM", yytext());}
{ModelName}              { printData("RW", yytext());loadData("RW", yytext()); return sym(MN);}
{ModelType}              { printData("RW", yytext());loadData("RW", yytext()); return sym(MT);}
{Inputs}                 { printData("RW", yytext());loadData("RW", yytext()); return sym(IS);}
{InputName}              { printData("RW", yytext());loadData("RW", yytext()); return sym(IN);}
{InputType}              { printData("RW", yytext());loadData("RW", yytext()); return sym(IT);}
{Outputs}                { printData("RW", yytext());loadData("RW", yytext()); return sym(OS);}
{OutputName}             { printData("RW", yytext());loadData("RW", yytext()); return sym(ON);}
{OutputType}             { printData("RW", yytext());loadData("RW", yytext()); return sym(OT);}
{Layers}                 { printData("RW", yytext());loadData("RW", yytext()); return sym(LS);}
{LayerName}              { printData("RW", yytext());loadData("RW", yytext()); return sym(LN);}
{LayerParams}            { printData("RW", yytext());loadData("RW", yytext()); return sym(LP);}
{Model}                  { printData("RW", yytext());loadData("RW", yytext()); return sym(M);}
{Input}                  { printData("RW", yytext());loadData("RW", yytext()); return sym(I);}
{Output}                 { printData("RW", yytext());loadData("RW", yytext()); return sym(O);}
{Layer}                  { printData("RW", yytext());loadData("RW", yytext()); return sym(L);}
{OpenBracket}            { printData("OPEN B", yytext());loadData("OB", yytext()); return sym(OB);} 
{CloseBracket}           { printData("CLOSE B", yytext());loadData("CB", yytext()); return sym(CB); }
{String}                 { printData("STRING", yytext());loadData("STRING", yytext()); return sym(STRING, yytext()); }
{Number}                 { printData("NUMBER", yytext());loadData("NUMBER", yytext()); return sym(NUMBER, yytext()); }
{OpenParams}             { printData("OPEN P", yytext());loadData("OP", yytext()); return sym(OP); }
{CloseParams}            { printData("CLOSE P", yytext());loadData("CP", yytext()); return sym(CP); }
{Colon}                  { printData("COLON", yytext());loadData("COLON", yytext()); return sym(COLON); }
{Comma}                  { printData("COMMA", yytext());loadData("COMMA", yytext()); return sym(COMMA); }
{Type}                   { printData("TYPE", yytext());loadData("TYPE", yytext()); return sym(TYPE); }
{MType}                  { printData("MODEL TYPE", yytext());loadData("M_TYPE", yytext()); return sym(M_TYPE); }
}
[^]                      { throw new Error("Illegal character <"+yytext()+">"); }