import java.util.*;

public class Problem973 {

	public static void main(String[] args) {
		int[][] points = new int[][] { {1,3}, {-2,2} };
		int[][] res = closest(points, 1);
		print2dArray(res);
	}

	static int[][] closest(int[][] points, int k) {
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
			double distA = Math.hypot(a[0], a[1]);
            double distB = Math.hypot(b[0], b[1]);
			return Double.compare(distA, distB);
		});
		int[][] res = new int[k][2];
		for(int[] point: points) {
			pq.offer(point);
		}

		for(int i=1; i<=k; i++) {
			int[] point = pq.poll();
			res[i-1] = point;
		}

		return res;
	}

	static class Node {
		int val;
		Node left;
		Node right;

		Node() {}
		Node(int val) { this.val = val; }
		Node(int val, Node left, Node right) { this.val = val; this.left = left; this.right = right; }
	}
	
	public static Node buildBSTFromSortedArray(int[] arr, int l, int r) {
		if(l > r) return null;

		int m = (l + r) / 2;

		Node node = new Node(arr[m]);
		node.left = buildBSTFromSortedArray(arr, l, m-1);
		node.right = buildBSTFromSortedArray(arr, m+1, r);

		return node;
	}

	public static void printInOrder(Node node) {
		if(node == null) return;

		printInOrder(node.left);
		System.out.print(node.val + " ");
		printInOrder(node.right);
	}

	public static void printPreOrder(Node node) {
		if(node == null) return;
		System.out.print(node.val + " ");

		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	public static void printPostOrder(Node node) {
		if(node == null) return;

		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.val + " ");
	}

	static void print2dArray(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
