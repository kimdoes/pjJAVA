자유개발을 통한 탐구결과

# 1. 참조 하나별 인수 하나나
- littlepractice.java (main)
package practice;

class littlepractice{
    public static void main(String[] args){
        ints a = new ints();

        a.randnum();
        System.out.println(a);
    }
}

- ints.java
package practice;

public class ints {
    int num;

    public void randnum() {
        num = (int) (Math.random() * 10);
    }
}

### 출력결과 : 2

* 자바 출력은 main 메서드에서만 출력해야 터미널에 출력됨
* num을 선언한 후 randnum 메서드를 통해 1~10까지의 랜덤한 정수를 만듦.
* a는 ints 객체를 참조하며 randnum 메서드를 수행함. -> 그렇다면 num은 어디에 저장되는가?

- GPT의 추가설명
* JVM은 ints 클래스를 로드함 → 힙 메모리에 ints 클래스의 인스턴스변수 (객체)인 int num을 저장 → new ints()는 ints 객체의 메모리주소를 반환함 → a에 그것이 저장됨
* 즉, ints a = new ints()가 실행될 때마다, a는 ints를 참조하게되며, ints 클래스 내의 num 함수에 접근하게 됨.


# 2. 참조 하나에 인수 두 개 반환 시
-main.java
package practice;

class littlepractice{
    public static void main(String[] args){
        ints a = new ints();

        a.randnum();
        System.out.println(a);
    }
}

-ints.java
package practice;

public class ints {
    int num;
    int num2;

    public void randnum() {
        num = (int) (Math.random() * 50);
        num2 = (int) (Math.random() * num);
    }
}

### 실행결과 : practice.ints@4517d9a3

수정하기
- main.java

class littlepractice{
    public static void main(String[] args){
        ints a = new ints();

        a.randnum();
        System.out.println(a.num);
        System.out.println(a.num2);
    }

}

(ints.java는 동일)
* 클래스에서 반환하는 요소가 2개일 경우 (클래스를 참조하는 변수명).(접근할 인스턴스 명) 으로 각 객체에 접근할 수 있다.


# 3. 클래스 3개 활용해보기
- main.java
package practice;

class mainprogress{
    public static void main(String[] args){
        ints nums = new ints();
        intadd add = new intadd();
        int rst;

        int n1 = nums.randnum();
        int n2 = nums.randnum();

        rst = add.inadd(n1,n2);
        System.out.println(n1 + " " + n2);
        System.out.println(rst);
    }
}

- ints.java
package practice;

public class ints {
    int num;

    public int randnum() {
        num = (int) (Math.random() * 100);
        return num;
    }
}

- intadd.java
package practice;

public class intadd {
    public int inadd (int num1, int num2){
        return num1 + num2;
    }
}

* return 값이 있으려면 void가 아닌 int, String 등을 써야함

# 4. 배열선언
- main.java (EchoTestDrive.java)
package practice;

public class EchoTestDrive {
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
    }
}


- Code mag.java
package practice;

class Dog{
    String name;
    int age;
    
    public void bark(){
    }

    public void eat(){

    }
}

* 배열에 . 을 사용하여 인스턴스에 접근할 수 있다.
* pets[0]에는 인스턴스스가 여러 개 저장되어 . 을 사용하여 각 인스턴스에 접근해야한다.

- 한 파일에 들어가도록 수정
- main.java (Dog.java)

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


# 5. 수영장 퍼즐 p.107
package practice;

class Triangle{
    double area;
    int height;
    int length;

    public static void main(String[] args) {
        int x = 0;
        Triangle [] ta = new Triangle[4];

        while (x < 4){
            ta[x] = new Triangle();
            ta[x].height = (x+1) * 2;
            ta[x].length = x + 4;
            ta[x].setArea();

            System.out.print("triangle " + x + ", area");
            System.out.println(" = " + ta[x].area);
            x = x + 1;
        }

        int y = x;
        x = 27;
        Triangle t5 = ta[2];
        ta[2].area = 343;
        System.out.print("y = " + y);
        System.out.println(", t5 area = " + t5.area);
    }

    void setArea() {
        area = (height * length) / 2;
    }
}

배열에서 ta[x].height, ta[x].length로 변수를 입력한 다음 ta[x].setArea();로 계산할 수 있다.