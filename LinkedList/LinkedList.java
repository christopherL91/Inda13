/**
 * A singly linked list.
 * 
 * @author Christopher Lillthors
 * @version 1.0
 */
public class LinkedList<T> { 
    
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size = 0;            // Number of elements in list.
    
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
    //write more tests...
    public boolean isHealthy() {
        boolean ok = false;
        return true;
}

    //count the number of elements using iterative search!
    private int getSize() {

    if(isEmpty() == true) {
            return 0;
        }

        int counter = 1;
        ListElement<T> current;
        for (current = this.first; current != null && current.next != null; current = current.next) {
         counter++;
        }
    return counter;
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
        this.size++;
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
        this.size++;
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
        if (index < 0 || index >= size()) {
            return null;
        }

        ListElement<T> current = this.first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Removes and returns the first element from this list.
     * Returns <code>null</code> if the list is empty.
     */ //bugs fix
    public T removeFirst() {
        ListElement<T> f = this.first;

        if (this.size == 1) {
            this.last = null;
        }

        if (f != null) {
            ListElement<T> n = f.next;
            this.first = n;
            this.size--;
            return f.data;
        }
        return null;
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Returns the number of elements in this list.
     */
    public int size() {
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
            return "[]";
        }
        //inspiration from c++
        for (current = this.first; current.next != null; current = current.next) {
            res += current.data.toString() + ", ";
        }
        //add last element
        res += last.data + "]";
        return res;
    }
}