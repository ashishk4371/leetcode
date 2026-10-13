import java.util.*;

public class Problem1257 {

	public static void main(String[] args) {
		List<List<String>> regions = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList("Earth", "North America", "South America")), new ArrayList<>(Arrays.asList("North America", "United States", "Canada")), new ArrayList<>(Arrays.asList("United States", "New York", "Boston")), new ArrayList<>(Arrays.asList("Canada", "Ontario", "Quebec")), new ArrayList<>(Arrays.asList("South America", "Brazil"))));

		System.out.println(findSmallestRegion(regions, "New York", "Brazil"));
	}

	static List<String> findPathToRoot(Map<String, String> map, String region) {
		List<String> res = new ArrayList<>();
		while(map.containsKey(region)) {
			res.add(region);
			region = map.get(region);
		}

		res.add(region);
		return res;
	}

	static String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
		Map<String, String> map = new HashMap<>();
		List<String> path1 = new ArrayList<>();
		List<String> path2 = new ArrayList<>();

		for(List<String> region: regions) {
			for(int i=1; i<region.size(); i++) {
				map.put(region.get(i), region.get(0));
			}
		}

		path1 = findPathToRoot(map, region1);
		path2 = findPathToRoot(map, region2);
		String s = "";

		int i=0, j=0;
		System.out.println(path1 + " " + path2);
		while(i < path1.size() && j < path2.size() && path1.get(path1.size()-i-1).equals(path2.get(path2.size()-j-1))) {
			s = path1.get(path1.size()-i-1);
			i++;
			j++;
		}

		return s;
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
