import java.util.*;

public class Problem295 {

	public static void main(String[] args) {
		System.out.println("find median: ");
		String[] testCase = new String[] {"MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"};
		String[] input = new String[] {"[]","[6]","[]","[10]","[]","[2]","[]","[6]","[]","[5]","[]","[0]","[]","[6]","[]","[3]","[]","[1]","[]","[0]","[]","[0]","[]"};
		runTest(testCase, input);
	}

	static void runTest(String[] testCase, String[] input) {
		MedianFinder mf = new MedianFinder();
		long start = System.nanoTime();
		for(int i=0; i<testCase.length; i++) {
			String str = testCase[i];
			String in = input[i];
			if(str.equals("MedianFinder")) {
				mf = new MedianFinder();
			} else if(str.equals("addNum")) {
				int num = Integer.parseInt(in.substring(1, in.length()-1));
				mf.addNum(num);
			} else {
				System.out.println(mf.findMedian());
			}
		}
		System.out.println((double)(System.nanoTime() - start) / 1_000_000);
	}

	static int lowerBound(List<Integer> list, int num) {
		int l = 0, r = list.size() - 1;

		while(l <= r) {
			int m = l + (r - l) / 2;

			if(list.get(m) == num) {
				r = m - 1;
			} else if(list.get(m) > num) {
				r = m - 1;
			} else if(list.get(m) < num) {
				l = m + 1;
			}
		}

		return l;
	}

	static class MedianFinder {
		Queue<Integer> min; 
		Queue<Integer> max;

		public MedianFinder() {
			min = new PriorityQueue<>();
			max = new PriorityQueue<>(Collections.reverseOrder());
		}

		public void addNum(int num) {
			max.offer(num);
			min.offer(max.poll());
			if(min.size() > max.size()) {
				max.offer(min.poll());
			}
		}

		public double findMedian() {
			if(max.size() > min.size()) {
				return max.peek();
			}

			return (max.peek() + min.peek()) / 2.0d;
		}
	}
}
