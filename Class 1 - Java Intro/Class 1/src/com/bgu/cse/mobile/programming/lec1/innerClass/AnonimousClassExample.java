package com.bgu.cse.mobile.programming.lec1.innerClass;



public class AnonimousClassExample implements InnerClass{
	// create an array
	private final static int SIZE = 15;
	private int[] arrayOfInts = new int[SIZE];
	
	interface InnerEvenIterator {

		boolean hasNext();

		int getNext();
		
	}

	public AnonimousClassExample() {
		// fill the array with ascending integer values
		for (int i = 0; i < SIZE; i++) {
			arrayOfInts[i] = i;
		}
	}

	public EvenIterator evenIterator() {		
		
		// anonimous class
		return new EvenIterator() {
			// start stepping through the array from the beginning
			private int next = 0;

			public boolean hasNext() {
				// check if a current element is the last in the array
				return (next <= SIZE - 1);
			}

			public int getNext() {
				// record a value of an even index of the array
				int retValue = arrayOfInts[next];
				//get the next even element
				next += 2;
				return retValue;
			}			
		};		
	}

}
