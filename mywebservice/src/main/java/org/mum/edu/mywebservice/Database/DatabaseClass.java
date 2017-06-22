package org.mum.edu.mywebservice.Database;

import java.util.HashMap;
import java.util.Map;

import org.mum.edu.mywebservice.Model.Message;
import org.mum.edu.mywebservice.Model.Profile;

public class DatabaseClass {
	private static Map<Long, Message> messages=new HashMap<>();
	private  static Map<String, Profile> profiles=new HashMap<>();
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
