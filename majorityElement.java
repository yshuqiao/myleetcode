package myleetcode;
//力扣169，求众数-多数元素（不是普通概念里的“众数”，而是指在数组中出现次数大于[n/2]的元素，且假定有且只有一个）
//此题可用暴力、哈希表、排序、分治等方法，这里用分治实现。
//时间复杂度为O(nlgn)，空间复杂度为O(lgn)
public class majorityElement
{
	private int countInRange(int[] nums,int num,int lo,int hi) {
		//子区间的左右指针lo和hi表示相应区间的左右下标
		int count = 0;
		for (int i = lo;i<=hi;i++) {
			if (nums[i] == num) {
				count++;
			}
		}
		return count;  //返回这个区间里num这种数值的数量
	}
	
	private int majorityElementec(int[] nums,int lo,int hi) {
		//base case;the only element in an array of size 1 is the majority element
		if (lo == hi) {
			return nums[lo];
		}
		//recurse on left and right halves of this slice.
		int mid = (hi-lo)/2 + lo;
		int left = majorityElementec(nums,lo,mid);
		int right = majorityElementec(nums,mid+1,hi);
		
		//if the two halvess agree on the majority element,return it.
		if (left == right) {
			return left;
		}
		
		//otherwise,count each element and return the "winner".
		int leftCount = countInRange(nums,left,lo,hi);
		int rightCount = countInRange(nums,right,lo,hi);
		
		return leftCount > rightCount ? left : right;
		
	}
	
	public int majorityElement(int[] nums) {
		return majorityElementec(nums,0,nums.length-1);
	}
	//以下是实例化
	public static void main(String[] args) {
		int[] nums= {3,2,3};
		majorityElement searchMajority = new majorityElement();
		int majority = searchMajority.majorityElement(nums);
		System.out.println(majority);
	}

}
