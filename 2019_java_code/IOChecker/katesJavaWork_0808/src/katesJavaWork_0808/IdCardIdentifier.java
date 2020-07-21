package katesJavaWork_0808;

public class IdCardIdentifier {
	
	@SuppressWarnings("unused")
	public void PID(String id) {
		
		int[] num = new int[10];
		
		int[] rdd = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
				25, 26, 27, 28, 29, 30, 31, 32, 33, 34};
		
		id = id.toUpperCase();
		
		if(id.charAt(0)<'A'||id.charAt(0)>'Z') {
			System.out.println("第一個字錯誤");
			return;
			} if (id.charAt(1)!='1'&& id.charAt(1)!='2') {
				System.out.println("第二個字錯誤");
			return;
		    } for (int i=1; i<10; i++) {
		    	System.out.println("輸入錯誤！"); return;
		    } for (int i=1; i<10; i++) {
		    	num[i]=(id.charAt(i)-'0');
		    }
		    num[0] = rdd[id.charAt(0)-'A'];
		    int sum = ((int)num[0]/10+(num[0]%10)*9);
		    for(int i=0; i<8; i++) {
		    	sum += num[i+1]*(8-i);
		    }
		    if(10-sum%10==num[9]) {
		    	System.out.println("身分證號碼正確");
		    } else {
		    	System.out.println("身分證號碼錯誤");
		    }
	}
}
