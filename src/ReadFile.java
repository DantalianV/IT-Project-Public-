import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadFile {

	public static String[] readStrings(String s) {
		String filename = s;

		String[] data = new String[10000];
		int i = 0;
		
		File myObj = new File(filename);
		Scanner myReader;
		try {
			myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				data[i] = myReader.nextLine();
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static double[] readDouble(String s) {
		String filename = s;

		double[] data = new double[10000];
		int i = 0;
		
		File myObj = new File(filename);
		Scanner myReader;
		try {
			myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				data[i] = Double.parseDouble(myReader.nextLine());
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static int[] readInt(String s) {
		String filename = s;

		int[] data = new int[10000];
		int i = 0;
		
		File myObj = new File(filename);
		Scanner myReader;
		try {
			myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				data[i] = Integer.parseInt(myReader.nextLine());
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static String[][] readAdd(String s) {
		String filename = s;

		String[][] data = new String[15000][13];
		int i = 0;
		
		File myObj = new File(filename);
		Scanner myReader;
		try {
			myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				for(int j = 0; j<13; j++) {
					data[i][j] = myReader.nextLine();
				}
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}
}
