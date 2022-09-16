package top.starp.daJiang.t1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * IBG开发岗位招聘B卷1
 * 时间限制： 5000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 *
 *
 * 输入描述
 * nums=[1,2,3,1],k=3
 *
 * 在【输入样例】的数据结构为：
 *
 * 4  //第一行为nums数组长度
 *
 * 1  //第二行至倒数第二行为nums数组元素
 *
 * 2
 *
 * 3
 *
 * 1
 *
 * 3 //最后一行为k
 *
 * 输出描述
 * true    //请注意，赛码网的默认代码模板中会将ture、false转化为1、0，需要修改代码模板转换，否则不能通过测试用例。测试用例是以字符串格式的true和false为断言结果。
 *
 *
 * 样例输入
 * 4
 * 1
 * 2
 * 3
 * 1
 * 3
 * 样例输出
 * true
 *
 * 规则
 * 请尽量在全场考试结束10分钟前调试程序，否则由于密集排队提交，可能查询不到编译结果
 * 点击“调试”亦可保存代码
 * 编程题可以使用本地编译器，此页面不记录跳出次数
 */
class Solution {

    /* Write Code Here */
    public boolean containsNearbyDuplic(int[] nums, int k) {

        if(k<=0){
            return false;
        }
        int j=1;
        for(int i=0;i<nums.length&&j<nums.length;){
            if(j-i>k){
                i++;
                continue;
            }
            if(j>=nums.length){
                return false;
            }
            if(nums[i]==nums[j]){
                if(i==j){
                    continue;
                }
                return true;
            }
            j++;
        }
        return false;

    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean res;

        int nums_size = 0;
        nums_size = in.nextInt();
        int[] nums = new int[nums_size];
        for(int nums_i = 0; nums_i < nums_size; nums_i++) {
            nums[nums_i] = in.nextInt();
        }

        if(in.hasNextLine()) {
          in.nextLine();
        }

        int k;
        k = Integer.parseInt(in.nextLine().trim());

        res = new Solution().containsNearbyDuplic(nums, k);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}
