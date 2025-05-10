클래스 내에서의 메서드

메서드는 클래스 내에서의 변수에 따라 다른 메서드를 가지도록 할 수 있다.
특정 클래스의 각 인스턴스들은 동일한 메서드를 가진다. 단, 메서드의 행동을 다르게 할 수 있다.

-> 메서드에 특정 값을 전달하기
 매개변수(파라미터), 인자가 있다. 메서드에 전달되는 값 (호출하는 쪽에서 넘기는 값)은 인자, 메서드가 받는 것은 매개변수. 메서드가 매개변수를 받도록 선언했다면 그 메서드를 호출할 때 반드시 어떠한 값을 전달해야함. 받는 매개변수는 정해진 타입과 값이어야함

-> 메서드에서 특정 값을 리턴하기
 메서드가 완전히 실해오딘 후 특정 값을 반환하게 하는 것. type이 void라면 어떠한 값도 반환하지 않는다. 메서드를 선언할 때 int add(); 와 같은 방식으로 메서드를 선언했다면 반드시 반환할 때 그 타입을 지켜야 한다. (int add();와 같은 경우에는 return type이 반드시 int)

-> 여러 개의 인자를 전달받는 메서드
 메서드에서 여러 매개변수를 받을 때에는 쉼표로 구분할 수 있다. 

 ->
 int x = 7;

 class bh {
    void go(int z){
        z = 0;
    }
 }
 
 bh foo = new bh();
 foo.go(x)

일 때, x에는 7이 저장되고, go 메서드의 z에는 x의 복사본인 7이 전달된다.
z 값을 바꾸더라도 x 값은 바뀌지 않는다. 이는 x와 z의 type인 int가 immutable 객체이기 때문이다.
 
-> p.120 Q&A
 메서드에서 리턴값은 오직 1개만 가능. 여러 개를 리턴하고 싶을 때는 배열로 return 할 수 있다. 서로 다른 type을 리턴하고 싶을 때는 추후 작성예정

-- 인스턴스변수 -> 객체가 가지고 있는 정보 / 메서드 -> 객체가 하는 것
클래스 내에서, 클래스의 인스턴스 변수를 활용하여 어떤 메서드를 통해 어떻게 객체를 이용할지 정한다. 

==================================

-- 게터세터
게터(getter) -> 접근자(accessor), 인스턴스 변수값에 대해 값을 가져옴. 가져오기로 한 값을 리턴값 형태로 받아오기 위한 용도로 사용
세터(setter) -> 변경자(mutator), 인스턴스 변수값를 설정함. 세터는 세터가 설정할 값을 인자로 받아 인스턴스 변수를 그 값으로 설정하기 위한 용도로 사용됨.

class ElectricGuitar {
    String brand;
    int num0fPickups;
    boolean rockStarUseIt;

    String getBrand() {
        return brand;
    }

    void setBrand(String aBrand) {
        brand = aBrand;
    }

    int get Num0fPickups() {
        return num0fPickups = num;
    }

    boolean getRocksStarUseIt() {
        return rockStarUseIt;
    }

    void setRockStarUseIt(boolean yesOrNo) {
        rockStarUseIt = yesOrNo;
    }
}

인스턴스 변수들은 brand, num0fPickups, rockStarUseIt이고, 메서드는 getBrand(), setBrand(), getNum0fPickups(), setNum0fPickups(), getRockStarUseIt(), setRockStarUseIt() 이다.

Extra Question (with GPT)
Person.java

package practice;

public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

namegetset.java
package practice;

public class namegetset {
    public static void main (String[] args) {
        String name;
        Person p = new Person();

        p.setName("민준");
        name = p.getName();
        System.out.println(name);

    }
}

여기서 p.setName으로 민준을 저장하고 name으로 불러온다. 외부에서 name에 접근할 수 없다.
p.setName을 한다면 기존의 값은 사라진다.

===========================================

캡슐화
현재가지의 코드들은 모두 클래스의 변수에 직접적인 접근이 가능한 형태
따라서 객체에 절대로 직접적으로 접근할 수 없게 해야하고, 접근한다면 게터와 세터로만 접근해야함

게터 -> 이미 설정된 값을 가지고 오는 역할
세터 -> 값에 접근하여 값을 설정하는 역할

캡슐화는 public 접근변경자를 private로 변경함
게터와 세터만 public으로 설정하면 됨.

세터에서 값을 설정한다면 매개변수의 값을 확인하고 검수를 진행할 수 있음. 세터를 통하지 않고 직접 값을 수정한다면 이를 막기 어렵다. 세터를 사용할 경우 값을 변경하기 쉽다는 것도 장점이다.

============================================

게터와 초기화
인스턴스 변수의 경우 클래스 내에서 (메서드 내에서 선언되지 않음)
로컬 변수는 메서드 내에서 선언됨 -> 따라서 로컬 변수를 사용하기 전에는 반드시 초기화를 해야함

public void go() {
    int x;
    int z = x + 3;  -> 오류
}

인스턴스 변수에는 초기값이 있다.
정수 0, 부동소수점 0.0, 불리언 false, 레퍼런스 null...

로컬 변수에는 초기값이 없어서 컴파일 과정에서 오류가 생긴다.
메서드 매개변수의 경우에는 로컬 변수와 거의 똑같고 메서드 내에서 선언된다. 다만, 메서드 매개변수는 올바른 인자를 전달하기 위해 항상 자동으로 초기화되고 인자들은 자동으로 매개변수에서 대입된다.

============================================

원시 변수와 레퍼런스 변수의 값 비교
- 원시변수
값이 같은지 확인할 때에는 == 연산자, 두 변수가 참조하고 있는 객체가 같은지의 여부를 확인할 때에는 .equals() 메서드를 사용해야함.