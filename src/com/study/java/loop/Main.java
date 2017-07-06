package com.study.java.loop;

public class Main {

	public static void main(String[] args) {
		loop2();
	}

	public static void loop1() {
		// 外层循环，并使用outer作为标签
		outer: for (int k = 0; k < 5; k++) {
			// 内层循环
			for (int m = 0; m < 5; m++) {
				System.out.println("k=" + k + ",m=" + m);
				if (m == 1) {
					// 此出outer标签所在循环，继续下次循环时continue语句跳
					continue outer;
					//break;
				}
			}
		}
	}

	public static void loop2() {
		// 外层循环，并使用outer作为标签
		outer: for (int k = 0; k < 5; k++) {
			// 内层循环
			for (int m = 0; m < 5; m++) {
				System.out.println("k=" + k + ",m=" + m);
				if (m == 2) { // 此时break语句跳出outer标签所在循环，即外层循环
					break outer;
				}
			}
			System.out.println(k);
		}
	System.out.println("dd");

	}

}
