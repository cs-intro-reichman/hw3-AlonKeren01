/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true 

		// Tests the preProcess function.
		//System.out.println(preProcess("What? No way!!!"));
		//System.out.println(preProcess("1234"));
		
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed"); 
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		char s = 's';
		boolean exist = false;

		for(int i = 0; i < str1.length(); i++){
			s = str1.charAt(i);

			for(int j = 0; j < str2.length(); j++){
				if(s == str2.charAt(j)) {
					str2.replace(str2.charAt(j), '$');
					exist = true;
					break;
				}
			}

			if (!exist) return exist;
			exist = false;
		}

		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String s = "";
		for(int i = 0; i < str.length(); i++){
			if (Character.isLetter(str.charAt(i)) || Character.isDigit(str.charAt(i)) || Character.isSpaceChar(str.charAt(i))) s += str.charAt(i);
		}
		return s.toLowerCase();
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newStr = "";
		int rnd;

		for(int i = str.length() - 1; i >= 0; i--){
			rnd = (int) (Math.random() * str.length());
			newStr += str.charAt(rnd);

			if (rnd == 0) str = str.substring(1);
			else if (rnd == str.length() - 1) str = str.substring(0, str.length() - 1);
			else str = str.substring(0, rnd) + str.substring(rnd + 1);
		}

		return newStr;
	}
}
