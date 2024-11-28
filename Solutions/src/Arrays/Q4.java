package Arrays;

public class Q4 {

	public static void main(String[] args) {
		Q4 q4 = new Q4();

		System.out.println(q4.palindromePermutation("t a c tz coapapa"));
	}

	public boolean palindromePermutation(String str) {
		int num_letters = 0;
		int num_non_pairs = 0;
		boolean[] char_set = new boolean[128];

		for (char letter : str.toLowerCase().toCharArray()) {
			if (letter != ' ') {
				num_letters++;
				if (!char_set[letter]) {
					char_set[letter] = true;
					num_non_pairs++;

				}

				else {

					num_non_pairs--;
					char_set[letter] = false;

				}
			}
		}

		if (num_letters % 2 != 0 && num_non_pairs == 1) {
			return true;
		} else if (num_letters % 2 == 0 && num_non_pairs == 0) {
			return true;
		} else {
			return false;
		}

	}

}
