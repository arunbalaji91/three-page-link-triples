/*
 * HomeworkMapper.java
 * 
* Arunbalaji Sivakumar
 * SUID: 594227528
 * Homework#2
 * Created on Apr 20, 2015
 */

package org.sample;

import java.io.IOException;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.Text;

public class HomeworkMapper extends Mapper<Text,Text,Text,Text> {
  
	@Override
	protected void map(Text key, Text value, Context context)
	                throws IOException, InterruptedException {
		
	String  str1 = key.toString() + " " + value.toString() + ";T;";
	context.write(key, new Text(str1));
	
	String  str2 = key.toString() + " " + value.toString() + ";U;";
	context.write(value, new Text(str2));	
	}
}
