/*-***
 *
 * This file defines a stand-alone lexical analyzer for a subset of the Pascal
 * programming language.  This is the same lexer that will later be integrated
 * with a CUP-based parser.
 */


%%
/*-*
 * LEXICAL FUNCTIONS:
 */

%class NotJavaLexer
%public
%type Token
%function getNextToken
%{    
    public boolean EOF()
    {
        return yy_atEOF;
    }
%}


/*-*
 * PATTERN DEFINITIONS:
 */
letter          = [A-Za-z]
digit           = [0-9]
alphanumeric    = {letter}|{digit}
other_id_char   = [_]
identifier      = {letter}{alphanumeric}*|{other_id_char}*{alphanumeric}
integer         = [-]{digit}*
string          = \"((\"(2))*{alphanumeric}*(\"(2))*)*\"
comment         = #.*\n
whitespace      = [ \n]


%%
/**
 * LEXICAL RULES:
 */
and             { return new Token(Token.AND, yytext()); }
do              { return new Token(Token.DO, yytext()); }
else            { return new Token(Token.ELSE, yytext()); }
function        { return new Token(Token.FUNCTION, yytext()); }
if              { return new Token(Token.IF, yytext()); }
implies         { return new Token(Token.IMPLIES, yytext()); }
not             { return new Token(Token.NOT, yytext()); }
or              { return new Token(Token.OR, yytext()); }
procedure       { return new Token(Token.PROCEDURE, yytext()); }
var             { return new Token(Token.VAR, yytext()); }
while           { return new Token(Token.WHILE, yytext()); }
xor             { return new Token(Token.XOR, yytext()); }
"*"             { return new Token(Token.TIMES, yytext()); }
"+"             { return new Token(Token.PLUS, yytext()); }
"-"             { return new Token(Token.MINUS, yytext()); }
"/"             { return new Token(Token.DIVIDE, yytext()); }
";"             { return new Token(Token.SEMI, yytext()); }
","             { return new Token(Token.COMMA, yytext()); }
"("             { return new Token(Token.LEFT_PAREN, yytext()); }
")"             { return new Token(Token.RT_PAREN, yytext()); }
"["             { return new Token(Token.LEFT_BRKT, yytext()); }
"]"             { return new Token(Token.RT_BRKT, yytext()); }
"<"             { return new Token(Token.LESS, yytext()); }
">"             { return new Token(Token.GTR, yytext()); }
"<="            { return new Token(Token.LESS_EQ, yytext()); }
">="            { return new Token(Token.GTR_EQ, yytext()); }
"=="            { return new Token(Token.EQ_TO, yytext()); }
"/="            { return new Token(Token.NOT_EQ, yytext()); }
":"             { return new Token(Token.COLON, yytext()); }
"->"            { return new Token(Token.RETURN, yytext()); }
"<-"            { return new Token(Token.ASSIGN, yytext()); }
"&"             { return new Token(Token.CONCAT, yytext()); }
{identifier}    { return new Token(Token.IDENT, yytext()); }
{integer}       { return new Token(Token.INT, yytext()); }
{string}        { return new Token(Token.STRING, yytext()); }
{comment}       { /* For this stand-alone lexer, print out comments. */
                  System.out.println("Recognized comment: " + yytext()); }
{whitespace}    { /* Ignore whitespace. */ }
.               { }
