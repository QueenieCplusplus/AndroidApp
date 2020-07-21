
package katesJavaWork_0807;

public class  addZeroForNum {
	
	public static void main(String[] args){
//	  public String addZeroForNum (String str, int strLength) {  
		  String str = "8";
		  int strLen =str.length();  
		  int strLength = 2;
		 
		   while (strLen< strLength) {  
		    StringBuffer sb = new StringBuffer(); 
		    sb.append("0").append(str);
		    str= sb.toString();  
		    strLen= str.length();  
		   }  
		 
//		  return str;  
		  System.out.println(str);
//		 } 
	}
}
