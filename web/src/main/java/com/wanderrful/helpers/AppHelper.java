package com.wanderrful.helpers;

import com.wanderrful.service.MyService;
import static com.wanderrful.IndexKt.myExtensionMethod;

public class AppHelper {
    public String retrieveBaseMessage() {
        MyService myService = new MyService();
        return myExtensionMethod(myService);
    }
}
