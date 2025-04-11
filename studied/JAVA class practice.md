자바 배우기 4 - 자바 객체 및 클래스 실습
=================================

객체를 사용하기 위해서는 클래스 2개가 필요함
1. 사용할 객체의 타비을 나타내는 클래스
2. 새로운 클래스를 테스트하기 위한 클래스 -> main 메서드 사용


main 탈출
객체 간 상호작용을 할 수 있어야함.
main의 용도 : 클래스 테스트, 자바 애플리케이션 시작

객체 간 서로 다른 메서드를 호출하는 것


main 벗어나기 예제 - 숫자 맞히기 게임
클래스 : GuessGame / Player / GamLauncher
-->public 클래스는 한 코드 당 한 개만!

GameLauncher 클래스에서 시작 (main 메서드 포함)
main 메서드는 GuessGame의 객체를 만ㄷ름, 객체의 startgame 메서드 호출



자바의 최종모습은
클래스 여러 개가 모여 있는 것. 그 중에 하나는 main 메서드. 그 메서드를 통해 프로그램을 시작하게 됨.



public class Dog {
    // 속성 (필드, 멤버 변수)
    String name;
    int age;

    // 행동 (메서드)
    void bark() {
        System.out.println(name + "가 멍멍 짖어요!");
    }

    void introduce() {
        System.out.println("안녕! 나는 " + name + ", " + age + "살이야!");
    }
}

Dog mydog = new Dog();
-->Dog 클래스에서 객체를 만듦.