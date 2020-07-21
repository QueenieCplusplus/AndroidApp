package katesJavaWork_0808;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class LotterySetMaker {
	private String number;
	public LotterySetMaker(String num) {
		this.number = num;
	}
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		return true;
	}	
	public int hashCode() {
		return Integer.valueOf(number);
	}
	public String toString() {
		return number;
	}
	public static void main(String[] args) {
		Random random = new Random();
		Set lotteryNum = new HashSet();
		
		while(lotteryNum.size() < 6) {
			lotteryNum.add(new LotterySetMaker(
					Integer.toString(random.nextInt(49)+1)));
		}
		System.out.println(lotteryNum);
	}
}

