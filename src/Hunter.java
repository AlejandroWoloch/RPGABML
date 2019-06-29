
public class Hunter extends PhysicalClass{
	
	
	//Constructors
	public Hunter(String name) throws Exception{	//For brand new Hunters
		super(name);
	}
	
	public Hunter(byte level, String name, int experience, int stamina) throws Exception{ //Used to instance characters with data from JSON
		super(level, name,experience,stamina);
	}
	/*COMENTED UNTIL WE IMPLEMENT SKILLS AND ITEMS
	@Override
	public void lernNewSkill(PhysicalSkill newSkill) {
		if(! this.getSkillList().contains(newSkill)) {
			if(newSkill.getAviableClasses().contains("Hunter")) {
				if(newSkill.getLevelRequired() <= this.getLevel())
					this.getSkillList().add(newSkill);
			}
		}
	}
	*/
	
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
