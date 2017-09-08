/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first_project;
import java.util.*;
import  java.io.*;//File
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
class Art{
    Art(){System.out.println("Art");}
    void draw (String s){System.out.println("Art"+s);}
}

class Drawing extends Art{
    Drawing(){System.out.println("Drawing");}
    void draw (String s){System.out.println("Drawing"+s);}
}

class Cartoon extends Drawing{
    Cartoon(){System.out.println("Cartoon");}
    void draw (String s){System.out.println("Cartoon"+s);}
}


public class First_project {
    /**
     * @param args the command line arguments
     */
    
    static void merge(ArrayList a, ArrayList b) 
    {  
    ArrayList C = new ArrayList();

    for(int i = 0 ; i < b.size() ; i++)
        C.add(a.get(i));
    for(int i = 0 ; i < b.size() ; i++)
        C.add(b.get(i));
    
    Collections.sort(C);
    a = C;
    for(int i = 0 ; i < C.size() ; i++)
        System.out.println(a.get(i)); 
System.out.println(a); 
    // return (a);
    } 

    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("hello");
        System.out.println(new Date());
        Random rand=new Random(47);
        int a=1073741824;
        int b=1;
        int c=a*b;

    ArrayList A = new ArrayList();
    ArrayList B = new ArrayList();
    A.add(1);        
    A.add(3);        
    A.add(5);        
    A.add(7);        
         
    B.add(2);        
    B.add(4);        
    B.add(6);        
    B.add(8);        
        //

        //for (int i = 0; i<files.lenght;i++)
    System.out.println(A);
    System.out.println(B);
    merge(A,B);
    
    for(int i=0;i<A.size();i++)
        //for(int j=i;j<C.size();j++){
            System.out.println(A.get(i)); 
    System.out.println(A); 
   }    
}


