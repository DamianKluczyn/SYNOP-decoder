package pl.damiankluczynski.sections.sectionZero;

import pl.damiankluczynski.sections.Section;

public class TimeAndWind extends Section implements ITimeAndWind{
    private String timeAndWind;

    public TimeAndWind(String wind){
        timeAndWind = wind;
        decode();
    }

    private void decode(){
        String tmp = timeAndWind.substring(4,5);
        if (tmp == "0"){
            timeAndWind = "Predkosc wiatru oszacowano w m/s";
        } else if (tmp == "1") {
            timeAndWind = "Predkosc wiatru zmierzono anemometrem w m/s";
        } else if (tmp == "3") {
            timeAndWind = "Predkosc wiatru oszacowano w wezlach";
        } else if (tmp == "4") {
            timeAndWind = "Predkosc wiatru zmierzono anemometrem w wezlach";
        }
    }

    @Override
    public void show(){
        System.out.println("Wskaznik wiatru: " + timeAndWind);
    }
}
