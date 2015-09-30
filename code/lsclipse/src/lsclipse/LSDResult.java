package lsclipse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import lsd.rule.LSDFact;
import lsd.rule.LSDInvalidTypeException;
import lsd.rule.LSDLiteral;
import lsd.rule.LSDRule;
import lsd.rule.LSDVariable;
import lsd.rule.LSDBinding;

public class LSDResult {
	
	public static class Bookmark {
		public String filename;
		public int startpos;
		public int length;
		public boolean oldFB;
		public Bookmark(String filename, int startpos, int length, boolean oldFB) {
			this.filename = filename;
			this.startpos = startpos;
			this.length = length;
			this.oldFB = oldFB;
		}
	}

	public int num_matches;
	public int num_counter;
	public LSDRule rule;
	public String desc;
	public List<LSDFact> examples;
	public List<Map<LSDVariable, String>> exceptions;
	public List<Bookmark> examplesBookmarks;
	public List<Bookmark> exceptionsBookmarks;
	private List<String> examplesString = null;
	private List<String> exceptionsString = null;
	public List<String> getExampleStr() {
		if (examplesString==null) {	//contruct strings from examples
			examplesString = new ArrayList<String>();
			for (LSDFact fact : examples) {
				examplesString.add(fact.toString());
			}
		}
		return examplesString;
	}
	public List<String> getExceptionsString() {
		if (exceptionsString==null) {	//contruct strings from examples
			exceptionsString = new ArrayList<String>();
			for (Map<LSDVariable, String> exception : exceptions) {
				String s = "";
				for (LSDLiteral l : rule.getAntecedents().getLiterals()) {
					if (!s.isEmpty()) s+=", ";
					LSDLiteral mylit = l;
					for (Entry<LSDVariable, String> entry : exception.entrySet()) {
						try {
							mylit = mylit.substitute(entry.getKey(), new LSDBinding(entry.getValue()));
						} catch (LSDInvalidTypeException e) {
							e.printStackTrace();
						}
					}
					s += mylit.nonNegatedCopy().toString();
				}
				s = "{"+s+"}";
				exceptionsString.add(s);
			}
		}
		return exceptionsString;
	}
}
