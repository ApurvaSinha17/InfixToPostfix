
public class Stack {

	private static String[] originalArray = new String[1];	
	private static String[] tempArray = null;
	private static int top = -1;
	
	private static void resizeStack(int newCapacity){
		
		tempArray = new String[newCapacity];
		for(int i=0;i<=top;i++)
			tempArray[i] = originalArray[i];
		originalArray = tempArray;
	}
	
	public static String peek(){
		
		return originalArray[top];
	}
	
	public static void push(String str){
		
		if(top == originalArray.length - 1)
			resizeStack(originalArray.length * 2);
		originalArray[++top] = str;
	}
	
	public static String pop(){
		
		if(top == -1){
			System.out.println("Empty Stack");
			System.exit(0);
		}
		
		if(top < originalArray.length/4)
			resizeStack(originalArray.length / 2);
		
		String str = originalArray[top]; 
		originalArray[top] = null;
		top--;
		return str;
	}
	
	public static Boolean isEmpty(){
		
		return top == -1;
	}
}
