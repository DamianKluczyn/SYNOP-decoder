package pl.damiankluczynski.sections.sectionOne.clouds;

import pl.damiankluczynski.sections.Section;

public class Clouds extends Section implements IClouds{
    private String N;
    private String CL;
    private String CM;
    private String CH;
    public Clouds(String clouds){
        decode(clouds);
    }

    private void decode(final String data) {
        N = data.substring(1,2);
        CL = data.substring(2,3);
        CM = data.substring(3,4);
        CH = data.substring(4,5);
        switch(CL){
            case "0" -> CL = "brak chmur CL ";
            case "1" -> CL = "Cumulus humilis lub Cumulus fractus, lecz nie złej pogody, lub obie chmury razem ";
            case "2" -> CL = "Cumulus mediocris lub congestus występujący sam lub z Cu hum lub Cu fra bądź też ze Stratocumulus; wszystkie chmury mają podstawy na tym samym poziomie – chmury Cu o umiarkowanej lub dużej rozciągłości pionowej na ogół z wypukłościami w kształcie kopuł lub wież, występujące same bądź łącznie z chmurami Cu lub Sc; wszystkie chmury o podstawach na tym samym poziomie";
            case "3" -> CL = "Cumulonimbus calvus (sam lub z Cu, Sc lub St) ";
            case "4" -> CL = "Stratocumulus cumulogenitus ";
            case "5" -> CL = "Stratocumulus (lecz nie cumulogenitus)";
            case "6" -> CL = "Stratus nebulosus lub Stratus fractus (lecz nie złej pogody) lub obie chmury razem";
            case "7" -> CL = "Stratus fractus lub Cumulus fractus (złej pogody) lub obie chmury razem (pannus), zwykle pod Altostratus lub Nimbostratus";
            case "8" -> CL = "Cumulus i Stratocumulus (lecz nie Stratocumulus cumulogenitus) o podstawach na różnych poziomach";
            case "9" -> CL = "Cumulonimbus capillatus (często z kowadłem) występujący sam lub z Cumulonimbus calvus, Cumulus, Stratocumulus, Stratus lub pannus";
            default -> CL = "chmury CL są niewidoczne z powodu ciemności, mgły, wysokiej zamieci pyłowej lub piaskowej lub też innych podobnych zjawisk";
        }
        switch(CM){
            case "0" -> CM = "brak chmur CM";
            case "1" -> CM = "Altostratus translucidus ";
            case "2" -> CM = "Altostratus opacus lub Nimbostratus";
            case "3" -> CM = "Altocumulus translucidus na jednym poziomie";
            case "4" -> CM = "ławice Altocumulus translucidus, często soczewkowate, ciągle zmieniające się i występujące na jednym lub kilku poziomach";
            case "5" -> CM = "Altocumulus translucidus w pasmach, albo jedna lub więcej warstw Altocumulus translucidus lub opacus, stopniowo zaciągająca niebo; te chmury Ac na ogół w całości grubieją";
            case "6" -> CM = "Altocumulus cumulogenitus (lub cumulonimbogenitus) – chmury Altocumulus utworzone wskutek rozpościerania się chmur Cumulus (lub Cumulonimbus)";
            case "7" -> CM = "Altocumulus translucidus lub opacus w dwóch lub więcej warstwach, lub Altocumulus opacus w pojedynczej warstwie, nie zaciągający nieba lub Altocumulus z Altostratus lub Nimbostratus";
            case "8" -> CM = "Altocumulus castellanus lub floccus";
            case "9" -> CM = "Altocumulus na niebie o wyglądzie chaotycznym, na ogół na kilku poziomach";
            default -> CM = "chmury CM są niewidoczne wskutek ciemności, mgły, wysokiej zamieci pyłowej lub piaskowej, albo z powodu ciągłej warstwy chmur niższych";
        }
        switch(CH){
            case "0" -> CH = "brak chmur CH";
            case "1" -> CH = "Cirrus fibratus lub Cirrus uncinus (nie zaciągający nieba)";
            case "2" -> CH = "Cirrus spissatus w ławicach lub w postaci poplątanych wiązek, albo Cirrus castellanus lub floccus";
            case "3" -> CH = "Cirrus spissatus cumulonimbogenitus";
            case "4" -> CH = "Cirrus uncinus lub Cirrus fibratus lub obie te chmury razem (stopniowo zaciągający niebo)";
            case "5" -> CH = "Cirrus (w pasmach) i Cirrostratus lub sam Cirrostratus stopniowo zaciągający niebo, ale nie wyżej niż 45° nad horyzontem";
            case "6" -> CH = "Cirrus (w pasmach) i Cirrostratus lub sam Cirrostratus stopniowo zaciągający niebo, powyżej niż 45° nad horyzontem, lecz nie pokrywa całkowicie nieba";
            case "7" -> CH = "Cirrostratus pokrywający całkowicie niebo – zasłona chmur Cirrostratus pokrywająca całkowicie niebo";
            case "8" -> CH = "Cirrostratus nie zaciągający i nie pokrywający nieba";
            case "9" -> CH = "Cirrocumulus sam lub przeważający wśród chmur wysokich";
            default -> CH = "chmury CH są niewidoczne wskutek ciemności, mgły, wysokiej zamieci pyłowej lub piaskowej albo ciągłej warstwy chmur niższych)";
        }

    }

    @Override
    public void show(){
        System.out.println("Zachmurzenie na poziomie: " + N);
        System.out.println("Zachmurzenie Cl: " + CL);
        System.out.println("Zachmurzenie Cm: " + CL);
        System.out.println("Zachmurzenie Ch: " + CL);
    }
}
