package myleetcode;

import myleetcode.mergeLists.ListNode;

//力扣题206,反转链表

public class reverseLinkedlist
{
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}
	
	public static class ListNode	
	//this method could be called when adding the 'static'
	{
	    int val;

	    ListNode next;

	    public ListNode(int x){

	        val=x;	
	    }	  	
	}
	
	public static void main(String[] args)
	{
		reverseLinkedlist reverseList = new reverseLinkedlist();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);   //make up linkedlist l1
		ListNode b = reverseList.reverseList(l1);
		System.out.println(b.val);
		
	}


}
