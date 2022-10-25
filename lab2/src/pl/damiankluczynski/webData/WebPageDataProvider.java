package pl.damiankluczynski.webData;

import pl.damiankluczynski.userData.UserDataProvider;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class WebPageDataProvider implements IWebPageDataProvider{
    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> response;
    private String link;
    private ArrayList<String> listOfDate;

    public WebPageDataProvider(){
        UserDataProvider userDataProvider =  new UserDataProvider();
        userDataProvider.initialize();
        listOfDate = userDataProvider.prepareDate();
    }

    public void initialize(){
        client = HttpClient.newHttpClient();
        link = prepareLink(listOfDate);
        request = HttpRequest.newBuilder().uri(URI.create(link)).GET().build();
        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String provideResponse(){
        return response.body();
    }

    private String prepareLink(ArrayList<String> listOfDate){
        String tmpLink = "https://www.ogimet.com/cgi-bin/getsynop?begin="+listOfDate.get(0)+"&end="+listOfDate.get(1)+"&state=Pol";
        return tmpLink;
    }
}

