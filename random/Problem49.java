import java.util.*;

class Problem49 {

	public static void main(String[] args) {
		String[] strs = new String[] { "eat","tea","tan","ate","nat","bat" };
		System.out.println(groupAnagrams(strs));

		String[] strs1 = new String[] { "" };
		System.out.println(groupAnagrams(strs1));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		int[] freq = new int[26];

		for(String str: strs) {
			Arrays.fill(freq, 0);

			for(char ch: str.toCharArray()) {
				freq[ch - 'a']++;
			}

			StringBuilder sb = new StringBuilder();
			for(int i=0; i<26; i++) {
				sb.append("#");
				sb.append(freq[i]);
			}

			String key = sb.toString();

			if(map.containsKey(key)) {
				List<String> list = map.get(key);
				list.add(str);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(key, list);
			}
		}

		for(List<String> values: map.values()) {
			res.add(values);
		}

		return res;
	}
}
