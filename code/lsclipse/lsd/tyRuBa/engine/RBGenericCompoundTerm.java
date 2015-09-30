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
/*
 * Created on Aug 13, 2004
 */
package tyRuBa.engine;

import tyRuBa.modes.ConstructorType;

/**
 * @author riecken
 */
public class RBGenericCompoundTerm extends RBCompoundTerm {

    ConstructorType typeTag;
    RBTerm args;

    public RBTerm getArg() {
        return args;
    }
    public RBGenericCompoundTerm(ConstructorType constructorType, RBTerm args) {
        this.typeTag = constructorType;
        this.args = args;
    }
    
    public ConstructorType getConstructorType() {
        return typeTag;
    }
   
}