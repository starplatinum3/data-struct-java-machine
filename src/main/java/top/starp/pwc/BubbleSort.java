package top.starp.pwc;

import top.starp.util.ArrayUtil;

public class BubbleSort {
  static   void bubbleSort(int [ ]arr){
        for (int i = 0; i < arr.length-1; i++) {
//            System.out.println(a);
//            PrintUt
            ArrayUtil.printArr(arr);
            for (int j = 0; j <arr.length-i-1 ; j++) {
//                if(arr[i]>arr[i+1]){
//                    int temp=arr[i];
//                    arr[i]=arr[i+1];
//                    arr[i+1]=temp;
//                }

                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int []arr=new int[]{3,4,2,1,5,6,7,8};
//        3,4,2,1,5,6,7,8
//        3 4
//          2 4
//           1  4
//        3,2,1,4,5,6,7,8,
        bubbleSort(arr);
    }
}
