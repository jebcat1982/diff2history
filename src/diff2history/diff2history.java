package diff2history;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class diff2history {

	public String repoID;
	public String GID;
	public String AID;
	public File dir;
	public File[] commits;
	public File out;
	public diff2history(String repoID, String GID, String AID) throws IOException {
		this.repoID = repoID;
		this.GID = GID;
		this.AID = AID;
		dir = new File(this.repoID);
		commits = dir.listFiles();
		out = new File("/home/shuaili/X/" + GID + "_" + AID + "/" + repoID);
		out.createNewFile();
	}

	public static void main(String[] args) {
		String repoID = args[0];
		String GID = args[1];
		String AID = args[2];
		diff2history d2h = null;
		try {
			d2h = new diff2history(repoID, GID, AID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (d2h.commits != null) {
			for (File commit : d2h.commits) { //for each commit(file)
				BufferedReader reader = null;
				String oldversion = null;
				String newversion = null;
				try {
					reader = new BufferedReader(new FileReader(commit));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String line = null;
				boolean s2 = false;
				try {
					while ((line = reader.readLine()) != null) {
						if (line.equals("diff --git a/pom.xml b/pom.xml")) {
							s2 = true;
							line = reader.readLine();
							break;
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (s2) {
					while (line != null && !line.startsWith("diff")) {
						if (line.indexOf("<groupId>")!=-1 && line.indexOf("</groupId>")!=-1 && line.indexOf(GID)!= -1) {//
							try {
								line = reader.readLine();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (line.indexOf("<artifactId>")!= -1 && line.indexOf("</artifactId>")!= -1 && line.indexOf(AID)!= -1) {
								try {
									line = reader.readLine();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								if (line.indexOf("<version>")!=-1 && line.indexOf("</version>")!=-1) {
									if (line.startsWith("-")) {
										oldversion = line.substring(line.indexOf("<version>" + 9), line.indexOf("</version>"));
									}
								}
							}
						}
						if (line.indexOf("")!=-1) {
						}
					}
				}
			}
		}

	}

}
