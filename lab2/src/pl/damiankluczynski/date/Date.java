package pl.damiankluczynski.date;

import java.util.Calendar;
import java.util.Scanner;

public class Date implements IDate{
    private final Scanner scanner = new Scanner(System.in);
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;

    public Date(){
        day = 0;
        month = 0;
        year = 0;
        hour = 0;
        minute = 0;
    }
    @Override
     public void initialize(String label){
        label = label.toUpperCase();
        System.out.println(label);

        try{
            System.out.println("Podaj dzien: ");
            day = scanner.nextInt();
        }
        catch(Exception exception){
            System.out.println("Błędne dane, wporwadz dane ponownie");
            initialize(label);
        }

        try{
            System.out.println("Podaj miesiac: ");
            month = scanner.nextInt();
        }
        catch(Exception exception){
            System.out.println("Błędne dane, wporwadz dane ponownie");
            initialize(label);
        }

        try{
            System.out.println("Podaj rok: ");
            year = scanner.nextInt();
        }
        catch(Exception exception){
            System.out.println("Błędne dane, wporwadz dane ponownie");
            initialize(label);
        }

        try{
            System.out.println("Podaj godzine: ");
            hour = scanner.nextInt();
        }
        catch(Exception exception){
            System.out.println("Błędne dane, wporwadz dane ponownie");
            initialize(label);
        }

        try{
            System.out.println("Podaj minute: ");
            minute = scanner.nextInt();
        }
        catch(Exception exception){
            System.out.println("Błędne dane, wporwadz dane ponownie");
            initialize(label);
        }

        if(checkDate()==false){
            initialize(label);
        }
    }

    public int getDay() {
        return day;
    }

    @Override
    public void setDay() {

    }

    public int getMonth() {
        return month;
    }

    @Override
    public void setMonth() {

    }

    public int getYear() {
        return year;
    }

    @Override
    public void setYear() {

    }

    public int getHour() {
        return hour;
    }

    @Override
    public void setHour() {

    }

    public int getMinute() {
        return minute;
    }

    @Override
    public void setMinute() {

    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    private boolean checkDate(){
        if (day > Calendar.getInstance().get(Calendar.DAY_OF_MONTH) && month > Calendar.getInstance().get(Calendar.MONTH) && year >Calendar.getInstance().get(Calendar.YEAR)){
            return false;
        }

        if (year < 2021 || year > Calendar.getInstance().get(Calendar.YEAR)) {
            return false;
        }

        if (month < 1 || month > 12) {
            return false;
        }

        if (day < 1) {
            return false;
        }

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 31) {
                    return false;
                }
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) {
                    return false;
                }
                break;

            case 2:
                if (year % 4 == 0) {
                    if (day > 29) {
                        return false;
                    }
                } else {
                    if (day > 28) {
                        return false;
                    }
                }
                break;
        }

        if(hour<0 || hour>24){
            return false;
        }

        if(minute<0 || minute>60){
            return false;
        }
        return true;
    }
}
