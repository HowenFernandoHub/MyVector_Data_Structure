/**
 *  Midterm2 Coding Challenge
 *  Abstract class that is a superclass to the MyVector class
 *  CS108-4
 *  Date 4/18/20
 *  @author  Howen Anthony Fernando
 */


public abstract class MyAbstractList<E> implements MyList<E> {

	protected int size;

	public MyAbstractList() {
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

}