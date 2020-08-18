package ru.HomeWork.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.HomeWork.Logic.ClientRequest;
import ru.HomeWork.Logic.ClientResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.rmi.server.ExportException;
import java.text.SimpleDateFormat;

@RestController
public class ClientController {
    //ClientRequest clientRequest = new ClientRequest();
    ClientResponse clientResponse= new ClientResponse();

    @PostMapping(value = "/sessions", consumes = "application/json", produces = "application/json")
    public ClientResponse setClientInfo(@RequestBody ClientRequest clientRequest){
        //System.out.println("!!!");

        clientResponse.getResponse(clientRequest);
        return clientResponse;
    }



}
