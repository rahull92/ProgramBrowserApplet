/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package program.applet.browser;

import java.applet.Applet;
import java.util.Random;
import java.util.StringTokenizer;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.*;
import javax.swing.event.*;


/**
 *
 * @author A605
 */
public class ProgramApplet extends Applet {
    int number=0;
    int ln=10;
    int amount=10;
    int total=ln*amount;
    int mas[]=new int[total];
    int bounds=10;
    int index=-1;
    int buf=0;
    boolean flag=true;
    String line=new String();
    static String path=new String ("H:\\file.big data");
    static String filepath=new String("H:\\myfile.big data");
    Random random=new Random();
    
    
    
    
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     * Generates the file of randomig numbers with location path 
     * Sorts contents of this file
     * Writes results of this sorting
     * Outputs contents of sorting file
     * 
     */
    public void init() {
        try{
        FileReader fx=new FileReader(path);
        BufferedReader bx=new BufferedReader(fx);
        PrintWriter wx=new PrintWriter(path);
        for(int i=0;i<amount;i++){
        for(int j=0;j<ln;j++){   
        number=random.nextInt(bounds);
        line=Integer.toString(number)+" ";
        if (line!=null){
        wx.print(line);
        }
        
        }
        wx.println();
        }
        wx.close();
        
         index=-1;
        for(int i=0;i<amount;i++){
        line=bx.readLine();
        if (line!=null){
        StringTokenizer st=new StringTokenizer(line," ");    
        while(st.hasMoreTokens()){
        mas[++index]=Integer.parseInt(st.nextToken());
        }
        }
        }
        bx.close();
        
         while(flag){
         flag=false;
         for(int j=0;j<mas.length-1;j++){
         if(mas[j]>mas[j+1]){
         buf=mas[j];
         mas[j]=mas[j+1];
         mas[j+1]=buf;
         flag=true;
         }
         }
         }
        index=-1;
        PrintWriter pwr=new PrintWriter(filepath);
        for(int i=0;i<amount;i++){
        for(int j=0;j<ln;j++){   
        line=Integer.toString(mas[++index])+" ";
        if (line!=null){
        pwr.print(line);
        }
        
        }
        pwr.println();
        
        
        }
        pwr.close();
        }
        catch(FileNotFoundException e)
        {System.out.println("исключение FileNotFoundException ");}
        catch(IOException e)
        {System.out.println("исключение IOException");}
                   
    }
    
    /**
    * Outputs containig of file 
    * with location filepath
    * using drawString(String str,int x,int y)
    *  
    */
  
    @Override
    public void paint(Graphics g){
     try{
         FileReader freader=new FileReader(filepath);
         BufferedReader breader=new BufferedReader(freader);
         line=new String();
         int ind=0;
         while(line!=null){
         line=breader.readLine();
         if (line!=null) {
         g.drawString(line,10,10+20*(++ind));}
              
     }
         breader.close();
         freader.close();
         
     }
     catch(FileNotFoundException e)
     {System.out.println("исключение FileNotFoundException");}
     catch(IOException e)
     {System.out.println("исключение IOException");}
     
    }
   
}
