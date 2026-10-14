import java.util.*;

public class Problem560 {

	public static void main(String[] args) {
		System.out.println(subarraySum(new int[] {1, 1, 1}, 2));
		System.out.println(subarraySum(new int[] {1, 2, 3}, 3));
	}

	public static int subarraySum(int[] nums, int target) {
		int count = 0;
		for(int i=0; i<nums.length; i++) {
			int sum = 0;
			for(int j=i; j<nums.length; j++) {
				sum += nums[j];
				if(sum == target) count++;
			}
		}

		return count;
	}
}
