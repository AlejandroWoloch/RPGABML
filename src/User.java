import java.util.Objects;

public abstract class User implements ISystemMessage {
	// Attributes
	private static int lastId = 0;
	private int id;
	private String name;
	private String username;
	private String password;
	private String email;
	
	// Constructor
	public User(String name, String username, String email) {
		this.setId();
		this.setName(name);
		this.setUsername(username);
		this.setEmail(email);
	}
	
	public User(String name, String username, String password, String email) {
		this.setId();
		this.setName(name);
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
	}
	
	// Override equals method.
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass().isInstance(User.class)) {
			return ((User) obj).getId() == this.getId();
		} else {
			return false;
		}
	}
	
	// Override hashCode method.
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	// Override toString method.
	@Override
	public String toString() {
		return "Character [Id = " + getId() +
				", Name = " + getName() + 
				", Username = " + getUsername() + 
				", Email = " + getEmail() + " ]";
	}

	// Getters and Setters
	private static int getLastId() {
		return ++User.lastId;
	}
	
	public int getId() {
		return id;
	}

	private void setId() {
		this.id = User.getLastId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.length() > 0) {
			this.name = name;			
		} else {
			System.out.println(valueErrorMessage + "... Dude, please... Your fathers thought a name for you... Just use it");
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if(username.length() > 0) {			
			this.username = username;
		} else {
			System.out.println(valueErrorMessage + "... Dude, please... Create a username, don't be lazy e.e");
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(username.length() > 0) {
			this.password = password;
		} else {
			System.out.println(valueErrorMessage + "... That is not a password. Or maybe yes, if you like or want to have huge security problems");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email.length() > 0) {
			this.email = email;
		} else {
			System.out.println(valueErrorMessage + "... That is not even an email");
		}
	}	
}
