package ru.HomeWork.Logic;

/*
{
    "clientIP": "192.168.1.141",
    "clientInfo":
    {
        "property1": "Google Chrome",
        "property2": "Version 84.0.4147.125"
    },
    "deviceID": "‎08-ED-B9-FC-FF-87",
    "identification":
    {
        "username": "SusPecT-PC",
        "usernameType": "MainUser"
    },
    "sessionID":"CD723LGeXlf0134"
}
*/

public class ClientRequest {
    private String clientIP;
    private ClientInfo clientInfo;
    private String deviceID;
    private Identification identification;
    private String sessionID;


    public class ClientInfo {
        public String property1;
        public String property2;

        public String getProperty1() {
            return property1;
        }

        public void setProperty1(String property1) {
            this.property1 = property1;
        }

        public String getProperty2() {
            return property2;
        }

        public void setProperty2(String property2) {
            this.property2 = property2;
        }
    }
    public class Identification {
        public String username;
        public String usernameType;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUsernameType() {
            return usernameType;
        }

        public void setUsernameType(String usernameType) {
            this.usernameType = usernameType;
        }
    }

    public ClientRequest() {
    }

    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
}

