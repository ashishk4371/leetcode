import java.util.*;

class Problem128 {

	public static void main(String[] args) {
		int[] arr = new int[] { 100, 4, 200, 1, 3, 2 };
		System.out.println(longestConsecutiveSequence(arr));

		
	}

	public static int longestConsecutiveSequence(int[] nums) {
		int max = 0;

		Set<Integer> set = new HashSet<>();
		for(int num: nums) {
			set.add(num);
		}

		for(int num: set) {
			if(!set.contains(num-1)) {
				int currMax = 1;

				while(set.contains(num+1)) {
					num += 1;
					currMax += 1;
				}

				max = Math.max(max, currMax);
			}
		}

		return max;
	}
}
