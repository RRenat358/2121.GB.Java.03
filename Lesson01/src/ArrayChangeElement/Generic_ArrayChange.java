package ArrayChangeElement;





public class Generic_ArrayChange <T>{

    private T obj;

    public Generic_ArrayChange(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void showArr() {
        System.out.println("Тип T: " + getObj());
    }



}
