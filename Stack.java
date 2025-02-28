public class Stack<T> implements IStack<T>{
    private Node<T> head = null;

    @Override
    public void push(T value){
        Node<T> newNode= new Node<>(value);
        newNode.setNext(head);
        head = newNode;
    }

    //Obtener el valor del nodo en la cima.
    @Override
    public T pop(){
        if(head == null){
        throw new IllegalStateException("No se encuentra nada en la pila.");
        }
        T value = head.getValue();
        head = head.getNext();
        return value;
    }
}
