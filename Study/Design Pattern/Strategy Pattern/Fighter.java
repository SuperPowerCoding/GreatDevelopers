
public class Fighter {
	private Weapon weapon;
	
	public Fighter() {
		// TODO Auto-generated constructor stub
		this.weapon = null;
	}
	
	public void setWeapon(Weapon newWeapon)
	{
		weapon = newWeapon;
	}
	
	public void attack()
	{
		if(weapon == null)
		{
			System.out.println("punch");
		}
		else
		{
			weapon.attack();
		}
	}
}
