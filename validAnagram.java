package myleetcode;
//力扣题242，有效的字母异同（给定两个字符串s和t，判断t是否s的字母异同）
//可以用排序法、哈希表，这里用哈希表。
public class validAnagram
{
	public boolean isAnagram(String s,String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] counter = new int[26];
		for (int i=0;i<s.length();i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}
		for (int count : counter) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "art";
		String t = "rat";
		validAnagram aAnagram = new validAnagram();
		boolean isAnagramOrnot = aAnagram.isAnagram(s,t);
		System.out.println(isAnagramOrnot);
	}
	
}
