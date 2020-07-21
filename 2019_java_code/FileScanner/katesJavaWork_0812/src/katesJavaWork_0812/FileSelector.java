package katesJavaWork_0812;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileSelector {

	public static void main(String[] args) {
		try {
			while (true) {
				System.out.println("請在Console內輸入欲查詢第幾筆樂透並輸出的資料: ");
				Scanner scanner = new Scanner(System.in);
				String input = scanner.next();
				if (!input.matches("[0-9]{1,3}")) {
					System.out.println("請輸入數字");
					continue;
				}
				int outputDataLines = Integer.valueOf(input);
				int totalCount = getTotalCount();
				if (outputDataLines > 0 && outputDataLines <= totalCount) {

					BufferedReader bufferedReader = getNewBufferedReader();
					// 長度17(含空白)是>>01 05 07 35 38 40 , 長度2是每行的"換行"吧...請問高手
					bufferedReader.skip((17 + 2) * (outputDataLines - 1));
					String line = bufferedReader.readLine();
					bufferedReader.close();
					// 因為要覆蓋就不是用new FileWriter("D:/lotte_new.txt", true);
					FileWriter fileWriter = new FileWriter("/Users/katesapp2019/Desktop/here.txt");
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					if (line != null) {
						bufferedWriter.write("第 " + outputDataLines + " 筆樂透\r\r\r");

						// line.split(" ")分離字串後丟到tmpStr 再寫入TXT
						for (String tmpStr : line.split(" ")) {
							bufferedWriter.write(tmpStr + "\r\r");
						}

						bufferedWriter.close();
						fileWriter.close();
						System.out.println("Output Finish");
					}
				} else {
					System.out.println("請輸入1~" + totalCount);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 取BufferedReader
	public static BufferedReader getNewBufferedReader() throws Exception {
		String pathname = "/Users/katesapp2019/Desktop/here.txt"; // 絕對路徑或相對路徑都可以，這裡是絕對路徑，寫入檔案時演示相對路徑
		File filename = new File(pathname); // 要讀取以上路徑的input。txt檔案
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(new FileInputStream(filename));
			return new BufferedReader(inputStreamReader);

		} catch (Exception e) {
			throw new Exception("讀取檔案失敗! " + e);
		}
	}

	// 取筆數
	public static int getTotalCount() throws Exception {
		try {
			return (int) getNewBufferedReader().lines().count();
		} catch (Exception e) {
			throw new Exception("取總筆數失敗!  " + e);
		}

	}

}
