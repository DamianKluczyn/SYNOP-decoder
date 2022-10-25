package pl.damiankluczynski.extractor;
import pl.damiankluczynski.sections.sectionZero.StationType;


public class Extractor implements IExtractor {
    private String line;
    private int leftSplitIndex;
    private int rightSplitIndex;
    private String stationID;
    private String year;
    private String month;
    private String day;
    private String hour;
    private String minute;
    private String stationTypeID;
    private String timeAndWind;
    private String rainCloudsVisibility;
    private String generalCloudsWind;
    private String airTemperature;
    private String dewTemperature;
    private String stationAtmosphericPressure;
    private String seaAtmosphericPressure;
    private String atmosphericPressureTendency;
    private String totalRain;
    private String actuallPrevoiusWeather;
    private String clouds;
    private String observationTimeWhenMoreThan10MinutesFromStandardTime;
    public Extractor(String dataLine) {
        this.line = dataLine;
        rightSplitIndex = -1;
        leftSplitIndex = 0;

        stationID = extractDataFromLine(',');
        year = extractDataFromLine(',');
        month = extractDataFromLine(',');
        day = extractDataFromLine(',');
        hour = extractDataFromLine(',');
        minute = extractDataFromLine(',');
        stationTypeID = extractDataFromLine(' ');
        if (!stationTypeID.equals("AAXX")) {
            return;
        }
        timeAndWind = extractDataFromLine(' ');
        String tmpStationID = extractDataFromLine(' ');
        if (!tmpStationID.equals(stationID)) {
            System.out.println("Blad rozpakowywania danych");
            System.exit(1);
        }
        rainCloudsVisibility = extractDataFromLine(' ');
        generalCloudsWind = extractDataFromLine(' ');
        airTemperature = extractDataFromLine(' ');
        dewTemperature = extractDataFromLine(' ');
        stationAtmosphericPressure = extractDataFromLine(' ');
        seaAtmosphericPressure = extractDataFromLine(' ');
        atmosphericPressureTendency = extractDataFromLine(' ');

        String tmp;
        boolean stayInTheWhileLoop = true;
        while (stayInTheWhileLoop) {
            tmp = extractDataFromLine(' ');
            if (tmp.charAt(0) == '6') {
                totalRain = tmp;
            } else if (tmp.charAt(0) == '7') {
                actuallPrevoiusWeather = tmp;
            } else if (tmp.charAt(0) == '8') {
                clouds = tmp;
            } else if (tmp.charAt(0) == '9') {
                observationTimeWhenMoreThan10MinutesFromStandardTime = tmp;
            } else {
                stayInTheWhileLoop = false;
            }
        }
    }

    private String extractDataFromLine(char splitSign) {
        leftSplitIndex = rightSplitIndex + 1;
        rightSplitIndex = line.indexOf(splitSign, leftSplitIndex);
        if (rightSplitIndex == -1) {
            return "EOF";
        }
        return line.substring(leftSplitIndex, rightSplitIndex);
    }

    public String getStationID() {
        return stationID;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getHour() {
        return hour;
    }

    public String getMinute() {
        return minute;
    }

    public String getStationTypeID() {
        return stationTypeID;
    }

    public String getTimeAndWind() {
        return timeAndWind;
    }

    public String getRainCloudsVisibility() {
        return rainCloudsVisibility;
    }

    public String getGeneralCloudsWind() {
        return generalCloudsWind;
    }

    public String getAirTemperature() {
        return airTemperature;
    }

    public String getDewTemperature() {
        return dewTemperature;
    }

    public String getStationAtmosphericPressure() {
        return stationAtmosphericPressure;
    }

    public String getSeaAtmosphericPressure() {
        return seaAtmosphericPressure;
    }

    public String getAtmosphericPressureTendency() {
        return atmosphericPressureTendency;
    }

    public String getTotalRain() {
        return totalRain;
    }

    public String getActuallPrevoiusWeather() {
        return actuallPrevoiusWeather;
    }

    public String getClouds() {
        return clouds;
    }

    public String getObservationTimeWhenMoreThan10MinutesFromStandardTime() {
        return observationTimeWhenMoreThan10MinutesFromStandardTime;
    }
}
