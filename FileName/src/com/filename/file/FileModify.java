package com.filename.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileModify {
	
	private static String[] names;
	
	//private static File[] files;
	
	private static String pathname;
	
	private static String endType ;
	
	private static List<String> list_newName = new ArrayList<String>();	
	
	public static List<String> Modify(File file,String rule,String str,int start,int end,int length) {
		
		names = file.list();
		
		//files = file.listFiles();
		
 		pathname = file.getPath();
 		
 		int templen = end-start>names.length?names.length:end-start;
 		
		for (int i = start; i < templen;i++) {
			//获取每个文件的文件后缀名
			endType = names[i].toString().substring(names[i].lastIndexOf("."),names[i].length());
			//以新的文件名在当前目录下新建文件，
			File newfile = new File(pathname + "\\" + rule.replaceAll("["+str+"]", String.valueOf(i*length))+endType);					
			//得到新文件的文件名		
			list_newName.add(newfile.getName());
					
		}		
		
		return list_newName;
	}
	
	public static List<String> Modify(File file,String rule,String str,String start,String end) {
		
		String string = "abcdefrgijklmnopqrstuvwxyz";
		
		String nameString = string.substring(string.indexOf(start), string.indexOf(end)+1);
		
		names = file.list();
		
		//files = file.listFiles();
		
		pathname = file.getPath();
		
		int templen = nameString.length()>names.length?names.length:nameString.length();				
			
 		for (int i = 0; i < templen; i++) {
 			//获取每个文件的文件后缀名
 			endType = names[i].toString().substring(names[i].lastIndexOf("."),names[i].length());
			//以新的文件名在当前目录下新建文件
			File newfile = new File(pathname + "\\" + rule.replaceAll("["+str+"]", nameString.substring(i, i+1))+endType);					
			//得到新文件的文件名
			list_newName.add(newfile.getName());
 		}
		
		return list_newName;
	}
	
	
	
	
	
}
