package com.bgu.cse.mobile.programming.lec1.Composition.implemented;



import java.util.ArrayList;



public class Composite {
	public static StringBuffer indent = new StringBuffer();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting Composite");
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

interface AbstractFile{
	public void ls();
}

class File implements AbstractFile{

	private String name;

	public File (String name){
		this.name = name;
	}

	@Override
	public void ls() {
		System.out.println(Composite.indent+name);
	}
}

class Directory implements AbstractFile {
	private String name;
	private ArrayList files = new ArrayList();

	public Directory(String name) {
		this.name = name;
	}

	public void add(Object o){
		files.add(o);
	}

	@Override
	public void ls() {
		System.out.println(Composite.indent + name);
		Composite.indent.append("   ");
		for (Object current : files){
			AbstractFile file = (AbstractFile)current;
			file.ls();
		}
		Composite.indent.setLength(Composite.indent.length() - 3);
	}
}