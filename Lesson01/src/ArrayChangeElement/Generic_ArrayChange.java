package ArrayChangeElement;


import java.util.Arrays;
import java.util.List;

public class Generic_ArrayChange <T>{

    private T[] obj;

    public Generic_ArrayChange(T... obj) {
        this.obj = obj;
    }

    public T[] getObj() {
        return obj;
    }

    public <T> void showArr2(List <T> another) {
        System.out.println("Тип T: " + getObj().toString());
    }

    public void showArr(T... another) {
        System.out.println("Тип T: " + another.toString());

    }


    @Override
    public String toString() {
        return "Generic_ArrayChange{" +
                "obj=" + Arrays.toString(obj) +
                '}';
    }






}
