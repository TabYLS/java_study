package com.study.java.io.randomAccess;


/**
 *
 * @author 叶林生
 *
 * @date 2017年6月18日 上午12:12:58
 *
 * @version 1.0
 * 
 */
public class RandomFile {

	private FileSource source = null;
	private long pos = 0;//每个小文件的终止位置
	private static int threadID = 0;
	public RandomFile(FileSource source){
		this.source = source;
		threadID += 1;
	}
	public long getPos() {
		pos = (source.getFile_size() > source.EACH_PART_SIZE) ? threadID * source.EACH_PART_SIZE : (long)source.getFile_size() ;
		return pos;
	}
	public static int getThreadID() {
		return threadID;
	}
	
	/*public void setPos(int pos) {
		this.pos = pos * this.source.EACH_PART_SIZE;
	}*/
	
	
}
