package practice;

public class Dog {
    String name;
    int age;

    public static void main(String[] args) {
        Dog[] pets;
        pets = new Dog[3];

        pets[0] = new Dog();
        pets[1] = new Dog();

        pets[0].name = "Fido";
        pets[0].age = 7;
        pets[1].name = "Dodo";
        pets[1].age = 6;

        System.out.println(pets[0].name);
        System.out.println(pets[1].name);

        Dog dogin = new Dog();
        dogin.name = "hai";
        dogin.age = 8;
        dogin.information();
    }

    public void information(){
        System.out.println(name + " 이의 나이는 " + age +"살 입니다.");
    }
}
