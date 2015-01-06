import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class Converter {
	
	private static ArrayList<String> postfixExpr = new ArrayList<String>();
	
	public static String[] getPostfixExpr(String[] infixExpr){
		
		for(String str : infixExpr){
			
			int precedence = getPrecendence(str);
			
			if(precedence == -1)
				postfixExpr.add(str);
			else
				conversion(str,precedence);
		}
		while(Stack.getTop() >= 0){
			postfixExpr.add(Stack.pop());
		}
		
		String [] strArray= new String[postfixExpr.size()];
		  postfixExpr.toArray(strArray);
				//Arrays.copyOf(postfixExpr.toArray(),postfixExpr.toArray().length,String[].class);
		
		return strArray;
	}
	
	private static void conversion(String str, int precedence){
		
		if(Stack.getTop() == -1)
			Stack.push(str);
		else if(str.equals(")")){
			
			while(!Stack.peek().equals("(")){
				
				String token = Stack.pop();
				postfixExpr.add(token);
			}
			Stack.pop();
		}							
		else{
			while( (Stack.getTop() >= 0) && (!Stack.peek().equals("(")) && (getPrecendence(Stack.peek()) >= precedence) ){
				String token = Stack.pop();
				postfixExpr.add(token);
			}
			Stack.push(str);
		}
	}
	
	private static int getPrecendence(String c){
		
		switch(c){
		
		case "(":
		case ")":
			return 4;
		case "^":
			return 3;
		case "*":
		case "/":
		case "%":
			return 2;
		case "+":
		case "-":
			return 1;
		default :
				return -1;
		}
	}
		
}
