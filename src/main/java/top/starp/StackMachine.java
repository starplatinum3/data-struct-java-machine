package top.starp;
/* Java implementation of a unified-stack abstract machine
   sestoft@itu.dk * 2001-02-05

   In a real stack machine, the stack is an array (not a list as in
   the SML or F# model), and there is a special register called the
   stack pointer sp which is updated as the stack grows and shrinks.
   Accessing a variable x stored n deep into the stack can be done in
   constant time by address arithmetic relative to the stack pointer:
   just access the element stack[sp-n].

   The interpreter seval below is a simple bytecode machine: each
   instruction is a single integer (representable in a byte).
   Instructions with arguments, such as SCST and SVAR, simply take their
   arguments from the next integer in the instruction stream.

   This is a Java program but might be written in C instead; it does
   not rely on object-orientation or garbage collection.
   统一堆栈抽象机的Java实现
sestoft@itu.dk * 2001-02-05
在真正的堆栈计算机中，堆栈是一个数组（而不是中的列表
SML或F#模型），并且有一个称为
堆栈指针sp，随着堆栈的增长和收缩而更新。
访问存储在堆栈中n深处的变量x可以在中完成
相对于堆栈指针的按地址计算的恒定时间：
只需访问元素堆栈[sp-n]。
下面的解释器seval是一个简单的字节码机器：每个
指令是一个整数（可以用字节表示）。
带有参数的指令，如SCST和SVAR，只需
指令流中下一个整数的参数。
这是一个Java程序，但可能用C编写；确实如此
不依赖面向对象或垃圾收集。 */

//import com.sun.org.apache.bcel.internal.generic.SWAP;
import top.starp.util.ArrayUtil;

import java.util.Collections;

class Machine {
    final static int
            SCST = 0, SVAR = 1, SADD = 2, SSUB = 3, SMUL = 4, SPOP = 5, SSWAP = 6;

    public static void main(String[] args) {
//        final int[] rpn1 = {SCST, 17, SVAR, 0, SVAR, 1, SADD, SSWAP, SPOP};
//        System.out.println(seval(rpn1));
//        final int[] rpn2 = {SCST, 17, SCST, 22, SCST, 100, SVAR, 1, SMUL,
//                SSWAP, SPOP, SVAR, 1, SADD, SSWAP, SPOP};
//        System.out.println(seval(rpn2));

//        final int[] rpnAdd = {SCST,2,SCST,3,SVAR,0,SVAR,0,SADD, SSWAP,SPOP,SMUL};
//        final int[] rpnAdd = {SCST,2,SCST,3,SVAR,0,SVAR,1,SADD, SSWAP,SPOP,SMUL};
//        Index -2 out of bounds for length 1000
        final int[] rpnAdd = {SCST,2,SCST,3,SVAR,0,SVAR,0,SADD,SMUL};
//        18

        System.out.println(seval(rpnAdd));
    }

    static int seval(int[] code) {
        int[] stack = new int[1000];    // evaluation and env stack
        int sp = -1;            // pointer to current stack top
        //指向当前堆栈顶部的指针

        int pc = 0;                // program counter
//     程序计数器
        int instr;                // current instruction

        while (pc < code.length)
            switch (instr = code[pc++]) {
                case SCST:
                    stack[sp + 1] = code[pc++];
                    sp++;
                    break;
                case SVAR:
//                    int instrNow = code[pc++];
                    int disToValIdx = code[pc];
//                    距离需要的下标 和现在栈顶的差距
                    System.out.println("=====");
                    ArrayUtil.printMarked(code, Collections.singletonList(pc));
                    pc++;
                    System.out.println(" 距离需要的下标 和现在栈顶的差距 disToValIdx");
                    System.out.println(disToValIdx);
                    int stVal = stack[sp - disToValIdx];
                    System.out.println("打印栈");
                    ArrayUtil.printArr(stack,0,sp);
//                    获得栈里的 idx 下标的值
                    int idx=sp - disToValIdx;
                    System.out.println("sp 栈顶");
                    System.out.println(sp);
                    System.out.println("idx");
                    System.out.println(idx);
                    System.out.println("stVal");
                    System.out.println(stVal);
//	stack[sp+1] = stack[sp-code[pc++]];
                    stack[sp + 1] = stVal;
//                    从栈里拿出一个值 放到
//                    拿到这个值 把他放在栈顶
                    sp++;
                    break;
                // 栈顶-  现在的指令
                case SADD:
//                    Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException:
//                    Index -2 out of bounds for length 1000

                    stack[sp - 1] = stack[sp - 1] + stack[sp];
                    sp--;
                    break;
                case SSUB:
                    stack[sp - 1] = stack[sp - 1] - stack[sp];
                    sp--;
                    break;
                case SMUL:
                    stack[sp - 1] = stack[sp - 1] * stack[sp];
                    sp--;
                    break;
                case SPOP:
                    sp--;
                    break;
                case SSWAP: {
                    int tmp = stack[sp];
                    stack[sp] = stack[sp - 1];
                    stack[sp - 1] = tmp;
                    break;
                }
                default:
                    throw new RuntimeException("Illegal instruction " + instr
                            + " at address " + (pc - 1));
            }
        return stack[sp];
    }
}
