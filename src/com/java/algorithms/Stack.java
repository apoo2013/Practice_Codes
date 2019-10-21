package com.java.algorithms;

import java.util.Iterator;

/**
 * @author apoorva
 *
 * Implement stack using Linked Lists and Iterator
 */

public class Stack<Item> implements Iterable<Item>
{
    private Node first;
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

    public void push(Item item)
    {
        Node old_first = first;
        first = new Node();
        first.item = item;
        first.next = old_first;
        n++;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        n--;
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

