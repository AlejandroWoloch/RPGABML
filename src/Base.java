
public class Base {
	
	protected int id;
	boolean deleted;
	protected String name;
	
	public Base() {
		setDeleted(false);
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean isDeleted() {
		return this.deleted;
	}
	
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getName() {
		return this.name;
	}
}
