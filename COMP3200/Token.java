public class Token {

   int tokenType;
   String tokenValue;

   public Token(int inputType, String inputText){
   // Implement this constructor so that it stores the input 
   // parameters in the new object's state
   tokenType = inputType;
   
   if (inputType == 26) {
      inputText = inputText.replace("\"\"", "\"");
   }
   
   tokenValue = inputText;
   // Make sure that if the input type is a string literal that the
   // input text is stored without the duplicated internal double quotes
   }

// Create a series of named constants, one for each of the token types
// (for example, I have done AND for you)

   public static final int MINUS = 2;
   public static final int TIMES = 3;
   public static final int PLUS = 4;
   public static final int DIVIDE = 5;
   public static final int SEMI = 6;
   public static final int COMMA = 7;
   public static final int LEFT_PAREN = 8;
   public static final int RT_PAREN = 9;
   public static final int LEFT_BRKT = 10;
   public static final int RT_BRKT = 11;
   public static final int LESS = 12;
   public static final int GTR = 13;
   public static final int COLON = 14;
   public static final int CONCAT = 15;
   public static final int INT = 16;
   public static final int RETURN = 17;
   public static final int DO = 18;
   public static final int OR = 19;
   public static final int IF = 20;
   public static final int NOT_EQ = 21;
   public static final int ASSIGN = 22;
   public static final int LESS_EQ = 23;
   public static final int GTR_EQ = 24;
   public static final int EQ_TO = 25;
   public static final int STRING = 26;
   public static final int AND = 27;
   public static final int NOT = 28;
   public static final int VAR = 29;
   public static final int XOR = 30;
   public static final int ELSE = 31;
   public static final int WHILE = 32;
   public static final int IMPLIES = 33;
   public static final int FUNCTION = 34;
   public static final int IDENT = 35;
   public static final int PROCEDURE = 36;   


// Create a toString method for this class that prints the token type description
// (similar to what is in the lab-writeup specification for output). Make sure that
// it also displays the corresponding values for integer & string literals and 
// identifiers.

   public String toString() {
      if (this.tokenType == 2){
         return "MINUS";
      } else if (this.tokenType == 3) {
         return "TIMES";
      } else if (this.tokenType == 4) {
         return "PLUS";
      } else if (this.tokenType == 5) {
         return "DIVIDE";
      } else if (this.tokenType == 6) {
         return "SEMI";
      } else if (this.tokenType == 7) {
         return "COMMA";
      } else if (this.tokenType == 8) {
         return "LEFT_PAREN";
      } else if (this.tokenType == 9) {
         return "RT_PAREN";
      } else if (this.tokenType == 10) {
         return "LEFT_BRKT";
      } else if (this.tokenType == 11) {
         return "RT_BRKT";
      } else if (this.tokenType == 12) {
         return "LESS";
      } else if (this.tokenType == 13) {
         return "GTR";
      } else if (this.tokenType == 14) {
         return "COLON";
      } else if (this.tokenType == 15) {
         return "CONCAT";
      } else if (this.tokenType == 16) {
         return "INT (" + tokenValue + ")";
      } else if (this.tokenType == 17) {
         return "RETURN";
      } else if (this.tokenType == 18) {
         return "DO";
      } else if (this.tokenType == 19) {
         return "OR";
      } else if (this.tokenType == 20) {
         return "IF";
      } else if (this.tokenType == 21) {
         return "NOT_EQ";
      } else if (this.tokenType == 22) {
         return "ASSIGN";
      } else if (this.tokenType == 23) {
         return "LESS_EQ";
      } else if (this.tokenType == 24) {
         return "GTR_EQ";
      } else if (this.tokenType == 25) {
         return "EQ_TO";
      } else if (this.tokenType == 26) {
         return "STRING (" + tokenValue + ")";
      } else if (this.tokenType == 27) {
         return "AND";
      } else if (this.tokenType == 28) {
         return "NOT";
      } else if (this.tokenType == 29) {
         return "VAR";
      } else if (this.tokenType == 30) {
         return "XOR";
      } else if (this.tokenType == 31) {
         return "ELSE";
      } else if (this.tokenType == 32) {
         return "WHILE";
      } else if (this.tokenType == 33) {
         return "IMPLIES";
      } else if (this.tokenType == 34) {
         return "FUNCTION";
      } else if (this.tokenType == 35) {
         return "IDENTIFIER (" + tokenValue + ")";
      } else if (this.tokenType == 36) {
         return "PROCEDURE";
      }
    return "";
  }
}