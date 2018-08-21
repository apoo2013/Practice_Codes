package com.java.algorithmsbook;

import java.util.Iterator;

/**
 * @author apoorva
 *
 * Implementing Queue using LinkedLists and Iterator
 */
public class Queue<Item> implements Iterable<Item>
{
    private Node first;
    private Node last;
    private int n;

    private class Node
    {
        Item item;
        Node next;
    }

    @Override
    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }

    public boolean isEmpty()
    {
        return n == 0;
    }

    public int size()
    {
        return n;
    }

    public void enqueue(Item item)
    {
        Node oldlast  = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty())
            first = last;
        else
            oldlast.next = last;
        n++;
    }

    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        n--;
        if(isEmpty())
            last = null;
        return item;
    }
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext()
        {
            return current != null;
        }
        public void remove()
        {
            //
        }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;

        }
    }
}
