import java.io.*;
 
public class Pro2_zakiadha {
 
    public static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
     
    public static void main(String[] args) {
         
        for(;;){
	    String output;
            System.out.println("\n   JAVA CONVERSION PROGRAM");
            displayMenu();
            int MENU = getInteger("Enter choice: ", 0, 3);
             
            if(MENU == 3){
            	System.out.println();
            	for(int i=0; i < _numConversions; ++i){
            		System.out.format("Conversion #%d: %s\n",i+1, _prevConversions[i]);
            	}
                
            }
             
            else if(MENU == 2){
            	System.out.println();
                output = cmTofeetInches();
                System.out.println("\n"+output);
                addConversion(output);
            }
             
            else if(MENU == 1){
            	System.out.println();
            	output = feetInchesToCm();
            	System.out.println("\n"+output);
            	addConversion(output);
            }
             
            else {
            	System.out.print("\nGoodbye!");
                break;
            }
             
             
        }
    }
    
    public static String[] _prevConversions = new String[1];
    public static int _numConversions = 0;
    
    public static void displayMenu(){
        System.out.println("0 - Quit");
        System.out.println("1 - Convert feet and inches to centimeters");
        System.out.println("2 - Convert centimeters to feet and inches");
        System.out.println("3 - Print previous conversions\n");
    }
     
    public static int getInteger(String prompt, int LB, int UB){
        int num;
         
        for(;;) {
            try {
                System.out.print(prompt);
                num = Integer.parseInt(cin.readLine());
                 
                if(num < LB || num > UB)
                    throw new IOException(String.format("must be in [%d, %d]", LB, UB));
                break;
            }
            catch (Exception e){
                System.out.format("ERROR: Input must be an integer in [%d, %d]!\n\n", LB,UB);
            }
        }
        return num;
    }
     
    public static double getDouble(String prompt, double LB, double UB){
        double num;
         
        for(;;) {
            try {
                System.out.print(prompt);
                num = Double.parseDouble(cin.readLine());
                 
                if(num < LB || num > UB)
                    throw new IOException(String.format("must be in [%d, %d]", LB, UB));
                break;
            }
            catch (Exception e){
                System.out.format("ERROR: Input must be a real number in [0.00, infinity]!\n\n");
            }
        }
        return num;
    }
    
    public static String feetInchesToCm(){
    	double feet = getDouble("Enter feet: ", 0.00, Double.MAX_VALUE);
    	double inches = getDouble("Enter inches: ", 0.00, Double.MAX_VALUE);
    	FeetInches fi = new FeetInches(feet,inches);
    	double cm = fi.convertToCm();
    	return String.format(fi+" equals %.2f centimeters.", cm);
    	
    }
    public static String cmTofeetInches(){
    	double cm = getDouble("Enter centimeters: ", 0.00, Double.MAX_VALUE);
    	FeetInches fi = FeetInches.convertToIn(cm);
    	return String.format("%.2f centimeters equals " + fi+".", cm);

    }
    
    public static void addConversion(String s){
    	if(_numConversions + 1 == _prevConversions.length){
    		String[] temp = new String[_prevConversions.length*2];
    		for(int i=0; i<_prevConversions.length; i++){
    			temp[i] = _prevConversions[i];
    		}
    		_prevConversions = temp;
    	}
    	_prevConversions[_numConversions] =  s;
    	_numConversions++;
    }    
}
