import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class PriorityQueue<T extends Comparable<T>> implements PriorityQueueInterface<T> {

    private List<T> heap = null;
    private int heapSize = 0;
    private int heapCapacity = 5;
    
    public PriorityQueue() {
        heap = new ArrayList<T>(heapCapacity);
    }

    public PriorityQueue(int capacity) {
        heap = new ArrayList<T>(capacity);
    }

    public PriorityQueue(T[] elements) {
        heapSize = heapCapacity = elements.length;
        heap = new ArrayList<T>(heapCapacity);
        
        for (int i = 0; i < heapSize; i++) {
              heap.add(elements[i]);
         }
        
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--)
            sink(i);
    }

    public PriorityQueue(Collection<T> elements) {
        heapSize = heapCapacity = elements.size();
        heap = new ArrayList<T>(elements.size());
        for (T each : elements) add(each);
    }

    public boolean contains(T element) {
        if (element == null) 
            return false;

        for(int i = 0; i < heapSize; i++)
            if (heap.get(i).equals(element))
                return true;
        
        return false;
    }

    public int size() {
        return heapSize;
    }

    public T peek() {
        if (isEmpty()) 
            return null;
        
        return heap.get(0);
    }

    public T poll() {
        return removeAt(0);
    }

    public void add(T element) {
        if (element == null) 
            throw new IllegalArgumentException();

        if (heapSize < heapCapacity)
            heap.set(heapSize, element);
        
        else {
            heap.add(element);
            heapCapacity++;
        }

        swim(heapSize);
        heapSize++;
    }

    public boolean remove(T element) {
        if (element == null)
            return false;

        for (int i = 0; i < heapSize; i++) {
            if (heap.get(i).equals(element)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    private T removeAt(int i) {
        if (isEmpty()) 
            return null;

        heapSize--;
        T removed_data = heap.get(i);
        swap(i, heapSize);
        heap.set(heapSize, null);

        if (i == heapSize) 
            return removed_data;

        T element = heap.get(i);
        sink(i);

        if (heap.get(i).equals(element)) 
            swim(i);

        return removed_data;
    }

    private boolean lessEqual(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);
        return node1.compareTo(node2) <= 0;
    }

    private void swim(int k) {
        int parent = (k - 1) / 2;

        while (k > 0 && lessEqual(k, parent)) {
            swap(parent, k);
            k = parent;
            parent = (k - 1) / 2;
        }
    }

    private void sink(int k) {
        int heapSize = size();

        while (true) {
            int left = 2 * k + 1; 
            int right = 2 * k + 2; 
            int smallest = left; 

            if (right < heapSize && lessEqual(right, left)) 
                smallest = right;

            if (left >= heapSize || lessEqual(k, smallest)) 
                break;

            swap(smallest, k);
            k = smallest;
        }
    }

    private void swap(int i, int j) {
        T i_elem = heap.get(i);
        T j_elem = heap.get(j);

        heap.set(i, j_elem);
        heap.set(j, i_elem);
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public void clear() {
        for (int i = 0; i < heapCapacity; i++)
            heap.set(i, null);
        heapSize = 0;     
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}

