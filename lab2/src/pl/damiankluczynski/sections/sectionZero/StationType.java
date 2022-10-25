package pl.damiankluczynski.sections.sectionZero;

import pl.damiankluczynski.sections.Section;

public class StationType extends Section implements IStationType{
    private String stationType;
    public StationType(String type){
        stationType = type;
    }

    @Override
    public void show(){
        System.out.println("Typ Stacji: " + stationType);
    }
}
