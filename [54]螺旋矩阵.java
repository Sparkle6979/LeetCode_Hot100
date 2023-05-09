//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1374 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 静态初始化
    public int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public List<Integer> res = new ArrayList<>();

    public boolean check(int x,int y,int h,int l){
        if(x >= 0 && x < h && y>=0 && y<l)
            return true;
        return false;
    }

    public void dfs(int x,int y,int nd,int cnt,int[][] m,boolean[][] visit){
        visit[x][y] = true;
        res.add(m[x][y]);

        if(cnt == m.length * m[0].length)
            return ;

        for(int i=0;i<4;++i){
            nd = (nd + i)%4;
            int newx = x + dir[nd][0];
            int newy = y + dir[nd][1];

            if(check(newx,newy,m.length,m[0].length) && !visit[newx][newy]){
                dfs(newx,newy,nd,cnt+1,m,visit);
                break;
            }
        }


    }

    public List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        dfs(0,0,0,1,matrix,visit);
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
