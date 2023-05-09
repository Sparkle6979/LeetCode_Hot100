//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 9567 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.math.BigInteger;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode end = res;

        boolean act = false;
        int r;
        while(l1 != null && l2!=null){
            int vl1 = l1.val;
            int vl2 = l2.val;
            r = vl1 + vl2;
            if( act ){
                r += 1;
            }

            if( r >= 10){
                act = true;
                r = r%10;
            }
            else{
                act = false;
            }

            ListNode tmp = new ListNode(r,null);
            tmp.next = end.next;
            end.next = tmp;
            end = tmp;

            l1 = l1.next;
            l2 = l2.next;

        }

        while(l1 != null || l2!= null){
            if(l1 != null) {
                r = l1.val;
                l1 = l1.next;
            }
            else {
                r = l2.val;
                l2 = l2.next;
            }

            if( act ){
                r += 1;
            }

            if( r >= 10){
                act = true;
                r = r%10;
            }
            else{
                act = false;
            }

            ListNode tmp = new ListNode(r,null);
            tmp.next = end.next;
            end.next = tmp;
            end = tmp;

        }

        if(act){
            ListNode tmp = new ListNode(1,null);
            tmp.next = end.next;
            end.next = tmp;

        }

        return res.next;







//
//        long ind = 1;
//        long r1 = 0,r2 = 0;
//        while(l1 != null){
//            long val = l1.val * ind;
//            r1 += val;
//            ind*=10;
//            l1 = l1.next;
//        }
//
//        ind = 1;
//        while(l2 != null){
//            long val = l2.val * ind;
//            r2 += val;
//            ind*=10;
//            l2 = l2.next;
//        }
//
//        long res = r1 + r2;
//        System.out.println(res);
//        String sr = String.valueOf(res);
//
//
//        ListNode r = new ListNode();
////        ListNode tmp = res;
//        for(int i=0;i<sr.length();++i){
//            char ch = sr.charAt(i);
//            ListNode tmp = new ListNode();
//            tmp.val = Integer.parseInt(String.valueOf(ch));
//            tmp.next = r.next;
//            r.next = tmp;
//        }
//        return r.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
