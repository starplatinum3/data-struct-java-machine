package top.starp.antBi.t3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChuCao {

    static  class  OneCut{
        int time;
        int x;
        int y;
        int hei;
    }
//    int [] [] hei=new int[][];
    static  int [] [] hei;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int row;
        int col;
        row = scanner.nextInt();
        col = scanner.nextInt();

        hei=new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                hei[i][j]=scanner.nextInt();
            }
        }
        int cutTimes=scanner.nextInt();
        List<OneCut>oneCuts=new ArrayList<>();
        for (int i = 0; i <cutTimes ; i++) {
            OneCut oneCut = new OneCut();
            oneCut.time=scanner.nextInt();
            oneCut.x=scanner.nextInt();
            oneCut.y=scanner.nextInt();
            oneCut.hei =scanner.nextInt();
            oneCuts.add(oneCut);
        }

        System.out.println(100);
    }
}
