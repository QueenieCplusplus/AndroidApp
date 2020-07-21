package katesJavaWork_0806;

import java.io.FileWriter;
import java.io.IOException;

public class fileWriter {
	
	public static void main(String[] args) throws IOException{ //舉例需要，這裡用throws
		
		FileWriter fw = new FileWriter("/Users/katesapp2019/Desktop/here.txt");
		fw.write("Patty\n");
	
		String str = "is absolutely" + System.getProperty("line.separator");
		fw.write(str);
		
		fw.write(" A Real Backend Engineer !!!");
		fw.close();
	}
}
