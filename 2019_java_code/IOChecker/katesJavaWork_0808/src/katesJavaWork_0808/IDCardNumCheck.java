package katesJavaWork_0808;
import java.io.*;
public class IDCardNumCheck {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public IDCardNumCheck() {

	}
	public static void main(String[] args) {
		String number;
		char[] numChar;
		int[] numInt;
		String sex = null;
		String place = null;
		System.out.println("請輸入身分證字號");
		try {

			// 判斷輸入的位數是否正確
			number = br.readLine();
			if (number.length() != 10) {
				System.out.println("輸入錯誤");
			}
			numChar = number.toUpperCase().toCharArray(); // 字串轉為字元陣列
			numInt = charToInteger(numChar); // 字元陣列轉為數字
			place = placeFinder(numChar);
			System.out.println("place:" + place);

			// 判斷男女
			if (numInt[1] == 1) {
				sex = "Male";
			} else if (numInt[1] == 2) {
				sex = "female";
			} else if (numInt[1] != 1 || numInt[1] != 2) {
				sex = "第二位數只能為1或是2。";
			}
			System.out.println("sex:" + sex);

//		// 每位數的正確性
//		int idAll = 0;
//	    idAll += a*1;
//	    idAll += b*9;
//	    for(int i = 1, j = 8; i < numChar.length; i++, j--) {
//	    	idAll += numInt[i] * j;
//	    }
//	    
//	    idAll %= 10;
//	    
//	    if((10-idAll) == numInt[numInt.length-1]) {
//	    	System.out.println(number);
//	    } else {
//	    	System.out.println("Invalid, plz try again");
//	    }

			// 抓錯
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("plz type in the ID number");
		}
	}

	private static String placeFinder(char[] numChar) throws ArrayIndexOutOfBoundsException {

		switch (numChar[0]) {
		case 'A':
			return "Taipei";
		case 'B':
			return "Taichung";
		case 'C':
			return "Keelung";
		case 'D':
			return "Tainan";
		case 'E':
			return "Kaushiung";
		case 'F':
			return "New Taipei City";
		case 'G':
			return "YiLan";
		case 'H':
			return "Taoyuan";
		case 'I':
			return "Chiayi";
		case 'J':
			return "HsinZhu";
		case 'K':
			return "MiaoLi";
		case 'L':
			return "Other City";
		case 'M':
			return "Other City";
		case 'N':
			return "Other City";
		case 'O':
			return "Other City";
		case 'P':
			return "Other City";
		case 'Q':
			return "Other City";
		case 'R':
			return "Other City";
		case 'S':
			return "Other City";
		case 'T':
			return "Other City";
		case 'U':
			return "Other City";
		case 'V':
			return "Other City";
		case 'W':
			return "Other City";
		case 'X':
			return "Other City";
		case 'Y':
			return "Other City";
		case 'Z':
			return "Other City";
		}
		return null;
	}

	public static int[] charToInteger(char[] num) {
		int[] numA = new int[num.length];

		for (int i = 1; i < num.length; i++) {
			numA[i] = num[i] & '\u000f'; // 字符與編碼
		}
		return numA;
	}
}
