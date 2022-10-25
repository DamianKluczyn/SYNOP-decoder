package pl.damiankluczynski.sections.sectionOne.actuallPrevoiusWeather;

import pl.damiankluczynski.fileReader.FileReaderProvider;
import pl.damiankluczynski.sections.Section;

import java.util.ArrayList;

public class ActuallPrevoiusWeather extends Section implements IActuallPrevoiusWeather{
    private static ArrayList<ArrayList<String>> weatherArray;
    private String actuallPreviousWeather;
    private String actuallOrPrevious;

    public ActuallPrevoiusWeather(String actuallPreviousWeather){
        this.actuallPreviousWeather = actuallPreviousWeather;
        decode(actuallPreviousWeather);
    }
    private void decode(final String data){
        if(!data.substring(1,3).equals("//")){
            actuallOrPrevious = "aktualna";
            String tmp = data.substring(1,3);
            for(var x : weatherArray){
                if(x.get(0).equals(tmp)){
                    actuallPreviousWeather = x.get(1);
                    break;
                }
            }

        } else{
            actuallOrPrevious = "nieaktualna, poprzednia";
            switch(data.substring(3,4)){
                case "0" -> actuallPreviousWeather = "chmury pokrywały połowę lub mniej niż połowę nieba w ciągu branego pod uwagę okresu";
                case "1" -> actuallPreviousWeather = "chmury pokrywały ponad połowę nieba przez część okresu i mniej niż połowę przez pozostałą część okresu";
                case "2" -> actuallPreviousWeather = "chmury pokrywały ponad połowę nieba w ciągu branego pod uwagę okresu";
                case "3" -> actuallPreviousWeather = "wichura pyłowa, wichura piaskowa lub zamieć śnieżna wysoka";
                case "4" -> actuallPreviousWeather = "mgła, mgła lodowa lub gęste zmętnienie (widzialność poniżej 1000 m)";
                case "5" -> actuallPreviousWeather = "mżawka";
                case "6" -> actuallPreviousWeather = "deszcz ciągły";
                case "7" -> actuallPreviousWeather = "śnieg lub śnieg z deszczem lub ziarna lodowe";
                case "8" -> actuallPreviousWeather = "opady przelotne";
                case "9" -> actuallPreviousWeather = "burza z opadem lub bez opadu";
                default -> actuallPreviousWeather = "brak danych";
            }
        }
    }
    @Override
    public void show(){
        System.out.println("Pogoda " + actuallOrPrevious + ": " + actuallPreviousWeather);
    }

    public static void readFromFile(){
        weatherArray = new ArrayList<ArrayList<String>>();
        weatherArray = FileReaderProvider.fileReaderProvider("Files/Weather");
    }
}
