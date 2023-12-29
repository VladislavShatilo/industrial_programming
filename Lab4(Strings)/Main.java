package org.example;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        {
            try {
                FileReader reader=new FileReader("input.txt");
                Scanner scan= new Scanner(reader);
                FileWriter writer=new FileWriter("output.txt");
                String str=scan.nextLine();
                String separators=scan.nextLine();
                writer.write( str + "\nSeparators: "+ separators );
                StringWork stringWork=new StringWork(str,separators);
                String dates=stringWork.getDates();
                String num=stringWork.getNumbers();
                String lexemes=stringWork.getLexemes();
                writer.write("\nDate: "+ dates+"\nFloat: "+ num+"\nLexemes: "+lexemes+"\nNew string: "+ stringWork.getBaseString());
                scan.close();
                reader.close();
                writer.close();
            }
            catch(IOException e)
            {
                System.out.println("Error");
            }
        }
    }
}