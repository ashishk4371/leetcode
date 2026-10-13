import java.util.*;

public class Problem108 {

	static class Node {
		int val;
		Node left;
		Node right;

		Node() {}
		Node(int val) { this.val = val; }
		Node(int val, Node left, Node right) { this.val = val; this.left = left; this.right = right; }
	}
	
	public static void main(String[] args) {

		int[] arr = new int[] {-10,-3,0,5,9};
		Node node = buildBST(arr, 0, arr.length-1);
		printPreOrder(node);
		System.out.println();
		printInOrder(node);
		System.out.println();
		printPostOrder(node);
	}

	public static Node buildBST(int[] arr, int l, int r) {
		if(l > r) return null;

		int m = (l + r) / 2;

		Node node = new Node(arr[m]);
		node.left = buildBST(arr, l, m-1);
		node.right = buildBST(arr, m+1, r);

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

	public void BFS(Node node) {

	}

}
