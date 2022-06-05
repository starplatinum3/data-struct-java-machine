package top.starp.util;

import java.util.List;

public class ArrayUtil {
   public  static   void printMarked(int[] arr, List<Integer> markIdxes){
       for (int i = 0; i < arr.length; i++) {
           if(markIdxes.contains(i)){
               System.out.print("("+arr[i]+"),");
           }else{
               System.out.print(arr[i]+",");
           }
       }
       System.out.println();
    }

    public  static   void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+",");

        }
        System.out.println();
    }

    public  static   void printArr(int[] arr,int start,int end){
        for (int i = start; i < end; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }
}
