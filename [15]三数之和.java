//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 5908 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int first,second,third;
        List<List<Integer>> res = new ArrayList<>();
        for(first = 0;first<nums.length&&nums[first]<=0;++first){
            if(first > 0 && nums[first] == nums[first-1])
                continue;
            third = nums.length-1;
            int target = -nums[first];
            for (second = first+1;second < nums.length;++second){
                if(second > first+1 && nums[second] == nums[second-1])
                    continue;

                while(nums[second] + nums[third] > target && third > second)
                    --third;
                if(third == second)
                    break;
                if(nums[second] + nums[third] == target){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[first]);
                    tmp.add(nums[second]);
                    tmp.add(nums[third]);
                    res.add(tmp);
                }
            }


        }
        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
