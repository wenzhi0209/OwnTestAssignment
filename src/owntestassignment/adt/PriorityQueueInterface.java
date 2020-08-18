
public interface PriorityQueueInterface<T> { 
    public boolean contains(T element);
    public int size(); 
    public T peek();
    public T poll();
    public void add(T element);
    public boolean remove(T element);
    public boolean isEmpty();
    public void clear();
    public String toString();
}
