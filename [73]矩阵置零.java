//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -2³¹ <= matrix[i][j] <= 2³¹ - 1 
// 
//
// 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个仅使用常量空间的解决方案吗？ 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 873 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        int[] hrec = new int[matrix.length];
        int[] lrec = new int[matrix[0].length];

        for(int i=0;i<matrix.length;++i)
            for(int j=0;j<matrix[0].length;++j){
                if(matrix[i][j] == 0) {
                    hrec[i] = 1;
                    lrec[j] = 1;
                }

            }
        for(int i=0;i<matrix.length;++i){
            if(hrec[i] == 1){
                for(int j=0;j<matrix[0].length;++j)
                    matrix[i][j] = 0;
            }
        }

        for(int i=0;i<matrix[0].length;++i){
            if(lrec[i] == 1){
                for(int j=0;j<matrix.length;++j)
                    matrix[j][i] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
