package Arrays;

public class Q9 {

	public static void main(String[] args) {
		Q9 q9 = new Q9();
		System.out.println(q9.stringRotation ("waterbottle", "terbottlewa"));
		}
		public boolean stringRotation (String
		s1, String
		s2) {
		if (s1. length() != s2.length()) {
		return false;
		}
		StringBuilder s3 = new StringBuilder();
		s3. append (s1); 
		s3. append(s1); 
		return (s3. indexOf(s2) != -1);
	}

}
