package pl.damiankluczynski.sections.sectionOne.seaAtomsphericPressure;

import pl.damiankluczynski.sections.Section;

public class SeaAtmosphericPressure extends Section implements ISeaAtmosphericPressure{
    private String seaAtmosphericPressure;
    public SeaAtmosphericPressure(String seaAtmosphericPressure){
        this.seaAtmosphericPressure = seaAtmosphericPressure;
        decode(seaAtmosphericPressure);
    }
    private void decode(final String data){
        if(Integer.parseInt(data.substring(1,5)) > 500){
            seaAtmosphericPressure = data.substring(1,4) + "," + data.substring(4,5);
        }
        else{
            seaAtmosphericPressure = "1" + data.substring(1,5) + "," + data.substring(4,5);
        }
    }

    @Override
    public void show(){
        System.out.println("Cisnienie atmosferyczne na poziomie morza: " + seaAtmosphericPressure);
    }
}
