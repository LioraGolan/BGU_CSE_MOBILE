package com.bgu.cse.mobile.programming.lec1.Composition.notImplemented;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class NoComposite {

	public static StringBuffer g_indent = new StringBuffer();
	public static void main(String[] args) {
		System.out.println("Starting No Composite");
		Directory 	one = new Directory("Dir_one"), 
				two = new Directory("Dir_two"),
				three = new Directory("Dir_three");
		File 	a = new File("a"), 
				b = new File("b"), 
				c = new File("c"),
				d = new File("d"),
				e = new File("e");

		one.add(a);
		one.add(two);
		one.add(b);
		two.add(c);
		two.add(d);
		two.add(three);
		three.add(e);
		one.ls();
	}

}

class File{
	private String name;
	public File (String name){
		this.name = name;
	}
	public void ls(){
		System.out.println(NoComposite.g_indent+this.name);
	}
}

class Directory{
	private String name;
	private ArrayList files = new ArrayList();

	public Directory (String name){
		this.name = name;
	}

	public void add(Object o){
		this.files.add(o);
	}

	public void ls(){
		System.out.println(NoComposite.g_indent+this.name);
		NoComposite.g_indent.append("   ");
		for (Object current : this.files){
			/**
			 * The usage of instanceof is very bad practice in OOP  
			 */
			if (current instanceof File) {
				((File) current).ls();
			}else if (current instanceof Directory){
				((Directory) current).ls();
			}

		}
		NoComposite.g_indent.setLength(NoComposite.g_indent.length() - 3);
	}

}


