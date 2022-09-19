package top.starp.netEase.t1;

import java.util.Scanner;

public class Main {

    static String last5(String string){
     return    string.substring(
                string.length()-5,
                string.length()
        );
    }
   static void lenMaxDiffTest(){
//        int ab6868 = Main.lenMaxDiff("B6868", "88688");
//        int ab6868 = Main.lenMaxDiff("86888", "88688");
        int ab6868 = Main.lenMaxDiff("86888", "86888");
        System.out.println(ab6868);
    }
//    void tes
    static int lenMaxDiff(String str1,String str2){
//        if(str1.equals(str2)){
//            return str1.length();
//        }
        int len=0;
        int maxLen=0;

        for (int i = 0; i <str1.length() ; i++) {
            for (int j = i+1;
                 j <= str1.length(); j++) {
                String substring = str1.substring(i, j);
//                int lenOne=j-i;
//                int lenOne=j-i+1;
                int lenOne=j-i;
                if(substring.length()==5){
//                    System.out.println("---");
//                    System.out.println("substring");
//                    System.out.println("有是5长度的 ");
                }

//                System.out.println(substring);
                for (int k = 0; k < str2.length()&&
                        k + lenOne<=str2.length(); k++) {
//                    if()

//                        if(k + lenOne>=str2.length()){
//                            break;
//                        }
                    String substring1 = str2.substring(k, k + lenOne);
//                    String substring1 = str2.substring(k, k + lenOne+1);
                    if(substring.equals(substring1)){
//                        System.out.println("=======");
//                        System.out.println("substring");
//                        System.out.println(substring);
//                        System.out.println("substring1");
//                        System.out.println(substring1);
                        maxLen=Math.max(maxLen,lenOne);
                    }
                }
            }
//            char c = str1.charAt(i);
//            if(c== str2.charAt(i)){
//                len++;
//            }else{
//                len=0;
//            }
//            maxLen=Math.max(maxLen,len);
        }
        return maxLen;
    }

    static int lenMax(String str1,String str2){
        int len=0;
        int maxLen=0;
        for (int i = 0; i <str1.length() ; i++) {
            char c = str1.charAt(i);
            if(c== str2.charAt(i)){
                len++;
            }else{
                len=0;
            }
            maxLen=Math.max(maxLen,len);
        }
        return maxLen;
    }

    static   String area(String string){
        String area = string.substring(1,
                string.length() - 5
        );


//        System.out.println("area");
//        System.out.println(area);
        return   area;
    }

   static int cmp(String right,String guess){
        int score=0;
//       System.out.println("=========");
//       System.out.println("right");
//       System.out.println(right);
//       System.out.println("guess");
//       System.out.println(guess);
        if(right.charAt(0)==guess.charAt(0)){
            score+=2;
        }
//        right.length()-5
//        right.substring()
//       System.out.println("======");
        String rightLast5 = last5(right);
       String last5Guess = last5(guess);

//
//       System.out.println("rightLast5");
//       System.out.println(rightLast5);

//       System.out.println("last5Guess");
//       System.out.println(last5Guess);
//       int maxLenEnd = lenMax(rightLast5, last5Guess);
       int maxLenEnd = lenMaxDiff(rightLast5, last5Guess);
//       System.out.println("maxLenEnd");
//       System.out.println(maxLenEnd);
        score+=maxLenEnd;
        if (area(right).equals(area(guess))) {
//            score+=2;
            score+=3;
        }
        return score;
    }

static     double baifei(String right,String guess){
//       return cmp(right,guess)*1.0/10;
//       return cmp(right,guess)*1.0*10;
    return  Math.round(
            cmp(right,guess)
    )
            *10;
//       return cmp(right,guess)*1.0*10;
    }


    static  void mainDo(){


        //5
        //YZHEA163N8 YZHEA163NB
        //GHUCNE163 GHUCNE163
        //OJINGA88688 BJINGAB6868
        //GMINGA366A BMING886A3
        //BJIN1A66686 BJIN2A66666
//        int cmp = cmp("YZHEA163N8", "YZHEA163NB");
//        double baifei = baifei("YZHEA163N8", "YZHEA163NB");
//        System.out.println(baifei);

        Scanner scanner=new Scanner(System.in);
//        int num = scanner.nextInt();
        double sum=0;
        String line1 = scanner.nextLine();
        int num = Integer.parseInt(line1);
        for (int i = 0; i <num ; i++) {
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] sps = line.split(" ");
//                sum+=baifei(sps[0],sps[1]);
//            }

            String line = scanner.nextLine();
            String[] sps = line.split(" ");
            double baif= baifei(sps[0],sps[1]);
//            System.out.println("baif");
//            System.out.println(baif);
            sum+=baif;
        }
//        System.out.printf("%02f%%",sum/num);
//        System.out.printf("%2f%%",sum/num);
        System.out.printf("%.2f%%",sum/num);
//        System.out.println(sum/num);
    }

    public static void main(String[] args) {

//        lenMaxDiffTest();

        mainDo();

    }
//    ac
}
