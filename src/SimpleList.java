public class SimpleList<T> implements IList<T> {

    SimpleNode<T> first;
    SimpleNode<T> last;
    int count = 0;

    @Override
    public void add(T value) {
        if (first == null) {
            first = new SimpleNode<T>(value);
            last = first;
            count = 1;
        } else {
            count++;
            SimpleNode<T> nuevo = new SimpleNode<T>(value);
            last.next = nuevo;
            last = nuevo;
        }
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        if (index == 0) {
            first = first.getNext();
            if (first == null) {
                last = null;
            }
        } else {
            SimpleNode<T> current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }

            SimpleNode<T> toDelete = current.getNext();
            current.setNext(toDelete.getNext());

            if (toDelete == last) {
                last = current;
            }
        }

        count--;
    }
}