

import java.util.Scanner;
import java.util.Stack;

class Postfix {
	
	void evaluate(String exp) {
		String str[] = exp.split(" ");
		int n = 0, l = str.length;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < l; i++) {
			try {
				n = Integer.parseInt(str[i]);
				stack.push(n);
			} catch (NumberFormatException e) {
				int v1 = stack.pop();
				int v2 = stack.pop();
				switch (str[i].charAt(0)) {
				case '+':
					n = v1 + v2;
					break;
				case '-':
					n = v2 - v1;
					break;
				case '*':
					n = v1 * v2;
					break;
				case '/':
					n = v2 / v1;
					break;

				}
				stack.push(n);
			}

		}
		System.out.println(stack.pop());
	}
}

class Stackdemo {

	public static void main(String[] args) {
		String exp;
		Scanner s = new Scanner(System.in);
		System.out.println("enter stringfor postfix nottion");
		exp = s.nextLine();
		Postfix p = new Postfix();
		p.evaluate(exp);

	}

}
