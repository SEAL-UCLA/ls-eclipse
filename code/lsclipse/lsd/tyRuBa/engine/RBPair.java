/* 
*    Logical Structural Diff (LSDiff)  
*    Copyright (C) <2015>  <Dr. Miryung Kim miryung@cs.ucla.edu>
*
*    This program is free software: you can redistribute it and/or modify
*    it under the terms of the GNU General Public License as published by
*    the Free Software Foundation, either version 3 of the License, or
*    (at your option) any later version.
*
*    This program is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License
*    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package tyRuBa.engine;

import tyRuBa.engine.visitor.TermVisitor;
import tyRuBa.modes.Factory;
import tyRuBa.modes.Type;
import tyRuBa.modes.TypeEnv;
import tyRuBa.modes.TypeModeError;
import tyRuBa.util.ObjectTuple;

/**
 * @author kdvolder
 */
public class RBPair extends RBAbstractPair {

	/**
	 * Constructor for incomplete RBPair. For efficiency reasons only. Evil.
	 */
	public RBPair(RBTerm aCar) {
		super(aCar, null);
	}

	/**
	 * Constructor for RBPair.
	 */
	public RBPair(RBTerm aCar, RBTerm aCdr) {
		super(aCar, aCdr);
	}

	public static RBTerm make(RBTerm[] terms) {
		RBTerm t = FrontEnd.theEmptyList;
		for (int i = terms.length - 1; i >= 0; i--) {
			t = new RBPair(terms[i], t);
		}
		return t;
	}

	/** If proper list then Turn into an Object[] otherwise
	 *  just do as in super */
	public Object up() {
		try {
			int size = getNumSubterms();
			Object[] array = new Object[size];
			for (int i = 0; i < size; i++) {
				array[i] = getSubterm(i).up();
			}
			return array;
		} catch (ImproperListException e) {
			return super.up();
		}
	}

	public String toString() {
		return "[" + cdrToString(true, this) + "]";
	}

	public String quotedToString() {
		return getCar().quotedToString() + getCdr().quotedToString();
	}

	protected Type getType(TypeEnv env) throws TypeModeError {
		Type car,cdr,result;
		try {		
			car = getCar().getType(env);
		} catch (TypeModeError e) {
			throw new TypeModeError(e, getCar());
		}
		try {		
			cdr = getCdr().getType(env);
		} catch (TypeModeError e) {
			throw new TypeModeError(e, getCdr());
		}
		try {
			result = Factory.makeListType(car).union(cdr);
		} catch (TypeModeError e) {
			throw new TypeModeError(e, this);
		}				
		return result;
	}

	public Object accept(TermVisitor v) {
		return v.visit(this);
	}

    /**
     * @see tyRuBa.util.TwoLevelKey#getFirst()
     */
    public String getFirst() {
        return getCar().getFirst();
    }

    /**
     * @see tyRuBa.util.TwoLevelKey#getSecond()
     */
    public Object getSecond() {
        Object[] result = new Object[2];
        result[0] = getCar().getSecond();
        result[1] = getCdr();
        return ObjectTuple.make(result);
    }
}
