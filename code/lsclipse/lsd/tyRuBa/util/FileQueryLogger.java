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
 * Created on Jul 15, 2004
 */
package tyRuBa.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import tyRuBa.engine.RBExpression;

public class FileQueryLogger extends QueryLogger {
	
    PrintWriter writer;
    
    public void close() {
    		writer.close();
    }
    
    public FileQueryLogger(File logFile, boolean append) throws IOException {
        writer = new PrintWriter(new FileOutputStream(logFile, append));
        writer.println("//SCENARIO");
    }
    
    public void logQuery(RBExpression query) {
        writer.println(query.toString());
    }
}
