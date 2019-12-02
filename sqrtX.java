package myleetcode;
//力扣题69,求平方根
public class sqrtX
{
	//牛顿迭代法
	public int mySqrt(int a) {
		long x = a;
		while (x > a/x) {
			x = (x+x/a)/2;  //求解式
		}
		return (int)x;
	}
    
	//二分查找法
	public int mySqrtX(int x) {
		if (x == 1 || x == 0) {
			return x;
		}
		int start = 1;
		int end = x / 2 + 1;
		int mid = 0;
		while (start <= end) {
			mid = start +(end -start)/2;
			//防止越界
			if (mid <= x / mid &&(mid +1)>x/(mid+1)) {
				return mid;
			}
			if (mid>x/mid) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return mid;
	}
	
	public static void main(String[] args) {
		sqrtX mySqrtt = new sqrtX();
		int x =5;
		int a = mySqrtt.mySqrtX(x);
		System.out.println(a);
	}
}


