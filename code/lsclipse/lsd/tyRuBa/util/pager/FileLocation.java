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
 * Created on Jul 26, 2004
 */
package tyRuBa.util.pager;

import java.io.File;

import tyRuBa.util.pager.Pager.ResourceId;

/**
 * Represents a location on disk
 * @category FactBase
 * @author riecken
 */
public class FileLocation extends Location {

    /** Base location. */
    File base = null;

    /** precomputed hashcode for efficiency. */
    int myHashCode;

    /** Creates a new FileLocation. */
    public FileLocation(File theBasePath) {
        base = theBasePath;
        myHashCode = base.hashCode();
    }

    /** Creates a new FileLocation. */
    public FileLocation(String filename) {
        this(new File(filename));
    }

    /** Gets the base location. */
    public File getBase() {
        return base;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if (other instanceof FileLocation) {
            FileLocation flOther = (FileLocation) other;
            return flOther.base.equals(base);
        } else {
            return false;
        }
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return myHashCode;
    }

    /**
     * Creates a resourceId for the given path relative to the base.
     */
    public ResourceId getResourceID(String relativeID) {
        return new FileResourceID(this, relativeID);
    }
    
    public String toString() {
    		return base.toString();
    }

}