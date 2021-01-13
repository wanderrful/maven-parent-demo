package com.wanderrful.helpers;

import com.wanderrful.service.MyService;

public class AppHelper {
    public String retrieveBaseMessage() {
        MyService myService = new MyService();
        return myService.getMessage();
    }
}
