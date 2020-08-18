/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.util.Iterator;

/**
 *
 * @author Chin Yew
 */
public class SortedArrayList<T extends Comparable<T>> implements SortedListInterface<T> {
    private T[] array;
    private int length;

    public SortedArrayList(int initialCapacity){
        length =0;
        array = (T[]) new Comparable[initialCapacity];
    }
   
    public boolean add(T newEntry){
        int i = 0;
        while(i<length && newEntry.compareTo(array[i])>0){ //newEntry is greater
            i++;
        }
        makeRoom(i+1);
        array[i] = newEntry;
        length++;
        return true;
    }
    
    public boolean contains(T anEntry){
        boolean found = false;
        for (int i=0; i<length;i++)
        {
            if(anEntry.equals(array[i]))
                found = true;
        }
        return found;
    }
    
    public void clear(){
        length = 0;
    }
    
    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }
    
    public boolean isFull(){
        return length == array.length;
    }
    
    private void makeRoom(int newPosition){
        int newIndex = newPosition -1;
        int lastIndex = length - 1; 
        
        for(int i=lastIndex; i>=newIndex;i--)
        {
            array[i+1]=array[i];
        }
    }
    
     public Iterator<T> getIterator() {
     return new SortedArrayIterator();
    }
  
    private class SortedArrayIterator implements Iterator<T> {
        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < length;
        }

        @Override
        public T next() {
            T currentElement = null;
            if (hasNext()) {
                currentElement = array[currentIndex];
                currentIndex++;
            }
        return currentElement;
        }
    
  }
    
}
