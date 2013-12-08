// Ida Huang
// Period 8
// HW39
// 2013-12-05

/*==================================================
  class SuperArray version 4.0
  Wrapper class for array. Facilitates 
  resizing 
  expansion 
  read/write capability on elements
  adding an element to end of array
  adding an element at specified index
  removing an element at specified index
  ==================================================*/

public class SuperArray implements ListObj {

    private Object[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values

    //default constructor
    //initializes 10-item array
    public SuperArray() { 
        _data = new Object[10];
        _lastPos = 0;
        _size = 0;        
    }

    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() { 
        String foo = "[";
        for( int i = 0; i < _size; i++ ) {
            foo += _data[i] + ",";
        }
        if ( foo.length() > 1 )
            //shave off trailing comma
            foo = foo.substring( 0, foo.length()-1 );
        foo += "]";
        return foo;
    }

    //double capacity of this instance of SuperArray 
    private void expand() { 
        Object[] temp = new Object[ _data.length * 2 ];
        for( int i = 0; i < _data.length; i++ )
            temp[i] = _data[i];
        _data = temp;
    }

    //accessor method -- return value at specified index
    public Object get( int index ) {
        return _data[index];
    }

    //mutator method -- set index to newVal, return old value at index
    public Object set( int index, Object newVal ) {
        Object temp = _data[index];
        _data[index] = newVal;
        return temp;
    }


    //adds an item after the last item
    public boolean add( Object newVal ) { 
        if (_data.length <= _size) {
        expand();
    }
        set(_lastPos + 1, newVal);
        _size ++;
        _lastPos ++;
	return true;
    }


    //inserts an item at index    
    public void add( int index, Object newVal ) { 
        if (_data.length <= _size) {expand();}
        for (int i = _lastPos + 1; i > index; i--){ 
        _data[i] = _data[i - 1];
        }
        _data[index] = newVal;
        _size++;
        _lastPos++;
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public Object remove( int index ) { 
	Object ans = _data[index];
        for (int i = index; i < _lastPos; i++){ 
        _data[i] = _data[i + 1];
        }
        _size--;
        _lastPos--;
	return ans;    
	}


    //return number of meaningful items in _data
    public int size() {
        return _size;
    }


    public static void main( String[] args ) {

        SuperArray mayfield = new SuperArray();
        System.out.println("Printing empty SuperArray mayfield...");
        System.out.println(mayfield);

        mayfield.add(5);
        mayfield.add(4);
        mayfield.add(3);
        mayfield.add(2);
        mayfield.add(1);

        System.out.println("Printing populated SuperArray mayfield...");
        System.out.println(mayfield);

        mayfield.remove(3);
        System.out.println("Printing SuperArray mayfield post-remove...");
        System.out.println(mayfield);
        mayfield.remove(3);
        System.out.println("Printing SuperArray mayfield post-remove...");
        System.out.println(mayfield);

        mayfield.add(3,99);
        System.out.println("Printing SuperArray mayfield post-insert...");
        System.out.println(mayfield);
        mayfield.add(2,88);
        System.out.println("Printing SuperArray mayfield post-insert...");
        System.out.println(mayfield);
        mayfield.add(1,77);
        System.out.println("Printing SuperArray mayfield post-insert...");
        System.out.println(mayfield);
    }//end main()

}//end class SuperArray
