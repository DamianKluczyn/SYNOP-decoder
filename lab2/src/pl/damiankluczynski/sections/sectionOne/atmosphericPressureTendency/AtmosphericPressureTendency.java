package pl.damiankluczynski.sections.sectionOne.atmosphericPressureTendency;

import pl.damiankluczynski.sections.Section;

public class AtmosphericPressureTendency extends Section implements IAtmosphericPressureTendency{
    private String atmosphericPressureTendency;
    private String characteristics;
    public AtmosphericPressureTendency(String atmosphericPressureTendency){
        this.atmosphericPressureTendency = atmosphericPressureTendency;
        decode(atmosphericPressureTendency);
    }
    private void decode(final String data){
        switch(data.substring(1,2)){
            case "0" -> characteristics = "wzrost, potem spadek; ciśnienie jest wyższe lub takie samo jak przed trzema godzinami";
            case "1" -> characteristics = "wzrost potem stan stały; lub wzrost, potem wzrost wolniejszy; ciśnienie jest wyższe niż przed trzema godzinami";
            case "2" -> characteristics = "wzrost równomierny lub nierównomierny; ciśnienie jest wyższe niż przed trzema godzinami";
            case "3" -> characteristics = "spadek, potem wzrost; lub stan stały, potem wzrost; lub wzrost, potem wzrost słabszy; ciśnienie jest wyższe niż przed trzema godzinami";
            case "4" -> characteristics = "stan stały; ciśnienie jest takie samo jak przed trzema godzinami";
            case "5" -> characteristics = "spadek, potem wzrost; ciśnienie jest takie samo lub niższe niż przed trzema godzinami";
            case "6" -> characteristics = "spadek, potem stan stały; lub spadek, potem spadek wolniejszy; ciśnienie jest niższe niż przed trzema godzinami";
            case "7" -> characteristics = "spadek równomierny lub nierównomierny; ciśnienie jest niższe niż przed trzema godzinami";
            case "8" -> characteristics = "wzrost, potem spadek; lub stan stały, potem spadek; lub spadek, potem spadek szybszy; ciśnienie jest niższe niż przed trzema godzinami";
        }
        atmosphericPressureTendency = data.substring(2,5);
    }

    @Override
    public void show(){
        System.out.println("Charakterystyka cisnieniowa: " + characteristics);
        System.out.println("Tendencja cisnienia: " + atmosphericPressureTendency);
    }
}
