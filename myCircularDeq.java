package myleetcode;

import myleetcode.myCircularDeq.MyCircularDeque;

public class myCircularDeq
{

	public static void main(String[] args)
	{
		MyCircularDeque circularDeque = new myCircularDeq().new MyCircularDeque(3);
		
		circularDeque.insertLast(1);			        // 返回 true
		circularDeque.insertLast(2);			        // 返回 true
		circularDeque.insertFront(3);			        // 返回 true
		circularDeque.insertFront(4);			        // 已经满了，返回 false
		int tosee = circularDeque.getRear();  				// 返回 2
		boolean trueorFalse = circularDeque.isFull();				        // 返回 true
		circularDeque.deleteLast();			        // 返回 true
		circularDeque.insertFront(4);			        // 返回 true
		circularDeque.getFront();				// 返回 4
    	System.out.println(tosee);
    	System.out.println(trueorFalse);

	}
	
	class MyCircularDeque {
	    private int size;
	    private int lastIndex;
	    private MyCircularDequeNode node;

	    /**
	     * Initialize your data structure here. Set the size of the deque to be k.
	     */
	    public MyCircularDeque(int k) {
	        this.size = k;
	    }

	    /**
	     * Adds an item at the front of Deque. Return true if the operation is successful.
	     */
	    public boolean insertFront(int value) {
	        if (lastIndex < size) {
	            MyCircularDequeNode node = new MyCircularDequeNode(value);
	            if (this.node == null) {
	                this.node = node;
	                lastIndex ++;
	            } else {
	                this.node.prev = node; //put the new value to the front of the linkedlist
	                node.next = this.node;
	                this.node = node;
	                lastIndex++;
	            }
	            return true;
	        } else {
	            return false;
	        }
	    }

	    /**
	     * Adds an item at the rear of Deque. Return true if the operation is successful.
	     */
	    public boolean insertLast(int value) {
	        if (lastIndex < size) {
	            MyCircularDequeNode node = new MyCircularDequeNode(value);
	            if (this.node == null) {
	                this.node = node;
	                lastIndex ++;
	            } else {
	                MyCircularDequeNode oNode = this.node;  //oNode is the original linkedlist head
	                while (oNode.next != null) {
	                    oNode = oNode.next; //find the last element of the original linkedlist 
	                }
	                oNode.next = node;
	                node.prev = oNode;   //set the original linkedlist as the front
	                lastIndex++;
	            }
	            return true;
	        } else {
	            return false;
	        }
	    }

	    /**
	     * Deletes an item from the front of Deque. Return true if the operation is successful.
	     */
	    public boolean deleteFront() {
	        if (this.node == null) {
	            return false;
	        } else {
	            MyCircularDequeNode next = this.node.next;
	            if (next == null) {
	                this.node = null;
	                lastIndex--;
	                return true;
	            } else {
	                next.prev = null;  //delete the front item of the linkedlist
	                this.node = next;
	                lastIndex--;
	                return true;
	            }
	        }
	    }

	    /**
	     * Deletes an item from the rear of Deque. Return true if the operation is successful.
	     */
	    public boolean deleteLast() {
	        if (this.node == null) {
	            return false;
	        } else {
	            MyCircularDequeNode next = this.node;
	            while (next.next != null) {
	                next = next.next;
	            }
	            MyCircularDequeNode prev = next.prev;
	            if (prev != null) {
	                prev.next = null;
	            } else {
	                this.node = null;
	            }
	            lastIndex--;
	            return true;
	        }
	    }

	    /**
	     * Get the front item from the deque.
	     */
	    public int getFront() {
	        if (this.node == null) {
	            return -1;
	        } else {
	            return this.node.val;
	        }
	    }

	    /**
	     * Get the last item from the deque.
	     */
	    public int getRear() {
	        if (this.node == null) {
	            return -1;
	        } else {
	            MyCircularDequeNode next = this.node;
	            while (next.next != null) {
	                next = next.next;
	            }
	            return next.val;
	        }
	    }

	    /**
	     * Checks whether the circular deque is empty or not.
	     */
	    public boolean isEmpty() {
	        return lastIndex == 0;
	    }

	    /**
	     * Checks whether the circular deque is full or not.
	     */
	    public boolean isFull() {
	        return lastIndex == size;
	    }

//	    private static class MyCircularDequeNode{
	    private class MyCircularDequeNode{
	        int val;
	        MyCircularDequeNode prev;
	        MyCircularDequeNode next;

	        public MyCircularDequeNode(int val) {
	            this.val = val;
	        }
	    }
	    
	  
//	    	MyCircularDequeNode dequeNode = new MyCircularDequeNode(-1);
//	    	dequeNode.next = new MyCircularDequeNode(0);
//	    	dequeNode.next.next = new MyCircularDequeNode(1);
	    	
	    

	}

}
