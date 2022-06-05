package top.starp.weiZhong;

import java.util.Scanner;

public class 十六进制 {
//    char[] hexSet=new char[]{'0','1',2,3,4,5,6,7,8,9,'A','B','C','D','E','F'};
  static   char[] hexSet=new char[]{'0','1','2','3','4','5'
        ,'6','7','8','9','A','B','C','D','E','F'};
//   15
//    static String hex(int num){
//
//        StringBuilder res= new StringBuilder();
//        while (num>0){
//            int idx=num%16;
//            System.out.println("======");
//            System.out.println("idx");
//            System.out.println(idx);
//            res.append(hexSet[idx]);
//            char hexChar=hexSet[idx];
//            System.out.println("hexChar");
//            System.out.println(hexChar);
//            num/=16;
//        }
//        return res.toString();
//    }
    static String hex(int num){

        String res="";
//        StringBuilder res= new StringBuilder();
        while (num>0){
            int idx=num%16;
//            System.out.println("======");
//            System.out.println("idx");
//            System.out.println(idx);

//            res.append(hexSet[idx]);
            char hexChar=hexSet[idx];
            res=hexChar+res;
//            System.out.println("hexChar");
//            System.out.println(hexChar);
            num/=16;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int num;
//        String.valueOf(num,16)
//        Integer.parseInt(num+"",16);
//        hex()
//        he
        Scanner scanner=new Scanner(System.in);
      num=  scanner.nextInt();
        String hex = hex(num);
//        System.out.println("hex");
//        System.out.println(hex);
        int cnt=0;
        for (int i = 0; i <hex.length() ; i++) {
            char c = hex.charAt(i);
            if(c>='A'&&c<='F'){
                cnt++;
            }
//            if();
        }
        System.out.println(cnt);
    }
}
