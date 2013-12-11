// Ida Huang
// Period 8
// HW40
// 2013-12-10

// class TwoDimArray
// ...practice working with 2D arrays


public class TwoDimArray {

    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a ) {
	String retStr = ""; 

	//starts with each row
        for (int i = 0; i < a.length; i++){ 
	    //in the ith row, add each element in the jth column
	    for (int j = 0; j < a[i].length; j++){
		retStr = retStr + "[" + a[i][j] + "]" ;
	    }
	    retStr = retStr + "\n";
	}
	System.out.println(retStr);
    }


    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a ) { 
	String retStr = "";
        for (int[] i: a){ //for each row (i) int array of a
	    for (int j : i) {// for each element (int) j  in row array i
 		retStr = retStr + "[" + j + "]";
	    }
	    retStr = retStr + "\n";
	}
	System.out.println(retStr);
    }

    //postcond: returns sum of all items in 2D integer array a
    public static int sum1( int[][] a ) { 
	int sum = 0; 
	for (int[] i: a){
	    for (int j : i){
		sum += j;
	    }
	}
        return sum;
    }

    //postcond: returns sum of all items in 2D integer array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m ) { 
	int sum = 0;
	for (int i = 0; i < m.length; i++){
	    sum += sumRow(i,m);
	}
	return sum;
    }

    //postcond: returns sum of all items on row r of 2D integer array a
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a ) { 
	int sum = 0;
	for (int j = 0; j < a[r].length; j++){
	    sum += a[r][j];
	}
	return sum;
    }

    //postcond: returns sum of all items on row r of 2D integer array a
    //          uses a FOREACH loop
    public static int sumRow2(int r, int[][] m){ 
	int sum = 0;
	for (int j: m[r]){
	    sum += j;
	}
	return sum;
    }


    public static void main(String [] args) {
    
        int [][] m1 = new int[4][2];
        int [][] m2 = { {2,4,6}, {3,5,7} };
        int [][] m3 = { {2}, {4,6}, {1,3,5} };

	print1(m1);
        print1(m2);
	print1(m3);

        print2(m1);
        print2(m2);
        print2(m3);

        System.out.print("testing sum1...\n");
        System.out.println("sum m1 : " + sum1(m1));
        System.out.println("sum m2 : " + sum1(m2));
        System.out.println("sum m3 : " + sum1(m3));

        System.out.print("testing sum2...\n");
        System.out.println("sum m1 : " + sum2(m1));
        System.out.println("sum m2 : " + sum2(m2));
        System.out.println("sum m3 : " + sum2(m3));
      /*~~~~~~~~~~~~~~~~
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class TwoDimArray
