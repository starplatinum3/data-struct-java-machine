package top.starp.weiZhong;

import java.util.Scanner;

public class 努力 {
    static  boolean checkNuli(int idx){
//        persons[idx]==
//        这个人的前面
//        persons[]
//        for (int i = idx; i > ; i++) {
//
//        }
        int lookNow=idx-1;
        for (int i = 0; i <leftCanLook; i++) {
            if(lookNow<0){
                break;
            }
            if (persons[lookNow]<=persons[idx]) {
//                都比他大
//                没有比自己强
                return  false;
            }
            lookNow--;
        }
        int lookNowRight=idx+1;
        for (int i = 0; i <rightCanLook; i++) {
            if(lookNowRight>=num){
                break;
            }
            if (persons[lookNowRight]<=persons[idx]) {
//                都比他大
                return  false;
            }
            lookNowRight++;
        }
        return true;
    }
   static int leftCanLook;
    static int rightCanLook;
    static  int maxN=100007;
    static  int num;
    static  int [] persons=new int[maxN];
    public static void main(String[] args) {
//        int num;
//        int leftCanLook;
//        int rightCanLook;
        Scanner scanner=new Scanner(System.in);
//        scanner.
       num=  scanner.nextInt();
       leftCanLook=  scanner.nextInt();
       rightCanLook=  scanner.nextInt();
        for (int i = 0; i <num ; i++) {
            persons[i]=scanner.nextInt();
        }
//        int [] persons=new int[num];
        int ans=0;
        for (int i = 0; i < num; i++) {
//            persons[i];
//            for (int j = 0; j < ; j++) {
//
//            }
          if (checkNuli(i)) {
              ans=i;
              break;
          }
        }
        System.out.println(ans+1);
    }
}
