package com.example.webutils.demo.javageneral;

import sun.jvm.hotspot.oops.Array;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2019/2/27 3:08 PM
 */
public class StringJoinerTest {
	public static void main(String[] args) {
		// 1.
		StringJoiner sj = new StringJoiner("Hollis");    //当我们使用StringJoiner(CharSequence delimiter)初始化一个StringJoiner的时候，这个delimiter其实是分隔符，并不是可变字符串的初始值。

		sj.add("hollischuang");
		sj.add("Java干货");
		System.out.println(sj.toString());

		// 2.
		StringJoiner sj1 = new StringJoiner(":", "[", "]");
		sj1.add("Hollis").add("hollischuang").add("Java干货");
		System.out.println(sj1.toString());

		// 3.
		List<String> list = Arrays.asList("Hollis", "hollischuang", "Java干货");
		StringBuilder builder = new StringBuilder();
		if (!list.isEmpty()) {
			builder.append(list.get(0));
			for (int i = 1, n = list.size(); i < n; i++) {
				builder.append(",").append(list.get(i));
			}
		}
		System.out.println(builder.toString());

		// 4.
		String out = list.stream().reduce(new StringBuilder(), (sb, s) -> sb.append(s).append(','), StringBuilder::append).toString();
		System.out.println(out);

		// 5.
		System.out.println(list.stream().collect(Collectors.joining(":")));
		;
	}
}
