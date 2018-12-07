
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// - interface를 이용하여 교환 가능한 행동을 캡슐화하고 위임(deligate)을 통해서 어떤 행동을 사용할지 결정한다.
		Weapon[] blackSmith = {
					null,
					new Knife(),
					new Bow()
		};	
		
		Fighter f = new Fighter();
		
		for(Weapon w : blackSmith)
		{	
			f.setWeapon(w);
			f.attack();
		}
	}

}
