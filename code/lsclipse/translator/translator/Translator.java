package translator;

import java.util.*;
import java.io.*;

public class Translator {
	File ruleFile;
	FileWriter writeFile;
	boolean willWriteToFile;

	public static void main(String[] args) {
		Translator t = new Translator("C:\\sample.rules");
		t.translate();
	}

	public Translator(String inReadFile, String inWriteFile) {
		this(inReadFile, inWriteFile, true);
	}

	public Translator(String inReadFile) {
		this(inReadFile, "", false);
	}

	private Translator(String inReadFile, String inWriteFile, boolean inWillWriteToFile) {
		ruleFile = new File(inReadFile);
		try {
			if (!inWriteFile.equals(""))
				writeFile = new FileWriter(inWriteFile);
		}
		catch (Exception e) {
		}
		willWriteToFile = inWillWriteToFile;
	}
	
	public void translate() {
		ArrayList<Rule> rules;
		Parser fileParser = new Parser(ruleFile);
		BufferedWriter fileWriter = null;
		
		if (willWriteToFile) {
			fileWriter = new BufferedWriter(writeFile);
		}
		
		try {
			rules = fileParser.parseRuleFile();
			
			for (int i = 0; i < rules.size(); i++) {
				String rule = printRule(rules.get(i), i + 1);
				System.out.println(rule);
				if (willWriteToFile) {
					fileWriter.write(rule + "\n");
				}
			}
			if (willWriteToFile) {
				fileWriter.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private String printRule(Rule inRule, int ruleNum) {
		return "#" + ruleNum + ": " + inRule.translateRule() + "\n";
	}
}



