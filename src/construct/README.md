# 📘 Java Basic - 생성자(Constructor)

이번 학습에서는 객체를 생성하는 시점에 초기화를 보장하기 위한 **생성자(Constructor)** 개념과  
`this`, 기본 생성자, 생성자 오버로딩, `this()` 사용법을 이해했다.

---

## 이번에 학습한 핵심 내용

---

##  생성자가 필요한 이유

객체를 생성한 뒤, 항상 초기값을 설정해야 하는 경우가 많다.

```java
MemberInit member = new MemberInit();
member.name = "user1";
member.age = 15;
member.grade = 90;
```

이 방식은

- 객체 생성 후 별도의 초기화 코드 필요
- 초기화 코드 반복
- 실수로 초기화를 하지 않을 가능성 존재

-> 객체 생성과 동시에 초기화를 보장할 방법이 필요하다.

---

##  this 키워드

###  this의 의미

> `this`는 인스턴스 자기 자신의 참조값을 의미한다.

```java
void initMember(String name, int age, int grade) {
    this.name = name;
    this.age = age;
    this.grade = grade;
}
```

###  왜 this가 필요할까?

- 매개변수 이름과 멤버 변수 이름이 같을 경우
- 지역변수가 우선순위를 가지기 때문

```java
name = name; // 둘 다 매개변수 → 멤버변수 값 변경 안됨 X
this.name = name; // 멤버변수에 값 저장 O
```

---

###  this 정리

- `this`는 인스턴스 자신을 가리킨다.
- 이름이 겹칠 때 멤버변수를 명확히 구분하기 위해 사용한다.
- 꼭 필요한 경우에만 사용해도 충분하다.

---

##  생성자(Constructor)란?

> 객체 생성 시 자동으로 호출되는 특별한 메서드

### 생성자의 특징

- 클래스 이름과 동일하다.
- 반환 타입이 없다.
- 객체 생성 시 자동 호출된다.

```java
public class MemberConstruct {

    String name;
    int age;
    int grade;

    MemberConstruct(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
```

객체 생성:

```java
MemberConstruct member = new MemberConstruct("user1", 15, 90);
```

-> 객체 생성과 동시에 초기화 완료

---

##  생성자의 장점

###  중복 제거

```java
// 생성자 등장 전
MemberInit member = new MemberInit();
member.initMember("user1", 15, 90);

// 생성자 등장 후
MemberConstruct member = new MemberConstruct("user1", 15, 90);
```

코드가 훨씬 간결해진다.

---

###  필수값 입력 보장 -> 제약조건

생성자를 정의하면 반드시 호출해야 한다.

```java
MemberConstruct member = new MemberConstruct(); // 컴파일 오류 
```

→ 잘못된 객체 생성을 원천 차단  
→ "유령 객체" 방지

---

##  기본 생성자(Default Constructor)

###  기본 생성자란?

> 매개변수가 없는 생성자

```java
MemberConstruct() {
}
```

###  규칙

- 생성자가 하나도 없으면 → 컴파일러가 자동 생성
- 생성자가 하나라도 있으면 → 기본 생성자 자동 생성 X

즉,

```java
MemberConstruct(String name, int age) { }
```

이렇게 생성자를 하나라도 만들면  
기본 생성자는 자동으로 만들어지지 않는다.

---

##  생성자 오버로딩

생성자도 메서드처럼 오버로딩 가능하다.

```java
MemberConstruct(String name, int age) {
    this.name = name; 
    this.age = age;
    this.grade = 50;
}

MemberConstruct(String name, int age, int grade) {
    this.name = name;
    this.age = age;
    this.grade = grade;
}
```

-> 상황에 따라 다른 생성자 선택 가능

---

##  this() - 생성자 내부에서 다른 생성자 호출

중복 코드 제거를 위한 기능

```java
MemberConstruct(String name, int age) {
    this(name, age, 50);
}
```

###  규칙

- `this()`는 생성자 **첫 줄**에만 작성 가능
- 생성자 내부에서 다른 생성자 호출

---

##  생성자 정리

- 생성자는 객체 생성 직후 자동 호출된다.
- 객체 초기화를 강제할 수 있다.
- 필수값 입력을 보장할 수 있다.
- 기본 생성자는 조건에 따라 자동 생성된다.
- 생성자도 오버로딩 가능하다.
- `this()`로 중복 제거 가능하다.

---

##  이번 파트에서 얻은 가장 중요한 이해

- 객체는 생성 시점에 완전한 상태로 만들어져야 한다.
- 생성자는 초기화를 강제하는 장치다.
- 좋은 프로그램은 "자유"가 아니라 "제약"이 있는 프로그램이다.
- 생성자는 안정성을 높이는 도구다.

---

## 한 줄 정리

> 생성자는 객체 생성 시 초기화를 보장하는 특별한 메서드이며, 올바른 객체 상태를 강제하는 중요한 장치이다.