package com.study.java.io.readerWriter;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 
 * 模拟一个BufferedReader
 * 
 * 装饰模式： 装饰模式模式能做的事，用继承也能完成，但是继承有些时候会显得特别臃肿，因此新的思想就使用装饰模式
 * 
 * 装饰模式比继承要灵活。避免了继承体系臃肿。 而且降低了类于类之间的关系。
 * 装饰类因为增强已有对象，具备的功能和已有的是相同的，只不过提供了更强功能。 所以装饰类和被装饰类通常是都属于一个体系中的。
 * 
 * 
 * @author YLS
 *
 */
/*
   		演变解释：
		1.最开始每增加一个类如果需要缓冲技术就要衍生子类，导致体系臃肿（注意：这个体系功能上并没有问题，但是需要优化）：
		 MyReader//专门用于读取数据的类（超类）。
			|--MyTextReader
				|--MyBufferTextReader//衍生子类，扩展缓冲功能
			|--MyMediaReader
				|--MyBufferMediaReader
			|--MyDataReader
				|--MyBufferDataReader
		2.1思考：他们所用的都是同一种技术那就是缓冲技术，所以没必要全部都定义成单独的子类
		因此单独定义一个缓冲类，谁需要缓冲技术就把谁传进来
		class MyBufferReader
		{
			MyBufferReader(MyTextReader text)
			{}
			MyBufferReader(MyMediaReader media)
			{}
		}
		2.2上面这个类扩展性很差。
		找到其参数的共同类型。通过多态的形式。可以提高扩展性（使用超类作为参数）。
		class MyBufferReader
		{
			private MyReader r;
			MyBufferReader(MyReader r)
			{}
		}
		2.3注意：缓冲了Reader之后也是读取行为，只不过是更加强的读取行为，也应该是MyReader的子类
		class MyBufferReader extends MyReader
		{
			private MyReader r;
			MyBufferReader(MyReader r)
			{}
		}	
		
		3体系发生变化：装饰模式（设计模式是为了优化而存在的）
		MyReader//专门用于读取数据的类。
			|--MyTextReader
			|--MyMediaReader
			|--MyDataReader
			|--MyBufferReader
		
		
		以前是通过继承将每一个子类都具备缓冲功能。
		那么继承体系会复杂，并不利于扩展。
		
		现在优化思想。单独描述一下缓冲内容。
		将需要被缓冲的对象。传递进来。也就是，谁需要被缓冲，谁就作为参数传递给缓冲区。
		这样继承体系就变得很简单。优化了体系结构。
		
		
		装饰模式比继承要灵活。避免了继承体系臃肿。
		而且降低了类于类之间的关系。
		
		装饰类因为增强已有对象，具备的功能和已有的是相同的，只不过提供了更强功能。
		所以装饰类和被装饰类通常是都属于一个体系中的。 
 */
public class MyBufferedReaderDemo {
	
	public static void main(String[] args) {
		FileReader reader;
		try {
			reader = new FileReader(".\\src\\com\\study\\java\\io\\readerWriter\\MyBufferedReaderDemo.java");
			@SuppressWarnings("resource")
			MyBufferedReader myReader = new MyBufferedReader(reader);
			String line = null;
			while((line = myReader.myReadLine()) != null){
				System.out.println(line);
			}
			myReader.myClose();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class MyBufferedReader extends Reader {//扩展缓冲技术，但是任然属于Reader的体系

	private Reader reader;

	public MyBufferedReader(Reader reader) {
		this.reader = reader;
	}
	
	public String myReadLine(){
		//定义一个临时容器。原BufferReader封装的是字符数组。
		//为了演示方便。定义一个StringBuilder容器。因为最终还是要将数据变成字符串。
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		try {
			while((ch = this.reader.read()) != -1) {
				if (ch == '\r') 
					continue;
				if (ch == '\n')//读完一行
					return sb.toString();
				else
					sb.append((char)ch);
				
			}
			if (sb.length() != 0)//读完了全部内容
				return sb.toString();
			return null;//空文本
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		return this.reader.read(cbuf, off, len);
	}

	@Override
	public void close() throws IOException {
		this.reader.close();
	}
	
	public void myClose() throws IOException{
		this.reader.close();
	}

}
