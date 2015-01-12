
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Infix expression");
		String []infixExpr = (scanner.nextLine()).split(" ");		
		
		String []postfixExpr = Converter.getPostfixExpr(infixExpr);
		
		System.out.println("Infix expression");
		for(String str : infixExpr){
			System.out.print(str+" ");
		}		
		System.out.println();
		
		System.out.println("Postfix expression");
		for(String str : postfixExpr){
			System.out.print(str+" ");
		}
		
		scanner.close();
	}

}
