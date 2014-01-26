/**
 * A singly linked list.
 * 
 * @author Christopher Lillthors
 * @version 1.0
 */
public class LinkedList<T> { 
    
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size;               // Number of elements in list.
    
    /**
     * A list element.
     */
    private static class ListElement<T> {
        public T data;
        public ListElement<T> next;
        
        public ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    /**
     * This TEST METHOD returns true if the following invariants hold:
     * <ul>
     *   <li> size equals the number of list elements, </li>
     *   <li> if size == 0, first == null and last == null, </li>
     *   <li> if size > 0, first != null and last != null, </li>
     *   <li> if size == 1, first == last, </li>
     *   <li> last.next == null. </li>
     * </ul>
     */
    public boolean isHealthy() {
    	
    	return false;
    }
    
    /**
     * Creates an empty list.
     */
    public LinkedList() {
        first = null;
        last = null;
    }

    /**
     * Inserts the given element at the beginning of this list.
     */
    public void addFirst(T element) {
       ListElement<T> firstElement = new ListElement<T>(element);
       if (this.first != null) {
            ListElement<T> previous = this.first;
            firstElement.next = previous;
        } else {
            this.last = firstElement;
        }
        this.first = firstElement;
    }

    /**
     * Inserts the given element at the end of this list.
     */
    public void addLast(T element) {
        ListElement<T> lastElement = new ListElement<>(element);
        if (this.last != null) {
            ListElement<T> previous = this.last;
            previous.next = lastElement;
        } else {
            this.first = lastElement;
        }
        this.last = lastElement;
    }
    /**
     * Returns the first element of this list.
     * Returns <code>null</code> if the list is empty.
     */
    public T getFirst() {
        ListElement<T> first;
        first = this.first;
        if (first == null) {
            return null;
    } else {
        return first.data;
    }
}

    /**
     * Returns the last element of this list.
     * Returns <code>null</code> if the list is empty.
     */
    public T getLast() {
        ListElement<T> last;
        last = this.last;
        if (last == null) {
            return null;
        }else {
            return last.data;
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * Returns <code>null</code> if <code>index</code> is out of bounds.
     */
    public T get(int index) {
        ListElement<T> current;
        current = this.first;
        return null;
    }

    /**
     * Removes and returns the first element from this list.
     * Returns <code>null</code> if the list is empty.
     */ //bugs fix
    public T removeFirst() {
        ListElement<T> first;
        first = this.first;

        if (first != null) {
            ListElement<T> next = first.next;
            first = null;
            return next.data;
        }
        return null;
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        first = null;
        last = null;
    }

    /**
     * Returns the number of elements in this list.
     */
    public int size() {
        int counter = 0;
        ListElement<T> current;
        for (current = this.first; current != null && current.next != null; current = current.next) {
         counter++;
        }

    //compensate for the first element
    this.size = counter + 1;
    return this.size;
    }

    /**
     * Returns <code>true</code> if this list contains no elements.
     */
    public boolean isEmpty() {
        if (this.first != null && this.last != null) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Returns a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     */
    public String toString() {
        ListElement<T> current;
        String res = "[";
        if (this.first == null) {
            return null;
        }
        //inspiration from c++
        for (current = this.first; current.next != null; current = current.next) {
            res += current.data + ", ";
        }
        //add last element
        res += last.data + "]";
        return res;
    }
}