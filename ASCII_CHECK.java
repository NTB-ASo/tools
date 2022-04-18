// ASCII_CHECK.java                                        ASo 09.12.20 
// 

import java.io.*; 
import java.lang.*; 
import java.text.*; 
import java.util.*; 

public class ASCII_CHECK 
{ 
  static boolean eof = false; 
  static String asciiFile = " ";
  static String sumFile = " ";
  static int[] asciiarray = new int [256]; 
  static int more = 0; 
  static int less = 0; 
  static FileReader asciiReader; 
  static PrintWriter sumWriter; 

  public static void main(String[] args) throws IOException 
  { 
    int ch; 
    int index; 
    int i; 
    String hexstr = " ";

    if (args.length < 2) 
    { 
      System.out.println("ASCII_CHECK V1.0 ASo 2020"); 
      System.out.println("usage: java ASCII_CHECK asciiFile sumFile"); 
      System.exit(1); 
    } 
    else 
    { 
      asciiFile = args[0]; 
      sumFile = args[1]; 
    } 

    asciiReader = new FileReader(asciiFile); 
    sumWriter = new PrintWriter(new FileWriter(sumFile)); 

    while ((ch= asciiReader.read()) != -1) 
    { 
      index= ch; 
      if (index< 0) 
      { 
        less= less+ 1; 
      } 
      if (index< 256) 
      { 
        asciiarray[index] = asciiarray[index] + 1; 
      } 
      if (index>= 256) 
      { 
        more= more+ 1; 
      } 
    } 

    System.out.println( "ASCII_CHECK Vl. 0                 ASo 2020"); 
    sumWriter.printf("%-30s ASCII_CHECK Vl.0                      ASo 2020", asciiFile); 
    sumWriter.println(); 
    sumWriter.println(); 
    sumWriter.println("           0        1        2        3        4        5        6        7"); 
    sumWriter.println("           8        9        A        B        C        D        E        F");

    for (i = 0; i < asciiarray.length; i++) 
    { 
      if ((i % 8) == 0) 
      { 
        hexstr = Integer.toHexString(i).toUpperCase(); 
        sumWriter.printf(" %2s ", hexstr); 
      } 
      if ((i < 32) | (i >= 127)) 
      { 
        sumWriter.printf("   %5d ", asciiarray[i]); 
      }  
        else 
      { 
        sumWriter.printf(" %1s %5d ", ((char)i), asciiarray[i]); 
      } 
      if ((i % 8) == 7) 
      { 
        sumWriter.println(); 
      } 
    } 
    sumWriter.println(); 
    sumWriter.printf("Char lt 0: %d Char gt 255: %d", less, more); 
    sumWriter.println(); 
    sumWriter.close(); 
    asciiReader.close(); 
  } 
} 