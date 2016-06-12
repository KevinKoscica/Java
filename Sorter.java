/* 
Date:    6/1/2016   
The purpose of this program is to Sort a list using the quicksort and mergesort algorithms.
Author:
Kevin Koscica
*/
import java.util.*;
public class Sorter{

    private int length;
    private Comparable[] c;
  


   public static void swapReferences(Object [] a, int index1, int index2){
   Object tmp=a[index1];
   a[index1]=a[index2];
   a[index2]=tmp;  
   }
   public void quicksort(Comparable[] list, int start, int stop){
     if(start>=stop){
     return; //base case list of 0 or 1 elements
     }
     
     int pivotIndex=(start+stop)/2;
     // Place pivot at start position
     swapReferences(list,pivotIndex,start);
     Comparable pivot=list[start];
     // Begin partitioning
     int i,j=start;
     // from first to j are elements less than or equal to pivot     
     // from j to i are elements greater than pivot 
      // elements beyond i have not been checked yet
      for(i=start+1;i<=stop;i++){
      //is current element less than or equal to pivot
         if(list[i].compareTo (pivot)<=0){
            j++;
            swapReferences(list,i,j);
            }
      }
      //restore pivot to correct spot
      swapReferences(list,start,j);
      quicksort(list,start,j-1);
      quicksort(list,j+1,stop);
      
   }
   /*end quicksort code, begin mergsort*/
   
   /**  * perform a merge sort on the data in c  * @param c c != null, all elements of c  * are the same data type  */
   
   public static void mergeSort(Comparable[] c){
      Comparable[] temp=new Comparable[c.length];
      sort(c,temp,0,c.length-1);
      }
   
   private static void sort(Comparable[] list, Comparable[] temp,int low, int high){
      if(low<high){
         int center=(low+high)/2;
         sort(list,temp,low,center);
         sort(list,temp,center+1,high);
         merge(list,temp,low,center+1,high);
        }
        }
  private static void merge(Comparable[] list, Comparable[] temp, int leftPos, int rightPos, int rightEnd){
   int leftEnd= rightPos-1;
   int tempPos= leftPos;
   int numElements=rightEnd-leftPos+1;
   //main loop
   while(leftPos<=leftEnd&& rightPos<=rightEnd){
      if(list[leftPos].compareTo(list[rightPos])<=0){
         temp[tempPos]=list[leftPos];
         leftPos++;
         }
      else{
         temp[tempPos]=list[rightPos];
         rightPos++;
         }
     tempPos++;
   }
   //copy rest of left half
   
   while(leftPos<=leftEnd){
      temp[tempPos]=list[leftPos];
      tempPos++;
      leftPos++;
      }
   //copy rest of right half
   
   while(rightPos<=rightEnd){
      temp[tempPos]=list[rightPos];
      tempPos++;
      rightPos++;
      }
   //copy temp back into list
   for(int i=0;i<numElements;i++, rightEnd--){
      list[rightEnd]= temp[rightEnd];
      }
 }  
    
   public static void main(String[] args){
   //creates the list
     Comparable[] list={44,68,191,119,119,
                       37,83,82,191,45,
                       158,130,76,153,39,26};
                       
     System.out.println("The data in this list before sorting is: " );
     for(Comparable i:list){
      System.out.print(i);
      System.out.print(" ");
      }
      System.out.println();
                       
    Sorter sort=new Sorter();
   
    sort.quicksort(list,0,list.length-1);
    //prints out the quicksorted list
    System.out.println("The data in this list after quicksorting is: ");
    for(Comparable i:list){
            System.out.print(i);
            System.out.print(" ");

   }
   System.out.println();   
   //end quick sort, begin merge sort for new data set.
   
  Comparable[] c={38,27,43,3,9,82,10};
     System.out.println("The data in this list before sorting is: " );
     for(Comparable j:c){
      System.out.print(j);
      System.out.print(" ");
      }
      System.out.println();
  sort.mergeSort(c);
  System.out.println("The data in this list after merge sorting is: ");
   for(Comparable j:c){
      System.out.print(j);
      System.out.print(" ");
}
}
}