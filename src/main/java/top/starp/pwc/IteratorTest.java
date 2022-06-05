package top.starp.pwc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
//    https://www.runoob.com/java/java-iterator.html
    public static void main(String[] args) {
        List<Integer>list=new ArrayList<>();
        Iterator<Integer> iterator = list.iterator();
//        iterator.next();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
        }
    }
}
