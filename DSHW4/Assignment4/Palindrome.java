package Assignment4;
public class Palindrome {
	public static boolean isPalindrome(String s) {
		LinkedStack<Character> stack = new LinkedStack<Character>();
		for(int i = 0; i < Math.ceil((double)s.length()/2.0); i++) {
			stack.push(s.charAt(i));
		}

		for(int i = s.length()/2; i < s.length(); i++) {
			if(stack.pop() != s.charAt(i)) {
				return false;
			}
		}

		return true;
	}
}