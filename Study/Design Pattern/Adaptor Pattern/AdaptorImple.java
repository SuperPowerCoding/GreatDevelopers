
public class AdaptorImple implements Adaptor {

	@Override
	public double getDouble(double d) {
		// TODO Auto-generated method stub		
		return (double)Math.getDouble((float)d);
	}

	@Override
	public double getHalf(double d) {
		// TODO Auto-generated method stub
		return (double)Math.getHalf((float)d);
	}

}
