
public interface IAbility { //An interface created to make every ability (Spell or Skill at the moment) be forced to follow certain rules.
	//Attributes
	int baseCost=3; //Base cost that'll be used to determine the cost of each ability
	
	//Methods
	int calculateFinalCost();
}
