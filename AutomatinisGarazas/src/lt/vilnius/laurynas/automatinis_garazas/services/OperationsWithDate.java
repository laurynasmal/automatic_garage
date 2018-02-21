package lt.vilnius.laurynas.automatinis_garazas.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OperationsWithDate {

    static SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat("yyyy/M/dd/H/mm");

    public static Date stringToDate (String stringTypeDate){
        try {
            return simpleDateFormat.parse(stringTypeDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String addOneMonth(Date time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.MONTH, 1);
        String reportDate = simpleDateFormat.format(calendar.getTime());
        return reportDate;
    }

    public static String addOneDay(Date time){
//        time.setDate(time.getDate() + 1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.DATE, 1);
        String reportDate = simpleDateFormat.format(calendar.getTime());
        return reportDate;
    }
    public static String addOneHour(Date time){
        //time.setHours(time.getHours() + 1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        String reportDate = simpleDateFormat.format(calendar.getTime());
        return reportDate;
    }

    public static boolean canYouEnter(String payedTill){
        Date now = new Date();
        Date tempDate = stringToDate(payedTill);
        return now.compareTo(tempDate)>=0;

    }

    public static String returnActualTime() {
        Date now = new Date();
        String reportDate = simpleDateFormat.format(now);
        return reportDate;
    }
}
