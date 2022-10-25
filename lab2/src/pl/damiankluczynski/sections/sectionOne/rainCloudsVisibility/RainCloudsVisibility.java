package pl.damiankluczynski.sections.sectionOne.rainCloudsVisibility;

import pl.damiankluczynski.sections.Section;

import static java.lang.Integer.parseInt;

public class RainCloudsVisibility extends Section implements IRainCloudsVisibility{
    private String rain;
    private String stationType;
    private String cloudHeight;
    private String visibility;
    private String rainCloudsVisibility;
    private String visibilitySeaOrLand;
    public RainCloudsVisibility(String rainCloudsVisibility){
        this.rainCloudsVisibility = rainCloudsVisibility;
        decode(rainCloudsVisibility);
    }

    @Override
    public void show(){
        System.out.println("Typ Stacji: " + stationType);
        System.out.println("Wskaznik grupy opadowej: " + rain);
        System.out.println("Wysokosc wzgledna chmur: " + cloudHeight);
        System.out.println("Widzialnosc: " + visibility + " na " + visibilitySeaOrLand);
    }
    private void decode(final String rainCloudsVisibility){
        rain = rainCloudsVisibility.substring(0,1);
        stationType = rainCloudsVisibility.substring(1,2);
        cloudHeight = rainCloudsVisibility.substring(2,3);
        visibility = rainCloudsVisibility.substring(3,5);

        switch (parseInt(rain)) {
            case 0 -> rain = "grupa opadowa w sekcji 1 i 3";
            case 1 -> rain = "grupa opadowa w sekcji 1";
            case 2 -> rain = "grupa opadowa w sekcji 3";
            case 3 -> rain = "grupa opadowa pominieta (opady nie wystapily)";
            case 4 -> rain = "grupa opadowa pominięta (nie wykonano pomiarow opadu)";
            default -> {
            }
        }

        switch (parseInt(stationType)) {
            case 1 -> stationType = "stacja nieautomatyczna, grupa 7wwW1W2 włączona";
            case 2 -> stationType = "stacja nieautomatyczna, grupa 7wwW1W2 opuszczona (brak zjawisk)";
            case 3 -> stationType = "stacja nieautomatyczna, grupa 7wwW1W2 opuszczona (brak danych)";
            case 4 ->
                    stationType = "stacja automatyczna, grupa 7wwW1W2 włączona kodowana za pomocą WMO Code Table 4677 i 4561";
            case 5 -> stationType = "stacja automatyczna, grupa 7wwW1W2 opuszczona (brak zjawisk)";
            case 6 -> stationType = "stacja automatyczna, grupa 7wwW1W2 opuszczona (brak danych)";
            case 7 ->
                    stationType = "stacja automatyczna, grupa 7wwW1W2 włączona kodowana za pomocą WMO Code Table 4680 i 4531";
            default -> {
            }
        }

        switch (parseInt(cloudHeight)) {
            case 0 -> cloudHeight = "0 do 50 m";
            case 1 -> cloudHeight = "50 do 100 m";
            case 2 -> cloudHeight = "100 do 200 m";
            case 3 -> cloudHeight = "200 do 300 m";
            case 4 -> cloudHeight = "300 do 600 m";
            case 5 -> cloudHeight = "600 do 1000 m";
            case 6 -> cloudHeight = "1000 do 1500 m";
            case 7 -> cloudHeight = "1500 do 2000 m";
            case 8 -> cloudHeight = "12000 do 2500 m";
            case 9 -> cloudHeight = "powyżej 2500 m lub brak chmur";
            default -> cloudHeight = "wysokość podstawy chmur nieznana";
        }
        if(parseInt(visibility)<51){
            visibility = visibility.substring(0,1)+","+visibility.substring(1,2);
            visibilitySeaOrLand = "ladzie.";
        } else if (parseInt(visibility)>=51 && parseInt(visibility)<= 80) {
            visibility = (Integer.toString(parseInt(visibility) - 30));
            visibilitySeaOrLand = "ladzie.";
        } else if (parseInt(visibility)>=81 && parseInt(visibility)<= 88) {
            visibility = (Integer.toString(((parseInt(visibility) - 80) * 5) + 30));
            visibilitySeaOrLand = "ladzie.";
        } else if (parseInt(visibility) == 89) {
            visibility = ">70";
            visibilitySeaOrLand = "ladzie.";
        } else{
            visibilitySeaOrLand = "morzu.";
            switch(parseInt(visibility)){
                case 90 -> visibility = ">0.05";
                case 91 -> visibility = "0.05";
                case 92 -> visibility = "0.2";
                case 93 -> visibility = "0.5";
                case 94 -> visibility = "1";
                case 95 -> visibility = "2";
                case 96 -> visibility = "4";
                case 97 -> visibility = "10";
                case 98 -> visibility = "20";
                default -> visibility = ">50";
            }
        }
    }
}
