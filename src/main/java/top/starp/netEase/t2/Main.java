package top.starp.netEase.t2;

import java.util.*;

public class Main {

 static    class  Depen{
        List<Integer>ids;
        void makeIds( int depenCnt ,String[] sps){
            ids=new ArrayList<>();
            if(depenCnt==0){
              return;
            }
            for (int i = 1; i <sps.length ; i++) {

                int id = Integer.parseInt(sps[i]);
                ids.add(id);
            }
        }
    }

  static   void onMeShow(int [] onMe,Set<Integer> haveLoad){
      System.out.print("[");
        for (Integer srcId : haveLoad) {
            System.out.print(onMe[srcId]+", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner
                scanner;
        scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] s = line.split(" ");
//        s[0]
        int srcCnt = Integer.parseInt(s[0]);
        int opCnt = Integer.parseInt(s[1]);
//        10k
//        1k
        int [] onMe=new int[srcCnt];
        Depen[] depensMap=new Depen[srcCnt];
        Set<Integer> haveLoad=new HashSet<>();
        for (int i = 0; i <srcCnt ; i++) {
            String lienSrc = scanner.nextLine();
            String[] s1 = lienSrc.split(" ");
            int depenCnt = Integer.parseInt(s1[0]);
//            2 1 5
//            0 -> 1 5
            Depen depen = new Depen();
            depen.makeIds(depenCnt,s1);
            depensMap[i]=depen;

        }

        int onNum=0;

        int maxOnNum=0;
        for (int i = 0; i <opCnt ; i++) {
            String lienSrc = scanner.nextLine();
            String[] s1 = lienSrc.split(" ");
            int op = Integer.parseInt(s1[0]);
            int srcId = Integer.parseInt(s1[1]);
            Depen depen = depensMap[srcId];

            System.out.println("======");
            System.out.println("我这个资源");
            System.out.println(srcId);
            System.out.println("我有需要依赖的资源 ");
            System.out.println(depen.ids);
//            haveLoad.add(srcId);

            if(op==0) {

                onMe[srcId]--;
                for (Integer id : depen.ids) {
                    onMe[id]--;
//                    如果依赖的依赖 本来不用了 但是因为依赖需要启动 所以也要启动呢。。
//                    if(onMe[id]==0){
//                        haveLoad.remove(id);
//                        System.out.println("haveLoad");
//                        System.out.println(haveLoad);
//                        onMeShow(onMe,haveLoad);
//                    }
                }
            }else{
                for (Integer id : depen.ids) {
                    onMe[id]++;
                    haveLoad.add(id);
                }
                onMe[srcId]++;
                haveLoad.add(srcId);
            }


            if(op==0) {

                onMe[srcId]--;
//                end

                System.out.println("被依赖的资源是否可以逃脱");
//                depe =    map[srcId];
                System.out.println( depen.ids);
                for (Integer id : depen.ids) {
//                    他需要的依赖 的id
//                    他的依赖 减少一个依赖
                    onMe[id]--;
//                    System.out.println("我被依赖的减少了 ");
//                    System.out.println("id");
//                    System.out.println(id);
//                    haveLoad.add(id);
                    if(onMe[id]==0){
//                    no src
//                        System.out.println("逃脱");
//                        System.out.println("id");
//                        System.out.println(id);

//                        onNum--;
//                        System.out.println("onNum");
//                        System.out.println(onNum);
//                        拜托了
//                        摆脱
                        haveLoad.remove(id);
                        System.out.println("haveLoad");
                        System.out.println(haveLoad);
                        onMeShow(onMe,haveLoad);
                    }
                }
//                for (depen) {
//                 dep--
//            }

            }else{
                haveLoad.add(srcId);
//                加载
//                haveLoad.add()
                for (Integer id : depen.ids) {
//                    他需要的依赖 的id
//                    他的依赖 减少一个依赖
                    onMe[id]++;
//                    System.out.println("我身上多了一个依赖");
//                    System.out.println("id 资源名字");
//                    System.out.println(id);

                    if (haveLoad.contains(id) ){
//                        onNum not need add
                    }else{
                        System.out.println("我没有被加载 所以我是新的加载的 所以会增加");
                        System.out.println("id 资源名字");
                        System.out.println(id);
                        haveLoad.add(id);
                        System.out.println("haveLoad");
                        System.out.println(haveLoad);
                        onMeShow(onMe,haveLoad);
                        onNum++;

//                        System.out.println("onNum 新的个数");
//                        System.out.println(onNum);
//                        onNum
//                        maxOnNum=Math.max(maxOnNum,onNum);
                        maxOnNum=Math.max(maxOnNum,haveLoad.size());
                    }
//                    onMe[id]--;
//                    if(onMe[id]==0){
////                    no src
//                        onNum--;
//                    }
                }

//                for(depneSrcId){
////                    a -> aDep ++
////                    b-> aDep ++
//                    dep[depneSrcId]++;
////                    他依赖的东西 会增加
////                    如果他依赖的已经加载了 就不会加上
////                    set contains
//                    if (depneSrcId have ){
////                        onNum not need add
//                    }else{
//                        onNum++;
////                        onNum
//                        maxOnNum=Math.max(maxOnNum,onNum);
//                    }
//
//                }
            }

        }

        System.out.println("maxOnNum");
        System.out.println(maxOnNum);
    }
}
