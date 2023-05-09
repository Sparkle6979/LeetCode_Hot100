//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 1909 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        // 方法一：前缀和数组 + 暴力：n2
        // 方法二：哈希表优化
        Map<Integer,Integer> rec = new HashMap<>();
        rec.put(0,1);
        int sum = 0;
        int res = 0;

        for (int num : nums) {
            sum += num;

            res += rec.getOrDefault(sum-k,0);

            if(rec.containsKey(sum))
                rec.put(sum,rec.get(sum)+1);
            else
                rec.put(sum,1);
        }


        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
