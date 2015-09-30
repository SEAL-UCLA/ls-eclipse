package translator;


public class Translation {
	
	private String activeS, passiveS, activeV, passiveV, result, fullNames;
	private boolean isActiveFirst, hasObject, isSpecialResult, isStructural;
	
	/* 
	 * active subject, passive subject, active verb, passive verb, is first argument active,
	 * does translation have object, result subject, string that specifies whether arguments are full
	 * identifiers, boolean that specifies whether type is "special": i.e. whether it needs to be
	 * translated fully if it is the result literal (so far this has only happened in 2 cases - 
	 * inheritedmethod and inheritedfield), boolean that specifies if type is structural (package,
	 * class, method, field)
	 */

	public Translation(String inActiveS, String inPassiveS, String inActiveV, String inPassiveV,
			boolean inIsActiveFirst, boolean inHasObject, String inResult, String inFullNames,
			boolean inIsSpecialResult, boolean inIsStructural) {
		activeS = inActiveS;
		passiveS = inPassiveS;
		activeV = inActiveV;
		passiveV = inPassiveV;
		isActiveFirst = inIsActiveFirst;
		hasObject = inHasObject;
		result = inResult;
		fullNames = inFullNames;
		isSpecialResult = inIsSpecialResult;
		isStructural = inIsStructural;
	}
	
	public String getActiveSubject() {
		return activeS;
	}
	
	public String getPassiveSubject() {
		return passiveS;
	}
	
	public String getActiveVerb() {
		return activeV;
	}
	
	public String getPassiveVerb() {
		return passiveV;
	}
	
	public boolean isActiveFirst() {
		return isActiveFirst;
	}
	
	public boolean hasObject() {
		return hasObject;
	}
	
	public String getResult() {
		return result;
	}
	
	public String getFullNames() {
		return fullNames;
	}
	
	public boolean isSpecialResult() {
		return isSpecialResult;
	}
	
	public boolean isStructural() {
		return isStructural;
	}
}
