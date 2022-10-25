package pl.damiankluczynski.sections.sectionZero;

import pl.damiankluczynski.sections.IShow;
import pl.damiankluczynski.sections.Section;

public class StationID  extends Section implements IStationID{
    private String stationID;
    public StationID(String id){
        stationID = id;
    }

    @Override
    public void show(){
        System.out.println("ID stacji: " + stationID);
    }
}
