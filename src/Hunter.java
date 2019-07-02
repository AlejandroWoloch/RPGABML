
public class Hunter extends PhysicalClass{
	
	
	//Constructors
	public Hunter(String name) throws Exception{	//For brand new Hunters
		super(name);
	}
	
	public Hunter(byte level, String name, int experience, int stamina) throws Exception{ //Used to instance characters with data from JSON
		super(level, name,experience,stamina);
	}
	
	// Methods
	@Override
	public void lernNewSkill(PhysicalSkill newSkill) throws Exception {
		
		if(! this.getSkillList().contains(newSkill)) {
			if(newSkill.getClassUser().contains("Hunter")) {
				this.getSkillList().add(newSkill);
			} else {
				throw new Exception("You can't learn that");
			}
		} else {
			throw new Exception("You already know that");
		}
	}
	
	@Override
	public void updateSkill(PhysicalSkill skill) throws Exception {
		if(this.getSkillList().get(skill.id) != null) {
				super.skillList.update(skill);
		} else {
			throw new Exception("You can't update an object that doesn't exist");
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
			return "Hunter " + super.toString();
		}
}
