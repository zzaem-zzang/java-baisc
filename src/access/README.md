# 📘 Java Basic - 접근 제어자 (Access Modifier)

이번 학습에서는 **접근 제어자(access modifier)** 를 통해  
객체 내부 데이터를 보호하는 방법과 캡슐화의 완성 개념을 배웠다.

---

##  이번에 학습한 핵심 내용

---

###  접근 제어자가 필요한 이유

자바는 `public`, `private` 같은 접근 제어자를 제공한다.  
접근 제어자는 **클래스 외부에서 필드나 메서드에 접근할 수 있는 범위를 제한**한다.

ex) Speaker 클래스

```java
public class Speaker {
    int volume;

    void volumeUp() {
        if (volume >= 100) {
            System.out.println("음량을 증가할 수 없습니다.");
        } else {
            volume += 10;
        }
    }
}
```

문제 발생:

```java
speaker.volume = 200;  // 외부에서 직접 수정 가능
```

-> 메서드에서 100을 넘지 못하게 막았지만  
외부에서 필드에 직접 접근하면 제약이 무너진다.

---

###  private으로 데이터 보호하기

해결 방법:

```java
private int volume;
```

`private`은 **해당 클래스 내부에서만 접근 가능**하다.

외부에서 접근하면 컴파일 오류가 발생한다.

```
volume has private access in Speaker
```

- 외부 직접 수정 차단
- 반드시 메서드를 통해서만 값 변경 가능

---

###  접근 제어자의 종류

| 접근 제어자 | 접근 범위 |
|-------------|-----------|
| `private` | 같은 클래스 내부 |
| `default`  | 같은 패키지 |
| `protected` | 같은 패키지 + 상속 관계 |
| `public` | 모든 외부 |

접근 허용 범위:

```
private → default → protected → public
(가장 제한적)              (가장 개방적)
```

---

###  default 

접근 제어자를 명시하지 않으면 자동으로 `default`가 적용된다.

```java
int number;  // default 접근 제어자
```

- 같은 패키지에서는 접근 가능  
-  다른 패키지에서는 접근 불가

---

###  필드/메서드 접근 제어

#### 같은 패키지

- public → 가능
- default → 가능
- private → 불가

#### 다른 패키지

- public → 가능
- default → 불가
- private → 불가

 private은 오직 자기 클래스 내부에서만 접근 가능

---

###  클래스 레벨 접근 제어

클래스에는 `public`과 `default`만 사용 가능하다.

- `public` 클래스 → 파일명과 동일해야 함
- 한 파일에 public 클래스는 하나만 가능
- default 클래스는 여러 개 가능

```java
public class PublicClass { }
class DefaultClass { }
```

---

###  캡슐화 (Encapsulation)

캡슐화란 **데이터와 메서드를 하나로 묶고, 외부에서 꼭 필요한 기능만 공개하는 것**이다.

-  데이터는 숨기고 (`private`)  
-  기능은 필요한 것만 공개 (`public`)

---

###  잘 캡슐화된 예제 

```java
public class BankAccount {
    private int balance;

    public void deposit(int amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(int amount) {
        if (amount > 0 && balance >= amount)
            balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
```

-  balance는 외부에서 직접 수정 불가  
-  deposit/withdraw를 통해서만 변경 가능  
-  내부 검증 로직은 private 메서드로 숨길 수 있다

---

##  이번 파트에서 얻은 가장 중요한 이해

- 접근 제어자는 객체 내부 데이터를 보호하기 위한 장치이다
- private은 가장 강력한 보호 수단이다
- default는 같은 패키지 내부 보호
- public은 외부 공개용 기능
- 캡슐화는 접근 제어자를 통해 완성된다
- 좋은 객체는 **데이터를 숨기고 필요한 기능만 제공한다**

---

##  한 줄 정리

> **접근 제어자는 객체의 데이터를 보호하고, 캡슐화를 완성하기 위한 핵심 문법이다.**