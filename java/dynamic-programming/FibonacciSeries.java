//Program to print first 'n' fibonacci series 

import java.util.Scanner;

public class FibonacciSeries{
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.println("Enter the number of elements for series: ");

      int n = sc.nextInt();

      for(int i=0; i<n; i++)
      System.out.println((i+1) + ": " + generate_fibonacci(i));
      
   }

   public static int generate_fibonacci(int n){
      if(n == 0 || n == 1){
         return n;
      }

      return generate_fibonacci(n-1) + generate_fibonacci(n-2);
   }
}