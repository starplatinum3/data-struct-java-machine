package top.starp.sort;

import java.util.Arrays;

//https://blog.csdn.net/shujuelin/article/details/82423852
public class QuickSortRecite {

    // 快速排序
   static void quickSort(int [] arr,int low,int high){
       if(low>high){
           return;
       }
        int tmp=arr[low];
        int i=low;
        int j=high;
        while (i<j){

            while (i<j&&arr[j]>=tmp){
                j--;
            }
            while (i<j&&arr[i]<=tmp){
                i++;
            }

//            想要找的是j 的比i 的小
            if(i<j){
                int tt=arr[i];
                arr[i]=arr[j];
                arr[j]=tt;

            }
        }

        arr[low]=arr[i];
        arr[i]=tmp;
        quickSort(arr,low,j-1);
        quickSort(arr,j+1,high);


    }

    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        System.out.println(Arrays.toString(arr));
    }

}
