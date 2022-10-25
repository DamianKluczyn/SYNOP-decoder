package pl.damiankluczynski.userData;
import pl.damiankluczynski.date.Date;

import java.util.ArrayList;


public class UserDataProvider implements IUserDataProvider {
    private Date beginDate;
    private Date endDate;
    public UserDataProvider(){
        beginDate = new Date();
        endDate = new Date();
        try {
            if(beginDate.getYear()>endDate.getYear()){
                throw new Exception();
            } else if(beginDate.getYear() == endDate.getYear()){
                if(beginDate.getMonth() > endDate.getMonth()){
                    throw new Exception();
                } else if (beginDate.getMonth() == endDate.getMonth()) {
                    if (beginDate.getDay() > endDate.getDay()){
                        throw new Exception();
                    } else if (beginDate.getHour() == endDate.getHour()) {
                        if(beginDate.getMinute() > beginDate.getMinute()) {
                            throw new Exception();
                        }
                    }
                }
            }
        }
        catch(Exception exception){
            System.out.println("Przedzial dat podany nieprawidlowo, daty zostana zamienione.");
            Date tmpDate = endDate;
            endDate = beginDate;
            beginDate = tmpDate;
        }
    }

    @Override
    public void initialize(){
        System.out.println("PODAJ ZAKRES DAT");
        beginDate.initialize("Data początkowa");
        endDate.initialize("Data końcowa");
    }

    @Override
    public ArrayList<String> prepareDate(){
        ArrayList<String> listOfDate = new ArrayList<String>();

        String tmpBeginDate = "";
        tmpBeginDate += Integer.toString(beginDate.getYear());
        int tmpMonth = beginDate.getMonth();
        tmpBeginDate += String.format("%02d", tmpMonth);
        int tmpDay = beginDate.getDay();
        tmpBeginDate += String.format("%02d", tmpDay);
        int tmpHour = beginDate.getHour();
        tmpBeginDate += String.format("%02d", tmpHour);
        int tmpMinute = beginDate.getMinute();
        tmpBeginDate += String.format("%02d", tmpMinute);
        listOfDate.add(tmpBeginDate);

        String tmpEndDate = "";
        tmpEndDate += Integer.toString(endDate.getYear());
        tmpMonth = endDate.getMonth();
        tmpEndDate += String.format("%02d", tmpMonth);
        tmpDay = endDate.getDay();
        tmpEndDate += String.format("%02d", tmpDay);
        tmpHour = endDate.getHour();
        tmpEndDate += String.format("%02d", tmpHour);
        tmpMinute = endDate.getMinute();
        tmpEndDate += String.format("%02d", tmpMinute);
        listOfDate.add(tmpEndDate);

        return listOfDate;
    }
}
