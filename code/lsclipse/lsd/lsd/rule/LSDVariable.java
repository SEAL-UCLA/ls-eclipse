package lsd.rule;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class LSDVariable {
	public static boolean isValidType(char type) {
//		Is type one of package, class, method, or field?
//		return "ptmf".contains(Character.toString(type));

		// Is type one of package, class, method, field, name of
		// type, name of field, or name of method?
		return "ptmfabc".contains(Character.toString(type));
	}     
	/**
	 * @param args
	 */
	private char type; 
	private String variableName;
	private boolean constantHolder = false; 
	
	public LSDVariable(String variableName, char type)
	{
		this.variableName = variableName;
		this.type = type;
	}
	public LSDVariable(String variableName, char type, boolean constantHolder)
	{
		this.variableName = variableName;
		this.type = type;
		this.constantHolder = true;
	}
	public String getName() { return variableName;}
	
	public boolean typeChecks(char type) { 
		return (this.type==type);
	}
	public boolean typeChecks(LSDVariable match) { 
		return (this.type==match.type);
	}
	
	public boolean typeConflicts(LSDVariable toBeMatched) {
		return (this.variableName.equals(toBeMatched.variableName) &&
				!typeChecks(toBeMatched));
	}
	public String toString() {return "?"+variableName;}
	
	public boolean equals(LSDVariable other){ return this.variableName.equals(other.variableName) && this.type == other.type;} 
	public boolean equals(Object other) {
		if (other instanceof LSDVariable)
			return equals((LSDVariable) other);
		else
			return false;
	}
	@Override
	public int hashCode() {
		String identity = variableName + type;
		return identity.hashCode();
	}

	public int compareTo(Object o) {
		return o.hashCode() - this.hashCode();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public char getType() { 
		// FIXME kinda violates information hiding. I need to know the type of variable in LSDBruteForceRuleEnumerator though.
		return type;
	}
	public static LSDVariable newFreeVariable(Collection<LSDVariable> variables,
			char type) {
		Set<String> varNames = new HashSet<String>();
		for (LSDVariable variable : variables)
			varNames.add(variable.getName());
		int i;
		for (i = 0; varNames.contains("x" + i); i++)
			;
		return new LSDVariable("x" + i, type);
	}

	public static LSDVariable newConstantHolder(Collection<LSDVariable> variables,
			char type) {
		Set<String> varNames = new HashSet<String>();
		for (LSDVariable variable : variables)
			varNames.add(variable.getName());
		int i;
		for (i = 0; varNames.contains("c" + i); i++)
			;
		return new LSDVariable("c" + i, type, true);
	}
	public boolean isConstantHolder () { 
		return constantHolder;
	}
	public String toStringIgnoreConstHolders() {
		if (this.constantHolder==true) { 
			return "?"+"c";
		}
		return "?"+ variableName;
	}
}
