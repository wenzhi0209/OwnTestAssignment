/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;


/**
 *
 * @author Winnie wong
 */
public class ArrayList<T> implements ListInterface<T> {

  private T[] arr;
  private int length;
  private static final int DEFAULT_CAPACITY = 100;

  public ArrayList() {
    this(DEFAULT_CAPACITY);
  }

  public ArrayList(int initialCapacity) {
    length = 0;
    arr = (T[]) new Object[initialCapacity];
  }

  @Override
  public boolean add(T newEntry) {
    arr[length] = newEntry;
    length++;
    return true;
  }

  public boolean add(int newPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= length + 1)) {
      if (!isArrayFull()) {
        makeRoom(newPosition);
        arr[newPosition - 1] = newEntry;
        length++;
      }
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  public T remove(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      result = arr[givenPosition - 1];

      if (givenPosition < length) {
        removeGap(givenPosition);
      }

      length--;
    }

    return result;
  }

  public void clear() {
    length = 0;
  }

  public boolean replace(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      arr[givenPosition - 1] = newEntry;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      result = arr[givenPosition - 1];
    }

    return result;
  }

  public boolean contains(T anEntry) {
    boolean found = false;
    for (int index = 0; !found && (index < length); index++) {
      if (anEntry.equals(arr[index])) {
        found = true;
      }
    }

    return found;
  }

  public int getLength() {
    return length;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public boolean isFull() {
    return false;
  }

  public String toString() {
    String outputStr = "";
    for (int index = 0; index < length; ++index) {
      outputStr += arr[index] + "\n";
    }

    return outputStr;
  }

  private boolean isArrayFull() {
    return length == arr.length;
  }

  /**
   * Task: Makes room for a new entry at newPosition. Precondition: 1 <=
   * newPosition <= length + 1; length is arr's length before addition.
   */
  private void makeRoom(int newPosition) {
    int newIndex = newPosition - 1;
    int lastIndex = length - 1;

    // move each entry to next higher index, starting at end of
    // arr and continuing until the entry at newIndex is moved
    for (int index = lastIndex; index >= newIndex; index--) {
      arr[index + 1] = arr[index];
    }
  }

  /**
   * Task: Shifts entries that are beyond the entry to be removed to the next
   * lower position. Precondition: array is not empty; 1 <= givenPosition <
 length; length is arr's length before removal.
   */
  private void removeGap(int givenPosition) {
    // move each entry to next lower position starting at entry after the
    // one removed and continuing until end of arr
    int removedIndex = givenPosition - 1;
    int lastIndex = length - 1;

    for (int index = removedIndex; index < lastIndex; index++) {
      arr[index] = arr[index + 1];
    }
  }
  
 
}
