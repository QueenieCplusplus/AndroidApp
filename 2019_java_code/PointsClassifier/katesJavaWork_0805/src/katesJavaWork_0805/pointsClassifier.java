package katesJavaWork_0805;

public class pointsClassifier {
	
	public static void main(String[] args) {
		for(int i=1; i<=25; i++) {
			int score = (int)(Math.random()*(100-40)+40);
			if(score>=90) System.out.println("優秀"); 
			else if(score>=0) System.out.println("良好"); 
			else if(score>=70) System.out.println("中等"); 
			else if(score>=60) System.out.println("及格"); 
			else System.out.println("不及格"); 
			
			switch (score/10) { 
			case 10: 
			case 9: System.out.println("優秀"); break; 
			case 8: System.out.println("良好"); break; 
			case 7: System.out.println("中等"); break; 
			case 6: System.out.println("及格"); break; 
			default:System.out.println("不及格"); break; 
			} 
			
			String arr[] = {"優秀","良好","中等","及格","不及格"}; 			
//			陣列pos中的下標對應於score/10的結果,pos中的值對應於陣列arr等級 
			int pos[] = {}; 
//		
			System.out.println(i + "->" + score);
			System.out.println(arr[pos[score/10]]); 
		}
	}
}
/*學生編號1到25的隨機分數*/

