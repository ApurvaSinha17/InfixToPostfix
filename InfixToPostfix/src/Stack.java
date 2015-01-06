
public class Stack {

	private static String[] operatorStack = new String[1];	
	private static String[] tempArray = null;
	private static int top = -1;
	
	private static void resizeStack(int newCapacity){
		
		tempArray = new String[newCapacity];
		for(int i=0;i<=top;i++)
			tempArray[i] = operatorStack[i];
		operatorStack = tempArray;
	}
	
	public static String peek(){
		
		return operatorStack[top];
	}
	
	public static void push(String str){
		
		if(top == operatorStack.length - 1)
			resizeStack(operatorStack.length * 2);
		operatorStack[++top] = str;
	}
	
	public static String pop(){
		
		if(top == -1){
			System.out.println("Empty Stack");
			System.exit(0);
		}
		
		if(top < operatorStack.length/4)
			resizeStack(operatorStack.length / 2);
		
		String str = operatorStack[top]; 
		operatorStack[top] = null;
		top--;
		return str;
	}
	
	public static int getTop(){
		
		return top;
	}
}
