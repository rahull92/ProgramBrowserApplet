/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package program.applet.browser;

import java.applet.*;
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;


/**
 *
 * @author A605
 */
public class ProgramApplet extends Applet {
int number=10;
    int ln=150;
    int amount=100;
    int total=ln*amount;
    int mas[]=new int[total];
    int bounds=10;
    int index=-1;
    Scanner scanner =new Scanner(System.in);
    Random random=new Random();
    String line=new String();
    String path=new String ("H:\\file.big data");
    String filepath=new String("H:\\myfile.big data");
    
    String str[]=new String[amount];
    int buf=0;
    
    
    
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
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
           index=-1;
        for(int i=0;i<amount;i++){
           for(int j=0;j<ln;j++){
        System.out.print(mas[++index]+" ");
        }
           System.out.println();
        }
        
        //сортировка массива 
        //Объявляем переменную buf
        int buf=0;
        
           boolean flag=true;
         
         
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
        /*
        
        //вывод массива на экран
        index=-1;
        System.out.println(" массив ");
        for(int i=0;i<amount;i++){
            for(int j=0;j<ln;j++){
        System.out.print(mas[++index]+" ");
        }
        }
        
        */
        
        //запись массива в файл
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
        catch(Exception e){}
        
        
                 
    }
    public void start(){
     try{}   
  
    catch(Exception e){}
    
    }
    @Override
    public void paint(Graphics g){
     try{
         FileReader freader=new FileReader(filepath);
         BufferedReader breader=new BufferedReader(freader);
         
         
         line=new String();
         int ind=0;
         while(line!=null){
         line=breader.readLine();
         if (line!=null)
         g.drawString(line,10,10+20*(++ind));
     }
         breader.close();
         freader.close();
         
     }
     catch(Exception e){}
    }
   
}
