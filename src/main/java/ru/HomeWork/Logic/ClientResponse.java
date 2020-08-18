package ru.HomeWork.Logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientResponse {
    private List<DateParam> references = new ArrayList<DateParam>();
    private Payment payment = new Payment();

    public static class DateParam {
        public String date;
        public String externalID;
        public String systemNumber;

        public void setDate(String date) { this.date = date;}
        public void setExternalID(String externalID) { this.externalID = externalID; }
        public void setSystemNumber(String systemNumber) { this.systemNumber = systemNumber; }

        public String getDate() {return this.date;}
        public String getExternalID() {return this.externalID;}
        public String getSystemNumber() {return this.systemNumber;}

        public DateParam() {
        }
    }

    public static class Payment {
        public String sessionID;
        public String uniqueClientNumber;

        public void setSessionID(String sessionID) {this.sessionID = sessionID;}
        public void setUniqueClientNumber(String uniqueClientNumber) {this.uniqueClientNumber = uniqueClientNumber;}

        public String getSessionID() {return sessionID;}
        public String getUniqueClientNumber() {return uniqueClientNumber;}
    }

    public ClientResponse() {
        try {
            SimpleDateFormat smplDate = new SimpleDateFormat("yyy-MM-dd");
            SimpleDateFormat smplTime = new SimpleDateFormat("HH:mm:ss.SSS");
            //this.Date = smplDate.format(new Date())+"T"+smplTime.format(new Date())+"+033.00";
            DateParam dateParam = new DateParam();
            dateParam.setDate(smplDate.format(new Date()) + "T" + smplTime.format(new Date()) + "+033.00");
            dateParam.setExternalID("3333");
            dateParam.setSystemNumber("555555");
            references.add(dateParam);
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<DateParam> getReferences(){return this.references;}
    public void setReferences(List<DateParam> references){this.references = references;    }
    public void addReferences(DateParam dateParam){this.references.add(dateParam);    }
    public void setPayment(Payment payment){this.payment = payment;}
    public Payment getPayment(){return this.payment;}

    public ClientResponse getResponse(ClientRequest clientRequest){
        try {
            SimpleDateFormat smplDate = new SimpleDateFormat("yyy-MM-dd");
            SimpleDateFormat smplTime = new SimpleDateFormat("HH:mm:ss.SSS");

            ClientResponse.DateParam dateParam2 = new ClientResponse.DateParam();
            dateParam2.setDate(smplDate.format(new Date()) + "T" + smplTime.format(new Date()) + "+033.00");
            dateParam2.setExternalID("123");
            dateParam2.setSystemNumber("123123123");
            this.addReferences(dateParam2);

            this.payment.setSessionID(clientRequest.getSessionID());
            this.payment.setUniqueClientNumber("33344455666");
            //this.setPayment(payment);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this;
    }

}

