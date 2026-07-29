package com.maram.training.service.impl;

import com.maram.training.service.NotificationService; 
import org.springframework.stereotype.Service;

@Service("emailNotificationService") 
public class EmailNotificationService implements NotificationService{
	public void notify(String m){System.out.println("[DEMO EMAIL] "+m);}}