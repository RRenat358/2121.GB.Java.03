




public class Lesson07_2 {

    public static void main(String[] args) {
        Class aClass = "Java".getClass();

        Class strClass = String.class;
        Class intClass = Integer.class;
        Class smallIntClass = int.class;
        Class smallIntArrClass = int[][].class;

        System.out.println(smallIntArrClass.getName() + " " + smallIntArrClass.getSimpleName());

        System.out.println(new int[][]{{1, 2}, {3, 4}});



    }








}
