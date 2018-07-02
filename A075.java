package À„∑®6º∂;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Nod implements Comparable<Object>{
    private int value;
    private int listNum;
    private int index;
    Nod(int value, int listNum, int index) {
        this.value = value;
        this.listNum = listNum;
        this.index = index;
    }
    public int getValue() {
        return value;
    }
    public int getListNum() {
        return listNum;
    }
    public int getIndex() {
        return index;
    }
    public int compareTo(Object o) {
        Nod node = (Nod)o;
        return value - node.value;
    }
};

class Pair<U,V> {
    private final U first;
    private final V second;
    Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
    public U getFirst() {
        return first;
    }
    public V getSecond() {
        return second;
    }
}

public class A075{
    public static Pair<Integer, Integer> findMinimumRange(List<List<Integer>> list){
        int high = Integer.MIN_VALUE;
        Pair<Integer, Integer> p = new Pair<Integer, Integer>(0, Integer.MAX_VALUE);
        PriorityQueue<Nod> pq = new PriorityQueue<>();
        for (int i = 0; i < list.size(); i++){
            pq.add(new Nod(list.get(i).get(0), i, 0));
            high = Integer.max(high, list.get(i).get(0));
        }
        while (true) {
            Nod top = pq.poll();
            int low = top.getValue();
            int i = top.getListNum();
            int j = top.getIndex();
            if (high - low < p.getSecond() - p.getFirst()) {
                p = new Pair<Integer, Integer>(low, high);
            }
            if (j == list.get(i).size() - 1) {
                return p;
            }
            pq.add(new Nod(list.get(i).get(j + 1), i, j + 1));
            high = Integer.max(high, list.get(i).get(j + 1));
        }
    }

    public static void main(String[] args){
        List<List<Integer>> list = Arrays.asList(
                                        Arrays.asList(3, 6, 8, 10, 15),
                                        Arrays.asList(1, 5, 12),
                                        Arrays.asList(4, 8, 15, 16),
                                        Arrays.asList(2, 6)
                                    );

        Pair<Integer, Integer> p = findMinimumRange(list);
        System.out.println(p.getFirst() +" " + p.getSecond());
    }
}
