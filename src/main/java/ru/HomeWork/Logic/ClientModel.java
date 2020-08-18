package ru.HomeWork.Logic;

public class ClientModel {
    private static final ClientRequest requestInstance = new ClientRequest();
    private static final ClientResponse responseInstance = new ClientResponse();

    public ClientModel() {
    }

    public static ClientRequest getRequestInstance() {
        return requestInstance;
    }

    public static ClientResponse getResponseInstance() {
        return responseInstance;
    }

//    public boolean addClient(ClientRequest clientRequest){
//        try{
//            ClientModel.getRequestInstance()=clientRequest;
//            return true;
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            return false;
//        }
//    }
}
