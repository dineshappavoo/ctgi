/**
 * 
 */
package com.ctgi.google.problems.implementation.linkedlist;


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

	public int remove(int key)
	{
		int value;
		if (first == null) return -1;

		if (first.key==key) {
			value = first.value;
			first = first.next;
			N--;
			return value;
		}

		for(Node x=first;x.next!=null;x=x.next)
		{
			if(x.key==key)
			{
				value=x.value;
				x.key=x.next.key;
				x.value=x.next.value;
				N--;
				return value;
			}
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
		}


		return -1;
	}

	public int size()
	{
		return N;
	}

	public void reverse()
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

	public void recReverse()
	{
		recursiveReverse(first);
	}

	public void recursiveReverse(Node current)
	{
		if(current==null)
			return;
		if(current.next==null)
		{
			first=current;
			return;
		}

		recursiveReverse(current.next);
		current.next.next=current;
		current.next=null;

	}

	public static void main(String args[])
	{

		LinkedList st = new LinkedList();

		// insert some key-value pairs
		st.insert(1,   324);
		st.insert(5,   4324);
		st.insert(6,   324);
		st.insert(7,   4324);
		st.insert(8,   324);
		st.insert(9,   4324);
		st.insert(10,   324);
		st.insert(11,   4324);


		// search for IP addresses given URL
		System.out.println("size = " + st.size());
		System.out.println(st.lookup(1));
		System.out.println(st.lookup(5));
		System.out.println(st.lookup(6));
		System.out.println();

		// test out the iterator
		//for (String s : st) 
		//  System.out.println(s);


		// print out all key-value pairs
		//for (String s : st)
		//  System.out.println(s + " " + st.get(s));
		System.out.println();

		System.out.println("Deleting");
		System.out.println(st.remove(1));
		System.out.println(st.remove(6));
		
		st.reverse();

	}
}
