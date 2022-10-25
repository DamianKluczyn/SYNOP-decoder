package pl.damiankluczynski.sections.sectionOne.dewTemperature;

import pl.damiankluczynski.sections.Section;

public class DewTemperature extends Section implements IDewTemperature{
    private String dewTemperature;
    private String plusOrMinus;
    public DewTemperature(String dewTemperature){
        this.dewTemperature = dewTemperature;
        decode(dewTemperature);
    }
    private void decode(final String data){
        switch(data.substring(1,2)){
            case "0" -> plusOrMinus = "+";
            case "1" -> plusOrMinus = "-";
        }
        dewTemperature = data.substring(2,4) + "," + data.substring(4,5);
    }

    @Override
    public void show(){
        System.out.println("Temperatura punktu rosy: " + plusOrMinus + dewTemperature + " stopni Celsjusza");
    }
}
