
//Mientras hacia esta interface se me ocurrio ponerle el generico ese
//No digo que este bien, pero como estamos obligados a usarlo me parece un lugar posible donde podemos forzarlo.

public interface ICombatActions<T extends IAbility> { //Interfaces used to force characters to have ways to fight

	void normalAttack(); // Used to perfom a normal attack
	void specialAttack(T ability); // Used to perform an ability (Skill/Spell)
}
