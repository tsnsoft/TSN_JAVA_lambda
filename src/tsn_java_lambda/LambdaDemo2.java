package tsn_java_lambda;

@FunctionalInterface
interface IMyNumber {
	double getValue();
}

@FunctionalInterface
interface INumericTest {
	boolean test(int n);
}

@FunctionalInterface
interface INumericTest2<T, K> {
	K test(T n);
}

@FunctionalInterface
interface IStringFunct {
	String func (String n);
}

public class LambdaDemo2 {

	static String StringOP (IStringFunct sf, String s) {
		return sf.func(s);
	} 
	
	public static void main(String[] args) {
		IMyNumber myNum;

		myNum = () -> 123.45; 
		System.out.println(myNum.getValue());

		myNum = () -> Math.random() * 100;
		System.out.println(myNum.getValue());

		INumericTest isEven = (n) -> (n % 2) == 0;
		if (isEven.test(10)) System.out.println("Число 10 четное");
		if (!isEven.test(9)) System.out.println("Число 9 нечетное");

		INumericTest2<Integer, Boolean> isNonNeg = n -> n >= 0;
		if (isNonNeg.test(1)) System.out.println("Число 1 неотрицательное");
		if (!isNonNeg.test(-1)) System.out.println("Число -1 отрицательное");
		
		String inStr = "     Лямбда выражения - это круто!";
		System.out.println("Это исходная строка: " + inStr);

		String outStr;

		outStr = StringOP(s -> s.toUpperCase(), inStr);
		System.out.println("Это исходная строка в верхнем регистре: " + outStr);

		outStr = StringOP(s -> { String s2 = s.trim(); return s2.toLowerCase(); }, inStr);
		System.out.println("Это исходная строка в нижнем регистре без пробелов на концах: " + outStr);
	}

}
