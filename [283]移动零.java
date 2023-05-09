//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 1985 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
//        int[] res = new int[nums.length];
        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        for (int num : nums) {
            if(num != 0)
                res.add(num);
            else
                ++cnt;
        }
        for(int i=0;i<nums.length;++i) {
            if(i<res.size())
                nums[i] = res.get(i);
            else
                nums[i] = 0;

        }



    }
}
//leetcode submit region end(Prohibit modification and deletion)
