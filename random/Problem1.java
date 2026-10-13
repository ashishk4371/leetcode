import java.util.*;

public class Problem1 {

	public static void main(String[] args) {
		int[] res = twoSum(new int[] {3,3}, 6);

		for(int n: res) {
			System.out.print(n + " ");
		}
	}

	static public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = nums.length;
		
		for(int i=0; i<n; i++) {
			int curr = nums[i];
			if(map.containsKey(target - curr)) {
				return new int[] {i, map.get(target - curr)};
			}

			map.put(curr, i);
		}

		return null;
	}

}
