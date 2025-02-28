/*
 * Interfaz de las Listas con sus métodos principales de add y delete
 */

public interface IList<T> {
    void add(T value);

    T delete();
}