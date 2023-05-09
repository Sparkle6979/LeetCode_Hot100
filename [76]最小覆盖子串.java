//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2480 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public Map<Character,Integer> sr;
    public Map<Character,Integer> tr;

    public String minWindow(String s, String t) {


        if(s.length() < t.length())
            return "";


        String res;

        sr = new HashMap<>();
        tr = new HashMap<>();

        for(int i=0;i<t.length();++i) {
            tr.put(t.charAt(i), tr.getOrDefault(t.charAt(i),0) + 1);
            sr.put(s.charAt(i), sr.getOrDefault(s.charAt(i),0) + 1);
        }

        int l=0,r=t.length()-1;
        int minl = Integer.MAX_VALUE;

        while (){
            while(!check()){
                r++;
                sr.put(s.charAt(r),sr.getOrDefault(s.charAt(r),0)+1);
            }

            if(r-l+1 < minl){
                minl = r-l+1;
                res = s.substring(l,r+1);
            }

            l++;
            while(check()){
                l++;
            }
            minl = r-l;
        }

    }

    public boolean check(){
        for (Character character : tr.keySet()) {
            if(sr.getOrDefault(character,0) < tr.get(character))
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
