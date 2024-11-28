package Arrays;

public class Q1 {
	public static void main(String[] args) {
		Q1 q1 = new Q1();
		System.out.println(q1.isUnique("abcd"));
	}

	public boolean isUnique(String str) {
		if (str.length ()> 128) {
			return false;
			}
			
			boolean [] charSet = new boolean [128];
			for (int i=0; i < str. length(); i++) {
			if (!charSet [str.charAt (i)]) {
			charSet [str.charAt(i)] = true;
			}
			else{
		return false;
		}
			}
			return true;
	}

}
