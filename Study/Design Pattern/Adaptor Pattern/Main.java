
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 
		 * 220V���� 110V�� �Ҷ� ����͸� ������..
		 * �̹� �ٸ� ����� �ۼ��� �ڵ带 �䱸���׿� �µ��� �߰��� adaptor Ŭ������ ��� �ϴ°�.		 
		 */
		Adaptor ad = new AdaptorImple();
		
		System.out.println(ad.getDouble(10.0d));
		System.out.println(ad.getHalf(10.0d));

	}

}
