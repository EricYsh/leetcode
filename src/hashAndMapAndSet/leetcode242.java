package hashAndMapAndSet;

//TODO 242. 有效的字母异位词 https://leetcode-cn.com/problems/valid-anagram/description/
public class leetcode242 {
    // TODO 1. 暴力，排序后，比较是否相同
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        char[] str1 = s.toCharArray();
//        char[] str2 = t.toCharArray();
//        Arrays.sort(str1);
//        Arrays.sort(str2);
//        return Arrays.equals(str1, str2);
//    }
    // TODO 2. 哈希表，统计每个字母的频次
    // t 是 s 的异位词等价于「两个字符串中字符出现的种类和次数均相等」。
    // 由于字符串只包含 26 个小写字母，因此我们可以维护一个长度为 26 的频次数组 table，
    // 先遍历记录字符串 s 中字符出现的频次，然后遍历字符串 t，减去 table 中对应的频次，
    // 如果出现 table[i]<0，则说明 t 包含一个不在 s 中的额外字符，返回 false 即可
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] != 0) return false;
        }

        return true;
    }
}
