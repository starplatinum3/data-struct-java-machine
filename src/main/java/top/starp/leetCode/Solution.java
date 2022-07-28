//package top.starp.leetCode;
//
//import java.util.HashMap;
//import java.util.Map;
//
//class Solution {
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
//        while(stringLeng != index )
//        {
//            //取出每个字符串的字符
//            char c = s.charAt(index) ;
//            //字符重复出现
//            if( map.containsKey( c )) {
//                两个相同字符之间的距离
//                mark = Math.max(mark , map.get( c ));
//            }
//            //最长子字符串, "+1"和下一条语句的"++index"是防止字符串s长度为1的情况.
//            maxLength =  Math.max(result , index - mark + 1);
//            //放入键值对
//            map.put(c , ++index);
//        }
//        return result ;
//    }
//}
