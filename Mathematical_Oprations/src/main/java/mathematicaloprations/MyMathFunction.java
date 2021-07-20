package mathematicaloprations;

@FunctionalInterface
public interface MyMathFunction {
	int calculate(int a , int b);
	static void printResult(String operation,int a, int b, MyMathFunction function)
	{
		System.out.println("Result of "+a+" "+operation+" "+b+" is "+function.calculate(a,b));
	}
}
