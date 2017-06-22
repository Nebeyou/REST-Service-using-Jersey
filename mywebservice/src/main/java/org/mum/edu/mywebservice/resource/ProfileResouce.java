package org.mum.edu.mywebservice.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mum.edu.mywebservice.Model.Profile;
import org.mum.edu.mywebservice.Service.ProfileService;
@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResouce {
	ProfileService ps=new ProfileService();
	@GET
	public List<Profile> getAllProfile(){
		return ps.getProfile();
	}
	@GET
	@Path("/{profilename}")
	public Profile getProfile(@PathParam("profilename")String name){
		return ps.getProfile(name);
	}
	@POST
	public Profile addProfile(Profile profile){
		ps.addProfile(profile);
		return profile;
	}
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName")String name,Profile profile){
		profile.setProfilename(name);
		return ps.updateProfile(profile);
	}
	@DELETE
	@Path("/{profileName}")
	public String deleteProfile(@PathParam("profileName")String profilename){
		ps.deleteProfile(profilename);
		return profilename;
	}
}
