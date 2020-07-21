package katesJavaWork_0807;

public class IDCardProducer {	
	public String str = "";	
	public IDCardProducer() { }	
	public IDCardProducer(String s) {
		this.str = s;
	}
	public static void main(String[] args) {
		String idNum = IDCardProducer.IDRandom();
		System.out.println(idNum);		
	}
	private static String IDRandom() {
		char[] idByChar = new char[9];
		String idString = "";		
		//隨機產生A~Z
		int x = (int)Math.floor(Math.random()*26+65); //有問題, Line 18
		idByChar[0] = (char) x;		
		//隨機產生1~2
		idByChar[1] = (char)(int)Math.floor(Math.random()*2+49);		
		//隨機產生第3~9個數字
		for(int i=2; i<9; i++) {
			idByChar[i] = (char)(int)Math.floor(Math.random()*10+48);
		}
		//組數值
		idString = new String(idByChar);
		IDCardProducer id = new IDCardProducer(idString);
		int[] temp = new int[10];
		temp[0] = id.D0();		
		for(int i=1; i<9; i++) {
			temp[i]=id.Dnumber(i);
		}		
		//組字
		idString = idString + temp[9];
		return idString;		
	}
	private int D0(){
		int D00=0;
		int temp = this.str.codePointAt(0);	
		if(72 >=temp && temp >= 65) {
			D00 = temp - 55;
		}else if(78 >= temp && temp >= 74){
			D00 = temp - 56;
		}else if(86 >= temp && temp >=80) {
			D00 = temp - 57;
		}else if(90 >= temp && temp >= 88) {
			D00 = temp -58;
		}		
		if(104 >= temp && temp >=97) {
			D00 = temp - 87;
		}else if(110 >= temp && temp >=106) {
			D00 = temp -88;
		}else if(118 >= temp && temp >=112) {
			D00 = temp - 89;
		}else if(122 >= temp && temp >= 120) {
			D00 = temp - 90;
		}		
		switch(temp){
			case 106: 
				D00 = temp-71;
			case 111:
				D00 = temp-76;
				break;
			case 119:
				D00 = temp - 87;
				break;
			default:
				break;	
		}
		return D00;
	}
	private int Dnumber(int i) {
		int D1=100; // 初始值 tr.codePointAt(i); //避免使用1~9;
		int temp = this.str.codePointAt(i);
		if(57 >= temp && temp >= 48) {
			D1 = temp-48;
		}
		return D1;
	}
}
