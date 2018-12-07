
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 
		 * 220V에서 110V로 할때 어댑터를 끼듯이..
		 * 이미 다른 사람이 작성한 코드를 요구사항에 맞도록 중간에 adaptor 클래스로 사용 하는것.		 
		 */
		Adaptor ad = new AdaptorImple();
		
		System.out.println(ad.getDouble(10.0d));
		System.out.println(ad.getHalf(10.0d));

	}

}
