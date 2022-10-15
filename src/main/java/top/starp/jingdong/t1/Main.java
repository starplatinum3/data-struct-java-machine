package top.starp.jingdong.t1;

import java.util.Scanner;

public class Main {

    static boolean isOu(String string){
        int len=string.length();
        if(len%2!=0){
            return false;
        }
        for (int i = 0; i < len; i+=2) {
            if (string.charAt(i)!=string.charAt(i+1)) {
                return false;
            }
        }
//        int cnt=0;
//        char last;
//        last=string.charAt(0);
//        cnt++;
//        for (int i = 1; i < string.length(); i++) {
//            if(last==string.charAt(i)){
//                cnt++;
//                if(cnt>2){
//                    return false;
//                }
//                cnt=0;
//            }
//        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line = scanner.nextLine();
        int len=line.length();
//        boolean dp [][]=new boolean[len][len];
        int max=0;
        for (int i = 0; i <line.length() ; i++) {
//            dp[]
            for (int j = i+1; j <len ; j++) {
                String substring = line.substring(i, j);
//                aa  b b cc ...aba aa bb cc dd


                boolean ou = isOu(substring);
                if(ou){
//                    int oneLen=j-i+1;
                    int oneLen=j-i;
//                    System.out.println("substring");
//                    System.out.println(substring);
                    max=Math.max(max,oneLen);
                }
            }
        }
//        aebbccdaa
//        9
        System.out.println(max);
    }
}
