



public class Cat {
    private String name;
    private String color;
    private Integer age;
    private Integer weight;

    public Cat() {
    }

    public Cat(String name, String color, Integer age, Integer weight) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    public String info1(String name, String age) {
        return name + ", " + age;
    }

//    @MyAnnotation(priority = 7)
    public String info2(){
        System.out.println("INFO1");

        return name;
    }


}
