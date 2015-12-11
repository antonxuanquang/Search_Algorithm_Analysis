package Model.Generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;

public class DataTableGenerator {
	String fileName;
	
	public DataTableGenerator() {}
	
	/**
	 * Read a file then add all the keys to an arraylist
	 * @return arraylist contains all the keys
	 */
	
	public ArrayList<String> readAFile() {
		ArrayList<String> result = new ArrayList<String> ();
		File file = getFile();
		
		if (file != null) {
			fileName = file.getName();
			String path = file.getAbsolutePath();
			
			try {
				BufferedReader bf = new BufferedReader( new FileReader(path));
				String line;
				while ((line = bf.readLine()) != null) {
					StringTokenizer st = new StringTokenizer(line);
					while (st.hasMoreTokens()) {
						String key = st.nextToken();
						result.add(key);
					}
				}
				bf.close();
			} catch (IOException e) {}
		}
		return result;
	}

	
	private File getFile() {
		JFileChooser fc = new JFileChooser("C:\\Users\\Quang Nguyen\\OneDrive"
				+ "\\mon hoc\\Fall 2015\\CoSc 20803\\Search_Algorithm_Analysis");
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile();
		} else {
			return null;
		}
	}
	
	public String getFileName() {
		return fileName;
	}
	
}
