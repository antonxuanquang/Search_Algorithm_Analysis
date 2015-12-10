package Model;

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
	
	public ArrayList<Integer> readAFile() {
		ArrayList<Integer> result = new ArrayList<Integer> ();
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
						int temp = convertToInteger(key);
						result.add(temp);
					}
				}
				bf.close();
			} catch (IOException e) {}
		}
		return result;
	}
	
	public int convertToInteger(String key) {
	   char c1 = key.charAt(0), c2 = key.charAt(1), c3 = key.charAt(2), c4 = key.charAt(3);
	   return (int)((((((int)c1<<8)+(int)c2)<<8)+(int)c3)<<8)+(int)c4;
	}

	
	private File getFile() {
		JFileChooser fc = new JFileChooser("C:\\Users\\Quang Nguyen\\OneDrive"
				+ "\\mon hoc\\Fall 2015\\CoSc 20803\\Search_Algorithms_Analysis");
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
