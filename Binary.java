// Ida Huang 
// Period 8
// HW29
// 2013-11-20

public class Binary implements Comparable {

    private int _decNum;
    private String _binNum;

    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() { 
        _decNum = 0;
	_binNum = "0";
    }

    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Binary( int n ) {
	_decNum = n;
	_binNum = decToBin(n);
    }

    /*=====================================
      get _decNum because it is a private variable
      =====================================*/
    public int getdec() {
	return _decNum;
    }

    /*====================================
      get _binNum because it is a private variable
      ===================================*/
    public String getbin(){
	return _binNum;
    }

   /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	return _binNum;
    }

    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
          decToBin(1) -> "1"
	  decToBin(2) -> "10"
	  decToBin(3) -> "11"
	  decToBin(14) -> "1110"
      =====================================*/
    public static String decToBin( int n ){
	if (n == 0) return "0";
	else {
	    String retStr = "";
	    while (n != 0){ 
		retStr = n%2 + retStr;
		n /= 2;
	    }
	    return retStr; 
	}
    }

    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
          decToBinR(1) -> "1"
	  decToBinR(2) -> "10"
	  decToBinR(3) -> "11"
	  decToBinR(14) -> "1110"
	  =====================================*/
    public static String decToBinR( int n ) { 
	if (n == 0) return "0";
	else {
	    String retStr = "";
	    while (n != 0) {
		retStr = decToBinR(n/2) + n%2;
	    }
	    return retStr;
	}
    }

    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) { 
	return( other instanceof Binary && _binNum.equals(((Binary)other).getbin()));
    // NOTE: USE .EQUALS BECAUSE WE ARE COMPARING STRINGS (_binNum)
	//TYPECASTING BECAUSE VAR TYPE OF OBJECT IS OBJECT AND AN OBJECT DOES NOT HAVE _binNum
    }// END EQUALS 

    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	if (other instanceof Binary){
	    Binary n = (Binary) other;
	    if ( this.equals(other)) return 0;
	    else return this.getdec() - n.getdec();
	}
	else {
	    throw new ClassCastException ("\nerror message!" + "compareTo() input was not a Binary");
	}
    }

    //main method for testing
    public static void main( String[] args ) {

	System.out.println();
	System.out.println( "Testing ..." );

	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	Binary b4 = new Binary(7);

	System.out.println( b1 ); 
	System.out.println( b2 );
	System.out.println( b3 ); 

	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be neg
	System.out.println( b4.compareTo(b1) ); //should be pos
	/*=========================================
	  =========================================*/
    }//end main()

} //end class
