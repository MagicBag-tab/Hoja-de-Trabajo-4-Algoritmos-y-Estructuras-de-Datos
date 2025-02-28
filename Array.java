
import java.util.ArrayList;
import java.util.Vector;

public class Array<T> implements IStack<T> {
    private Object structure;
    private String type;

    //Definición de estructuras.
    public Array(String type){
        this.type=type.toLowerCase();
        if(type.equalsIgnoreCase("arraylist")){
            structure= new ArrayList<T>();
        }
        else if(type.equalsIgnoreCase("vector")){
            structure = new Vector<T>();
        }
        else{
            throw new IllegalArgumentException("La estructura que has ingresado no se encuentra.");
         }
    }   


    //Agregar valores a las estructuras de las pilas.
    @Override
    public void push(T value){
        if(type.equals("arraylist")){
            ((ArrayList<T>)structure).add(value);
        }
        else{
            ((Vector<T>) structure).add(value);
        }
    }

    //Remover y devolver el último valor. 
    @Override
    public T pop(){
        if(type.equals("arraylist")){
            ArrayList<T> list =(ArrayList<T>)structure;
            if(list.isEmpty()) throw new IllegalStateException("La pila se encuentra aún vacía.");
            return list.remove(list.size()-1);
        }
        else{
            Vector<T> vector = (Vector<T>) structure;
            if(vector.isEmpty())throw new IllegalStateException("La íla se encuentra aún vacía.");
            return vector.remove(vector.size()-1);
        }
    }


}