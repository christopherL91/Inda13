 public class ListElement<T> {
        private T data;
        private ListElement<T> next;
        
        protected ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }