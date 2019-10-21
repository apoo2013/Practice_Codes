package com.java.hackerrank;

import java.util.List;

public class CompanyArrival 
{
	/*
     * Complete the 'maxEvents' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arrival
     *  2. INTEGER_ARRAY duration
     */

    public static int maxEvents(List<Integer> arrival, List<Integer> duration) 
    {
    	
    	int first = 0;
        
        //assuming the first event always gets selected
        int company = 1;
        
        //next set of events
        for(int j = 1; j < arrival.size(); j++)
        {
            //if the current event has start time greater than or equal to the finish time
            //of the previously selected event
            if(arrival.get(j) >= (duration.get(first) + arrival.get(first)))
            {
               first = j;
               company++; 
            }
        }
        return company;
    }

}
