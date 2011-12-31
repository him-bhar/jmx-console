package com.himanshu.server;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class HelloImpl extends NotificationBroadcasterSupport implements Hello {
	int sequenceNumber = 0;
	
	@Override
	public void printMe() {
		int oldValue=100;
		int newValue=200;
		System.out.println("Printing via JMX");
		Notification n = 
            new AttributeChangeNotification(this, 
                                            sequenceNumber++, 
                                            System.currentTimeMillis(), 
                                            "CacheSize changed", 
                                            "CacheSize", 
                                            "int", 
                                            oldValue, 
                                            newValue); 
 
        sendNotification(n); 
	}

}
