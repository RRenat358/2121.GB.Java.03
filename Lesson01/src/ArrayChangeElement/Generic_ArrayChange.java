package ArrayChangeElement;


import java.util.Arrays;

public class Generic_ArrayChange <T extends Object>{

    private T[] obj;

    public Generic_ArrayChange(T... obj) {
        this.obj = obj;
    }

    public T[] getObj() {
        return obj;
    }

    public void showArr(Generic_ArrayChange<?> another) {
        System.out.println("Тип T: " + another.getObj());
    }


    @Override
    public String toString() {
        return "Generic_ArrayChange{" +
                "obj=" + Arrays.toString(obj) +
                '}';
    }
}
