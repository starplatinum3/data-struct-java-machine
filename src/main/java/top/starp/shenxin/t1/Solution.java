package top.starp.shenxin.t1;

import java.util.*;


public class Solution {

    void stepOne(){
//        while (have[now]==1){
//            now++;
//            if(now>=n){
//                now=0;
//            }
//        }
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *  n 个人，m-1 的那个人
     * @param n int整型
     * @param m int整型
     * @return int整型
     */
//    @Requ

    public int lastRemaining (int n, int m) {
        // write code here
//        for(int i=0;i<n;i++){
//
//        }

        int have[]=new int[n+1];
        int now=0;
        int haveCnt=0;
        while (true){
//            m-1 ,  2*(m-1
            if(haveCnt==n-1){
                System.out.println("有这么多个了 退出");
                System.out.println("haveCnt");
                System.out.println(haveCnt);
                return now;
            }

            System.out.println("-----------------------");
            System.out.println("要走几个人");
            System.out.println(m);
            for (int i = 0; i <m ; i++) {
                while (have[now]==1){
                    now++;
                    System.out.println("now");
                    System.out.println(now);
                    if(now>=n){
                        now=0;
                    }
                }
                now++;
//                now =0  have=0
            }


            System.out.println("=======");
//            没走过的地方
            System.out.println("没走过的地方");
            System.out.println("now");
            System.out.println(now);
            have[now]=1;
            haveCnt++;


            while (have[now]==1){
                now++;
                if(now>=n){
                    now=0;
                }
            }

//            for(int i=0;i<m;i++){
//
////                没走过的地方
//
//                if(have[now]==0){
////                    没走过
//                    now++;
////                    have[no]
//                    if(now>=n){
//                        now=0;
////                        最前面
//                    }
//                    if(have[now]==0){
//
//                    }
//                }else{
////                    haveCnt++;
//
//                }
//
//
//            }
        }
//        return 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int i = solution.lastRemaining(3, 2);
        int i = solution.lastRemaining(7, 3);
        System.out.println(i);
    }
}
