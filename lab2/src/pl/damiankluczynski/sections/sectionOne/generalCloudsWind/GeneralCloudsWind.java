package pl.damiankluczynski.sections.sectionOne.generalCloudsWind;

import pl.damiankluczynski.fileReader.FileReaderProvider;
import pl.damiankluczynski.sections.IShow;
import pl.damiankluczynski.sections.Section;

import java.util.ArrayList;

public class GeneralCloudsWind extends Section implements IGeneralCloudsWind{
    private String generalClouds;
    private String windDirection;
    private String windSpeed;
    private static ArrayList<ArrayList<String>> windArray;

    public GeneralCloudsWind(String generalClouds){
        this.generalClouds = generalClouds;
        decode(generalClouds);
    }
    private void decode(final String data){
        switch(data.substring(0,1)){
            case "0" -> generalClouds = "Niebo bezchmurne";
            case "1" -> generalClouds = "1/8";
            case "2" -> generalClouds = "2/8";
            case "3" -> generalClouds = "3/8";
            case "4" -> generalClouds = "4/8";
            case "5" -> generalClouds = "5/8";
            case "6" -> generalClouds = "6/8";
            case "7" -> generalClouds = "7/8";
            case "8" -> generalClouds = "8/8";
            case "9" -> generalClouds = "niebo niewidoczne";
            default -> generalClouds = "niebo niewidoczne z powodów innych zjawiska meterologiczne lub brak pomiaru";
        }
        windDirection = data.substring(1,3);
        for(var x : windArray){
            if(x.get(0).equals(windDirection)){
                windDirection = x.get(1);
                break;
            }
        }
        windSpeed = data.substring(3,5);
    }

    @Override
    public void show() {
        System.out.println("Wielkosc zachmurzenia ogolnego: " + generalClouds);
        System.out.println("Kierunek wiatru: " + windDirection);
        System.out.println("Predkosc wiatru: " + windSpeed);
    }
    private static void readFromFile(){
        windArray = new ArrayList<ArrayList<String>>();
        windArray = FileReaderProvider.fileReaderProvider("Files/Wind");
    }
}
