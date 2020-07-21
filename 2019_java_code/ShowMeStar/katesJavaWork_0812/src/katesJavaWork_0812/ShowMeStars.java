package katesJavaWork_0812;

public class ShowMeStars {

	static int startCount = 6;

	public static void main(String[] args) {

		starMaker1(100);

	}

	public static void starMaker1(int startCount) {

		for (int i = 1; i <= startCount; i++) { // LineCount

			for (int j = 1; j <= startCount + 1 - i; j++) { // StarCount

				System.out.print("*");

			}

			System.out.println();
		}
		
	}

}
