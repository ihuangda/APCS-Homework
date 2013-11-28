// Ida Huang
// Period 8
// HW32
// 2013-11-25

/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

/*==================================================
  the Breakdown:
  The fastest way to guess a random number is to reduce the range by half with each guess. 
  The ranging keeps getting divided by two until you reach a range where there is not value between the _lo and _hi. 
  This turns into an equation of when 2^x will surpass the n, given that n is _hi of the original range. 
  Once 2^x > n, then this means that it's either of the endpoints values and you've already guessed one of them. 
  Maximum it will take you an x + 1 guesses if you guess the wrong one at first. 

  What is the max # of guesses if num is b/t 1&100? 8
  What is the max # go guesses if num is b/t 1&200? 9 
  What is the max # of guesses if num is b/t 1&400? 10
  What is the max # of guesses if num is b/t 1&1000? 11
  What is the max # of guesses if num is b/t 1&n? (x + 1) provided that 2^x > n

  ==================================================*/

// Need to import the Keyboard functions to be used later 
import cs1.Keyboard; 

public class GuessNumber {

    //instance vars
    private int _lo, _hi, _guessCtr, _target;

    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) {
	if (a > b){int temp = a; a = b; b = temp;} 
	//determine the correct _lo and _hi variable
	_lo = a;
	_hi=b;
 	_guessCtr = 1;
	_target = (int) ((b-a)* Math.random() + a);
    }

    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:
      post:
      ==================================================*/
    public void playRec() {
	System.out.print("Guess a number from " + _lo + "-" + _hi + ": ");
	int input = Keyboard.readInt();
	_guessCtr++; // if an input is read then _guessCtr is updated
	if (input != _target) { //if you don't guess correct then run body
	    if (input > _target) {
		System.out.println("Too high, try again...");
		if (input < _hi) _hi = input; 
		// if the input is less than upper bound, but greater than target, see new upper bound 
	    }
	    else {
		System.out.println("Too low, try again...");
		if (input > _lo) _lo = input;
		// if the input is greater than the lower bound but less than the target, then set new lower bound
	    }
	    playRec(); //if you're in this if loop, then you haven't guess correctly so run playRec() again.
	}
	// if outside the if loop, guessed correctly so print out number of guesses it took
	String guess;
	if (_guessCtr == 1) guess = " guess."; // you only made 1 guess!
	else guess = " guesses.";
	System.out.println("Correct! It took " + _guessCtr + guess);
    }

    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:
      post:
      ==================================================*/
    public void playIter() {
        while (true){ // this is always true unless you guess correctly --> break out of loop
	    System.out.print("Guess a number from " + _lo + "-" + _hi + ": ");
	    int input = Keyboard.readInt();
	    if (input == _target) { // correct guessing print _guessCtr
		String guess;
		if (_guessCtr == 1) guess = " guess.";
		else guess = " guesses.";
		System.out.println("Correct! It took " + _guessCtr + guess);
		break; // exists while loop because guess == _target
	    }
	    if (input > _target) {
		System.out.println("Too high, try again...");
		if (input < _hi) _hi = input; //update _hi: upper bound
	    }
	    else {
		System.out.println("Too low, try again...");
	    	if (input > _lo) _lo = input; // update _lo: lower bound
	    }
	    _guessCtr++; // update guessCtr after every run through the while loop
	}
    }

    //wrapper for playRec/playIter to simplify calling
    public void play() {
        //use one or the other below:
        //playRec();
        playIter();
    }

    //main method to run it all
    public static void main( String[] args ) {

        //instantiate a new game
        GuessNumber g = new GuessNumber(1,100);

        //start the game
        g.play();
    }


    /*==================================================
      _ _(_) --
      pre:
      post:
      ==================================================*/
}//end class
