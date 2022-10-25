package pl.damiankluczynski.dataProvider;

import java.util.ArrayList;
import java.util.Arrays;

public class DataProvider {
    public static ArrayList<String> splitLine(String data){
        String[] tmpListOfLines = data.split("\n");
        ArrayList<String> listOfLines = new ArrayList<String>(Arrays.asList(tmpListOfLines));
        return listOfLines;
    }
}
