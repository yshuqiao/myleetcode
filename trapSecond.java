package myleetcode;
//力扣题42. 接雨水
import java.util.Stack;

public class trapSecond
{
	public int trap6(int[] height) {
	    int sum = 0;
	    Stack<Integer> stack = new Stack<>();
	    int current = 0;
	    while (current < height.length) {
	        //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
	        while (!stack.empty() && height[current] > height[stack.peek()]) {
	            int h = height[stack.peek()]; //取出要出栈的元素
	            stack.pop(); //出栈
	            if (stack.empty()) { // 栈空就出去
	                break; 
	            }
	            int distance = current - stack.peek() - 1; //两堵墙之前的距离。
	            int min = Math.min(height[stack.peek()], height[current]);
	            sum = sum + distance * (min - h);
	        }
	        stack.push(current); //当前指向的墙入栈
	        current++; //指针后移
	    }
	    return sum;
	}
	
	public static void main(String[] args)
	{
		trapSecond trap = new trapSecond();  
		//notice here，about how to call the other methods in the same class
		//i.e. firstly create an object of the class("new") 
		int[] trapping = {0,1,0,2,1,0,1,3,2,1};
		int b = trap.trap6(trapping);
		System.out.println(b);

	}

}
