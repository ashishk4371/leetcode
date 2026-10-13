import java.util.*;

public class Problem450 {

	static class Node {
		int val;
		Node left;
		Node right;

		Node() {}
		Node(int val) { this.val = val; }
		Node(int val, Node left, Node right) { this.val = val; this.left = left; this.right = right; }
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {5,3,6,2,4,7};
		Node root = buildBSTFromSortedArray(arr, 0, arr.length-1);
		printPreOrder(root);
		System.out.println();
		printInOrder(root);
		System.out.println();
		printPostOrder(root);
	}

	public Node deleteNode(Node root, int key) {
		if(root == null) return null;
		if(root.val == key) {
			return helper(root);
		}

		Node dummy = root;
		while(root != null) {
			if(root.val > key) {
				if(root.left != null && root.left.val == key) {
					root.left = helper(root.left);
				} else {
					root = root.left;
				}
			} else {
				if(root.right != null && root.right.val == key) {
					root.right = helper(root.right);
				} else {
					root = root.right;
				}
			}
		}

		return dummy;
	}

	public Node helper(Node root) {
		if(root.left == null) {
			return root.right;
		}

		if(root.right == null) {
			return root.left;
		}

		Node lastLeftNode = findLastLeftNode(root.right);
		lastLeftNode.left = root.left;
		return root.right;
	}

	public Node findLastLeftNode(Node root) {
		if(root.left == null) return root;

		return findLastLeftNode(root.left);
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
}
