package katesJavaWork_0806;

import java.util.Random;

import java.util.Scanner;

public class rockPaperScissor {
	
	public static void main(String[] args) {
		
		int a, b;
		Random r = new Random(); // 建立亂數的物件，放在變數 r 
		Scanner sc = new Scanner(System.in);  // 建立輸入的物件，放入變數 sc
		String[] game = {"Rock", "Paper", "Scissor"}; // 建立字串資料型態的陣列物件，放入變數 game
		String[] playGame = {"Rock", "Paper", "Scissor", "Rock"}; // 字串陣列的物件，放入變數 playGame
		
		do {
			System.out.print("plz input:");
			a = sc.nextInt(); // 讓玩家輸入一整數
		}while(!(a>=1&a<=3));
		
		a = a-1;
		System.out.println("Player is:" +game[a]);
		
		b = r.nextInt(3); // 亂數元件產生範圍從 0 ~ 2的整數 // 這是電腦選手出的牌
		
		if(b==2&a==0) {a=3;}
		if(a==2&b==0) {b=3;}
		
		if(a==b) {
			System.out.println("Computer is"+playGame[b]);
			System.out.println("end in draw");}
		else if(a>b) {
			System.out.println("Computer is"+playGame[b]);
			System.out.println("You Win!!!");}
	    else {
	    	System.out.println("Computer is"+playGame[b]);
	    	System.out.println("Game Over");}
	}
}
