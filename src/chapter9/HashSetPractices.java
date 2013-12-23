package chapter9;

import java.util.HashSet;
import java.util.Set;

/**
 * 老紫竹JAVA提高教程(2)-认识Set集合之HashSet。<br>
 * Set用来保存不允许重复的数据。可以是任何对象类型。<br>
 * JDK5以后，主类型可以通过autobox 放入Set里面。
 * 
 * @author 老紫竹 JAVA世纪网(java2000.net)
 * 
 */

public class HashSetPractices {
	public static void main(String[] args) {
		// 普通测试
		testNormal();
		// 测试HashSet的特殊性
		testForHashSet();
		testForHashSet2();
	}

	/**
	 * 测试保存混合类型的数据.
	 */
	public static void testNormal() {
		System.out.println("----- testNormal -----------");
		// Set有多个实现，我们先看看最常用的HashSet
		Set set = new HashSet();
		// 添加一个字符串
		set.add("字符串");
		// 添加一个整数对象
		set.add(new Integer(1));
		// 利用JDK5的特性，增加一个浮点数
		set.add(123.45);
		// 我们看看集合里对象的数量
		System.out.println(set.size());
		// 我们尝试增加一个重复的字符串
		set.add("字符串");
		// 我们再次看看集合里对象的数量
		System.out.println(set.size());
		// 我们来测试看看是否集合里包含了某个数据
		System.out.println(set.contains(123.45));
		// 我们从里面把这个浮点数删除
		set.remove(123.45);
		// 我们再次看看集合里对象的数量
		System.out.println(set.size());
	}

	/**
	 * 专门针对HashSet的测试。
	 */
	public static void testForHashSet() {
		System.out.println("----- testForHashSet -----------");
		HashSet<MyObject> set = new HashSet<MyObject>();
		// 增加一个null对象
		set.add(null);
		// 我们再次看看集合里对象的数量
		System.out.println(set.size());
		// 再次增加一个null看看
		set.add(null);
		// 我们再次看看集合里对象的数量
		System.out.println(set.size());
		MyObject obj = new MyObject("java2000", 2);
		set.add(obj);
		obj = new MyObject("csdn", 10);
		set.add(obj);
		// 我们再次看看集合里对象的数量
		System.out.println(set.size());
		// 判断是否包含某个对象
		System.out.println(set.contains(obj));
		obj = new MyObject("java2000_net", 2);
		set.add(obj);
		// 我们再次看看集合里对象的数量
		System.out.println(set.size());
		// 我们尝试把obj再次放入set看看
		// 并没有增加，因为是重复的
		set.add(obj);
		System.out.println(set.size());
		// 我们构造一个新的对象，内容和前面的相同
		obj = new MyObject("java2000_net", 2);
		set.add(obj);
		System.out.println(set.size());
		// 我们修改一下obj里面的年龄，再看看
		obj.setAge(3);
		// 我们再测试看看是否包含此对象。
		// 请注意，我们这个obj和前面的obj是同一个对象
		// 我们仅仅修改了一下我们的年龄
		System.out.println(set.contains(obj));
		// 我们尝试把obj再次放入set看看
		// 我们又增加了长度
		set.add(obj);
		System.out.println(set.size());
	}

	/**
	 * 专门针对HashSet的测试2。
	 */
	public static void testForHashSet2() {
		System.out.println("----- testForHashSet2 -----------");
		HashSet<MyObject2> set = new HashSet<MyObject2>();
		MyObject2 obj = null;
		for (int i = 0; i < 3; i++) {
			obj = new MyObject2("java2000" + i, i);
			set.add(obj);
			System.out.println(set.size());
		}
	}
}

class MyObject {
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	MyObject(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean equals(Object obj) {
		System.out.println("equals");
		if (obj == null || !(obj instanceof MyObject)) {
			return false;
		}
		MyObject o = (MyObject) obj;
		return this.age == o.age && this.name.equals(o.name);
	}

	public int hashCode() {
		int hashCode = name.hashCode() + String.valueOf(age).hashCode();
		return hashCode;
	}
}

class MyObject2 {
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	MyObject2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean equals(Object obj) {
		System.out.println("equals");
		if (obj == null || !(obj instanceof MyObject2)) {
			return false;
		}
		MyObject2 o = (MyObject2) obj;
		return this.age == o.age && this.name.equals(o.name);
	}

	public int hashCode() {
		return 1;
	}
}

class MyObject3 {
	private int age;
	private String name;
	// 采用一个变量进行控制
	// 一旦生成了hashCode,则不再变动
	private int HASHCODE = Integer.MIN_VALUE;

	public int hashCode() {
		if (HASHCODE == Integer.MIN_VALUE) {
			// 重新生成本类的hashCode
			HASHCODE = name.hashCode() + String.valueOf(age).hashCode();
		}
		return HASHCODE;
	}
}