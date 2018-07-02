package À„∑®6º∂;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// A class for heap NNNN
class NNNN implements Comparable
{
    // value stores the element
    private int value;

    private int i;

    // index stores column number of the list from which
    // element was taken
    private int index;

    // Constructor
    public NNNN(int value, int i, int index) {
        this.value = value;
        this.i = i;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public int getListNum() {
        return i;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        NNNN NNNN = (NNNN)o;
        return value - NNNN.value;
    }
};

public class A076
{
    // Function to merge M sorted lists of variable length and
    // print them in ascending order
    public static void printSorted(List<List<Integer>> list)
    {
        // create an empty min-heap
        PriorityQueue<NNNN> pq = new PriorityQueue<NNNN>();

        // push first element of each list into the min-heap
        // along with list number and their index in the list
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() >= 1) {
                pq.add(new NNNN(list.get(i).get(0), i, 0));
            }
        }

        // run till min-heap is not empty
        while (!pq.isEmpty())
        {
            // extract minimum NNNN from the min-heap
            NNNN min = pq.poll();

            // print the minimum element
            System.out.print(min.getValue() + " ");

            // take next element from "same" list and insert it into the
            // min-heap
            if (min.getIndex() + 1 < list.get(min.getListNum()).size())
            {
                min.setIndex(min.getIndex() + 1);
                min.setValue(list.get(min.getListNum()).get(min.getIndex()));
                pq.add(min);
            }
        }
    }

    public static void main(String[] args)
    {
        List<List<Integer>> list = Arrays.asList(
                                        Arrays.asList(10, 20, 30, 40),
                                        Arrays.asList(15, 25, 35),
                                        Arrays.asList(27, 29, 37, 48, 93),
                                        Arrays.asList(32, 33)
                                    );

        printSorted(list);
    }
}

