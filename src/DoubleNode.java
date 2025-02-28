public class DoubleNode<T> {

    DoubleNode<T> next = null;
    DoubleNode<T> previous = null;
    T value;

    public DoubleNode(T value) {
        this.value = value;
    }

    public DoubleNode() {

    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

    public T getValue() {
        return value;
    }

}
