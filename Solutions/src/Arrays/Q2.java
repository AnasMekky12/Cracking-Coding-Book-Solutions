package Arrays;

public class Q2 {

	public static void main(String[] args) {
		Q2 q2 = new Q2();
		System.out.println(q2.checkPermutation("Carter MacLennan", "MacLennaC naarter"));
	}

	public boolean checkPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		int[] charSet = new int[128];
		for (int i = 0; i < str1.length(); i++) {
			charSet[str1.charAt(i)]++;

		}

		for (int i = 0; i < str2.length(); i++) {
			charSet[str2.charAt(i)]--;

			if (charSet[str2.charAt(i)] < 0) {
				return false;

			}
		}

		return true;
	}

}
