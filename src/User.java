import java.io.Serializable;
import java.util.Objects;


public abstract class User extends Base implements ISystemMessage, Serializable {

	// Attributes
	private static final long serialVersionUID = 1L;
	private static int lastId;
	private String name;
	private String username;
	private String password;
	private String email;
	
	// Constructor
	public User(int lastId, String name, String username, String email) throws Exception {
		User.setLastId(lastId);
		this.setId();
		this.setName(name);
		this.setUsername(username);
		this.setEmail(email);
	}
	
	public User(String name, String username, String password, String email) throws Exception {
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
	private static void setLastId(int lastId) {
		User.lastId = lastId;
	}
	
	private static int getLastId() {
		return ++User.lastId;
	}

	private void setId() {
		this.id = User.getLastId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		if(name.length() > 0) {
			this.name = name;
		} else {
			String setNameError = "This is not a valid name";
			throw new Exception(valueErrorMessage + setNameError);
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) throws Exception {
		if(username.length() > 0) {
			this.username = username;
		} else {
			String setUsernameError = "This is not a valid username";
			throw new Exception(valueErrorMessage + setUsernameError);
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws Exception {
		if(username.length() > 0) {
			this.password = password;
		} else {
			String setPasswordError = "This is not a valid password";
			throw new Exception(valueErrorMessage + setPasswordError);
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception {
		if(email.length() > 0) {
			this.email = email;
		} else {
			String setEmailError = "This is not a valid email";
			throw new Exception(valueErrorMessage + setEmailError);
		}
	}	
}
