/**
 *  Midterm2 Coding Challenge
 *  Data structure that uses arrays to store data
 *  Adds functionality similar to ArrayList by inheriting from MyAbstractList
 *  Can dynamically grow and shrink size
 *  CS108-4
 *  Date 4/18/20
 *  @author  Howen Anthony Fernando
 */


public class MyVector<E> extends MyAbstractList<E>{

    private int capacity;           // How many elements MyVector can store
    private int increment;          // How much to increase capacity of the Vector
    private E[] array;              // Array field of generic type, stores values for MyVector

    @SuppressWarnings("unchecked")
    public MyVector() {             // Default constructor
        capacity = 10;
        increment = 5;
        size = 0;
        array = (E[]) new Object[capacity];

    }

    @SuppressWarnings("unchecked")
    public MyVector(int capacity) {     // Takes input for the initial capacity
        this.capacity = capacity;
        increment = 5;
        size = 0;
        array = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public MyVector(int capacity, int increment) {      // Takes input for initial capacity and increment
        this.capacity = capacity;
        this.increment = increment;
        size = 0;
        array = (E[]) new Object[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public int getIncrement() {
        return increment;
    }

    /**
     * Appends the specified element to the end of this list,
     * @param data
     * @return
     */
    @Override @SuppressWarnings("unchecked")
    public boolean add(E data) {
        // Checks if capacity of array is at its max
        if (capacity == size()) {
            capacity += increment;
            changeCapacity();
        }

        // Traverses array until it finds first empty index
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = data;
                size++;
                break;
            }
        }
        return true;
    }

    /**
     *
     * @param index - index at which the specified element is to be inserted
     * @param data - element to be inserted
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public boolean add(int index, E data) throws IndexOutOfBoundsException {

        // Checks if capacity of array is at its max
        if (capacity == size()) {
            capacity += increment;
            changeCapacity();
        }

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Tried to add at an out of bounds index");
        }

        else if (array[index] == null) {
            array[index] = data;
            size++;
        }

        else {
            // Shifts all elements from the index onwards over to the right
            for (int i = size(); i > index; i--) {
                array[i] = array[i - 1];
            }

            array[index] = data;
            size++;
        }

        return true;
    }

    /**
     * Sets all elements in array = null
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     *
     * @param index at which to retrieve element
     * @return element at that index
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Tried to get an out of bounds index");
        }
        else {
            return array[index];
        }
    }

    /**
     *
     * @param index - index of the element to be removed
     * @return element at that index
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Tried to remove an out of bounds index");
        }
        else {
            E element = array[index];   // Preserves the element at the index to be removed

            for (int i = index; i < size(); i++) {
                array[i] = array[i + 1];
            }
            size--;
            return element;
        }
    }

    /**
     * Trims the capacity of this MyVector instance to be the list's current size.
     * An application can use this operation to minimize the storage of a MyVector instance.
     */
    @Override
    public void trimToSize() {
        capacity = size();
        changeCapacity();
    }

    /**
     * @return - MyVector instance as a String
     */
    @Override
    public String toString() {
        String myVector = "[";
        // Check size != 0 so that don't go out of bounds
        if (size != 0) {
            for (int i = 0; i < size() - 1; i++) {
                myVector += array[i].toString();
                myVector += ", ";
            }
            myVector += array[size - 1].toString();
        }
        myVector += "]";
        return myVector;
    }

    /**
     * Private method for changing capacity of the array as MyVector grows and shrinks
     * Builds a new array with the desired new capacity and copies over all the data from
     * the previous array.
     */
    @SuppressWarnings("unchecked")
    private void changeCapacity() {
        // This temporary array allows us to copy over all of the original arrays data
        E[] tempArr;
        tempArr = array;
        array = (E[]) new Object[capacity];

        /*
          Copying over old array's data
          Using if else to ensure that no out of bounds occurs
          when copying over due to differences in length
        */
        if (tempArr.length < array.length) {
            for (int i = 0; i < tempArr.length; i++) {
                array[i] = tempArr[i];
            }
        }
        else {
            for (int i = 0; i < array.length; i++) {
                array[i] = tempArr[i];
            }
        }
    }

}
