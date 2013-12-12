// Ida Huang
// Period 8
// HW42
// 2013-12-11

/*=====================================
  class CandidatePool -- 

  Each CandidatePool object contains the following
  instance variables that you may need to use:
       
  pool
      An ArrayList of only Candidate objects


  You will need to write the following methods:
   
  getCandidatesForPosition( String pos )
      Returns a candidate-only ArrayList containing all
      the Candidates in pool that have position pos.

  getBestCandidate( String pos )
      Returns the Candidte in pool that matches position
      pos with the highest score.
      If there are no candidates for the given position, 
      returns null.

  removeCandidatesForPosition( String pos )
      Removes all the Candidates in the pool that match
      position pos.
      Returns number of candidates removed.
  =====================================*/

//We usually leave this out because Java does this automatically:
import java.io.*; 
//...but this is not automatically performed (util pkg contains ArrayList):
import java.util.*;


public class CandidatePool {
    
    //=================================
    //DO NOT MODIFY THIS CODE BLOCK
    ArrayList<Candidate> pool;
    
    public CandidatePool() {
	pool = new ArrayList<Candidate>();
    }

    public void addCandidate( Candidate c ) {
	pool.add(c);
    }

    public String toString() {
	return pool.toString();
    }    
    //=================================



    //YOUR WORK BELOW:
    public ArrayList<Candidate> getCandidatesForPosition( String pos ) {
	ArrayList <Candidate> samepos = new ArrayList <Candidate>();
	for (Candidate i: pool){
	    if (i.getPosition().equals(pos)) {
		samepos.add(i);
	    }
	}
	return samepos;
    }


    public Candidate getBestCandidate( String pos ) { 

	ArrayList <Candidate> samepos = this.getCandidatesForPosition(pos);
	Candidate best = null;
	if (samepos.size() == 0) return best;

	double current = 0; //stores the current best score
	for (Candidate i: samepos) {
	    double temp = i.getInterviewScore(); //stores Candidate i's score
	    if (current < temp ){
		current = temp;
		best = i;
	    }
	}
	return best;
    }


    public int removeCandidatesForPosition( String pos ) {
	int counter = 0;
	ArrayList <Candidate> samepos = this.getCandidatesForPosition(pos);
	int stop = samepos.size(); //this is the number of candidates that should be removed
	
	ArrayList <Candidate> removed = new ArrayList <Candidate>() ; //create a replica of pool you can change while iterating through pool
	for (Candidate i : pool) {
	    if (!(i.getPosition().equals(pos))) {
		removed.add(i);
	    }
	    else { counter++; }
	    if (counter == stop){ //if you removed the all candidates necessary, do not continue cycling through pool
		pool = removed;
		return counter;
	    }
	}
	pool = removed;
	return counter;
    }


}//end class CandidatePool

    
