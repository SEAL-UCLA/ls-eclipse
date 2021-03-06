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
 * Created on Apr 17, 2003
 */
package tyRuBa.tests;

import tyRuBa.modes.Multiplicity;
import junit.framework.TestCase;

/**
 * @author kdvolder
 */
public class MultiplicityTest extends TestCase {
	
	Multiplicity zero = Multiplicity.zero;
	Multiplicity one  = Multiplicity.one;
	Multiplicity many = Multiplicity.many;
	Multiplicity infinite = Multiplicity.infinite;

	public MultiplicityTest(String arg0) {
		super(arg0);
	}


	public void testObjects() {
		assertFalse(zero.equals(one));
		assertFalse(one.equals(zero));

		assertFalse(zero.equals(many));
		assertFalse(many.equals(zero));

		assertFalse(one.equals(many));
		assertFalse(many.equals(one));

		assertTrue(zero.equals(zero));
		assertTrue(one.equals(one));
		assertTrue(many.equals(many));
		assertTrue(infinite.equals(infinite));
	}
	
	public void testMultiply() {
		for (int i=0;i<5;i++) {
			Multiplicity im = Multiplicity.fromInt(i);
			for (int j=0;j<5;j++) {
				Multiplicity jm = Multiplicity.fromInt(j);
				Multiplicity result = im.multiply(jm);
				assertEquals(result, Multiplicity.fromInt(i*j));
			}
		}
	}	

	public void testInfMultiply() {
		assertEquals(zero,zero.multiply(infinite));
		assertEquals(zero,infinite.multiply(zero));
		for (int i=1;i<5;i++) {
			Multiplicity im = Multiplicity.fromInt(i);
			assertEquals(infinite,im.multiply(infinite));
			assertEquals(infinite,infinite.multiply(im));
		}
		assertEquals(infinite,infinite.multiply(infinite));
	}	

	public void testAdd() {
		for (int i=0;i<5;i++) {
			Multiplicity im = Multiplicity.fromInt(i);
			for (int j=0;j<5;j++) {
				Multiplicity jm = Multiplicity.fromInt(j);
				Multiplicity result = im.add(jm);
				assertEquals(result, Multiplicity.fromInt(i+j));
			}
		}
	}

	public void testInfAdd() {
		for (int i=0;i<5;i++) {
			Multiplicity im = Multiplicity.fromInt(i);
			assertEquals(infinite,im.add(infinite));
			assertEquals(infinite,infinite.add(im));
		}
		assertEquals(infinite,infinite.add(infinite));
	}	

	public void testCompare() {
		for (int i=0;i<=2;i++) {
			Multiplicity im = Multiplicity.fromInt(i);
			assertEquals(im.compareTo(infinite),-1);
			assertEquals(infinite.compareTo(im),+1);
			for (int j=0;j<=2;j++) {
				Multiplicity jm = Multiplicity.fromInt(j);
				if (i==j)
					assertEquals(im.compareTo(jm),0);
				if (i<j)
					assertEquals(im.compareTo(jm),-1);
				if (i>j)
					assertEquals(im.compareTo(jm),+1);
			}
		}
		assertEquals(infinite.compareTo(infinite),0);		
	}

}
