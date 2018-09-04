package com.java.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Crossword 
{
	static final int SIZE = 10;
	static final int[] R_OFFSETS = {0, 1};
	static final int[] C_OFFSETS = {1, 0};
	
	static final String PATTERN = "^[+-]+$";

	static boolean validateString(String input)
	{
		return Pattern.matches(PATTERN, input);
	}
	
    static char[][] crosswordPuzzle(String[] crossword, String twords) 
    {
    	String[] words = twords.split(";");
    	char[][] grid = new char[SIZE][SIZE];
    	
    	for(int i = 0; i < SIZE; i++)
    	{
    		String line = crossword[i];
    		for(int j = 0; j < line.length(); j++)
    		{
    			grid[i][j] = line.charAt(j);
    		}
    	}
    	return search(grid, Arrays.stream(words).collect(Collectors.toSet()), 0, 0, 0);
    }

    static char[][] search(char[][] grid, Set<String> rwords, int r, int c, int dir)
    {
    	if(r == SIZE)
    		return grid;
    	if(c == SIZE)
    		return search(grid, rwords, r+1, 0, 0);
    	
    	if(dir == R_OFFSETS.length)
    		return search(grid, rwords, r, c+1, 0);
    	
    	int insertLen = countInsertLength(grid, r, c, dir);
    	
    	if(insertLen > 1)
    	{
    		for(String rw : new ArrayList<>(rwords))
    		{
    			if(canInsert(grid, r, c, dir, insertLen, rw))
    			{
    				List<Integer> insertOffsets = new ArrayList<Integer>();
    				
    				for(int ins = 0; ins < insertLen; ins++)
    				{
    					int insertR = r + R_OFFSETS[dir] * ins;
        				int insertC = c + C_OFFSETS[dir] * ins;
        				
        				if(grid[insertR][insertC] == '-')
        				{
        					grid[insertR][insertC] = rw.charAt(ins);
        					
        					insertOffsets.add(ins);
        				}
    				}
    				rwords.remove(rw);
    				char[][] subResult = search(grid, rwords, r, c, dir+1);
    				
    				if(subResult != null)
    					return subResult;
    				
    				rwords.add(rw);
    				for(int ins : insertOffsets)
    				{
    					int insertR = r + R_OFFSETS[dir] * ins;
        				int insertC = c + C_OFFSETS[dir] * ins;
        				
        				grid[insertR][insertC] = '-';
        				
    				}
    			}
    		}
    		return null;
    	}
    	else
    		return search(grid, rwords, r, c, dir+1);
    }
    
    static int countInsertLength(char[][] grid, int r, int c, int dir)
    {
    	int prevR = r - R_OFFSETS[dir];
    	int prevC = c - C_OFFSETS[dir];
    	if(prevR >= 0 && prevR < SIZE)
    	{
    		if(prevC >= 0 && prevC < SIZE)
    		{
    			if(grid[prevR][prevC] != '+')
    				return 0;
    		}
    	}
    	
    	int insertLen = 0;
    	while(r >= 0 && r < SIZE && c >= 0 && c < SIZE && grid[r][c] != '+')
    	{
    		insertLen++;
    		
    		r += R_OFFSETS[dir];
    		c += C_OFFSETS[dir];
    	}
    	
    	return insertLen;
    }
    
    static boolean canInsert(char[][] grid, int r, int c, int dir, int insLen, String word)
    {
    	return word.length() == insLen && IntStream.range(0, word.length()).allMatch(insertOffset -> {
    				int insertR = r + R_OFFSETS[dir] * insertOffset;
    				int insertC = c + C_OFFSETS[dir] * insertOffset;
    				
    				return grid[insertR][insertC] == '-' || grid[insertR][insertC] == word.charAt(insertOffset);
    			});
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] crossword = new String[10];

        for (int i = 0; i < 10; i++)
        {
            String crosswordItem = scanner.nextLine();
            crossword[i] = crosswordItem;
        }

        String words = scanner.nextLine();

        char[][]result = crosswordPuzzle(crossword, words);

        for (int i = 0; i < result.length; i++)
        {
        	for(int j = 0; j < result.length; j++)
        	{
        		bufferedWriter.write(result[i][j]);
        		
        		   if (j != result.length - 1)
                   {
                       bufferedWriter.write("\n");
                   }

        	}
        	 bufferedWriter.newLine();
         }
        bufferedWriter.close();

        scanner.close();
    }
}
