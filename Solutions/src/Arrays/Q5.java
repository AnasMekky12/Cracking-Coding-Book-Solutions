package Arrays;

public class Q5 {

    public static void main(String[] args) {
        System.out.println(oneAway("palef", "pable"));
    }

    public static boolean oneAway(String str1, String str2) {
        if (str1.length() == str2.length()) {
            return replace_once(str1, str2);
        } else if (Math.abs(str1.length() - str2.length()) == 1) {
            if (str1.length() < str2.length()) {
                return insert_once(str1, str2);
            } else {
                return insert_once(str2, str1);
            }
        }
        return false;
    }

    public static boolean replace_once(String str1, String str2) {
        boolean replaced = false;
        for (int i = 0; i < str1.length(); i++) { 
            if (str1.charAt(i) != str2.charAt(i)) {
                if (replaced) {
                    return false;
                }
                replaced = true;
            }
        }
        return true;
    }

    public static boolean insert_once(String min_str, String max_str) {
        int min_ptr = 0, max_ptr = 0; 
        while (min_ptr < min_str.length() && max_ptr < max_str.length()) {
            if (min_str.charAt(min_ptr) != max_str.charAt(max_ptr)) {
                if (min_ptr != max_ptr) {
                    return false; 
                }
                max_ptr++; 
            } else {
                min_ptr++;
                max_ptr++;
            }
        }
        return true; 
    }
}
