package top.starp.qunai.t2;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param priceArr int整型一维数组 价格数组
     * @return int整型一维数组
     */
    public int[] quickSort (int[] priceArr) {
        // write code here

        Arrays.sort(priceArr);
        return  priceArr;
    }

    void swap(int [] arr
    ,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

 void  qs(int[ ] arr,int start,int end){
         int par=arr[start];
         int i=start;
         int j=end;
         while (arr[i]<par){
             i++;
         }
        while (arr[j]>par){
            j++;
        }
        swap(arr,i,start);
        swap(arr,j,end);
        arr[start]=par;
        int mid=(start+end)/2;
        qs(arr,start,mid);
        qs(arr,mid,end);
//        System.out.println();
    }
}
