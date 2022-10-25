package pl.damiankluczynski.extractor;

public interface IExtractor {
    public String getStationID();
    public String getYear();
    public String getMonth();
    public String getDay();
    public String getHour();
    public String getMinute();
    public String getStationTypeID();
    public String getTimeAndWind();
    public String getRainCloudsVisibility();
    public String getGeneralCloudsWind();
    public String getAirTemperature();
    public String getDewTemperature();
    public String getStationAtmosphericPressure();
    public String getSeaAtmosphericPressure();
    public String getAtmosphericPressureTendency();
    public String getTotalRain();

    public String getActuallPrevoiusWeather();
    public String getClouds();
    public String getObservationTimeWhenMoreThan10MinutesFromStandardTime();
}
