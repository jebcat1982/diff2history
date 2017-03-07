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
			
		}

	}

}
