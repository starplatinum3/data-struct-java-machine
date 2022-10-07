package top.starp.antBi.t1;

//评测题目:
//Given a 2D matrix M X N, support two operations:

//Query(row1, col1, row2, col2) such that I get the sum of all numbers in the
//rectangle ((row1, col1), (row1, col2), (row2, col1), (row2, col2))

//update(newValue, row, col) to a new number

//package top.starp.ant.t3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  static   int nums[];
  static  int n;
  static void swap(int i,int j){
      int t=nums[i];
      nums[i]=nums[j];
      nums[j]=t;
  }

  static int sushu[];
//  static boolean isSu(int num){
//      for (int i = 2; i <num/2 ; i++) {
//          if(num%i==0){
//              return false;
//          }
//      }
//      return true;
//  }

    static boolean isSu(int num){
        for (int i = 0; i <sushu.length ; i++) {

        }
        for (int i = 2; i <num/2 ; i++) {
            if(num%i==0){
                return false;
            }
        }
        return true;
    }


    static  boolean good(){
//      int idx
      for (int i = 0; i <n ; i++) {
//          if(!isSu(
          if(isSu(
                  nums[i]+i+1
          )){
              return false;
          }
      }
//      nums[idx]+idx;
      return true;
  }

  static  boolean done=false;
  static  void dfs( int start){
      if(done){
          return;
      }
      if(start>=n){
//          System.out.println("nums");
//          System.out.println(Arrays.toString(nums));
//          for (int i = 0; i <n ; i++) {
//              if(!isSu(
//                      nums[i]+i
//              )){
//                  return;
//              }
//          }
          boolean good = good();
          if(good){
//              System.out.println(Arrays.toString(nums));
              for (int i = 0; i < n; i++) {
                  System.out.print(nums[i]+" ");
              }
              done=true;
              return;
          }
          return;
      }
      for (int i = start; i <n ; i++) {
//      for (int i = start+1; i <n ; i++) {
          swap(i,start);
//          dfs(start+1);
          dfs(i+1);
          swap(i,start);
      }
  }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        nums=new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i]=i+1;
        }
        dfs(0);
    }
}
