package practice;

public class Player {
    int number = 0;

    public void guess() {
        number = (int) (Math.random() * 10);
        System.out.println("추축한 숫자: " + number);
    }
}
