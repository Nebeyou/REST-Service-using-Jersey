package org.mum.edu.mywebservice.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
public class Profile {
	@Id
	@GeneratedValue
	private long id;
	@Column(name="Last_Name")
	private String lastname;
	@Column(name="First_Name")
	private String firstname;
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Column(name="Profile_Name")
	private String profilename;
	
	public Profile(){}
	
	public Profile(String lastname, String firstname, Date created, String profilename) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.created = created;
		this.profilename = profilename;
	}

	public Profile(long id, String lastname, String firstname,String profilename) {
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.created = new Date();
		this.profilename = profilename;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getProfilename() {
		return profilename;
	}
	public void setProfilename(String profilename) {
		this.profilename = profilename;
	}
	
}
