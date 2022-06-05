package top.starp.weiZhong.前缀序列;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wanna
 * @version v1.0
 * @Package com.wanna.main32
 * @date 2021/9/24 9:50 上午
 */
public class Main {

    /*
     @微众银行
     题目描述：
     已知一个长度为n的序列A。我们求出了它的前缀序列，但是却不小心把它的原序列丢失了，
     请你从它的前缀序列中推出它的原序列，并输出出来。

     这里的前缀序列B定义为，B[i]为所有下标小于等于i中的元素中，
     所有奇数位置的和减去所有偶数位置的和。A序列和B序列的下标均从1开始。

     输入描述
     输入第一行仅包含一个正整数n，表示序列的长度。(1<=n<=10000)
     输入第二行包含n个整数，空格隔开，表示一个前缀序列，所有整数的绝对值都小于等于10^9。

     输出描述
     输出仅包含一行，包含n个整数，表示原序列，中间用空格隔开。
     */
//    文档：1 2    3          4 5  6.note
//    链接：http://note.youdao.com/noteshare?id=01936f9148f60bdfd1466dd80aaa9057&sub=1F10FF5C65A2494EA6017055F832CC71
//    1 2 3 4 5  6
//       1-2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] list = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = scanner.nextInt();
        }
        process(list, N);
    }

    public static void process(int[] list, int N) {  //AC 100%
        int[] old = new int[N + 1];
        for (int i = 1; i <= N; i++) {
//            不是偶数 是奇数 奇数的话 就是1
            int sign = i % 2 != 0 ? 1 : -1;
            old[i] = (list[i] - list[i - 1]) * sign;
        }
        Arrays.stream(old, 1, N + 1)
                .mapToObj(String::valueOf)
//                .reduce(((left, right) -> left + " " + right))
                .reduce((left, right) -> left + " " + right)
                .ifPresent(System.out::println);
    }
}
