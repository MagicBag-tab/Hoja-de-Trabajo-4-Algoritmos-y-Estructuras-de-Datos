/*
 * Implementación de los nodos para una lista encadenada
 */

public class SimpleNode<T> {

    SimpleNode<T> next = null;
    T value;

    public SimpleNode(T value) {
        this.value = value;
    }

    public SimpleNode() {

    }

    public SimpleNode<T> getNext() {
        return next;
    }

    public void setNext(SimpleNode<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

}
