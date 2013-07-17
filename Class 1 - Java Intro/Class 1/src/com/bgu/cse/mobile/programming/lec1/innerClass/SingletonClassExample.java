package com.bgu.cse.mobile.programming.lec1.innerClass;


public class SingletonClassExample implements InnerClass{
	private static SingletonClassExample instace = null;
	// create an array
	private final static int SIZE = 15;
	private int[] arrayOfInts = new int[SIZE];

	//constructor
	private SingletonClassExample() {
		// fill the array with ascending integer values
		for (int i = 0; i < SIZE; i++) {
			arrayOfInts[i] = i;
		}
	}

	public static SingletonClassExample getInstance() {
		if (instace == null){
			synchronized(SingletonClassExample.class){
				if (instace == null){
					instace = new SingletonClassExample();
				}
			}
		}

		return instace;
	}

	@Override
	public EvenIterator evenIterator() {
		// recognize the next pattern?
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
