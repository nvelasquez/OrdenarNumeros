import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SortingNumbers {
  
  //ordena los numeros de menor a mayor
  private static void sort(int a[], int c){
    for (int i = 1; i < c; i++){
      int count    = i;
      int newArray = a[i];
      
      while ((count > 0)&&(a[count - 1]> newArray)){
	a[count] = a[count - 1];
	count--;
      }
      a[count] = newArray;
    }
  }
  
  //redimensiona el array para no usar una dimension harcode.
  private static Object resizeArray (Object oldArray, int newSize) {
   int oldSize = java.lang.reflect.Array.getLength(oldArray);
   Class elementType = oldArray.getClass().getComponentType();
   Object newArray = java.lang.reflect.Array.newInstance(elementType, newSize);
   int preserveLength = Math.min(oldSize, newSize);
   
   if (preserveLength > 0){
      System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
   }
   return newArray; 
   }
  
  //Main: ejecuta los metodos de ordenar y redimensionar para pedir por pantalla y dar salida al nuevo array.
  public static void main (String[] args){
    
    //redimensionarArray red = new redimensionarArray();
    Console  con    = System.console();
    String   seguir = "S";
    int      pos    =0;
    int[]    in     = new int[pos+1];
    int	     i;
    
    System.out.println("ORGANIZADOR DE NUMEROS INGRESADOS POR TECLADO DE MENOR A MAYOR");
    
    while (seguir.equals("S")){
      
      System.out.println("Favor ingrese un numero: ");
      in[pos]  = Integer.parseInt(con.readLine());
      System.out.println("Desea ingresar otro numero S, N para parar ");
      seguir = con.readLine();
      seguir = seguir.toUpperCase();
      seguir.trim();
      pos++;
      in = (int[])resizeArray(in, (pos+1));
      //System.out.println("Dimension: "+in.length);
    }
    System.out.println();
    System.out.println("El orden en que se ingresaron");
    
    for (i = 0; i < in.length; i++){
      System.out.print(in[i]+" ");
    }
    System.out.println();
    System.out.println("De la manera que se ordenaron");
    
    sort(in, in.length);
    for (i = 0; i < in.length; i++){
      System.out.print(in[i]+" ");
    }
    System.out.println();
  }  
}