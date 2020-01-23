package myleetcode;
//力扣题191，直接法/消1小技巧统计
public class solve191
{

	public int hammingWeight(int n) {
		int bits = 0;
		int mask =1;
		for (int i=0;i<32;i++) {
			if ((n&mask)!=0) {
				bits++;
			}
			mask <<= 1;
		}
		return bits;
	}
	
	public int hammingWeight2(int n) {
		int sum = 0;
		while(n!=0) {
			sum++;
			n&=(n-1);
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int a = 00000000000000000000000000001011;
		
		solve191 numberOfBits = new solve191();
		int b = numberOfBits.hammingWeight(a);
		int c = numberOfBits.hammingWeight2(a);
		System.out.println("解法一：" + b);
		System.out.println("解法二：" + c);

	}

}
