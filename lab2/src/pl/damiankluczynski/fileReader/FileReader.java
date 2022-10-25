package pl.damiankluczynski.fileReader;

import pl.damiankluczynski.sections.sectionOne.actuallPrevoiusWeather.ActuallPrevoiusWeather;
import pl.damiankluczynski.sections.sectionOne.airTemperature.AirTemperature;


public class FileReader implements  IFileReader{
    public static void read(){
        ActuallPrevoiusWeather.readFromFile();
    }
}
