package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConsumption {

    //Um método público, que retorna uma String, chamado getData (com parametro "adress" em formato de String)
    public String getData(String adress) {

        HttpClient client = HttpClient.newHttpClient();
        //Cria uma URI para dizer para qual endereço eu vou fazar uma requisição
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(adress)).build();

        HttpResponse<String> response = null;

        try {
        //Resposta <- recebe -> a request realizada pelo client
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }

}
