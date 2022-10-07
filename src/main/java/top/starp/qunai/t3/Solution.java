package top.starp.qunai.t3;

//import org.graalvm.compiler.serviceprovider.ServiceProvider;

import java.util.*;


public class Solution {

    static void printStr(String string,int idx){
        for (int i = 0; i <string.length() ; i++) {
//            char
            char c = string.charAt(i);
//            if()
            if(i==idx){
//                System.out.print("("+c+"), ");
//                System.out.print("("+c+")");
                System.out.print("&"+c+"&");
            }else{
//                System.out.print(c+", ");
                System.out.print(c);
            }
        }
        System.out.println();
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param content string字符串 文本内容
     * @return bool布尔型
     */
    public boolean matchBracket (String content) {
//        @ServiceProvider()
        // write code here
        Stack<Character>stack=new Stack<>();
        for (int i = 0; i <content.length() ; i++) {
//            12 2 1
            char ch = content.charAt(i);
            if(ch=='<'||ch=='《'||ch=='('||ch=='['||ch=='{'){
                stack.push(content.charAt(i));
            }else if(ch=='>'||ch=='》'||ch==')'||ch==']'||ch=='}'){
//                System.out.println("i");
//                System.out.println(i);
//                System.out.println("ch");
//                System.out.println(ch);


//                System.out.println("-------------");
//                System.out.println("stack");
//                System.out.println(stack);
//                printStr(content,i);
                if(stack.empty()){
//                    System.out.println("当他是空的时候 ");
//                    printStr(content,i);
//                    System.out.println("stack");
//                    System.out.println(stack);
                    return false;
                }
//                Character pop = stack.pop();
                Character pop = stack.peek();

                if(ch=='>'){
                    if(pop!='<'){
                        return false;
                    }
//                    java.
                    stack.pop();
                }

                if(ch=='》'){
                    if(pop!='《'){
                        return false;
                    }
//                    java.
                    stack.pop();
                }

                if(ch==')'){
                    if(pop!='('){
                        return false;
                    }
//                    java.
                    stack.pop();
                }

                if(ch==']'){
                    if(pop!='['){
                        return false;
                    }
//                    java.
                    stack.pop();
                }

                if(ch=='}'){
                    if(pop!='{'){
                        return false;
                    }
//                    java.
                    stack.pop();
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();

        boolean b = solution.matchBracket("\"<《航空旅客出示COVID-19疫苗接种证明的要求》[{https://www.cdc.gov/coronavirus}]>\"");
        System.out.println(b);

    }
}
