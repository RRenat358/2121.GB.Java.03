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
    

    public T[] arrChangGen(T[] array, int posElement_1, int posElement_2) {
        posElement_1--;
        posElement_2--;
        T temp = array[posElement_2];
        array[posElement_2] = array[posElement_1];
        array[posElement_1] = temp;
        return array;
    }


}
