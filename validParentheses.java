package myleetcode;
import java.util.HashMap;
//力扣题20，有效的括号，用栈的方法
//时间复杂度：O(n)，一次只遍历给定的字符串中的一个字符并在栈上进行O(1)的推入和弹出操作
//空间复杂度：O(n),当所有的开括号都推到栈上时以及在最糟糕的情况下，要把所有的括号都推到栈上，例如((((((((((
import java.util.Stack;
public class validParentheses
{
	//Hash table that takes care of the mappings.
	private HashMap<Character,Character> mappings;
	
	//Initialize hash map with mappings. This simply makes the code easier to read.
	public validParentheses() {    //notice!The constructor must be the same name of the class!
		this.mappings = new HashMap<Character,Character>();
		this.mappings.put(')','(');
		this.mappings.put('}','{');
		this.mappings.put(']','['); //左括号为键值(containsKey)，右括号为值(get)
		
	}
	
	public boolean isValid(String s) {
		
		//Iniitialize a stack to be used in the algorithm.
		Stack<Character> stack = new Stack<Character>();
		
		for (int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			
			//If the current character is a closing bracket.
			if (this.mappings.containsKey(c)) {
				
				//Get the top element of the stack.If the stack is empty,set a dummy value of '#'
				char topElement = stack.empty() ? '#' :stack.pop();
				
				//If the mapping for this bracket doesn't match the stack's element.return false.
				if (topElement != this.mappings.get(c)) {
					return false;
				}
			} else {
					//If it was an opening bracket,push to the stack.
					stack.push(c);
			}
			
		}
		//If the stack still contains elements,then it is an valid expression.
		return stack.isEmpty();
	}
	
	public static void main(String[] args)
	{
		validParentheses heses = new validParentheses();
		String s = "()[[{}]]";
		boolean validornot = heses.isValid(s);
		System.out.println(validornot);
	}

}
