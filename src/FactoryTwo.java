public class FactoryTwo {

    public static <T> IList<T> creatList(String name) {
        switch (name) {
            case "SimpleLinkedList":
                return new SimpleList<>();
            case "DoubleLinkedList":
                return new DoubleList<>();
            default:
                throw new IllegalArgumentException("Nombre Invalido");
        }
    }

}
