package malith.login.core;

public class User {

	private String id;
	private String lastName;
	private String firstName;
	private String email;
	private int accessPriviledge;
	private String password;

	public User() {
		
	}
	
	public User(String lastName, String firstName, String email, int accessPriviledge, String password) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.accessPriviledge = accessPriviledge;
		this.password = password;
	}
	
	public User(String id, String lastName, String firstName, String email, int accessPriviledge) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.accessPriviledge = accessPriviledge;
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
        return accessPriviledge;
    }

    public void setAccessPriviledge(int accessPriviledge) {
        this.accessPriviledge = accessPriviledge;
    }
	
	


	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
