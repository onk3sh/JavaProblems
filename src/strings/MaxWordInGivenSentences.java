package strings;

import java.io.*;
import java.util.*;


public class MaxWordInGivenSentences {
	 
    private int currentMaxCount = 0;
    private List<String> lines = new ArrayList<String>();
     
    public void readMaxLineCount(String sentences){
 
       
        try {
            
        	
                int sentenceCount=sentences.split(".").length;
                String[] arrSplit = sentences.split(".");
                for(int i=0;i<arrSplit.length;i++)
                {
                	System.out.println(arrSplit[i]);
                }
                int count = (sentences.split("\\s+")).length;
                /*if(count > currentMaxCount){
                    lines.clear();
                    lines.add(line);
                    currentMaxCount = count;
                } else if(count == currentMaxCount){
                    lines.add(line);*/
                } 
            
        
         catch (Exception e) {
            e.printStackTrace();
        } 
    }
 
    public int getCurrentMaxCount() {
        return currentMaxCount;
    }
 
    public void setCurrentMaxCount(int currentMaxCount) {
        this.currentMaxCount = currentMaxCount;
    }
 
    public List<String> getLines() {
        return lines;
    }
 
    public void setLines(List<String> lines) {
        this.lines = lines;
    }
     
    public static void main(String a[]){
         
        MaxWordInGivenSentences mdc = new MaxWordInGivenSentences();
        mdc.readMaxLineCount("true, false, and null might seem like keywords, but they are actually literals.\r\n" + 
        		"You cannot use them as identifiers in your programs. The servlet context\r\n" + 
        		"is an interface which helps to communicate with other servlets. It contains\r\n" + 
        		"information about the Web application and container. It is kind of\r\n" + 
        		"application environment. Using the context, a servlet can obtain URL\r\n" + 
        		"references to resources, and store attributes that other servlets in the\r\n" + 
        		"context can use.");
        System.out.println("Max number of words in a line is: "+mdc.getCurrentMaxCount());
        System.out.println("Line with max word count:");
        List<String> lines = mdc.getLines();
        for(String l:lines){
            System.out.println(l);
        }
    }
}
