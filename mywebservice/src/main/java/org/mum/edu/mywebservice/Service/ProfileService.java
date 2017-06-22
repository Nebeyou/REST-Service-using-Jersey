package org.mum.edu.mywebservice.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mum.edu.mywebservice.Database.DatabaseClass;
import org.mum.edu.mywebservice.Model.Profile;

public class ProfileService {
	
		private Map<String, Profile> profiles=DatabaseClass.getProfiles();
		public ProfileService() {
			profiles.put("Leo Prophet", new Profile(1, "Admasu", "Dagnachew","Leo Prophet"));
			profiles.put("Java World", new Profile(2, "Hello", "World", "Java World"));
		}
		public List<Profile> getProfile(){
			return new ArrayList<>(profiles.values());
		}
		public Profile getProfile(String profilename){
			return profiles.get(profilename);
		}
		public void addProfile(Profile profile){
			profile.setId(profiles.size()+1);
			profiles.put(profile.getProfilename(), profile);
		}
		public Profile updateProfile(Profile profile){
			if(profile.getId()<=0){
				return null;
			}
			profiles.put(profile.getProfilename(), profile);
			return profile;
		}
		public Profile deleteProfile(String profilename){
			return profiles.remove(profilename);
		}
		
}
