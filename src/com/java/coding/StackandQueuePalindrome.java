/**
 * 
 */
package com.java.coding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * A palindrome is a word, phrase, number, or other sequence of characters which reads the same backwards and forwards.
 * Can you determine if a given string,s , is a palindrome?
 * we must first take each character in s, enqueue it in a queue, and also push that same character onto a stack. 
 * Once that's done, we must dequeue the first character from the queue and pop the top character off the stack, 
 * then compare the two characters to see if they are the same; 
 * as long as the characters match, we continue dequeueing, popping, 
 * and comparing each character until our containers are empty (a non-match means isn't a palindrome).
 * Write the following declarations and implementations: 
 * Two instance variables: one for your stack, and one for your .
 * A void pushCharacter(char ch) method that pushes a character onto a stack.
 * A void enqueueCharacter(char ch) method that enqueues a character in the queue instance variable.
 * A char popCharacter() method that pops and returns the character at the top of the stack instance variable.
 * A char dequeueCharacter() method that dequeues and returns the first character in the queue instance variable.
 *
 * @author apoorva
 */

public class StackandQueuePalindrome 
{
	Stack<Character> stk;
	Queue<Character> que;
	
	public StackandQueuePalindrome()
	{
		stk = new Stack<Character>();
		que = new LinkedList<Character>();
	}
	
	
	public void pushCharacter(char ch)
	{
		stk.push(ch);
	}
	
	public void enqueueCharacter(char ch) 
	{
		que.add(ch);
	}
	
	public char popCharacter()
	{
		return stk.pop();
	}
	
	public char dequeueCharacter()
	{
		return que.remove();
	}
	
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		
		char[] s = input.toCharArray();
		
		StackandQueuePalindrome p = new StackandQueuePalindrome();
		
		for(char c:s)
		{
			p.pushCharacter(c);
			p.enqueueCharacter(c);
		}
		
		boolean isPalindrome = true;
		
		for(int i = 0; i < s.length/2; i++)
		{
			if(p.popCharacter() != p.dequeueCharacter())
			{
				isPalindrome = false;
				break;
			}
		}
		
		System.out.println("The word, "+input+", is "+((!isPalindrome)?"not a Palindrome." : "a Palindrome."));
	}
}
