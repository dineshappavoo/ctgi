/**
 * 
 */
package com.ctgi.google.implementation.linkedlist;


/**
 * @author Dinesh Appavoo
 *
 */
public class LinkedList {

	class Node{
		int key;
		int value;
		Node next;
		public Node(int key, int value, Node next)
		{
			this.key=key;
			this.value = value;
			this.next = next;
		}
	}

	Node first;
	int N;

	/**
	 * Method to insert a new node to the list
	 * @param key
	 * @param value
	 */
	public void insert(int key, int value)
	{
		for(Node x=first;x!=null;x=x.next)
		{
			if(x.key==key)
			{
				x.value=value;
				return;
			}
		}

		first=new Node(key,value,first);
		N++;
	}

	/**
	 * Method to look for an element in the list
	 * @param key
	 * @return
	 */
	public int lookup(int key)
	{
		Node x;
		int value;
		for(x=first;x!=null;x=x.next)
		{
			if(x.key==key)
			{
				value=x.value;
				return value;
			}
		}
		return -1;
	}

	/**
	 * Method to remove a node from the linked list
	 * @param key
	 * @return
	 */
	public int remove(int key)
	{
		int value;
		if (first == null) return -1;

		if (first.key==key) {
			if(first.next==null)
			{
				value= first.value;
				first = null;
			}else
			{
				value = first.value;
				first.key = first.next.key;
				first.value = first.next.value;
				first = first.next;
				N--;
			}	
			return value;
		}

		for(Node x=first;x.next!=null;x=x.next)
		{
			if(x.next.next==null)
			{
				if(x.next.key==key)
				{
					value = x.next.value;
					x.next = null;
					N--;
					return value;
				}
			}
			if(x.key==key)
			{
				value=x.value;
				x.key=x.next.key;
				x.value=x.next.value;
				x.next=x.next.next;
				N--;
				return value;
			}

		}


		return -1;
	}

	/**
	 * Method to get the size of the list
	 * @return
	 */
	public int size()
	{
		return N;
	}

	public void printList()
	{
		System.out.print("[");
		for(Node x=first;x!=null;x=x.next)
		{
			System.out.print(x.value);
			if(x.next!=null)
				System.out.print(",");
		}
		System.out.print("]\n");
	}

	/**
	 * Iterative reverse using another approach
	 */
	public void iterativeReverseAnother()
	{
		if(first==null||first.next==null)
			return;
		Node second = first.next;

		Node third = second.next;
		second.next=first;
		first.next=null;

		if(third == null)
		{
			first = second;
			return;
		}

		Node current = third;
		Node prev = second;

		while(current!=null)
		{
			Node next = current.next;
			current.next=prev;
			prev=current;
			current = next;
		}

		first=prev;
	}

	/**
	 * Iterative reverse Working 
	 */
	public void iterativeReverse()
	{
		Node current = first;
		Node reversedPart = null;
		Node next;
		while(current!=null)
		{
			next = current.next;
			current.next=reversedPart;
			reversedPart=current;
			current=next;
		}
		first= reversedPart;
	}

	/**
	 * Recursive reverse
	 */
	public void recursiveReverse()
	{
		recReverse(first);
	}

	public void recReverse(Node current)
	{
		if(current==null)
			return;
		if(current.next==null)
		{
			first=current;
			return;
		}

		recReverse(current.next);
		current.next.next=current;
		current.next=null;

	}

	public static void main(String args[])
	{
		LinkedList st = new LinkedList();

		// insert some key-value pairs
		st.insert(1,   1);
		st.remove(1);
		st.insert(5,   5);
		st.insert(6,   6);
		st.insert(7,   7);
		st.insert(8,   8);
		st.insert(9,   9);
		st.insert(10, 10);
		st.insert(11, 11);
		st.printList();

		// search for IP addresses given URL
		System.out.println("size = " + st.size());
		System.out.println("Lookup 1 is "+st.lookup(1));
		System.out.println("Lookup 5 is "+st.lookup(5));
		System.out.println("Lookup 6 is "+st.lookup(6));
		System.out.println();

		System.out.println("Deleting");
		System.out.println(st.remove(1));
		System.out.println(st.remove(6));
		st.printList();

		st.iterativeReverse();
		st.printList();

	}
}
