package malith.login.core;

import common.User;

public class Clerk extends User{

	private String id;
	private String lastName;
	private String firstName;
	private String email;
	
	

	public Clerk() {
		
	}
	
	public Clerk(String lastName, String firstName, String email, int accessPriviledge, String password) {
		
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		super.setAccessPriviledge(accessPriviledge);
		super.setPassword(password);
	}
	
	public Clerk(String id, String lastName, String firstName, String email, int accessPriviledge) {
		super(id);
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		super.setAccessPriviledge(accessPriviledge);
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

    public int getAccessPriviledge() {
        return super.getAccessPriviledge();
    }

    public void setAccessPriviledge(int accessPriviledge) {
        super.setAccessPriviledge(accessPriviledge);
    }
	
	


	
	public String getPassword() {
		return super.getPassword();
	}

	public void setPassword(String password) {
		super.setPassword(password);
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
