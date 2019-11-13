package myleetcode;

public class runCode
{

	public static void main(String[] args)
	{
		removeDuplicates s1 = new removeDuplicates();
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		int counts = s1.removeDuplicates(nums);
		System.out.println(counts);

	}

}
