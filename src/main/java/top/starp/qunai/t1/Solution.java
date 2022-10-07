package top.starp.qunai.t1;

//import jdk.internal.vm.annotation.Contended;
//import jdk.nashorn.internal.parser.DateParser;

import java.text.DateFormat;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.*;

//@Contended
public class Solution {

    static class   OneDate{
        int day;
        int month;
        int year;
        OneDate(String dateStr){
            String[] split = dateStr.split("-");
//            year=split[0]
            year= Integer.parseInt(split[0]);
            month= Integer.parseInt(split[1]);
            day = Integer.parseInt(split[2]);
        }

        static int[] monToDay={0,31,28,31,30,31,30,31,
                31,30,31,30,31
        };

        long fromDayZero(){
            long days=0;
            days+=day;
//            days+=year*365;
            days+=(year-1)*365;
            System.out.println("days");
            System.out.println(days);
//            1 1 1
//            1
//            if(month>2){
//                days+=      monToDay[month];
//            }
//            for(int i=1;i<=month;i++){
//            1--- 10
            for(int i=1;i<month;i++){
//                sout
//                System.out.println("add mont");
                days+=      monToDay[i];
            }
            if(isRun(year)&&month>2){
                days++;
            }
            return days;




        }

        public static void main(String[] args) {
//            OneDate oneDate = new OneDate("1-1-1");
//            OneDate oneDate = new OneDate("1-11-1");
//            1 ---30
            OneDate oneDate = new OneDate("1-2-1");
//            System.out.println(oneDate);
            long l = oneDate.fromDayZero();
            System.out.println(l);
        }
    }

    static boolean  isRun(int year){
      return   year%400==0||year%4==0&&year%100!=0;
    }

//    void tes(){
//
//        // write code here
////        DateFormat
////        DateForm
////        DateTimeFormatter()
//        String[] split = checkInDate.split("-");
//        Date date=new Date(checkInDate);
//        Date datecheckOutDate=new Date(checkOutDate);
////       DateUti datecheckOutDate-date
////       Date date1= datecheckOutDate-date;
//        System.out.println("date");
//        System.out.println(date);
////        DateParser dateParser = new DateParser("YYYY-MM-DD");
////        dateParser.parse()
////        DateTimeFormatter()
//
////        Calendar calendar=Calendar.getInstance();
////        calendar.
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
//        TemporalAccessor parse = dateTimeFormatter.parse(checkInDate);
////        parse.get(DateTimeFormatter.)
////        parse.get(DateFormat.Field.DAY_OF_MONTH);
////        parse.get(DayOfWeek)
//////        parse.get(DAY)
////        parse.get(DAY)
////        TemporalField.
////        DateTimeFormatter.
//        return 1;
////        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(checkInDate);
//
//    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param checkInDate string字符串 入住日期
     * @param checkOutDate string字符串 离店日期
     * @return int整型
     */
    public int daysBetweenDates (String checkInDate, String checkOutDate) {

        OneDate oneDate = new OneDate(checkInDate);
        OneDate oneDatecheckOutDate = new OneDate(checkOutDate);
      return (int) (oneDatecheckOutDate.fromDayZero()-  oneDate.fromDayZero());


    }

    public static void main(String[] args) {
        Solution solution=new Solution();
//        "2019-12-31","2020-01-15"
        int i = solution.daysBetweenDates("2019-12-31", "2020-01-15");
//        solution.  daysBetweenDates("2021-1-1","2021-1-1");
        System.out.println(i);

    }
}
