public class Factory {
    public static IStack<Integer> createArr(String name){
        if(name.equalsIgnoreCase("stack")){
            return new Stack<>();
        } 
        else if(name.equalsIgnoreCase("ArrayList")|| name.equalsIgnoreCase("vector")){
            return new Array<>(name);
        }
        else{
            throw new IllegalArgumentException ("El tipo de pila que has ingresado no es válido.");
        }
    }
    
}
