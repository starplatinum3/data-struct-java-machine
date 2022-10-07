package top.starp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fact {

    static Set<List<Integer>>set=new HashSet<>();
    static void dfs(List<Integer>nowSet,int now,int n){
//        set
        for (int i = now; i <=n ; i++) {
            nowSet.add(i);
            dfs(nowSet,i,n);
            nowSet.remove(nowSet.size()-1);
        }
    }
    public static void main(String[] args) {

    }
}
