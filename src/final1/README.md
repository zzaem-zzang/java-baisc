# 📘 Java Basic - final 키워드

이번 학습에서는 **final 키워드의 의미와 동작 원리**를 배우고,  
지역 변수 / 필드 / 상수 / 참조형 변수에서 final이 어떻게 다르게 적용되는지 이해했다.

---

##  이번에 학습한 핵심 내용

###  final의 의미

- final은 “끝”이라는 의미를 가진다.
- 한 번 값이 할당되면 더 이상 변경할 수 없다.
- 변수, 메서드, 클래스에 사용할 수 있다.
- 이번 파트에서는 변수에 사용하는 final을 중심으로 학습했다.

---

###  final - 지역 변수

```java
final int data1;
data1 = 10;   // 최초 1회 할당 가능
// data1 = 20; // 컴파일 오류
```

- 지역 변수에 final을 붙이면 최초 한 번만 값 할당 가능
- 이후 값을 변경하려 하면 컴파일 오류 발생
- 선언과 동시에 초기화하면 이후 재할당 불가

매개변수에 final을 붙인 경우:

```java
static void method(final int parameter) {
    // parameter = 20; // 컴파일 오류
}
```

- 메서드 내부에서 매개변수 값 변경 불가
- 호출 시 전달된 값이 끝까지 유지됨

---

###  final - 필드(멤버 변수)

생성자 초기화 방식

```java
public class ConstructInit {
    final int value;

    public ConstructInit(int value) {
        this.value = value;
    }
}
```

- 생성자를 통해 한 번만 초기화 가능
- 인스턴스마다 다른 값 설정 가능
- 생성 이후 변경 불가

---

필드 초기화 방식

```java
public class FieldInit {
    final int value = 10;
}
```

- 필드에서 직접 초기화하면 모든 인스턴스가 같은 값을 가짐
- 생성자에서 다시 초기화 불가
- 같은 값이 계속 생성되어 비효율적일 수 있음

---

###  static final (상수)

```java
public class Constant {
    public static final double PI = 3.14;
    public static final int MAX_USERS = 1000;
}
```

특징:

- static + final 조합 사용
- 프로그램 전체에서 하나만 존재
- 대문자 + 언더스코어(_) 사용 (관례)
- 값 변경 불가
- 클래스명으로 직접 접근

```java
Constant.MAX_USERS;
```

상수를 사용하는 이유:

- 매직 넘버 문제 해결
- 중앙에서 값 관리 가능
- 코드 가독성 향상

---

###  final - 기본형 vs 참조형

기본형 변수

```java
final int a = 10;
// a = 20; // 컴파일 오류
```

→ 값 자체를 변경할 수 없음

---

참조형 변수

```java
final Data data = new Data();
// data = new Data(); // 컴파일 오류

data.value = 10;  // 가능
data.value = 20;  // 가능
```

- 참조값(주소값) 변경 불가
- 하지만 참조 대상 객체 내부 값은 변경 가능

즉,

- final은 “변수에 저장된 값”을 변경하지 못하게 하는 것
- 참조형의 경우 “주소값”을 변경하지 못하게 하는 것

---

###  final 사용 예시

```java
public class Member {
    private final String id;
    private String name;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void changeData(String id, String name) {
        // this.id = id; // 컴파일 오류
        this.name = name;
    }
}
```

- id는 생성자에서 한 번만 초기화
- 이후 변경 시도 시 컴파일 오류 발생
- 중요한 데이터 보호에 유용

---

##  이번 파트에서 얻은 가장 중요한 이해

- final은 한 번 할당된 값을 변경하지 못하게 하는 키워드다.
- 지역 변수는 재할당 불가.
- 필드는 생성자 또는 필드에서 한 번만 초기화 가능.
- static final은 상수로 사용한다.
- 참조형에서 final은 주소 변경만 막고 객체 내부 값은 변경 가능하다.

---

##  한 줄 정리

> **final은 한 번 정해진 값을 끝까지 유지하도록 보장하는 안전장치이다.**