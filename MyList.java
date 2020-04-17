/**
 *  Midterm2 Coding Challenge
 *  Interface containing abstract methods to be implemented
 *  in the MyVector and MyAbstractList Classes
 *  CS108-4
 *  Date 4/18/20
 *  @author  Howen Anthony Fernando
 */


public interface MyList<E> {

   // The default value for your capacity variable should be 10, and the default value for your incrementCapacity variable should be 5

	/**
	 * Appends the specified element to the end of this list,
	 * The list capacity should be resized based on a capacity
	 * increment variable once the current capacity is filled (capacity == size).
	 * @param data
	 * @return boolean
	 */
	boolean add(E data);

	/**
	 * Inserts the specified element at the specified position in this list.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements by adding one to their indices.
	 * The list capacity should be resized based on a capacity
	 * increment variable once the current capacity is filled (capacity == size).
	 * @param index - index at which the specified element is to be inserted
	 * @param data - element to be inserted
	 * @return boolean
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
	 */
	boolean add(int index, E data);
	
	/**
	 * Removes all of the elements from this list
	 */
	void clear();

	/**
	 * Returns the element at the specified position in this list
	 * @param index
	 * @return E
	 */
	E get(int index);

	/**
	 * Returns true if this list contains no elements
	 * @return boolean
	 */
	boolean isEmpty();

	/**
	 * Removes the  element at the specified position in this list.
	 * Shifts any subsequent elements by subtracting one from their indices.
	 * @param index - index of the element to be removed
	 * @return E - the element that was removed from the list
	 * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
	E remove(int index);

	/**
	 * Trims the capacity of this MyVector instance to be the list's current size. An application 
         * can use this operation to minimize the storage of a MyVector instance.
	 */
	void trimToSize();
	 
	/**
	 * Returns the number of elements in this list
	 * @return int
	 */
	int size();

}