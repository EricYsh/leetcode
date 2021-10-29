package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 438. 找到字符串中所有字母异位词 https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
public class leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if (n < m) return res;
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for (int i = 0; i < m; i++) {
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCnt, pCnt)) {
            res.add(0);
        }
        for (int i = m; i < n; i++) {
            sCnt[s.charAt(i - m) - 'a']--;
            sCnt[s.charAt(i) - 'a']++;
            if (Arrays.equals(sCnt, pCnt)) {
                res.add(i - m + 1);
            }
        }
        return res;
    }
}
