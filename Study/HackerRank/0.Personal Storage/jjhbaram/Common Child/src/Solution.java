import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
    static int commonChild(String s1, String s2){
        // Complete this function
        boolean debugPrint = false;
        
    	int maxLength = 0;
        
        int strLen = s1.length()+1;
        int [][] lengthMat = new int[strLen][strLen];        
        
        for(int i = 1 ; i < strLen; i++)
        {
        	int length = lengthMat[i-1][0];
        	
        	for(int j = 1 ; j < strLen; j++)
        	{
        		if(s1.charAt(i-1) == s2.charAt(j-1))
        		{
        			length = lengthMat[i-1][j-1] + 1;
        		}
        		else
        		{
        			length = length > lengthMat[i-1][j] ? length : lengthMat[i-1][j];
        		}
        		
        		lengthMat[i][j] = length;
        	}
        	maxLength = maxLength > length ? maxLength : length;
        }   
        
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = commonChild(s1, s2);
        System.out.println(result);
        in.close();
    }
}
