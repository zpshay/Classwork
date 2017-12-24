/* The following code was generated by JFlex 1.3.5 on 11/28/17 1:46 PM */

/*-***
 *
 * This file defines a stand-alone lexical analyzer for a subset of the Pascal
 * programming language.  This is the same lexer that will later be integrated
 * with a CUP-based parser.
 */



/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.3.5
 * on 11/28/17 1:46 PM from the specification file
 * <tt>file:/C:/Users/Zachary/Documents/School/COMP3200/notjava.jflex</tt>
 */
public class NotJavaLexer {

  /** This character denotes the end of file */
  final public static int YYEOF = -1;

  /** initial size of the lookahead buffer */
  final private static int YY_BUFFERSIZE = 16384;

  /** lexical states */
  final public static int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  final private static char [] yycmap = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  8,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     9,  0,  5,  7,  0,  0, 42,  0, 34, 35, 29, 30, 33,  4,  0, 31, 
     2,  2,  6,  2,  2,  2,  2,  2,  2,  2, 41, 32, 38, 40, 39,  0, 
     0,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 36,  0, 37,  0,  3, 
     0, 10,  1, 19, 12, 14, 17,  1, 27, 21,  1,  1, 15, 22, 11, 13, 
    23,  1, 24, 16, 20, 18, 25, 26, 28,  1,  1,  0,  0,  0,  0,  0
  };

  /** 
   * Translates a state to a row index in the transition table
   */
  final private static int yy_rowMap [] = { 
        0,    43,    86,    43,   129,   172,   215,   258,    43,   301, 
      344,   387,   430,   473,   516,   559,   602,   645,   688,   731, 
       43,    43,   774,    43,    43,    43,    43,    43,    43,   817, 
      860,   903,    43,    43,   129,   946,    43,   215,   989,   258, 
       43,  1032,  1075,    86,    86,  1118,  1161,    86,  1204,  1247, 
     1290,  1333,  1376,    43,    43,    43,    43,    43,    86,    86, 
     1419,  1462,  1505,  1548,    86,  1591,    86,    86,  1634,  1677, 
     1720,  1763,  1806,  1849,  1892,    86,  1935,  1978,  2021,  2064, 
       86,  2107,    86,  2150,    86
  };

  /** 
   * The packed transition table of the DFA (part 0)
   */
  final private static String yy_packed0 = 
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\4\1\10"+
    "\2\11\1\12\1\13\1\14\1\15\1\16\2\3\1\17"+
    "\3\3\1\20\1\3\1\21\1\3\1\22\1\23\1\3"+
    "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\54\0"+
    "\2\3\3\0\1\3\3\0\23\3\17\0\2\4\1\43"+
    "\2\0\1\4\3\0\23\4\20\0\1\44\3\0\1\44"+
    "\40\0\1\45\4\0\2\46\2\0\1\47\1\46\3\0"+
    "\23\46\16\0\10\50\1\51\42\50\1\0\2\3\3\0"+
    "\1\3\3\0\1\3\1\52\21\3\17\0\2\3\3\0"+
    "\1\3\3\0\3\3\1\53\17\3\17\0\2\3\3\0"+
    "\1\3\3\0\3\3\1\54\17\3\17\0\2\3\3\0"+
    "\1\3\3\0\16\3\1\55\4\3\17\0\2\3\3\0"+
    "\1\3\3\0\5\3\1\56\15\3\17\0\2\3\3\0"+
    "\1\3\3\0\10\3\1\57\12\3\17\0\2\3\3\0"+
    "\1\3\3\0\7\3\1\60\4\3\1\61\6\3\17\0"+
    "\2\3\3\0\1\3\3\0\16\3\1\62\4\3\17\0"+
    "\2\3\3\0\1\3\3\0\1\63\22\3\17\0\2\3"+
    "\3\0\1\3\3\0\21\3\1\64\1\3\17\0\2\3"+
    "\3\0\1\3\3\0\3\3\1\65\17\3\66\0\1\66"+
    "\6\0\1\67\43\0\1\70\52\0\1\71\52\0\1\72"+
    "\4\0\1\44\3\0\1\44\52\0\1\46\45\0\2\3"+
    "\3\0\1\3\3\0\2\3\1\73\20\3\17\0\2\3"+
    "\3\0\1\3\3\0\12\3\1\74\10\3\17\0\2\3"+
    "\3\0\1\3\3\0\6\3\1\75\14\3\17\0\2\3"+
    "\3\0\1\3\3\0\1\3\1\76\21\3\17\0\2\3"+
    "\3\0\1\3\3\0\15\3\1\77\5\3\17\0\2\3"+
    "\3\0\1\3\3\0\3\3\1\100\17\3\17\0\2\3"+
    "\3\0\1\3\3\0\16\3\1\101\4\3\17\0\2\3"+
    "\3\0\1\3\3\0\13\3\1\102\7\3\17\0\2\3"+
    "\3\0\1\3\3\0\16\3\1\103\4\3\17\0\2\3"+
    "\3\0\1\3\3\0\4\3\1\104\16\3\17\0\2\3"+
    "\3\0\1\3\3\0\11\3\1\105\11\3\17\0\2\3"+
    "\3\0\1\3\3\0\5\3\1\106\15\3\17\0\2\3"+
    "\3\0\1\3\3\0\11\3\1\107\11\3\17\0\2\3"+
    "\3\0\1\3\3\0\5\3\1\110\15\3\17\0\2\3"+
    "\3\0\1\3\3\0\12\3\1\111\10\3\17\0\2\3"+
    "\3\0\1\3\3\0\13\3\1\112\7\3\17\0\2\3"+
    "\3\0\1\3\3\0\4\3\1\113\16\3\17\0\2\3"+
    "\3\0\1\3\3\0\4\3\1\114\16\3\17\0\2\3"+
    "\3\0\1\3\3\0\13\3\1\115\7\3\17\0\2\3"+
    "\3\0\1\3\3\0\4\3\1\116\16\3\17\0\2\3"+
    "\3\0\1\3\3\0\2\3\1\117\20\3\17\0\2\3"+
    "\3\0\1\3\3\0\3\3\1\120\17\3\17\0\2\3"+
    "\3\0\1\3\3\0\6\3\1\121\14\3\17\0\2\3"+
    "\3\0\1\3\3\0\10\3\1\122\12\3\17\0\2\3"+
    "\3\0\1\3\3\0\1\3\1\123\21\3\17\0\2\3"+
    "\3\0\1\3\3\0\16\3\1\124\4\3\17\0\2\3"+
    "\3\0\1\3\3\0\4\3\1\125\16\3\16\0";

  /** 
   * The transition table of the DFA
   */
  final private static int yytrans [] = yy_unpack();


  /* error codes */
  final private static int YY_UNKNOWN_ERROR = 0;
  final private static int YY_ILLEGAL_STATE = 1;
  final private static int YY_NO_MATCH = 2;
  final private static int YY_PUSHBACK_2BIG = 3;

  /* error messages for the codes above */
  final private static String YY_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Internal error: unknown state",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * YY_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private final static byte YY_ATTRIBUTE[] = {
     0,  9,  1,  9,  1,  1,  1,  1,  9,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  9,  9,  1,  9,  9,  9,  9,  9,  9,  1,  1,  1, 
     9,  9,  0,  1,  9,  0,  1,  0,  9,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  9,  9,  9,  9,  9,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1
  };

  /** the input device */
  private java.io.Reader yy_reader;

  /** the current state of the DFA */
  private int yy_state;

  /** the current lexical state */
  private int yy_lexical_state = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char yy_buffer[] = new char[YY_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int yy_markedPos;

  /** the textposition at the last state to be included in yytext */
  private int yy_pushbackPos;

  /** the current text position in the buffer */
  private int yy_currentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int yy_startRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int yy_endRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn; 

  /** 
   * yy_atBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean yy_atBOL = true;

  /** yy_atEOF == true <=> the scanner is at the EOF */
  private boolean yy_atEOF;

  /* user code: */
    public boolean EOF()
    {
        return yy_atEOF;
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public NotJavaLexer(java.io.Reader in) {
    this.yy_reader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public NotJavaLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the split, compressed DFA transition table.
   *
   * @return the unpacked transition table
   */
  private static int [] yy_unpack() {
    int [] trans = new int[2193];
    int offset = 0;
    offset = yy_unpack(yy_packed0, offset, trans);
    return trans;
  }

  /** 
   * Unpacks the compressed DFA transition table.
   *
   * @param packed   the packed transition table
   * @return         the index of the last entry
   */
  private static int yy_unpack(String packed, int offset, int [] trans) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do trans[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   IOException  if any I/O-Error occurs
   */
  private boolean yy_refill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (yy_startRead > 0) {
      System.arraycopy(yy_buffer, yy_startRead, 
                       yy_buffer, 0, 
                       yy_endRead-yy_startRead);

      /* translate stored positions */
      yy_endRead-= yy_startRead;
      yy_currentPos-= yy_startRead;
      yy_markedPos-= yy_startRead;
      yy_pushbackPos-= yy_startRead;
      yy_startRead = 0;
    }

    /* is the buffer big enough? */
    if (yy_currentPos >= yy_buffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[yy_currentPos*2];
      System.arraycopy(yy_buffer, 0, newBuffer, 0, yy_buffer.length);
      yy_buffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = yy_reader.read(yy_buffer, yy_endRead, 
                                            yy_buffer.length-yy_endRead);

    if (numRead < 0) {
      return true;
    }
    else {
      yy_endRead+= numRead;  
      return false;
    }
  }


  /**
   * Closes the input stream.
   */
  final public void yyclose() throws java.io.IOException {
    yy_atEOF = true;            /* indicate end of file */
    yy_endRead = yy_startRead;  /* invalidate buffer    */

    if (yy_reader != null)
      yy_reader.close();
  }


  /**
   * Closes the current stream, and resets the
   * scanner to read from a new input stream.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>YY_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  final public void yyreset(java.io.Reader reader) throws java.io.IOException {
    yyclose();
    yy_reader = reader;
    yy_atBOL  = true;
    yy_atEOF  = false;
    yy_endRead = yy_startRead = 0;
    yy_currentPos = yy_markedPos = yy_pushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    yy_lexical_state = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  final public int yystate() {
    return yy_lexical_state;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  final public void yybegin(int newState) {
    yy_lexical_state = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  final public String yytext() {
    return new String( yy_buffer, yy_startRead, yy_markedPos-yy_startRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  final public char yycharat(int pos) {
    return yy_buffer[yy_startRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  final public int yylength() {
    return yy_markedPos-yy_startRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void yy_ScanError(int errorCode) {
    String message;
    try {
      message = YY_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = YY_ERROR_MSG[YY_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  private void yypushback(int number)  {
    if ( number > yylength() )
      yy_ScanError(YY_PUSHBACK_2BIG);

    yy_markedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   IOException  if any I/O-Error occurs
   */
  public Token getNextToken() throws java.io.IOException {
    int yy_input;
    int yy_action;

    // cached fields:
    int yy_currentPos_l;
    int yy_startRead_l;
    int yy_markedPos_l;
    int yy_endRead_l = yy_endRead;
    char [] yy_buffer_l = yy_buffer;
    char [] yycmap_l = yycmap;

    int [] yytrans_l = yytrans;
    int [] yy_rowMap_l = yy_rowMap;
    byte [] yy_attr_l = YY_ATTRIBUTE;

    while (true) {
      yy_markedPos_l = yy_markedPos;

      yy_action = -1;

      yy_startRead_l = yy_currentPos_l = yy_currentPos = 
                       yy_startRead = yy_markedPos_l;

      yy_state = yy_lexical_state;


      yy_forAction: {
        while (true) {

          if (yy_currentPos_l < yy_endRead_l)
            yy_input = yy_buffer_l[yy_currentPos_l++];
          else if (yy_atEOF) {
            yy_input = YYEOF;
            break yy_forAction;
          }
          else {
            // store back cached positions
            yy_currentPos  = yy_currentPos_l;
            yy_markedPos   = yy_markedPos_l;
            boolean eof = yy_refill();
            // get translated positions and possibly new buffer
            yy_currentPos_l  = yy_currentPos;
            yy_markedPos_l   = yy_markedPos;
            yy_buffer_l      = yy_buffer;
            yy_endRead_l     = yy_endRead;
            if (eof) {
              yy_input = YYEOF;
              break yy_forAction;
            }
            else {
              yy_input = yy_buffer_l[yy_currentPos_l++];
            }
          }
          int yy_next = yytrans_l[ yy_rowMap_l[yy_state] + yycmap_l[yy_input] ];
          if (yy_next == -1) break yy_forAction;
          yy_state = yy_next;

          int yy_attributes = yy_attr_l[yy_state];
          if ( (yy_attributes & 1) == 1 ) {
            yy_action = yy_state; 
            yy_markedPos_l = yy_currentPos_l; 
            if ( (yy_attributes & 8) == 8 ) break yy_forAction;
          }

        }
      }

      // store back cached position
      yy_markedPos = yy_markedPos_l;

      switch (yy_action) {

        case 84: 
          {  return new Token(Token.PROCEDURE, yytext());  }
        case 86: break;
        case 27: 
          {  return new Token(Token.LEFT_BRKT, yytext());  }
        case 87: break;
        case 25: 
          {  return new Token(Token.LEFT_PAREN, yytext());  }
        case 88: break;
        case 1: 
        case 4: 
        case 6: 
        case 7: 
        case 31: 
          {   }
        case 89: break;
        case 40: 
          {  /* For this stand-alone lexer, print out comments. */
                  System.out.println("Recognized comment: " + yytext());  }
        case 90: break;
        case 43: 
          {  return new Token(Token.DO, yytext());  }
        case 91: break;
        case 44: 
          {  return new Token(Token.OR, yytext());  }
        case 92: break;
        case 47: 
          {  return new Token(Token.IF, yytext());  }
        case 93: break;
        case 82: 
          {  return new Token(Token.FUNCTION, yytext());  }
        case 94: break;
        case 80: 
          {  return new Token(Token.IMPLIES, yytext());  }
        case 95: break;
        case 28: 
          {  return new Token(Token.RT_BRKT, yytext());  }
        case 96: break;
        case 26: 
          {  return new Token(Token.RT_PAREN, yytext());  }
        case 97: break;
        case 55: 
          {  return new Token(Token.LESS_EQ, yytext());  }
        case 98: break;
        case 30: 
          {  return new Token(Token.GTR, yytext());  }
        case 99: break;
        case 29: 
          {  return new Token(Token.LESS, yytext());  }
        case 100: break;
        case 21: 
          {  return new Token(Token.PLUS, yytext());  }
        case 101: break;
        case 23: 
          {  return new Token(Token.SEMI, yytext());  }
        case 102: break;
        case 35: 
          {  return new Token(Token.INT, yytext());  }
        case 103: break;
        case 58: 
          {  return new Token(Token.AND, yytext());  }
        case 104: break;
        case 59: 
          {  return new Token(Token.NOT, yytext());  }
        case 105: break;
        case 64: 
          {  return new Token(Token.VAR, yytext());  }
        case 106: break;
        case 66: 
          {  return new Token(Token.XOR, yytext());  }
        case 107: break;
        case 67: 
          {  return new Token(Token.ELSE, yytext());  }
        case 108: break;
        case 8: 
          {  /* Ignore whitespace. */  }
        case 109: break;
        case 33: 
          {  return new Token(Token.CONCAT, yytext());  }
        case 110: break;
        case 32: 
          {  return new Token(Token.COLON, yytext());  }
        case 111: break;
        case 24: 
          {  return new Token(Token.COMMA, yytext());  }
        case 112: break;
        case 2: 
        case 3: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 41: 
        case 42: 
        case 45: 
        case 46: 
        case 48: 
        case 49: 
        case 50: 
        case 51: 
        case 52: 
        case 60: 
        case 61: 
        case 62: 
        case 63: 
        case 65: 
        case 68: 
        case 69: 
        case 70: 
        case 71: 
        case 72: 
        case 73: 
        case 74: 
        case 76: 
        case 77: 
        case 78: 
        case 79: 
        case 81: 
        case 83: 
          {  return new Token(Token.IDENT, yytext());  }
        case 113: break;
        case 5: 
          {  return new Token(Token.MINUS, yytext());  }
        case 114: break;
        case 20: 
          {  return new Token(Token.TIMES, yytext());  }
        case 115: break;
        case 22: 
          {  return new Token(Token.DIVIDE, yytext());  }
        case 116: break;
        case 36: 
          {  return new Token(Token.RETURN, yytext());  }
        case 117: break;
        case 38: 
          {  return new Token(Token.STRING, yytext());  }
        case 118: break;
        case 53: 
          {  return new Token(Token.NOT_EQ, yytext());  }
        case 119: break;
        case 54: 
          {  return new Token(Token.ASSIGN, yytext());  }
        case 120: break;
        case 56: 
          {  return new Token(Token.GTR_EQ, yytext());  }
        case 121: break;
        case 57: 
          {  return new Token(Token.EQ_TO, yytext());  }
        case 122: break;
        case 75: 
          {  return new Token(Token.WHILE, yytext());  }
        case 123: break;
        default: 
          if (yy_input == YYEOF && yy_startRead == yy_currentPos) {
            yy_atEOF = true;
            return null;
          } 
          else {
            yy_ScanError(YY_NO_MATCH);
          }
      }
    }
  }


}
