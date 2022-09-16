package top.starp.daJiang.t2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * 大疆创新 2023校招 IBG移动端/前端/后端开发工程师B卷在线考试 - 正式考试阶段
 * 编程题|10.0分2/2
 * IBG开发岗位招聘B卷2
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 *
 * 我们认为当员工一天中的工作小时数小于等于 8 小时的时候，这一天就是【正常工作】的一天，否则为【劳累工作】的一天。
 *
 * 我们定义【员工疲劳时间段】，意味在这段时间内，【正常工作】天数是严格小于【劳累工作】天数。
 *
 * 为追求工作生活平衡（WLB），保障员工身体健康和心情愉悦，编写算法输出【员工疲劳时间段】的最大长度。
 *
 *
 *
 * 输入描述
 * hours=[9,9,6,0,6,6,9]
 *
 * 在【输入样例】中表示的数据结构为：
 *
 * 7 //第一行，hours数组长度
 *
 * 9 //第二行至最后，每行表示数组一个元素
 *
 * 9
 *
 * 6
 *
 * 0
 *
 * 6
 *
 * 6
 *
 * 9
 *
 * 输出描述
 * 3
 *
 * 备注：最长的员工疲劳时间段是[9,9,6]
 *
 *
 * 样例输入
 * 7
 * 9
 * 9
 * 6
 * 0
 * 6
 * 6
 * 9
 * 样例输出
 * 3
 *
 * 提示
 * 1 <= hours.length <= 104
 *
 * 0 <= hours[i] <= 16
 */
class Solution {

    /* Write Code Here */
    public int longestWPI(int[] hours) {
        int lei=0;
        int zhe=0;
//        for (int hour: hours) {
//        int j=0;
        int j=1;
        int maxLen=0;
        int newHour0 =hours[0];
        if(newHour0>8){
            lei++;
        }else {
            zhe++;
        }
        for (int i=0;i<hours.length&&
                j<hours.length;) {

           int newHour =hours[j];
            if(newHour>8){
                lei++;
            }else {
                zhe++;
            }
            if(lei>zhe){

//                System.out.println("====");
//                System.out.println("i "+i);
//                System.out.println("j "+j);
                maxLen=Math.max(maxLen,j-i+1);
                j++;
            }else{
//                不累
                int hour= hours[i];
                if(hour>8){
                   lei--;
                }else {
                    zhe--;
                }
                i++;

            }
        }

        return maxLen;

    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int hours_size = 0;
        hours_size = in.nextInt();
        int[] hours = new int[hours_size];
        for(int hours_i = 0; hours_i < hours_size; hours_i++) {
            hours[hours_i] = in.nextInt();
        }

        if(in.hasNextLine()) {
          in.nextLine();
        }

        res = new Solution().longestWPI(hours);
        System.out.println(String.valueOf(res));

    }
}
