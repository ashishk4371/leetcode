import java.util.*;

public class Problem1614 {

	public static void main(String[] args) {
		System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
		System.out.println(maxDepth("(1)+((2))+(((3)))"));
		System.out.println(maxDepth("()(())((()()))"));
	}

	static int maxDepth(String s) {
		int max = 0, curr = 0;

		Stack<Character> stack = new Stack<>();
		for(char ch: s.toCharArray()) {
			if(ch == '(') {
				curr++;
				max = Math.max(max, curr);
			} else if(ch == ')') {
				curr--;
			}
		}

		return max;
	}
}
