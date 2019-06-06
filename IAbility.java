
public interface IAbility { //An interface created to make every ability (Spell or Skill at the moment) be forced to follow certain rules.
	int cost; //Stamina or Mana that will be consumed once the Ability is used.
	int levelRequired; //The PlayableCharacter will need to reach certain level to use this ability.
}
