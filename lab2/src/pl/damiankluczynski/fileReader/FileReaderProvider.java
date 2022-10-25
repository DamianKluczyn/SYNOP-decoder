package pl.damiankluczynski.fileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReaderProvider {
    public static ArrayList<ArrayList<String>> fileReaderProvider(String path)
    {
        var table = new ArrayList<ArrayList<String>>();
        try {
            File file = new File(path);
            Scanner fileReader = new Scanner(file);
            String line;
            int indexOfSplitSign;
            while (fileReader.hasNextLine())
            {
                var tmp = new ArrayList<String>();
                line = fileReader.nextLine();
                indexOfSplitSign = line.indexOf('-');
                tmp.add(line.substring(0, indexOfSplitSign));
                tmp.add(line.substring(indexOfSplitSign + 1));
                table.add(tmp);
            }
            fileReader.close();
        }
        catch (final FileNotFoundException exception) {
            System.err.println("Blad czytania z pliku");
            exception.printStackTrace();
        }
        return table;
    }
}
