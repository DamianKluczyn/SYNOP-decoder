package pl.damiankluczynski.sections.sectionZero;

import pl.damiankluczynski.sections.IShow;
import pl.damiankluczynski.sections.Section;

public class SDate extends Section implements ISDate{
    private String year;
    private String month;
    private String day;
    private String hour;
    private String minute;
    public SDate(String year, String month, String day, String hour, String minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public void show(){
        System.out.println("Data: " + day + "." + month + "." + year + " " + hour + ":" + minute);
    }

}
