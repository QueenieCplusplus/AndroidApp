package katesJavaWork_0812;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// 題目期望把日期資料結構轉為字串，並且追加運用天數 dateNum 的參數。

public class DateUtils {

	private static Date d;

	public static void main(String[] args) {

		Date d = showNow();
		dateToStr(d);

	}

	public static Date showNow() {

		Date date = new Date(); // 用 new 建立現在時間的物件
		System.out.print(date);
		return date;
	}

	public static String dateToStr(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		String str = "";

		try {

			str = sdf.format(d); // 將方法的變數修改成類別成員的變數
			// 本來變數寫法是 Date d = sdf.parse(str1);

			System.out.print(str);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

}
