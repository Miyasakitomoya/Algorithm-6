package 算法6级;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// Data structure for Min Heap
public class A063
{
    // Function to sort a K-Sorted Array
    public static void sortKSortedArray(List<Integer> list, int k)
    {
        // create an empty min heap and insert first k+1 elements in the heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(list.subList(0, k+1));

        int index = 0;

        // do for remaining elements of the array
        for (int i = k + 1; i < list.size(); i++)
        {
            // pop top element from min-heap and assign it to
            // next available array index
            list.set(index++, pq.poll());

            // push next array element into min-heap
            pq.add(list.get(i));
        }

        // pop all remaining elements from the min heap and assign it to
        // next available array index
        while(!pq.isEmpty())
        {
            list.set(index++, pq.poll());
        }
    }


    public static void main(String[] args)
    {
    	 Scanner input = new Scanner(System.in);
         ArrayList<Integer> array = new ArrayList<>();
         String s = input.nextLine();
         String[] s1 = s.split(" ");//此处修改分隔符类型
         for (int i = 0; i < s1.length; i++) {
             array.add(Integer.valueOf(s1[i]));
         }
    	 int k = input.nextInt();
         sortKSortedArray(array, k);
         for(int j:array) {
        	 System.out.print(j+" ");
         }
    }
}
