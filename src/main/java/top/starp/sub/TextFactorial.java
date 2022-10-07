package top.starp.sub;

public class TextFactorial {//操作计算阶乘的类

    public static int simpleCircle(int num) {//简单的循环计算的阶乘

        int sum = 1;

        if (num < 0) {//判断传入数是否为负数

            throw new IllegalArgumentException("必须为正整数!");//抛出不合理参数异常

        }

        for (int i = 1; i <= num; i++) {//循环num

            sum *= i;//每循环一次进行乘法运算

        }

        return sum;//返回阶乘的值

    }
}
//————————————————
//版权声明：本文为CSDN博主「La victoria」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/yue_2018/article/details/85227848
