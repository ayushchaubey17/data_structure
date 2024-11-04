package heaps;

import java.util.ArrayList;

public class Heap {
    static ArrayList<Integer> heap = new ArrayList<>();

    public static void insert(int a) {
        heap.add(a);

        int childIndex = heap.size()-1;
        int parrentIndex = (childIndex-1)/2;

        while (childIndex>0 && heap.get(parrentIndex) < heap.get(childIndex)) {
            int temp = heap.get(parrentIndex);
            heap.set(parrentIndex, heap.get(childIndex));
            heap.set(childIndex, temp);

            childIndex = parrentIndex;
            parrentIndex = (childIndex - 1) / 2;
        }
    }


    public static int peek() {
        return heap.get(0);
    }


    public static int remove() {
        int lastIndex= heap.size()-1;
        int data = heap.get(0);
        heap.set(0, heap.get(lastIndex));

        heap.remove(lastIndex);

        heapify(0);
        return data;
    }

    private static void heapify(int i) {
        int minIndex = i;
        int leftChild = 2*i+1;
        int rightChild = 2 * i + 2;

        if (leftChild < heap.size() &&  heap.get(minIndex)<heap.get(leftChild)) minIndex= leftChild;
        if (rightChild  < heap.size() && heap.get(minIndex)<heap.get(rightChild)) minIndex = rightChild;

        if (minIndex != i) {

            int temp = heap.get(minIndex);
            heap.set(minIndex, heap.get(i));
            heap.set(i, temp);
            heapify(minIndex);
        }
    }

    public static void main(String[] args) {

        insert(12);
        insert(15);
        insert(20);
        insert(1);
        System.out.println(heap);

        while (!heap.isEmpty()) {
            System.out.println(remove());
        }


    }
}
