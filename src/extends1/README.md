# 📘 Java Basic - 상속 (Inheritance)

이번 학습에서는 **상속의 개념과 필요성**,   
**메모리 구조 / 기능 확장 / 메서드 오버라이딩 / 접근 제어 / super / 생성자 호출 규칙**까지 전체 흐름을 학습했다.

---

##  이번에 학습한 핵심 내용

---

##  상속이란?

- 기존 클래스의 필드와 메서드를 새로운 클래스가 물려받는 것
- `extends` 키워드를 사용한다
- 코드 재사용성과 확장성을 높인다
- 자바는 **단일 상속만 지원**한다 (부모는 하나만 가능)

```java
public class Car {
    public void move() {
        System.out.println("차를 이동합니다.");
    }
}

public class ElectricCar extends Car {
    public void charge() {
        System.out.println("충전합니다.");
    }
}
```

- `ElectricCar`는 `Car`를 상속받는다.
- `move()`를 직접 작성하지 않아도 사용 가능하다.

---

##  상속 관계 정리

- **부모 클래스 (Super Class)**  
  → 자신의 필드와 메서드를 제공하는 클래스

- **자식 클래스 (Sub Class)**  
  → 부모의 기능을 물려받는 클래스

- 부모는 자식을 알지 못한다.
- 자식은 `extends`를 통해 부모를 안다.

---

##  상속과 메모리 구조 

```java
ElectricCar electricCar = new ElectricCar();
```

- 객체 생성 시 **부모 + 자식이 함께 생성된다**
- 참조값은 하나지만 내부에는 부모와 자식 타입이 공존한다

메서드 호출 과정:

1. 현재 변수 타입에서 먼저 메서드를 찾는다.
2. 없으면 부모 타입으로 올라가서 찾는다.
3. 끝까지 없으면 컴파일 오류 발생.


> 호출은 "현재 타입 → 부모 타입 방향"으로 올라가면서 탐색한다.

---

##  상속의 장점 - 기능 확장

부모 클래스에 기능을 추가하면 모든 자식이 자동으로 사용 가능하다.

```java
public class Car {
    public void openDoor() {
        System.out.println("문을 엽니다.");
    }
}
```

- 코드 중복 제거
- 유지보수 용이
- 새로운 클래스 확장에 유리

---

##  메서드 오버라이딩 (Overriding)

부모의 메서드를 자식이 재정의하는 것

```java
public class ElectricCar extends Car {

    @Override
    public void move() {
        System.out.println("전기차를 빠르게 이동합니다.");
    }
}
```

- 부모 메서드와 이름 / 매개변수 / 반환 타입이 같아야 한다.
- 접근 제어자는 부모보다 더 제한적일 수 없다.
- `@Override` 애노테이션 사용 권장.

실행 시:

- 자식에 오버라이딩된 메서드가 있으면 **자식 메서드가 실행된다.**

---

##  오버로딩 vs 오버라이딩

### 오버로딩 (Overloading)
- 메서드 이름 동일
- 매개변수 다름
- 같은 클래스 내부에서 사용

###  오버라이딩 (Overriding)
- 상속 관계에서 사용
- 부모 메서드를 자식이 재정의

---

##  접근 제어와 상속

접근 제어자 종류:

| 접근 제어자 | 같은 패키지 | 다른 패키지 | 상속 관계 |
|------------|--------|--------|-------|
| private    | X      | X      | X     |
| default    | O      | X      | X     |
| protected  | O      | X      | O     |
| public     | O      | O      | O     |

- `protected`는 상속 관계에서 매우 중요하다.
- `private`는 자식에서도 접근 불가.

---

##  super - 부모 참조

부모 필드나 메서드를 명시적으로 호출할 때 사용

```java
public class Child extends Parent {

    public void call() {
        System.out.println(this.value);
        System.out.println(super.value);

        this.hello();
        super.hello();
    }
}
```

- `this` -> 자기 자신 참조
- `super` -> 부모 참조

---

##  super - 생성자 호출 규칙 

상속 관계에서:

- 자식 생성자의 **첫 줄에는 반드시 super(...) 호출**
- 생략하면 기본 생성자 `super()` 자동 호출

```java
public class ClassB extends ClassA {

    public ClassB(int a) {
        super(); 
        System.out.println("ClassB 생성자");
    }
}
```

생성 순서:

1. 최상위 부모 생성자 실행
2. 그 다음 자식 생성자 실행
3. 부모 → 자식 순서로 초기화 진행

---

##  final과 상속

###  final 클래스

```java
public final class MyClass { }
```

- 상속 불가
- 확장 불가능

###  final 메서드

```java
public final void move() { }
```

- 오버라이딩 불가

---

##  이번 파트에서 얻은 가장 중요한 이해

- 상속은 코드 재사용과 확장을 위한 핵심 개념이다.
- 객체 생성 시 부모와 자식이 함께 생성된다.
- 메서드 탐색은 현재 타입 → 부모 타입 순으로 진행된다.
- 오버라이딩은 부모 기능을 자식이 재정의하는 것이다.
- 생성자에서는 반드시 super(...)가 호출되어야 한다.

---

##  한 줄 정리

> **상속은 공통 기능을 부모에 모으고, 자식이 확장하는 객체지향의 핵심 설계 방식이다.*