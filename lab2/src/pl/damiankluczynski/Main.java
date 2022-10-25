package pl.damiankluczynski;

import pl.damiankluczynski.extractor.Extractor;
import pl.damiankluczynski.fileReader.FileReader;
import pl.damiankluczynski.sections.Section;
import pl.damiankluczynski.sections.sectionOne.actuallPrevoiusWeather.ActuallPrevoiusWeather;
import pl.damiankluczynski.sections.sectionOne.airTemperature.AirTemperature;
import pl.damiankluczynski.sections.sectionOne.atmosphericPressureTendency.AtmosphericPressureTendency;
import pl.damiankluczynski.sections.sectionOne.clouds.Clouds;
import pl.damiankluczynski.sections.sectionOne.dewTemperature.DewTemperature;
import pl.damiankluczynski.sections.sectionOne.generalCloudsWind.GeneralCloudsWind;
import pl.damiankluczynski.sections.sectionOne.observationTimeOver10Minutes.ObservationTimeOver10Minutes;
import pl.damiankluczynski.sections.sectionOne.rainCloudsVisibility.RainCloudsVisibility;
import pl.damiankluczynski.sections.sectionOne.seaAtomsphericPressure.SeaAtmosphericPressure;
import pl.damiankluczynski.sections.sectionOne.stationAtmosphericPressure.StationAtmosphericPressure;
import pl.damiankluczynski.sections.sectionOne.totalRain.TotalRain;
import pl.damiankluczynski.sections.sectionZero.SDate;
import pl.damiankluczynski.sections.sectionZero.StationID;
import pl.damiankluczynski.sections.sectionZero.StationType;
import pl.damiankluczynski.sections.sectionZero.TimeAndWind;
import pl.damiankluczynski.webData.WebPageDataProvider;
import static pl.damiankluczynski.dataProvider.DataProvider.splitLine;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WebPageDataProvider webPageDataProvider = new WebPageDataProvider();
        webPageDataProvider.initialize();
        FileReader.read();
        ArrayList<String> linesOfData = splitLine(webPageDataProvider.provideResponse());
        ArrayList<Section> listOfSection = new ArrayList<Section>();

        for (var line : linesOfData){
            Extractor extractor = new Extractor(line);
            if(!extractor.getStationID().equals("AAXX")){
                continue;
            }
            listOfSection.add(new StationID(extractor.getStationID()));
            listOfSection.add(new SDate(extractor.getYear(), extractor.getMonth(), extractor.getDay(), extractor.getHour(), extractor.getMinute()));
            listOfSection.add(new StationType(extractor.getStationTypeID()));
            listOfSection.add(new TimeAndWind(extractor.getTimeAndWind()));
            listOfSection.add(new ActuallPrevoiusWeather(extractor.getActuallPrevoiusWeather()));
            listOfSection.add(new AirTemperature(extractor.getAirTemperature()));
            listOfSection.add(new AtmosphericPressureTendency(extractor.getAtmosphericPressureTendency()));
            listOfSection.add(new Clouds(extractor.getClouds()));
            listOfSection.add(new DewTemperature(extractor.getDewTemperature()));
            listOfSection.add(new GeneralCloudsWind(extractor.getGeneralCloudsWind()));
            listOfSection.add(new RainCloudsVisibility(extractor.getRainCloudsVisibility()));
            listOfSection.add(new SeaAtmosphericPressure(extractor.getSeaAtmosphericPressure()));
            listOfSection.add(new StationAtmosphericPressure(extractor.getStationAtmosphericPressure()));
            listOfSection.add(new TotalRain(extractor.getTotalRain()));
            listOfSection.add(new ObservationTimeOver10Minutes(extractor.getObservationTimeWhenMoreThan10MinutesFromStandardTime()));
        }
        System.out.println("DANE POMIAROWE: ");
        for (var element:listOfSection){
            element.show();
        }
        System.out.println("\n\n");
    }
}