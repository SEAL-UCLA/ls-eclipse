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
package tyRuBa.util;

/**
 * @author cburns
 *
 * Ultra simple list class designed for minimal overhead.
 */
public final class SList {
	
	private Object object;
	private SList next;
	
	public final Object object() {
		return object;
	}
	
	public final SList next() {
		return next;
	}
	
	public SList(Object object, SList next) {
		this.object = object;
		this.next = next;
	}
}
