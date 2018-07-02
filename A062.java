package 算法6级;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Data structure for Min Heap
public class A062
{
 // return left child of A[i]
 private static int LEFT(int i) {
     return (2 * i + 1);
 }

 // return right child of A[i]
 private static int RIGHT(int i) {
     return (2 * i + 2);
 }

 // Recursive Heapify-down algorithm
 // the node at index i and its two direct children
 // violates the heap property
 private static void Heapify(int[] A, int i, int size)
 {
     // get left and right child of node at index i
     int left = LEFT(i);
     int right = RIGHT(i);

     int smallest = i;

     // compare A[i] with its left and right child
     // and find smallest value
     if (left < size && A[left] < A[i]) {
         smallest = left;
     }

     if (right < size && A[right] < A[smallest]) {
         smallest = right;
     }

     // swap with child having lesser value and
     // call heapify-down on the child
     if (smallest != i) {
         swap(A, i, smallest);
         Heapify(A, smallest, size);
     }
 }

 // Utility function to swap two indices in the array
 private static void swap(int[] A, int i, int j) {
     int temp = A[i];
     A[i] = A[j];
     A[j] = temp;
 }

 // Function to convert max heap to min heap
 public static void convert(int[] A)
 {
     // Build-Heap: Call heapify starting from last internal
     // node all the way upto the root node
     int i = (A.length - 2) / 2;
     while (i >= 0) {
         Heapify(A, i--, A.length);
     }
 }

 public static void main(String[] args)
 {
	 Scanner input = new Scanner(System.in);
	 ArrayList<Integer> array = new ArrayList<>();
	 String s = input.nextLine();
     String[] s1 = s.split(" ");//此处修改分隔符类型
     int[] A = new int[s1.length];
	 for(int i=0;i<s1.length;i++){
         A[i]=Integer.valueOf(s1[i]);
     }

     // build a min heap by initializing it by given array
     convert(A);

     // print the Min Heap
 /*
            -2

       1         5

     9    4      6      7     */

     System.out.println(Arrays.toString(A));
 }
}