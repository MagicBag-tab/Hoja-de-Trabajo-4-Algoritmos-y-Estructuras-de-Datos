public class Node<T> {
    private T value;
    private Node<T> next;//Ir al siguiente nodo en la lista o en la pila.
    public Node(T value){
        this.value= value;
    }
    public T getValue(){
        return value;
    }
    public Node<T> getNext(){
        return next;
    }
    public void setNext(Node<T> next){
        this.next= next;
    }
}
