package com.study.java.io.encoding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author 叶林生
 *
 * @date 2017年6月17日 下午4:53:16
 *
 * @version 1.0
 * 
 */
/**
 * 有五个学生，每个学生有3门课的成绩， 
 * 从键盘输入以上数据（包括姓名，三门课成绩）， 
 * 输入的格式：如：zhagnsan，30，40，60计算出总成绩，
 * 并把学生的信息和计算出的总分数高低顺序存放在磁盘文件"stud.txt"中。
 * 
 * zhangsan,23,12,56
lisi,45,89,76
wangwu,56,89,90
zhaoliu,78,90,99
lisi,90,43,43
exit

 */
public class StudentInfoTest {
	public static void main(String[] args) {
		Comparator<StudentInfo> cmp = Collections.reverseOrder();
		Set<StudentInfo> students = StudentInfoTool.getStudents(cmp);
		StudentInfoTool.writeFile(students);
	}
}

class StudentInfoTool{
	
	public static Set<StudentInfo> getStudents()
	{
		return getStudents(null);
	}
	
	public static Set<StudentInfo> getStudents(Comparator<StudentInfo> cmp){
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		Set<StudentInfo> studens = null;
		if(cmp==null)
			studens = new TreeSet<StudentInfo>();
		else
			studens = new TreeSet<StudentInfo>(cmp);
		try {
			while((line = bufr.readLine()) != null){
				if (line.equals("exit"))
					break;
				String[] info = line.split(",");
				StudentInfo student = new StudentInfo(info[0], Integer.valueOf(info[1]), Integer.valueOf(info[2]), Integer.valueOf(info[3]));
				studens.add(student);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return studens;
	}
	
	public static void writeFile(Set<StudentInfo> stus){
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(".\\src\\com\\study\\java\\io\\encoding\\stuInfo.txt"));
			for (StudentInfo studentInfo : stus) {
				writer.write(studentInfo.toString()+"\t");
				writer.write(studentInfo.getSum()+"");
				writer.newLine();
				writer.flush();
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	} 
}

class StudentInfo implements Comparable<StudentInfo> {
	
	private String name;
	private int ma, cn, en;
	private int sum;
	
	public StudentInfo(String name, int ma, int cn, int en) {
		this.name = name;
		this.ma = ma;
		this.cn = cn;
		this.en = en;
	}

	@Override
	public int compareTo(StudentInfo o) {
		int num = new Integer(this.sum).compareTo(new Integer(o.sum));
		if(num==0)
			return this.name.compareTo(o.name);
		return num;
		
	}
	@Override
	public String toString() {
		return "StudentInfo [name=" + name + ", ma=" + ma + ", cn=" + cn
				+ ", en=" + en + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof StudentInfo)) 
			throw new ClassCastException("类型不匹配！");
		StudentInfo student = (StudentInfo)obj;
		return this.name.equals(student.name) && this.sum == student.sum;
	}

	public int getSum() {
		sum = this.ma + this.en + this.cn;
		return sum;
	}
	
}
