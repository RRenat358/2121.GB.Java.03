



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





    @TestR // (priority = 5) default
    private String prnt1() {
        System.out.println("MethodR = Test" + ", " + "priority = 5 default");
        return null;
    }

    @TestR(priority = 9)
    private String prnt2() {
        System.out.println("MethodR = Test" + ", " + "priority = 9");
        return null;
    }

    @TestR(priority = 3)
    private String prnt3() {
        System.out.println("MethodR = Test" + ", " + "priority = 3");
        return null;
    }

    @TestR(priority = 1)
    private String prnt4() {
        System.out.println("MethodR = Test" + ", " + "priority = 1");
        return null;
    }

    @TestR(priority = 8)
    private String prnt5() {
        System.out.println("MethodR = Test" + ", " + "priority = 8");
        return null;
    }

    @TestR(priority = 7)
    private String prnt6() {
        System.out.println("MethodR = Test" + ", " + "priority = 7");
        return null;
    }

    @TestR(priority = 6)
    private String prnt7() {
        System.out.println("MethodR = Test" + ", " + "priority = 6");
        return null;
    }



}

