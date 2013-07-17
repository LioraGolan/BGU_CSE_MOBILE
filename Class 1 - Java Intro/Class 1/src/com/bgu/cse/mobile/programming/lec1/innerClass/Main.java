package com.bgu.cse.mobile.programming.lec1.innerClass;


public class Main {
	
	public static void main(String[] args) {
		
		MemberClassExample memberClass = new MemberClassExample();
		System.out.println("Member class example");	
		printClassArray(memberClass);
		
		LocalClassExample localClass = new LocalClassExample();
		System.out.println("Local class example");	
		printClassArray(localClass);
		
		AnonimousClassExample anonimousClass = new AnonimousClassExample();
		System.out.println("Anonimous class example");	
		printClassArray(anonimousClass);
		
//		SingletonClassExample singletonClass = SingletonClassExample.getInstance();
//		System.out.println("Singleton class example");	
//		printClassArray(singletonClass);
//		
	}

	static void printClassArray (InnerClass innerClass){
		EvenIterator iter = innerClass.evenIterator();
		while (iter.hasNext()){
			System.out.println(iter.getNext());
		}
	}
}
