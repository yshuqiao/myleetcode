package myleetcode;
//力扣题189. 旋转数组
public class rotateArray
{
	public void rotate(int[] nums, int k) {
		k = k % nums.length;   //int[] nums = {1,2,3,4,5,6,7};
		int count = 0;
		for (int start = 0; count < nums.length; start++) {  //start=0,
			int current = start;   //current=0,
			int prev = nums[start];  //prev=1,
			do {
				int next = (current + k) % nums.length; //next=3,6,2(9除以7余2),5,1,4,0;
				int temp = nums[next];   //temp=4,7,3,6,2,5,1;
				nums[next] = prev;    //nums[3]=1,nums[6]=4,num[2]=7,num[5]=3,nums[1]=6,num[4]=2,nums[0]=5;
				prev = temp;    //prev=4,7,3,6,2,5,1;
				current = next;  //current=3,6,2,5,1,4,0;
				count++;   //count=1,2,3,4,5,6,7;
			}while (start != current);
			
		}
	
	}

}




