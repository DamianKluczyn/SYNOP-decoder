package pl.damiankluczynski.sections.sectionOne.airTemperature;

import pl.damiankluczynski.sections.Section;

public class AirTemperature extends Section implements IAirTemperature{
    private String airTemperature;
    private String plusOrMinus;
    public AirTemperature(String airTemperature){
        this.airTemperature = airTemperature;
        decode(airTemperature);
    }
    private void decode(final String data){
        switch(data.substring(1,2)){
            case "0" -> plusOrMinus = "+";
            case "1" -> plusOrMinus = "-";
        }
        airTemperature = data.substring(2,4) + "," + data.substring(4,5);
    }

    @Override
    public void show(){
        System.out.println("Temperatura powietrza: " + plusOrMinus + airTemperature + " stopni Celsjusza");
    }
}
