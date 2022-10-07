package top.starp.subset;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //放入一个空集合
        result.add(new ArrayList<>());

        //遍历所有数字
        for (int num : nums) {
            //遍历所有小集合
//            System.out.println("=====");
//            System.out.println("num");
//            System.out.println(num);
            int size = result.size();
            for (int i = 0; i < size; i++) {
//            for (int i = 0; i < size; i+=2) {
//            for (int i = 1; i < size; i+=2) {
                //在小集合原先的基础上，再加上当前值，然后保存到大集合里
                List<Integer> allready = result.get(i);
//                System.out.println("allready");
//                System.out.println(allready);
                List<Integer> list = new ArrayList<>(allready);
                if(allready.isEmpty()){
                    list.add(num);
//                [1], [2],
//                 [1 3], [2 3],
                    result.add(list);

                }
              else  if(num>allready.get(allready.size()-1)+1){
                    list.add(num);
//                    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//                [1], [2],
//                 [1 3], [2 3],
                    result.add(list);
                }

            }

//            System.out.println("result");
//            System.out.println(result);
        }
        //     添加前的大集合  多添加的小集合       添加后的大集合
        //第一轮：  []      -> [1]          -> [],[1]
        //第二轮：  [], [1] -> [2], [1,2]   -> [],[1],[2],[1,2]
        //....
        return result;
    }

    public static int simpleCircleFact(int num) {//简单的循环计算的阶乘

        int sum = 1;

        if (num < 0) {//判断传入数是否为负数

            throw new IllegalArgumentException("必须为正整数!");//抛出不合理参数异常

        }

        for (int i = 1; i <= num; i++) {//循环num

            sum *= i;//每循环一次进行乘法运算

        }

        return sum;//返回阶乘的值

    }
    static  int calOne(List<Integer> subset){
        int ji=1;
        for (Integer integer : subset) {
            ji*=integer;
        }
        return ji*ji;
    }
    static  int  calSubsets( List<List<Integer>> subsets){
        int sum=0;
        for (List<Integer> subset : subsets) {
            if(subset.size()==0){
                continue;
            }
            sum+= calOne(subset);

        }
        return sum;
    }

   static int calSubsetsOfN(int n){
//        int n=5;
        int [] nums=new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1]=i;
        }
        List<List<Integer>> subsets = subsets(nums);
        int sum = calSubsets(subsets);
        return sum;
    }

    public static void main(String[] args) {
        int n=5;
        int [] nums=new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1]=i;
        }
        List<List<Integer>> subsets = subsets(nums);
        System.out.println("subsets");
        System.out.println(subsets);

        int sum = calSubsets(subsets);
        int factRes =   simpleCircleFact(n+1)-1;
        System.out.println("factRes");
        System.out.println(factRes);
        System.out.println("sum");
        System.out.println(sum);
//        subsets
//                [[], [1], [2], [3], [1, 3], [4], [1, 4], [2, 4], [5], [1, 5], [2, 5], [3, 5], [1, 3, 5]]
//        factRes
//        719
//        sum
//        719

//        0---10 成立
//        n 为这个 成立
//        都成立 是性质
        System.out.println("查看有没有不成立的 ");
//        for (int i = 0; i <10 ; i++) {
        for (int i = 11; i <1000 ; i++) {
//            List<List<Integer>> subsets = subsets(nums);
//            if (simpleCircleFact(i+1)-1==calSubsetsOfN(i)){
//
//                System.out.println("n 为这个 成立");
//                System.out.println(i);
//            }

            if (simpleCircleFact(i+1)-1!=calSubsetsOfN(i)){

                System.out.println("n 为这个 不成立");
                System.out.println(i);
            }
//            assert  simpleCircleFact(i+1)-1==calSubsetsOfN(i);
        }
        System.out.println("结束");
    }
}
