package top.starp.netEase.t4;

import java.util.Map;
import java.util.Scanner;

public class Main {

//    int [][]map=new int[][];
    static  Stage[]stages;
    static  int stage=0;
    static  int coin=0;
    static  int blood=0;
    static  int hit=0;
   static int [][]map;
   static boolean [][]vis;
  static   int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};

  void fight(){

  }

static   void tryDeep(int x,int y){
      for (int[] dir: dirs) {
          int nx=dir[0]+x;
          int ny=dir[1]+y;
          if(nx<0||ny<0||nx>=6||ny>=6){
              continue;
          }
          if(vis[nx][ny]){
              continue;
          }
          vis[nx][ny]=true;
          dfs(nx,ny);
      }
  }
    static  void dfs(int x,int y){
//        fori

        Stage stage = stages[Main.stage];
     Block block=   stage.map[x][y];
//        block.type.equals(Block.typeCoin){
//
//        }
        if (Block.typeCoin.equals(block.type)) {
            coin+=block.coin;
        }else if(Block.typeEne.equals(block.type)){
//            blood
            while (true){
                blood-=block.hit;
                block.blood-=hit;
//                20 30
//                每次死之前都可以看值不值得?
                if(blood<=0){
                    tryDeep(x,y);
//                    把他杀死 值得吗 如果杀死 可以去后面的关
                }
            }
        }


        for (int[] dir: dirs) {
            int nx=dir[0]+x;
            int ny=dir[1]+y;
            if(nx<0||ny<0||nx>=6||ny>=6){
                continue;
            }
            if(vis[nx][ny]){
                continue;
            }
            vis[nx][ny]=true;
            dfs(nx,ny);
        }
    }

    static class Block{
        String  type="coin";
     public  final static   String  typeCoin="typeCoin";
        public final   static   String  typeEne="typeEne";

        int coin;
        int blood;
        int hit;
    }

    static  class  Stage{
        Block[][] map;
        Stage(){
            map=new Block[6][6];
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line = scanner.nextLine();
        String[] s = line.split(" ");
        int blood = Integer.parseInt(s[0]);
        int hit = Integer.parseInt(s[1]);
        String lineMon = scanner.nextLine();
        String[] spsMon = lineMon.split(" ");
        int money = Integer.parseInt(spsMon[0]);
        int monst = Integer.parseInt(spsMon[1]);

        for (int i = 0; i <10 ; i++) {
            stages[i]=new Stage();
        }
        for (int i = 0; i <money ; i++) {
            String coinLine = scanner.nextLine();
            String[] coinLineSps = coinLine.split(" ");
            int mapIdx = Integer.parseInt(coinLineSps[0]);
            int x = Integer.parseInt(coinLineSps[1]);
            int y = Integer.parseInt(coinLineSps[2]);
            int coin = Integer.parseInt(coinLineSps[3]);
//            stage
            Block block=   stages[mapIdx].map[x][y];
            block.type=Block.typeCoin;
            block.coin=coin;
//            stages[mapIdx].map[x][y].type=Block.typeCoin;
        }

        for (int i = 0; i <monst ; i++) {
            String coinLine = scanner.nextLine();
            String[] coinLineSps = coinLine.split(" ");
            int mapIdx = Integer.parseInt(coinLineSps[0]);
            int x = Integer.parseInt(coinLineSps[1]);
            int y = Integer.parseInt(coinLineSps[2]);
            int bloodNum = Integer.parseInt(coinLineSps[3]);
            int hitCnt = Integer.parseInt(coinLineSps[4]);
            Block block=   stages[mapIdx].map[x][y];
            block.type=Block.typeEne;
            block.blood=bloodNum;
            block.hit=hitCnt;
        }

        String coinLine = scanner.nextLine();
        String[] coinLineSps = coinLine.split(" ");
        int getMoney = Integer.parseInt(coinLineSps[0]);
        int halfBloodMoney = Integer.parseInt(coinLineSps[1]);

        System.out.println(500);
    }
}
