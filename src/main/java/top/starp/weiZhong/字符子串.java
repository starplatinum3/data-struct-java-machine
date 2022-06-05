package top.starp.weiZhong;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 字符子串 {
    static boolean isK(String string, char ch, int needCnt) {
        int cnt = 0;
        for (int i = 0; i < string.length(); i++) {
            if (ch == string.charAt(i)) {
                cnt++;
            }
        }
        return needCnt == cnt;
    }
//abcaa
//    i==j -> j++
//   if chCnt>needCnt i++
//    if chCnt==needCnt cnt++ i++

    static void  printStr(String string, List<Integer>indexes){
        for (int i = 0; i <string.length() ; i++) {
            if(indexes.contains(i)){
                System.out.print("("+string.charAt(i)+")");
            }else{
                System.out.print(string.charAt(i));
            }
        }
        System.out.println();
    }
    static int solve(String string, char needCh, int num) {
        int i = 0;
        int j = 1;
        int cnt = 0;
        int chCnt = 0;
        while (true) {
//            if (i >= j) {
////            if (i > j) {
//                break;
//            }
            System.out.println("=========");
            System.out.println("i"+i);
            System.out.println("j"+j);
            printStr(string, Arrays.asList(i,j));
            if(j>= string.length()){
                break;
            }
//            v
//            (b)(a)b
//            少了 bab
            if(string.charAt(j)==needCh){
                chCnt++;
            }
//            ij
//            if(string.charAt(i)==needCh){
////                1231
//            }
            if(i==j){
                j++;
            }else{
                if(chCnt>num){
                    if(string.charAt(i)==needCh){
//                1231
                        chCnt--;
                    }

                    i++;
                }
                else if(chCnt==num){
                    cnt++;
                    if(string.charAt(i)==needCh){
//                1231
                        chCnt--;
                    }
                    i++;
                }
            }





//            System.out.println("//////");
//            System.out.println("i"+i);
//            System.out.println("j"+j);
//            if (j < string.length()) {
//                String sub = string.substring(i, j);
//                System.out.println("=======");
//                System.out.println("sub");
//                System.out.println(sub);
//
//                char rightChar = string.charAt(j);
//                System.out.println(".......");
//                System.out.println("right point ");
//                System.out.println("j");
//                System.out.println(j);
//                if (rightChar == needCh) {
//                    chCnt++;
////                    最右边是 这个东西 那么现在左边来点
//                    if (chCnt == num) {
//                        while (i < j) {
//                            char chI = string.charAt(i);
//                            System.out.println("i");
//                            System.out.println(i);
//                            System.out.println("j");
//                            System.out.println(j);
//                            if (chI != needCh) {
//                                cnt++;
//                            } else {
//                                chCnt--;
//                                break;
//                            }
//                            i++;
//                        }
//                    }
//                }
////                else{
////                    j++;
////                }
////                j++;
//
////                if (isK(sub, ch, num)) {
////                    cnt++;
////                    j++;
////                } else {
//////                i++;
////                    j++;
////                }
////                if (chCnt > num) {
////                    i++;
////                    chCnt--;
////                }
//            }
//            else{
//                i++;
//            }
//
//            j++;
//            else {
//                i++;
//            }


        }
        return cnt;
    }
    static int solve2(String string, char needCh, int num) {
        int i = 0;
        int j = 1;
        int cnt = 0;
        int chCnt = 0;
        while (true) {
            if (i >= j) {
//            if (i > j) {
                break;
            }


            System.out.println("//////");
            System.out.println("i"+i);
            System.out.println("j"+j);
            if (j < string.length()) {
                String sub = string.substring(i, j);
                System.out.println("=======");
                System.out.println("sub");
                System.out.println(sub);

                char rightChar = string.charAt(j);
                System.out.println(".......");
                System.out.println("right point ");
                System.out.println("j");
                System.out.println(j);
                if (rightChar == needCh) {
                    chCnt++;
//                    最右边是 这个东西 那么现在左边来点
                    if (chCnt == num) {
                        while (i < j) {
                            char chI = string.charAt(i);
                            System.out.println("i");
                            System.out.println(i);
                            System.out.println("j");
                            System.out.println(j);
                            if (chI != needCh) {
                                cnt++;
                            } else {
                                chCnt--;
                                break;
                            }
                            i++;
                        }
                    }
                }
//                else{
//                    j++;
//                }
//                j++;

//                if (isK(sub, ch, num)) {
//                    cnt++;
//                    j++;
//                } else {
////                i++;
//                    j++;
//                }
//                if (chCnt > num) {
//                    i++;
//                    chCnt--;
//                }
            }
            else{
                i++;
            }

            j++;
//            else {
//                i++;
//            }


        }
        return cnt;
    }

    public static void main(String[] args) {
        int len, num;
        char ch;
        String string;
        Scanner scanner = new Scanner(System.in);
//        len=   scanner.nextInt();
//        num=scanner.nextInt();
//        ch=scanner.next();
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        len = Integer.parseInt(s1[0]);
        num = Integer.parseInt(s1[1]);
//        num = Character.parse(s1[2]);
//        ch=(char)s1[2];
        ch = s1[2].charAt(0);
        string = scanner.nextLine();
//        s1[0]
//
//        int cnt = 0;
//        for (int i = 0; i < len; i++) {
//            for (int j = i+1 ; j <= len; j++) {
//                String sub = string.substring(i, j);
////                System.out.println("===========");
////                System.out.println("sub");
////                System.out.println(sub);
//                if (isK(sub, ch, num)) {
////                    System.out.println("is k ===");
////                    System.out.println("sub");
////                    System.out.println(sub);
//                    cnt++;
//                }
//            }
//        }

        int cnt = solve(string, ch, num);
        System.out.println(cnt);
    }
}
