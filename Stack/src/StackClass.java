import java.util.EmptyStackException;

public class StackClass<T> implements Stack<T> {
	private LinkedList<T> list = new LinkedList<>();

	public StackClass() {
		//nothing to do...
	}

	/**
     * Adds an object to the top of the stack.
     * @param T object The object to add.
     */
    public void push(T object) {
    	list.addFirst(object);
    }

    /**
     * Retrieves the object of the top of the
     * stack and removes it from the stack.
     * @return T The topmost object.
     */
    public T pop() {
    	if (isEmpty() == true) {
    		throw new EmptyStackException();
    	}
    	T object = list.removeFirst();
    	return object;
    }
    
    /**
     * Retrieves the object of the top of the
     * stack without removing it from the stack.
     * @return T The topmost object.
     */    
    public T top() {
    	if (isEmpty() == true) {
    		throw new EmptyStackException();
    	}
    	T object = list.getFirst();
    	return object;
    }

    /**
     * Get the size of the stack.
     * @return int The size of the stack.
     */
    public int size() {
    	return list.size();
    }
    
    /**
     * Returns true if the stack is empty.
     * @return boolean True if empty.
     */
    public boolean isEmpty() {
    	return list.isEmpty();
    }
}