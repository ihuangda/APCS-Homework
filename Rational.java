// Ida Huang
// Period 8
// HW 27
// 2013-11-18

public class Rational{

    //---------------PHASE I---------------------
    //INSTANCE VARS: numerator and denominator
    int numerator, denominator; 

    //DEFAULT CONSTRUCTOR (no parameters): creates new rational number 0/1
    public Rational(){
	numerator = 0;
	denominator = 1;
    }

    /*CONSTRUCTOR: takes 2 parameters: numerator & denominator
      if an invalid denominator is attempted, should print a message and set the number to 0/1
    */
    public Rational(int num, int denom){
	if (denom != 0) {	    
	    numerator = num;
	    denominator = denom;
	}
	else {
	    numerator = 0;
	    denominator = 1;
	    System.out.println("ERROR : INVALID DENOMINATOR!");
	}
    }
    
    //--------------METHODS------------------
    //toString: returns a string representation of the rational number (formatting of your choice)
    public String toString(){
	return numerator + "/" + denominator;
    }

    /* floatValue: Returns a floating point value of the number
       Uses the most precise floating point primitive
       multiply 
    */
    public double floatValue(){
	return (double) numerator/denominator;
    }

    /*MULTIPLY: Takes 1 Rational object as a parameter and multiplies it by this Rational object 
      Does not return any value
      Should modify this object and leave the parameter alone (see below for example) 
      Need not reduce the fraction
    */
    public void multiply(Rational n){
	numerator = numerator * n.numerator;
	denominator = denominator * n.denominator;
    }

    //DIVIDE: Works the same as multiply, except the operation is division
    public void divide(Rational n){
	numerator = numerator * n.denominator;
	denominator = denominator * n.numerator;
    }

    //-------------PHASE II----------------:
    //ADD: Takes 1 Rational object and adds it to the current rational number object (need not reduce)
    public void add(Rational n){
	int denom = denominator; //stores denominator value
	denominator = denom * n.denominator;
	numerator = (numerator *n.denominator) + (n.numerator*denom);
    }

    //SUBTRACT: Works the same as add, except the operation is subtraction
    public void subtract(Rational n){
	int denom = denominator; 
	denominator = denom * n.denominator;
	numerator = (numerator*n.denominator) - (n.numerator*denom);
    }

    /*GCD :Returns the gcd of the numerator and denominator: Uses Euclid's algorithm (reuse your old code!)
    Recall that in order for Euclid's algorithm to work, the first number must be greater than the second
    */
    public int gcd(){
	int n = numerator;
	int d = denominator; 
	//switch num and denom
	if (n < d){
	    int temp = n;
	    n = d;
	    d= temp;
	}
	while ( d != 0){
	    int temp = d;
	    d = n % d;
	    n = temp;
	}
	return n; //gcd
    }

    // REDUCE: Changes this Rational to one in reduced form (should use gcd)
    public void reduce(){
	if (gcd() != 0){
	    int gcd = gcd(); //stores it b/c the value will change
	    denominator = denominator / gcd;
	    numerator = numerator / gcd ;
	}
    }

    //-------------Phase III---------------:
    //Add a static gcd method that will take numerator and denominator inputs.
    public static int gcd(int numerator, int denominator){
	//switch num and denom
	if (numerator < denominator){
	    int temp = numerator;
	    numerator = denominator;
	    denominator = temp;
	}
	while ( denominator != 0){
	    int temp = denominator;
	    denominator = numerator % denominator;
	    numerator = temp;
	}
        return numerator; 
    }

    /*Add a method called compareTo that...
      Takes a Rational as a parameter and compares it to the calling object
      Returns 0 if the two numbers are equal
      Returns a positive integer if the calling number is larger than the parameter
      Returns a negative integer if the calling number is smaller than the parameter
    */
    
    public int compareTo(Rational n){
	if (floatValue() >  n.floatValue()) return 100;
	else if (floatValue() < n.floatValue()) return -100;
	else return 0;
    }
	    
    //MAIN METHOD
    public static void main (String[] args){
	
	// testing floatValue, toString, constructors
	Rational a = new Rational();
	System.out.println("a= " + a); //return 0/1
	System.out.println("a= " + a.floatValue()); // returns 0.0
	Rational r = new Rational(2,3); //Stores the rational number 2/3
	System.out.println("r= " + r); // return 2/3
	System.out.println("r= " + r.floatValue()); // returns 0.666666
	Rational s = new Rational(1,0); // Stores 0/1 should return invalid number message
	System.out.println("s= " + s);
	System.out.println("s= " + s.floatValue()); // returns 0.0
	Rational f = new Rational(1,2);//stores 1/2
	System.out.println("f= " +f); // 1/2
	System.out.println("f= " + f.floatValue()); // returns 0.5
	//testing multiply method
	r.multiply(f); //multiplies r by s: r = 2/6, f = 1/2
	System.out.println("r*f= " + r); // 2/6
	System.out.println("r= " + r.floatValue()); // returns 0.333333
	System.out.println("f= " +f); // 1/2
	// testing gcd, reduce method, add, subtract
	System.out.println("r= " + r); // returns 2/6
	System.out.println("gcd(2,6)= " + r.gcd()); //  returns 2
	r.reduce(); //changes r to 1/3
	System.out.println("r= " + r); // returns 1/3
	r.add(f); //add r to f, changes r to  f remains 1/2
	System.out.println("f= " + f); // returns 1/2 	
	System.out.println("r + f= " + r); // returns 1/3 + 1/2 = 5/6
	System.out.println("f= " + f); // returns 1/2 
	Rational t = new Rational(4,18);
	System.out.println("t= " +t); // returns 4/18
	t.reduce(); //changes t to 2/9
	System.out.println("t= " +t); // returns 2/9
	r.subtract(t); // subtracts t from r - 5/6 - 4/18 = 11/18
	r.reduce(); //can't reduce
	System.out.println("r= " +r); // returns 11/18
	//testing static gcd method
	System.out.println("gcd(10,5): " + gcd(10,5)); //returns 5
	System.out.println("gcd(20,60): " + gcd(20,60)); //returns 20
	//testing compareTo method
	System.out.println("r= " +r); // returns 11/18
	System.out.println("f= " + f); // returns 1/2 
	System.out.println("compare(r,f): " + r.compareTo(f)); //returns 100
	System.out.println("compare(f,r): " + f.compareTo(r)); //returns -100
	Rational w = new Rational(1,2);
	System.out.println("w: " + w);
	System.out.println("compare(w,f): " + w.compareTo(w)); //return 0
	//testing divide method
	w.divide(f);
	System.out.println("w/f: " + w);
	w.reduce();
	System.out.println("w/f: " + w);
    }
}
