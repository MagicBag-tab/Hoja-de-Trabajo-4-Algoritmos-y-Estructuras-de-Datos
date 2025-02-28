public class DoubleList<T> implements IList<T> {

    private DoubleNode<T> first;
    private DoubleNode<T> last;
    private int count = 0;

    @Override
    public void add(T value) {
        DoubleNode<T> nuevo = new DoubleNode<>(value);
        if (first == null) {
            first = nuevo;
            last = nuevo;
        } else {
            last.setNext(nuevo);
            nuevo.setPrevious(last);
            last = nuevo;
        }

        count++;
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        if (index == 0) {
            first = first.getNext();
            if (first != null) {
                first.setPrevious(null);
            } else {
                last = null;
            }
        } else if (index == count - 1) {
            last = last.getPrevious();
            last.setNext(null);
        } else {
            DoubleNode<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }

            DoubleNode<T> previous = current.getPrevious();
            DoubleNode<T> next = current.getNext();

            previous.setNext(next);
            next.setPrevious(previous);
        }

        count--;
    }

}
