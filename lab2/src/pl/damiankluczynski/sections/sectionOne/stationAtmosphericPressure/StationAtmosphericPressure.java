package pl.damiankluczynski.sections.sectionOne.stationAtmosphericPressure;

import pl.damiankluczynski.sections.Section;

public class StationAtmosphericPressure extends Section implements IStationAtmosphericPressure{
    private String atmosphericPressure;
    public StationAtmosphericPressure(String stationAtmosphericPressure){
        this.atmosphericPressure = stationAtmosphericPressure;
        decode(stationAtmosphericPressure);
    }
    private void decode(final String data){
        if(Integer.parseInt(data.substring(1,5)) > 500){
            atmosphericPressure = data.substring(1,4) + "," + data.substring(4,5);
        }
        else{
            atmosphericPressure = "1" + data.substring(1,5) + "," + data.substring(4,5);
        }
    }

    @Override
    public void show(){
        System.out.println("Cisnienie atmosferyczne na stacji: " + atmosphericPressure);
    }
}
