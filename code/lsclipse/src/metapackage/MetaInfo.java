//*
package metapackage;

import java.io.File;

public class MetaInfo {
	public static int k=2; 
	public static int minConcFact=3;
	public static int beamSize=100;
	public static double accuracy =0.75;
	public static int maxException=10;

	public static String baseDir = lsclipse.LSclipse.getDefault().getStateLocation().toOSString();
	public static String srcDir = baseDir+"/input";
	public static String resDir = baseDir+"/output";
	public static String fdbDir = baseDir+"/fdb";

	public static File included1kb = new File (srcDir, "1KB_lsdPred.rub");
	public static File included2kb = new File (srcDir, "2KB_lsdPred.rub");
	public static File includedDelta = new File (srcDir, "deltaKB_lsdPred.rub");
//	public static String inFile2K=  new File (srcDir, version + "2KB.rub").getAbsolutePath();
//	public static String deltaFile = new File(srcDir, version + "delta.rub").getAbsolutePath();
	public static File derivationRules = new File (srcDir, "derivationRules.rub");
	public static File deltaDerivationRules = new File (srcDir, "deltaDerivationRules.rub");
	public static String winnowings = new File(srcDir, "winnowingRules.rub").getAbsolutePath();
	public static String modifiedWinnowings = new File(srcDir, "convertedwinnowingRules.rub").getAbsolutePath();

	public static String lsclipse2KB = new File(srcDir, "lsclipse/2KB_lsclipsePred.rub").getAbsolutePath();
	public static String lsclipseDelta = new File(srcDir, "lsclipse/deltaKB_lsclipsePred.rub").getAbsolutePath();

	public static String resultsFile = new File(resDir, "Hierarchical_lsclipse_Temp.rub").getAbsolutePath();
/*
	public static String get2KB(int i){
		File projectDir = new File (srcDir, folderName);
		if (!projectDir.exists()) projectDir.mkdir();
		inFile2K = new File (projectDir, version[i] + "2KB.rub").getAbsolutePath();
		return inFile2K;
	}
	
	public static String getDelta(int i){
		File projectDir = new File (srcDir, folderName);
		if (!projectDir.exists()) projectDir.mkdir();
		deltaFile = new File (projectDir, version[i] + "delta.rub").getAbsolutePath();
		return deltaFile;
	}
*/
	
}
//*/