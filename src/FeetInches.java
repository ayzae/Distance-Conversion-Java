
public class FeetInches {
	
	static final double IN_TO_CM = 2.54;
	private double _feet;
	private double _inches;
	
	public FeetInches(double feet, double inches){
		_feet = feet;
		_inches = inches;
	}
	
	/*public double getFeet(){
		return _feet;
	}
	
	public double getInches(){
		return _inches;
	} */
	
	public String toString(){
		return String.format("%.2f feet %.2f inches", _feet, _inches);
	}
	
	public double convertToCm(){
		return (12 * _feet + _inches) * IN_TO_CM;
	}
	
    public static FeetInches convertToIn(double cm){
    	double inches = cm/IN_TO_CM;
    	double feet = Math.floor(inches / 12);
    	inches = inches - feet*12;
    	return new FeetInches(feet,inches);
    	
    }
    

}
