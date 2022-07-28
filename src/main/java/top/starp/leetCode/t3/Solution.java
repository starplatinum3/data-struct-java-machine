package top.starp.leetCode.t3;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int maxLength = 0,currentLength = 0;
        int start = 0,end = 0;
        while(end < s.length()){
            char tmpChar = s.charAt(end);
            //窗口滑动
            System.out.println("=====");
            System.out.println("窗口滑动");
            System.out.println("start "+start);
            System.out.println("end "+end);
            for(int i = start; i < end; i++){
                if(tmpChar == s.charAt(i)){
                    System.out.println("---------");
                    System.out.println("字符开始 i  "+i);
                    System.out.println("tmpChar");
                    System.out.println(tmpChar);
                    start = i + 1;
                    System.out.println("start");
                    System.out.println(start);
                    break;
                }
            }
            //计算当前窗口的长度
            currentLength = end - start + 1;
            System.out.println("计算当前窗口的长度");
            System.out.println(currentLength);
            //获得目前为止的最大长度
            maxLength = Math.max(currentLength,maxLength);
            end++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution =
                new Solution();
        int abcdaf = solution.lengthOfLongestSubstring("abcdaf");
        System.out.println("abcdaf");
        System.out.println(abcdaf);
    }

//
//    public int lengthOfLongestSubstring(String s) {
//        //返回值,最长子字符串
//        int result = 0 ;
//        //索引号
//        int index = 0 ;
//        //记录键值对
//        Map<Character , Integer> map = new HashMap();
//        //两个相同字符之间的距离
//        int mark = 0 ;
//        //字符串的长度
//        int stringLeng = s.length();
//        //遍历字符串
//        int maxLength=0;
//        while(stringLeng != index )
//        {
//            //取出每个字符串的字符
//            char c = s.charAt(index) ;
//            //字符重复出现
//            if( map.containsKey( c )) {
////                两个相同字符之间的距离
//                mark = Math.max(mark , map.get( c ));
//            }
//            //最长子字符串, "+1"和下一条语句的"++index"是防止字符串s长度为1的情况.
//            maxLength =  Math.max(result , index - mark + 1);
//            //放入键值对
//            map.put(c , ++index);
//        }
//        return result ;
//    }
}
