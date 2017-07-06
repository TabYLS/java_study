package com.study.java.util.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
* @author 叶林生 
* @date：2017年7月3日 下午8:17:03
* @version 1.0
* 
*/


/**
 * 练习：
"sdfgzxcvasdfxcvdf"获取该字符串中的字母出现的次数。

希望打印结果：a(1)c(2).....

通过结果发现，每一个字母都有对应的次数。
说明字母和次数之间都有映射关系。

注意了，当发现有映射关系时，可以选择map集合。
因为map集合中存放就是映射关系。


什么使用map集合呢？
当数据之间存在这映射关系时，就要先想map集合。

思路：
1，将字符串转换成字符数组。因为要对每一个字母进行操作。

2，定义一个map集合，因为打印结果的字母有顺序，所以使用treemap集合。

3，遍历字符数组。
	将每一个字母作为键去查map集合。
	如果返回null，将该字母和1存入到map集合中。
	如果返回不是null，说明该字母在map集合已经存在并有对应次数。
	那么就获取该次数并进行自增。，然后将该字母和自增后的次数存入到map集合中。覆盖调用原理键所对应的值。

4，将map集合中的数据变成指定的字符串形式返回。

 * @author YLS
 *
 */
public class TreeMapCountWord {
	
	public static void main(String[] args) {
		String source = "aaaadddeeeff12433fsss";
		TreeMap<Character, Integer> map = charCount(source);
		String result = mapToString(map);
		System.out.println(result);
	}
	
	public static TreeMap<Character, Integer> charCount(String source) {
		TreeMap<Character, Integer> tm = new TreeMap<>();
		char[] arr = source.toCharArray();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!('a' <= arr[i] && arr[i] >= 'z' || 'A' <= arr[i] && arr[i] >= 'Z'))
				continue;
			Character key = arr[i];
			Integer value = tm.get(arr[i]);
			
			if(value != null)
				count = value;
			count += 1;
			tm.put(key, count);
			count = 0;
			/*
			 * 这段代码不够优化
			 * if (value == null) {
				tm.put(key, 1);
			} else {
				tm.put(key, ++value);
			}*/
			
		}
		return tm;
	}
	
	public static String mapToString(Map<Character, Integer> map) {
		Set<Map.Entry<Character, Integer>> entry = map.entrySet();
		Iterator<Map.Entry<Character, Integer>> it = entry.iterator();
		StringBuilder sb = new StringBuilder();
		while (it.hasNext()) {
			Map.Entry<Character, Integer> me = it.next();
			sb.append(me.getKey() + "(" + me.getValue() + ")");
		}
		return sb.toString();
	}

}
