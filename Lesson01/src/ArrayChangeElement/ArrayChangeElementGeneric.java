package ArrayChangeElement;


import java.util.Arrays;


public class ArrayChangeElementGeneric<T>{

    private T[] obj;

    public ArrayChangeElementGeneric(T... obj) {
        this.obj = obj;
    }

    public T[] getObj() {
        return obj;
    }
    

    public void arrChangGen(T... another) {
        System.out.println(Arrays.toString(another));

    }


    @Override
    public String toString() {
        return Arrays.toString(obj);
    }






}
