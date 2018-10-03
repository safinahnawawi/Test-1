//*
 //ITT786 Network Programming
 
package openwritebin;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class OpenWriteBin {

    public static void main(String[] args) throws IOException {
        //Open A.csv File
        //file to open
        File file = new File("/Users/User/Desktop/Test1/A.csv");
        
        //check if Desktop is supported by Platform or not
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }
        
        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) desktop.open(file);
        
        // Read A.csv and write to B.txt in reverse order
        ArrayList<String> revFile = new ArrayList<>();

        File sourceFile=new File("/Users/User/Desktop/Test1/A.csv");
        PrintStream ps;
        try (Scanner content = new Scanner(sourceFile)) {
            ps = new PrintStream(new File("/Users/User/Desktop/Test1/B.txt"));
            while (content.hasNextLine()){
                revFile.add(content.nextLine()); 
            }
            for(int i = (revFile.size()-1); i >=0 ; i--){
                String ar[]=revFile.get(i).split(" ");
                
                for(int j = (ar.length-1); j >=0; j--){
                    
                    
                    
                    System.setOut(ps);
                    System.out.println(ar[j--] + " ");
                    
                }
                
                System.out.println(" ");
                ar=null;
            }
        }
            ps.close();
            System.out.println(" ");
       //Write B.txt into C.bin 
        StringBuilder sb = new StringBuilder();
        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream("/Users/User/Desktop/Test1/B.txt"))) {
        PrintStream pt = new PrintStream(new File("/Users/User/Desktop/Test1/C.BIN"));
        
        for (int b; (b = is.read()) != -1;) {
            String s = "0000000" + Integer.toBinaryString(b);
            s = s.substring(s.length() - 8); 
            sb.append(s).append(' ');
            }
            //sb.append(s).append(' ');
            System.setOut(pt);
            System.out.println(sb);
    }

    }
}
