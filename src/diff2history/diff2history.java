package diff2history;

import java.io.File;
import java.io.IOException;

public class diff2history {

	public String repoID;
	public String lib;
	public File dir;
	public File[] commits;
	public File out;
	public diff2history(String repoID, String lib) throws IOException {
		this.repoID = repoID;
		this.lib = lib;
		dir = new File(this.repoID);
		commits = dir.listFiles();
		out = new File("/home/shuaili/X/" + lib + "/" + repoID);
		out.createNewFile();
	}

	public static void main(String[] args) {
		String repoID = args[0];
		String lib = args[1];
		diff2history d2h = null;
		try {
			d2h = new diff2history(repoID, lib);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (d2h.commits != null) {
			for (File commit : d2h.commits) { //for each commit(file)
				BufferedReader reader = new BufferedReader(new FileReader(commit));
				String line = null;
				boolean s2 = false;
				while ((line = reader.readLine()) != null) {
					if (line.startWith("diff") && line.endWith("pom.xml")) { //!!!!!!!!!!!
						s2 = true;
						line = reader.readLine();
						break;
					}
				}
				if (s2) {
					while (line != null && !line.startWith("diff")) {
						if (line.substring("")) {//?????
						}
						if (line.substring("")) {
						}
					}
				}
			}
		}

	}

}
