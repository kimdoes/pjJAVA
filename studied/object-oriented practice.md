객체지향에 관한 탐구 (도움 : GPT)
=======================================
모든 정보는 교차검토가 필요합니다.

객체는
데이터와 데이터를 다루는 함수를 포괄하는 하나의 단위. 파이썬에서는 모든 데이터, 함수들이 객체
단일 데이터, 단일 함수 모두 객체라고 부를 수 있다. 파이썬에선. 다른 언어에서는 조금 다른듯

변수와 참조
변수는 객체를 가리키는 이름표라고 할 수 있음. 가리키는 것을 참조라고 한다.
기존 언어에서는 변수에 데이터가 직접 저장됨. 파이썬에서는 

--> 헤드퍼스트자바 81쪽 Guessgame 예제 해부
GuessGame.java
public class GuessGame {
    Player p1;
    Player p2;
    Player p3;

//Player 클래스 호출하고 이 클래스를 기반으로 사용할 변수 p1, p2, p3를 형성
//new 키워드를 사용하지 않아 Player는 형성되지 않았고 p1, p2, p3는 null 상태

    public void startGame(){
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        //Player 클래스를 참조하는 변수 p1, p2, p3 형성
        //새로운 Player 객체를 메모리에 저장함
        //새 Plyaer 객체를 형성하고 그 객체를 Player를 참조하는 변수 p1, p2, p3에 저장함

        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;
        //세 명의 사람들이 추측한 숫자를 맞추기 위해 변수 3개 설정

        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;
        //세 명의 사람들이 추측한 결과를 정하기 위해 변수 3개 설정정

        
        int targerNumber = (int) (Math.random() * 10);
        //무작위 변수 설정. 0 이상 10 이하 (자료형) (Math.random() * (N 미만))
        //5이상 15 이하의 무작위 숫자를 뽑으려면 (int)(Math.random() * 11) + 5

        System.out.println("0 이상 9 이하의 숫자를 맞혀 보세요.");
        
        while(true){
            System.out.println("맞혀야 할 숫자는" + targerNumber + "입니다.")
            
            p1.guess();
            p2.guess();
            p3.guess();
            선수별로 guess 메서드 호출

            guessp1 = p1.number;
            System.out.println("1번 선수가 추측한 숫자: " + guessp1);

            guessp2 = p2.number;
            System.out.println("2번 선수가 추측한 숫자: " + guessp2)

            guessp3 = p3.number;
            System.out.println("3번 선수가 추측한 숫자: " + guessp3)

            //number와 guess는 Player 클래스에 속한 함수들일 것임
            //각 개체의 인스턴스 변수에 접근하여 각 선수가 추축한 숫자를 (guess() 메서드를 실행시킨 결과) 말함

            //public class Player{
            //    int number;
            //}
            //Player p1 = new Player()
            //p1.number = 5;
            //인스턴스 변수란 클래스에서 형성되며 객체가 생성될 때마다 따로 생성되는 변수.
            //p1.number와 p2.number는 다르다
            //클래스 내부에서 선언되며, 객체가 형성될 때마다 그 객체에 속해서 만들어지는 변수

            if (guessp1 == targetNumber){
                p1isRight = true;
            }
            if (guessp2 == targetNumber) {
                p2isRight = true;
            }
            if (guessp3 == targetNumber) {
                p3isRight = true;
            }

            if (p1isRight || p2isRight || p3isRight) {
                System.out.println("맞힌 선수가 있습니다.");
                System.out.println("1번 선수 : "+p1isRight);
                System.out.println("2번 선수 : "+p2isRight);
                System.out.println("3번 선수 : " + p3isRight);
                System.out.println("게임 끝");
            } else {
                System.out.println("다시 시도해야합니다.");
            }
        }
    }
}

Player.java
package practice;

public class Player {
    int number = 0;

    public void guess() {
        number = (int) (Math.random() * 10);
        System.out.println("추축한 숫자: " + number);
    }
}

GameLauncher.java
package practice;

public class GameLauncher {
    public static void main(String[] args) {
        GuessGame game = new GuessGame();
        //GuessGame의 객체 game에 저장함 new GuessGame에서도
        //GuessGame.java 파일에 GuessGame 메서드를 사용할 수 있음음

        game.startGame();
        //game 객체는 GuessGame의 인스턴스, 이 객체에서 startGame 메서드 호출출
        //game 객체는 GuessGame 클래스의 객체가 생성됨
        //생성된 game 객체에서 startGame 메서드가 호출, 게임시작
    }
}

main이 시작. main이 호출되면 JVM이 main 메서드를 호출하여 시작
void -> 이 메서드가 값을 반환하지 않음
String args[] -> 프로그램이 시작될 때 사용자로부터 입력된 값을 배열로 받을 수 있음


보통 클래스마다 새로이 문서를 만드는 편
각 클래스에서 외부 클래스를 참조할 때
(클래스명) (변수명) = new (클래스명);
(변수명).메서드명;의 형태로 메서드를 실행시킬 수 있다.
(변수명).(참조 중인 클래스의 변수명)으로 인스턴스변수를 실행시킬 수 있다.



힙 영역은 객체와 인스턴스들이 변수들이 저장되는 메모리공간

자바에는 전역변수가 없다. 메서드를 pubolic static으로 지정하면 전역메서드로 사용할 수 있다.
자바 프로그래밍은 변수들이 있으면 그 변수들을 어떻게 처리해야할지 정하는 클래스들이 모여 main에서 이를 어떻게 사용해야할지 지정한다.

- 객제지향 프로그래밍에서는 프로그래밍과 제작이 종료된 코드를 건드리지 않고도 프로그램을 확장시킬 수 있음
- 모든 자바 코드는 클래스 내에서 정의 - 클래스는 해당 클래스를 참조하는 객체를 어떻게 다룰지 설명하는 역할을 함
- 객체는 알고 있는 것(인스턴스 변수)과 할 수 있는 것(메서드)이 있음
- 클래스를 만들 때에는 테스트용 클래스 타입이 객체를 따로 만들어보는 것이 좋음
- 클래스는 덜 구체적인 상위 클래스로부터 인스턴스 변수와 메서드를 상속할 수 있음
- 자바는 다른 객체와와 대화하는 객체에 불과함