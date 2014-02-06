/*
* Interface that wraps methods around LinkedList.
*/

public interface Stack<T> {
      
        /**
        * Push and object on top of the stack
        */
        public void push(T object);
        
        /**
        * removes an object from the top of the stack
        * @return The object that was removed.
        */
        public T pop();
        
        /**
        * Returns the object on the top.
        * @return first object.
        */   
        public T top();

        /**
        * returns the size of the stack.
        * @return size of stack.
        */

        public int size();
        
        /**
         * checks if the stack is empty.
         * @return check if stack is empty.
         */
        public boolean isEmpty();
}