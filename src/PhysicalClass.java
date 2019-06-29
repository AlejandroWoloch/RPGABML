
public abstract class PhysicalClass extends PlayableCharacter{
	
	//Atributes
	private static final int maxStamina = 100;
	private int stamina;
	private CRUD<PhysicalSkill> skills;  //Comented until we implement Skills
	private int maxSkills;
	private static String msgError = "Error: Invalid value.";
	
	
	//Constructors
	public PhysicalClass(String name) throws Exception{ //For brand new PhysicalCharacters
		super(name);
		this.setStamina(maxStamina);
	}
	
	
	public PhysicalClass(byte level, String name, int experience, int stamina) throws Exception{ //Used to instance characters with data from JSON
		super(level, name,experience);
		this.setStamina(stamina);
	}
	
	//Getters and Setters
	public void setStamina(int stamina) throws Exception{
		if(stamina >= 0 && stamina <= maxStamina) {
			this.stamina = stamina;
		}
		else {
			String msg = "Stamina has to be higher than zero and lower than maxStamina";
			throw new Exception(PhysicalClass.msgError + msg);
		}
	}
	
	public int getStamina() {
		return this.stamina;
	}
	
	public int getMaxStamina() {
		return maxStamina;
	}
	
	public ArrayList<PhysicalSkill> getSkillList() {
		return this.skillList.getList();
	}
	
	public abstract void lernNewSkill(PhysicalSkill newSkill);
	
	public void forgetSkill(int id) {
		
		try {
			this.skills.delete(id)
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	//toString and Equals
		@Override
		public boolean equals(Object obj) {
			return super.equals(obj);
		}
		
		// Override hashCode method.
		@Override
		public int hashCode() {
			return super.hashCode();
		}

		// Override toString method.
		@Override
		public String toString() {
			return "PhysicalClass [Stamina = " + this.getStamina() + "]" + super.toString();
		}
}
