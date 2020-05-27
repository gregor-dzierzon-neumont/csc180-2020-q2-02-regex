package edu.neumont;

import edu.neumont.dtos.DtoBase;
import edu.neumont.interfaces.IApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class ApiBase<T extends DtoBase> implements IApi<T>
{
    protected static final String baseUrl = "https://swapi.dev/api/";

    protected String call(String url) throws IOException, InterruptedException
    {
        String theUrl = url.replace("http://", "https://");
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(theUrl))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
