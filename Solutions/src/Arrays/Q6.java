package Arrays;

public class Q6 {

	public static void main(String[] args) {

		Q6 q6 = new Q6();
		System.out.println(q6.compress("aabcccccaaa"));
	}

	public static String compress(String str) {
		StringBuilder compressedString = new StringBuilder();
		int repeatCount = 0;
		for (int i = 0; i < str.length(); i++) {
			repeatCount++;
			if (str.length() <= i + 1 || str.charAt(i) != str.charAt(i + 1)) {
				compressedString.append(str.charAt(i));
				compressedString.append(repeatCount);
				repeatCount = 0;
			}
		}
		if (compressedString.length() < str.length()) {
			return compressedString.toString();

		} else {
			return str;
		}

	}

}
