package top.starp.dataStruct.huaWei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://blog.csdn.net/bm1998/article/details/116213084
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }

        // 对二维数组第一个元素进行排序
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });

        List<int[]> list = new ArrayList<>();
        // 当前数组
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            // 下一个数组第一个元素 > 当前数组第二个元素时，不用合并
//            1 2  3 4
//            1 3  2 4
            if (intervals[i][0] > cur[1]) {
                list.add(cur);
                cur = intervals[i];
            } else {
//                合并 下一个数组的第二个元素
//                扩展为右边的最大的
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
        }
        list.add(cur);

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
