package myleetcode;


public class mergeLists
{	
	public static class ListNode	
	//this method could be called when adding the 'static'
	{
	    int val;
	
	    ListNode next;
	
	    public ListNode(int x){
	
	        val=x;	
	    }	  	
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //maintain an unchanging reference to node ahead of the return
        ListNode prehead = new ListNode(-1);  //-1 could be replace by any figure

        ListNode prev = prehead;  //prehead give its hand to prev,I think 
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point,so connect the non-null list to the end of the merged list.
        prev.next = l1 ==null ? l2 : l1; //if l1==null,prev.next=l2;else just prev.next=l1

        return prehead.next;
    
    }
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);   //make up linkedlist l1
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);   //make up linkedlist l2
		ListNode b = mergeTwoLists(l1,l2);
		System.out.println(b.next.next.next.next.next.val); 
		//try to print the last figure of the new merged linkedlist
		

	}

}
