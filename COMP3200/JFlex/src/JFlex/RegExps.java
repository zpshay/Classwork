/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * JFlex 1.3.5                                                             *
 * Copyright (C) 1998-2001  Gerwin Klein <lsf@jflex.de>                    *
 * All rights reserved.                                                    *
 *                                                                         *
 * This program is free software; you can redistribute it and/or modify    *
 * it under the terms of the GNU General Public License. See the file      *
 * COPYRIGHT for more information.                                         *
 *                                                                         *
 * This program is distributed in the hope that it will be useful,         *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of          *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the           *
 * GNU General Public License for more details.                            *
 *                                                                         *
 * You should have received a copy of the GNU General Public License along *
 * with this program; if not, write to the Free Software Foundation, Inc., *
 * 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA                 *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package JFlex;

import java.util.*;


/**
 * Stores all rules of the specification for later access in RegExp -> NFA
 *
 * @author Gerwin Klein
 * @version JFlex 1.3.5, $Revision: 1.19 $, $Date: 2001/10/08 10:08:05 $
 */
public class RegExps {
  
  /** the spec line in which a regexp is used */
  Vector /* of Integer */ lines;

  /** the lexical states in wich the regexp is used */
  Vector /* of Vector of Integer */ states;

  /** the regexp */
  Vector /* of RegExp */ regExps;

  /** the action of a regexp */
  Vector /* of Action */ actions;
  
  /** flag if it is a BOL regexp */
  Vector /* of Boolean */ BOL;

  /** the lookahead expression */
  Vector /* of RegExp */ look;

  public RegExps() {
    states = new Vector();
    regExps = new Vector();
    actions = new Vector();
    BOL = new Vector();
    look = new Vector();
    lines = new Vector();
  }

  public int insert(int line, Vector stateList, RegExp regExp, Action action, 
                     Boolean isBOL, RegExp lookAhead) {      
    if (Out.DEBUG) {
      Out.debug("Inserting regular expression with statelist :"+Out.NL+stateList); 
      Out.debug("and action code :"+Out.NL+action.content+Out.NL);    
      Out.debug("expression :"+Out.NL+regExp); 
    }

    states.addElement(stateList);
    regExps.addElement(regExp);
    actions.addElement(action);
    BOL.addElement(isBOL);
    look.addElement(lookAhead);
    lines.addElement(new Integer(line));
    
    return states.size()-1;
  }

  public int insert(Vector stateList, Action action) {

    if (Out.DEBUG) {
      Out.debug("Inserting eofrule with statelist :"+Out.NL+stateList);  
      Out.debug("and action code :"+Out.NL+action.content+Out.NL);     
    }

    states.addElement(stateList);
    regExps.addElement(null);
    actions.addElement(action);
    BOL.addElement(null);
    look.addElement(null);
    lines.addElement(null);
    
    return states.size()-1;
  }

  public void addStates(int regNum, Vector newStates) {
    Enumeration s = newStates.elements();
    
    while (s.hasMoreElements()) 
      ((Vector)states.elementAt(regNum)).addElement(s.nextElement());      
  }

  public int getNum() {
    return states.size();
  }

  public boolean isBOL(int num) {
    return ((Boolean) BOL.elementAt(num)).booleanValue();
  }
  
  public RegExp getLookAhead(int num) {
    return (RegExp) look.elementAt(num);
  }

  public boolean isEOF(int num) {
    return BOL.elementAt(num) == null;
  }

  public Vector getStates(int num) {
    return (Vector) states.elementAt(num);
  }

  public RegExp getRegExp(int num) {
    return (RegExp) regExps.elementAt(num);
  }

  public int getLine(int num) {
    return ((Integer) lines.elementAt(num)).intValue();
  }

  public void checkActions() {
    if ( actions.elementAt(actions.size()-1) == null ) {
      Out.error(ErrorMessages.NO_LAST_ACTION);
      throw new GeneratorException();
    }
  }

  public Action getAction(int num) {
    while ( num < actions.size() && actions.elementAt(num) == null )
      num++;

    return (Action) actions.elementAt(num);
  }
}
