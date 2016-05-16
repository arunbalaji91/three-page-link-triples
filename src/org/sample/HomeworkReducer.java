/*
 * HomeworkReducer.java
 * 
 * Arunbalaji Sivakumar
 * SUID: 594227528
 * Homework#2
 * Created on Apr 20, 2015
 */

package org.sample;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

public class HomeworkReducer extends Reducer<Text,Text,Text,Text> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context)
                        throws IOException, InterruptedException {
    	
    	ArrayList<String> inputString = new ArrayList<String>();
    	ArrayList<String> outputString = new ArrayList<String>(); 
    	ArrayList<String> output = new ArrayList<String>(); 
    	 
    	for(Text value: values) 
    	{ 
    		String temp = new String(); 
    		temp = value.toString(); 
    		
    		inputString.add(temp); 
    		outputString.add(temp); 
    	}
    	
    	for(String value: inputString) 
    	{ 
    		String position[] = value.split(";"); 
    		String kString[] = position[0].split(" "); 
    		
    		for(String val: outputString) 
    		{
    			String splitString[] = val.split(";"); 
    			
    			if(!position[1].equals(splitString[1])) 
    			{
    				String keyVal[] = splitString[0].split(" "); 
    				
    				if(!kString[0].equals(keyVal[1]) && kString[1].equals(keyVal[0])) 
    				{
    					output.add(keyVal[1] + "," + keyVal[0]); 
    					output.add(kString[0]); 
    				}
    			}
    		}
    	} 
 	
    	ArrayList<String> outputKey = new ArrayList<String>(); 
    	ArrayList<String> outputValue = new ArrayList<String>(); 
    	ArrayList<Integer> extraVal = new ArrayList<Integer>(); 
    	
    	for(int i = 0; i < output.size(); i = i+2) 
    	{ 
    		boolean flag = false; 
    		
    		for(int j = 0; j < extraVal.size(); j++) 
    		{
    			if(i == extraVal.get(j)) 
    				flag = true; 
    		} 
    		
    		if(flag)
    			continue; 
    		
    		else
    		{
    			outputKey.add(output.get(i));
    			outputValue.add(output.get(i+1));
    			
    			for(int k = i+2; k < output.size(); k = k+2)
    			{
    				if(output.get(i).equals(output.get(k)) && !output.get(i+1).equals(output.get(k+1)))
    				{
    					int index = outputValue.size()-1;
    					String str = outputValue.get(index);
    					str = str + "," + output.get(k+1);
    					outputValue.set(index, str);
    					extraVal.add(k);
    				}
    			}
    		}
    	}
    	
    	for(int i = 0; i < outputKey.size(); i++) 
    	{
    		context.write(new Text(outputKey.get(i)), new Text(outputValue.get(i)));    		
    	}    	
    }
 }