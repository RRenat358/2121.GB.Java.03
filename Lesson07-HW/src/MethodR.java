



public class MethodR {


    @BeforeSuite
    private String beforeSuite() {
        System.out.println("MethodR = BeforeSuite");
        return null;
    }

    @AfterSuite
    private String afterSuite() {
        System.out.println("MethodR = AfterSuite");
        return null;
    }





    @TestR
    private String prnt() {
        System.out.println("MethodR = body");
        return null;
    }

    @TestR
    private int sum(int a, int b) {
        return a + b;
    }



}

