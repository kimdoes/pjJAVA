package practice;

public class namegetset {
    public static void main (String[] args) {
        String name;
        Person p = new Person();

        p.setName("민준");
        p.setName("마치");
        name = p.getName();
        System.out.println(name);

    }
}