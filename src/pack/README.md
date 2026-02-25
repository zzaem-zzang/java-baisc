# 📘 Java Basic - 패키지

이번 학습에서는 자바에서 클래스를 체계적으로 관리하기 위한 **패키지(Package)** 개념과, `package` 선언 방법, `import` 사용법, 패키지 규칙에 대해 이해했다.

---

## 이번에 학습한 핵심 내용

---

###  패키지가 필요한 이유

프로그램이 작을 때는 클래스가 몇 개 없어서 관리가 어렵지 않다.

```
Order
User
Product
```

하지만 프로그램이 커지면 클래스 수가 매우 많아진다.

```
User
UserManager
UserHistory
Product
ProductCatalog
ProductImage
Order
OrderService
OrderHistory
ShoppingCart
CartItem
Payment
PaymentHistory
Shipment
ShipmentTracker
```

클래스가 많아질수록 **관련 기능끼리 묶어서 관리할 필요**가 생긴다.

-> 이때 사용하는 것이 **패키지(package)** 이다.

---

###  패키지란?

> 패키지는 관련된 클래스들을 묶어 관리하는 논리적 그룹(폴더 개념)이다.

예시 구조:

```
user
 ├ User
 ├ UserManager
 ├ UserHistory

product
 ├ ProductId
 ├ ProductPrice

order
 ├ Order
 ├ OrderService
 ├ OrderHistory
```

- `user`, `product`, `order` 가 패키지이다.
- 관련된 클래스들을 같은 패키지에 모아둔다.

---

###  패키지 선언 방법

패키지를 사용하는 경우 **코드 첫 줄에 package 선언**을 해야 한다.

```java
package pack;

public class Data {
}
```

- 패키지 이름과 실제 폴더 구조는 반드시 일치해야 한다.

---

###  다른 패키지 클래스 사용 방법

패키지가 다르면 전체 경로를 포함해서 작성해야 한다.

```java
pack.a.User user = new pack.a.User();
```

같은 패키지라면 패키지명을 생략할 수 있다.

---

###  import 사용

매번 전체 경로를 쓰는 것은 불편하다.  
이때 `import`를 사용한다.

```java
package pack;

import pack.a.User;

public class PackageMain {
    public static void main(String[] args) {
        User user = new User();
    }
}
```

- `import`는 `package` 아래에 작성한다.
- import를 사용하면 패키지명을 생략할 수 있다.

---

###  패키지 전체 import

```java
import pack.a.*;
```

- `*`를 사용하면 해당 패키지의 모든 클래스를 사용할 수 있다.

---

###  클래스 이름이 같은 경우

```
pack.a.User
pack.b.User
```

- 클래스 이름이 같아도 패키지가 다르면 구분할 수 있다.

둘 다 사용하려면:

```java
import pack.a.User;

User userA = new User();
pack.b.User userB = new pack.b.User();
```

- 하나는 import
- 하나는 전체 경로 작성

---

###  패키지 규칙

####  패키지 이름과 폴더 구조는 같아야 한다 (필수)

패키지 선언과 실제 디렉토리 구조가 일치해야 한다.

---

####  패키지 이름은 모두 소문자 사용 (관례)

```
com.example.myapp
```

---

####  도메인 이름을 거꾸로 사용 (관례)

~~~
com.company.project
~~~

이유:
- 외부 라이브러리와 이름 충돌 방지
- 전 세계적으로 고유한 패키지명 확보

---

###  패키지와 계층 구조

예:

```
a
 ├ b
 └ c
 
 총 3개의 패키지가 존재하는 것이다.
```

존재하는 패키지:

- a
- a.b
- a.c

주의할 점:

> 계층 구조처럼 보이지만 서로 완전히 다른 패키지이다.

따라서 `a`에서 `a.b`를 사용하려면 반드시 `import` 해야 한다.

---

## 이번 파트에서 얻은 가장 중요한 이해

- 패키지는 클래스를 논리적으로 묶는 단위이다.
- 패키지 선언과 폴더 구조는 반드시 일치해야 한다.
- 다른 패키지의 클래스를 사용하려면 `import`가 필요하다.
- 패키지는 계층 구조처럼 보이지만 서로 독립적이다.
- 도메인을 거꾸로 사용하는 것이 일반적인 관례이다.

---

## 한 줄 정리

> 패키지는 클래스를 체계적으로 분류하기 위한 구조이며, 폴더 구조와 일치해야 하고 import를 통해 다른 패키지와 연결된다.