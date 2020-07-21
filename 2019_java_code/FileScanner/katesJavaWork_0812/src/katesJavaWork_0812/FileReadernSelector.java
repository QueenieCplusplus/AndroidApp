package katesJavaWork_0812;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class FileReadernSelector {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			LinkedHashMap<Integer, String> lotteLinkedHashMap = getLotteLinkedHashMap();
			if (lotteLinkedHashMap.isEmpty()) {
				throw new Exception("GG!");
			}

			while (!lotteLinkedHashMap.isEmpty()) {

				System.out.println("請在Console內輸入欲查詢第幾筆樂透並輸出的資料: ");
				Scanner scanner = new Scanner(System.in);
				String input = scanner.next();
				if (!input.matches("[0-9]{1,3}")) {
					System.out.println("請輸入數字");
					continue;
				}

				int outputDataLines = 1;
				try {
					outputDataLines = Integer.valueOf(input);
				} catch (Exception e) {
					System.out.println("user input : " + input);
				}

				if (outputDataLines <= lotteLinkedHashMap.size()) {

					String tmpLotteData = lotteLinkedHashMap.get(outputDataLines);
					if (tmpLotteData != null) {
						FileWriter fileWriter = new FileWriter("/Users/katesapp2019/Desktop/here.txt");
						BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
						bufferedWriter.write("第 " + outputDataLines + " 筆樂透\r\r\r");

						for (String tmpStr : tmpLotteData.split(" ")) {
							bufferedWriter.write(tmpStr + "\r\r");
						}
						bufferedWriter.close();
						System.out.println("Output Finish");
					}
				} else {
					System.out.println("請輸入1~" + lotteLinkedHashMap.size());
				}
			}

		} catch (Exception e) {
			System.out.println("GG");
			e.printStackTrace();
		}
	}

	// 取出所有樂透資料
	public static LinkedHashMap<Integer, String> getLotteLinkedHashMap() throws Exception {

		LinkedHashMap<Integer, String> lotteLinkedHashMap = new LinkedHashMap<Integer, String>();
		try {
			String pathname = "/Users/katesapp2019/Desktop/here.txt"; // 絕對路徑或相對路徑都可以，這裡是絕對路徑，寫入檔案時演示相對路徑
			File filename = new File(pathname); // 要讀取以上路徑的input。txt檔案
			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filename));
			BufferedReader br = new BufferedReader(inputStreamReader);

			int count = 1;
			String line = br.readLine();
			while (line != null) {
				lotteLinkedHashMap.put(count, line);
				line = br.readLine();
				count++;
			}
			return lotteLinkedHashMap;
		} catch (Exception e) {
			throw new Exception("讀取檔案失敗! " + e);
		}
	}
}
