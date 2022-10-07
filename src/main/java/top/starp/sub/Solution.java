package top.starp.sub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        builderSubSet(nums,rs);
        rs.add(new ArrayList<Integer>());//最后添加一个空集
        return rs;
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

    public static void main(String[] args) {
        int n=5;
        int [] nums=new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1]=i;
        }
        List<List<Integer>> subsets = subsets(nums);
//        System.out.println("subsets");
//        System.out.println(subsets);

        int simpleCircleFact = simpleCircleFact(n);
        System.out.println("simpleCircleFact");
        System.out.println(simpleCircleFact);
//        simpleCircleFact
//        120
//        不包括 相邻的 子集

        int factRes =   simpleCircleFact(n+1)-1;

    }

    //求数组nums的所有非空子集，存于rs中
    public  static  void builderSubSet(int[] nums,List<List<Integer>> rs){
        //递归终结条件，只有一个元素，它的非空子集就是自己，直接添加到rs
        if(nums.length == 1){
            rs.add(Arrays.asList(nums[0]));
        }else if(nums.length>1){
        	//递归求解前n-1个元素的非空子集
            builderSubSet(Arrays.copyOf(nums,nums.length-1),rs);
            //前n-1个元素的非空子集求解完毕，处理第n个元素
            int size = rs.size();//获取当前子集的个数
            //将第n个子集也添加到rs
            rs.add(Arrays.asList(nums[nums.length-1]));
            //依次复制出当前子集，并为每一子集添加第n个元素，
            //之后再将这些子集添加到rs中
            List<Integer> clone;
            for(int i = 0;i<size;i++){
                clone = new ArrayList<>();
                for(Integer it : rs.get(i)){
                    clone.add(it);
                }
                clone.add(nums[nums.length-1]);
                rs.add(clone);
            }
        }
    }
}
