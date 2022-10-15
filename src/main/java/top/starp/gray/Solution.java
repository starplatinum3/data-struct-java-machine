package top.starp.gray;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                int addNum=ret.get(j) | (1 << (i - 1));
                System.out.println("addNum");
                System.out.println(addNum);
                ret.add(addNum);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.grayCode(4);
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode.cn/problems/gray-code/solution/ge-lei-bian-ma-by-leetcode-solution-cqi7/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
