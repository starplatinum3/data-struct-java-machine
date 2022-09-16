package top.starp.sort;

import top.starp.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

//https://blog.csdn.net/shujuelin/article/details/82423852
public class QuickSort {
    public static void quickSort(int[] arr,int low,int high){
//        int finalI = i;
//        int finalJ = j;
//
        class Printer{
            void printArr(int finalI,int finalJ){
                for (int i1 = 0; i1 < arr.length; i1++) {
                    if(i1==low){
                        System.out.print("["+arr[i1]+"]");
                    }else if(i1== finalI){
                        System.out.print("("+arr[i1]+")");
                    }else if(i1== finalJ){
                        System.out.print("<"+arr[i1]+">");
                    }else{
                        System.out.print(arr[i1]);
                    }
                    System.out.print(",");
                }
                System.out.println();
            }
        }

        Printer printer = new Printer();

        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        System.out.println("======");
        System.out.println("基准值");
        System.out.println(temp);
        while (i<j) {
            //先看右边，依次往左递减
//            右边比他大的还要一直往左看 想要小的
//            找到一个比基准值小的 我要把他往前面放
// 2 2 3 4 1 2 6
// 2 2  还是 要找前面的 只有1 是要停止了
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            System.out.println("xxxxxx");
            System.out.println("交换");
            printer.printArr(i,j);
//            ArrayUtil.printMarked(arr,Arrays.asList(i,j));
            //如果满足条件则交换
            // 找到基准的位置 i 是比基准大了的位置了 j 是比基准小了的位置了
            // 大的位置肯定要在右边啊 但是不符合啊 就是要swap 
            // 如果左边还是比右边小的话 应该是不用swap的吧 ，这里是左边比右边大了？
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
//        void printArr(int[] arr){
//
//        }



        printer.printArr(i,j);

        System.out.println("j  "+j);
        System.out.println("i  "+i);
//        ArrayUtil.printMarked(arr, Arrays.asList(i,j));
//        for (int i1 = 0; i1 < arr.length; i1++) {
//            if(i1==low){
//                System.out.print("["+arr[i1]+"]");
//            }else if(i1==i){
//                System.out.print("("+arr[i1]+")");
//            }else if(i1==j){
//                System.out.print("<"+arr[i1]+">");
//            }else{
//                System.out.print(arr[i1]);
//            }
//            System.out.print(",");
//        }
//        System.out.println();

        //最后将基准位与i和j相等位置的数字交换
         arr[low] = arr[i];
//         也是一个交换 swap
         arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }


    public static void main(String[] args){
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        System.out.println(Arrays.toString(arr));
    }
}
