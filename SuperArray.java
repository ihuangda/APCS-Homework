// Ida Huang
// Period 8
// HW36
// 2013-12-02

/*==================================================
class SuperArray
Wrapper class for array. Facilitates resizing,
getting and setting element values.
==================================================*/

public class SuperArray {

    private int[] _data;
    private int _lastPos; // the position value of the last meaningful element
    private int _size; // the number of meaingful elements in array

    //default constructor
    //initializes 10-item array
    public SuperArray() {
        _data = new int[10];
	_lastPos = 9;
	_size = 10; 
    }

    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() {
	String output = "[ ";
	for ( int i : _data ) {
	    output += i + ", " ;
	}
	output = output.substring(0, output.length()-1) + " ]";
	return output;
    }


    //double capacity of this instance of SuperArray
    private void expand() {
        int[] _ndata = new int[ _data.length* 2 ];
	for (int i = 0; i < _data.length; i++){
	    _ndata[i] = _data[i];
	}
	_data = _ndata; //because _ndata is local variable
	_size = _data.length;
	_lastPos = _size - 1;
    }


    //accessor method -- return value at specified index
    public int get( int index ) {
        return _data[index];
    }


    //mutator method -- set index to newVal, return old value at index
    public int set( int index, int newVal ) {
	int oldVal = _data[index]; //hold the value before it is changed
	_data[index] = newVal;
        return oldVal;
    }

    //main method for testing
    public static void main( String[] args ) {

  
        SuperArray curtis = new SuperArray();
        System.out.println( "Printing empty SuperArray curtis..." );
        System.out.println( curtis );

        for( int i = 0; i < curtis._data.length; i++ ) {
         curtis.set( i, i * 2 );
         curtis._size++;
        }

        System.out.println("Printing populated SuperArray curtis...");
        System.out.println(curtis);

	curtis.expand();
        System.out.println("Printing expanded SuperArray curtis...");
        System.out.println(curtis);

	for (int i = 0; i < curtis._data.length; i++) {
	    curtis.set (i , i * 2);
	}

        System.out.println("Printing repopulated SuperArray curtis...");
        System.out.println(curtis);

      /*===========================================  
      ===========================================*/

    }

}//end class SuperArray
