package com.study.java.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 过滤某个目录下面的.java后缀的文件
 */
public class FilterFile {

	/*public static void main(String[] args) throws IOException {
		File file = new File("test.txt");
		file.canExecute();
		file.createNewFile();
		File temp = File.createTempFile("aa_", "bb");
		temp.deleteOnExit();//退出的时候删除
		
		String string = File.separator;
		
	}*/
	
	public static void main(String[] args) {
		File file = new File(".\\src\\com\\study\\java\\io\\inOutPutStream\\");
		String[] strFiles = file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				
				return name.endsWith(".txt");
			}
		});
		for (String str_file : strFiles) {
			System.out.println(str_file);
		}
		
	}
	
}
