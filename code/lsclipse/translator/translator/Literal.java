package translator;

import java.util.ArrayList;


public class Literal {
	private String qualifier, type; 
	private ArrayList<String> args;
	
	public Literal (String inQual, String inType, int inNumArgs, ArrayList<String> inArgs) {		
		qualifier = inQual;
		type = inType;
		args = inArgs;
	}
	
	public String toString() {
		String retString = qualifier + " " + type + " (" + args.toString() + ")";
		return retString;
	}
	
	public ArrayList<String> getArgs() {
		return args;
	}
	
	public String getQualifier() {
		return qualifier;
	}
	
	public String getType() {
		return type;
	}
	
	public boolean equals(Literal otherLit) {
		if (this.type.equals(otherLit.type) && this.args.equals(otherLit.args))
			return true;
		else
			return false;
	}
	
}
