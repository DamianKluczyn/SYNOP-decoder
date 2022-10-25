package pl.damiankluczynski.sections.sectionOne.totalRain;

import pl.damiankluczynski.sections.Section;

public class TotalRain extends Section implements ITotalRain{
    private String totalRain;
    private String duration;
    public TotalRain(String totalRain){
        this.totalRain = totalRain;
        decode(totalRain);
    }
    private void decode(final String data){
        if(Integer.parseInt(data.substring(1,4)) <= 988 && Integer.parseInt(data.substring(2,4)) > 0){
            totalRain = data.substring(1,4) + " mm";
        } else if(Integer.parseInt(data.substring(1,4)) == 0){
            totalRain = "brak opadu";
        } else if (Integer.parseInt(data.substring(1,4)) == 989) {
            totalRain = data.substring(1,4) + " mm lub wiecej";
        } else if (Integer.parseInt(data.substring(1,4)) == 990) {
            totalRain = "slad opadu";
        } else if (Integer.parseInt(data.substring(1,4)) >= 991 && Integer.parseInt(data.substring(1,4)) <= 999) {
            totalRain = "0," + data.substring(4,5) + " mm";
        } else{
            totalRain = "opadu nie mierzono";
        }
        switch(data.substring(4,5)){
            case "1" -> duration = "całkowite opady w ciągu 6 godzin poprzedzających obserwację";
            case "2" -> duration = "całkowite opady w ciągu 12 godzin poprzedzających obserwację";
            case "3" -> duration = "całkowite opady w ciągu 18 godzin poprzedzających obserwację";
            case "4" -> duration = "całkowite opady w ciągu 24 godzin poprzedzających obserwację";
            case "5" -> duration = "całkowite opady w ciągu 1 godziny poprzedzającej obserwację";
            case "6" -> duration = "całkowite opady w ciągu 2 godzin poprzedzających obserwację";
            case "7" -> duration = "całkowite opady w ciągu 3 godzin poprzedzających obserwację";
            case "8" -> duration = "całkowite opady w ciągu 9 godzin poprzedzających obserwację";
            case "9" -> duration = "całkowite opady w ciągu 15 godzin poprzedzających obserwację";
        }
    }

    @Override
    public void show(){
        System.out.println("Suma opadow: " + totalRain);
        System.out.println("Czas trwania opadow: " + duration);
    }
}
