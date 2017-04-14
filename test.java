package lab4;

import java.util.Scanner;

class test {
  public static void main(String[] args) {
    int n;
 
    Scanner input = new Scanner(System.in);
    System.out.println("Input an integer"); 
    n = input.nextInt();
    while ((n) != 0) {
      System.out.println("You entered " + n);
      System.out.println("Input an integer");
    }
 
    System.out.println("Out of loop");
    int integer = Integer.MAX_VALUE;
    
  }
}