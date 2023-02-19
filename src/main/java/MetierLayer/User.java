package MetierLayer;

import java.io.Serializable;

public class User implements Serializable{
	private int id;
	private String name;
	private String gender;
	private String email;
	private String profession;
	
	
	
	public User() {
		super();
	}
	
	
	public User(int id, String name,String gender, String email, String profession) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.profession = profession;
		this.gender = gender;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfession() {
		return profession;
	}
	public String getGender() {
		return gender;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", profession="
				+ profession + ", getId()=" + getId() + ", getName()=" + getName() + ", getEmail()=" + getEmail()
				+ ", getProfession()=" + getProfession() + ", getGender()=" + getGender() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
