package top.starp.minSheng.week;

import java.util.Scanner;

public class Main {
    public static char[] putLine(String line) {
        char[] lineArr = new char[line.length() + 1];
        for (int i = 0; i < line.length(); i++) {
            lineArr[i] = line.charAt(i);
        }
        return lineArr;
    }

   static int row;

//    public static char getOne(int row, int col, int move) {
    public static char getOne( int col, int move) {
        int newCol = col + move;
//        System.out.println("=======");
//        System.out.println();
//        System.out.println("row");
//        System.out.println(row);
//        System.out.println("col");
//        System.out.println(col);
//        System.out.println("move");
//        System.out.println(move);


        if (col + move > rowLen) {
            newCol = col + move - rowLen;
            row=row+1;
        }

        char res=   mat[row][newCol];
        row++;
//        System.out.println("newCol");
//        System.out.println(newCol);

        return mat[row][newCol];
    }

    static int rowLen;
    static int maxN = 9999;

    static int moveIdx = 0;
    static String lastLine;

    static int getMove() {
        char c = lastLine.charAt(moveIdx);
//        Integer.parseInt(c);
//        char 转为
        moveIdx++;
        return c - '0';
    }

    static char[][] mat = new char[maxN][maxN];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int week;
//        week = scanner.nextInt();
        String weekStr = scanner.nextLine();
        week = Integer.parseInt(weekStr);
//        char [][]mat=new char[maxN][maxN];
        int rowNum = 0;
//        String lastLine;
        boolean first = true;
        int lineCnt = -1;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char[] chars = putLine(line);
            if (first) {
                rowLen = line.length();
                first = false;
            }
            lineCnt++;

            mat[rowNum++] = chars;
            if (Character.isDigit(line.charAt(0))) {
//                最后一行
                lastLine = line;
                break;
            }
        }
//        lastLine.charAt()

//        int moveIdx=0;
//        lastLine.charAt(moveIdx);
//        row++
        for (int row = week-1; row < lineCnt; ) {
//            char one = getOne(row, row, getMove());
            char one = getOne(row, getMove());
            System.out.println(one);
        }

    }
}
