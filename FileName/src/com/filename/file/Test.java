package com.filename.file;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String string= "aaa*ccc";
		
		System.out.println(string.replaceAll("[*]","123"));
		
		string = "aacaaa.java";
		
		System.out.println(string.substring(string.lastIndexOf("."),string.length()));
		
		System.out.println(String.valueOf(10));
		
		System.out.println(string.lastIndexOf("."));
				
		System.out.println(string.substring(string.indexOf("c"), string.indexOf(".")+1));
		
	}

}
