package top.starp.antBi.t2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {


    static  int [] nums;
    public static void main(String[] args) {
        Solution solution=new Solution();

        Scanner scanner=new Scanner(System.in);
        int cnt = scanner.nextInt();
        int canAdd=scanner.nextInt();
        nums=new int[cnt];
        for (int i = 0; i < cnt; i++) {
            nums[i]=scanner.nextInt();
//            nums[i]-=nums[0];
//            System.out.println("nums[i]");
//            System.out.println(nums[i]);
        }
        System.out.println("nums");
        System.out.println(Arrays.toString(nums));
        int num0=nums[0];
//        [2, 3, 1, 3, 4]   2+2
//        2, 3, 1, 3, 4 ,3 ...
//1 2 3 4 4 5 6 6 7 7 8 8 8 9 9
//  cntOf[4+ addNum]
// cnt of 4 ==2 , add Cnt +1
//        cntOf[4+ addNum] ==2  , add Cnt +2
//         cntOf[4+ addNum +addNum] ==3 , add Cnt +2 , addCnt+= 1+2 ...2 , n+1)*n/2 ,n=2
        for (int i = 0; i < cnt; i++) {
//            nums[i]-=nums[0];
            nums[i]-=num0;
        }
//        一样的 本来就是   如果 2+2==4
        System.out.println("nums");
        System.out.println(Arrays.toString(nums));


    }
}
