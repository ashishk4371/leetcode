import java.util.*;

public class Problem236 {

	public static void main(String[] args) {
		Node root = buildBSTFromSortedArray(new int[] {1,2,3,4,5,6,7,8,9,10,11}, 0, 10);
		printInOrder(root);
		System.out.println();

		Node lca = lowestCommonAncestor(root, new Node(7), new Node(11));
		System.out.println(lca.val);
	}

	static Node lowestCommonAncestor(Node root, Node p, Node q) {
		if(root == null) return null;

		if(root.val == p.val || root.val == q.val) {
			return root;
		}

		Node left = lowestCommonAncestor(root.left, p, q);
		Node right = lowestCommonAncestor(root.right, p, q);

		if(left == null) return right;
		if(right == null) return left;

		return root;
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
}
