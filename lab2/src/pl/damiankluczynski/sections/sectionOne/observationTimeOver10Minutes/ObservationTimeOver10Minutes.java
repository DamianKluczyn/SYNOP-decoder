package pl.damiankluczynski.sections.sectionOne.observationTimeOver10Minutes;

import pl.damiankluczynski.sections.Section;

public class ObservationTimeOver10Minutes extends Section implements IObservationTimeOver10Minutes{
    private String hour;
    private String minute;

    public ObservationTimeOver10Minutes(String data){
        hour = data.substring(1,3);
        minute = data.substring(3,5);
    }

    @Override
    public void show(){
        System.out.println("Czas obserwacji rozni sie od rzeczywistego o ponad 10min czas pomiaru: " + hour + ":" + minute);
    }
}
