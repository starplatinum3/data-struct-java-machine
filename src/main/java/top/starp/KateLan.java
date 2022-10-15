package top.starp;

import java.math.BigInteger;

public class KateLan {
    public static void main(String[] args) {
//        1:1
//        2:2
//        3:5
//        4:14
//        5:42
//        6:132
//        7:429
//        8:1430
//        9:4862
//        10:16796
//        11:58786
//        12:208012
//        13:742900
//        14:2674440
//        15:9694845
//        16:35357670
//        17:129644790
//        18:477638700
//        19:1767263190
//        20:6564120420

// 打印前 n 个卡特兰数
        int n = 20;
        BigInteger ans = BigInteger.valueOf(1);
        System.out.println("1:" + ans.toString());
        BigInteger four = BigInteger.valueOf(4);
        BigInteger one = BigInteger.valueOf(1);
        BigInteger two = BigInteger.valueOf(2);
        for (int i = 2; i <= n; i++) {
            BigInteger bi = BigInteger.valueOf(i);
//            (4*i -2)/(i+1)
            ans = ans.multiply(
                    four.multiply(bi).subtract(two)
            ).divide(bi.add(one));
            System.out.println(i + ":" + ans.toString());
        }

    }
}
