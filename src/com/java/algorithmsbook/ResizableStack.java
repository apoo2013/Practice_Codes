package com.java.algorithmsbook;

/**
 * @author apoorva
 *
 * Implement Resizable stack for a generic item 
 */
public class ResizableStack<Item>
{
    Item a[];
    int n;

    @SuppressWarnings("unchecked")
	public ResizableStack(int capacity)
    {
        a = (Item[])new Object[capacity];
    }

    public boolean isEmpty()
    {
        return n==0;
    }

    @SuppressWarnings("unchecked")
	private void resize(int max)
    {
        Item[] temp = (Item[])new Object[max];
        for(int i = 0; i < n; i++)
            temp[i] = a[i];
        a = temp;
    }

    public void push(Item item)
    {
        if(n == a.length)
           resize(2 * a.length);
        a[n++] = item;
    }

    public Item pop()
    {
        Item item = a[--n];
        a[n] = null; //to prevent loitering
        if(n > 0 && n == a.length/4)
            resize(a.length/2);
        return item;
    }
}
