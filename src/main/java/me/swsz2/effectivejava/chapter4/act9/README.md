# 태그 달린 클래스보다는 클래스 계층 구조를 활용하라

    - 두 가지 이상의 의미를 표현할 수 있으며 그중 현재 표현하는 의미를 태그 값으로 알려주는 클래스를 본 적이 있을 것이다.

```java
class Figure {
    enum Shape {
        RECTANGLE, CIRCLE
    }
}
```

## 태그 달린 클래스의 단점

    - 열거 타입 선언, 태그 필드, switch문 등 쓸데없는 코드가 많다.
        - 장황하고 오류를 내기 쉽고 비효율적이다.
    - 태그 달린 클래스는 클래스 계층 구조를 어설프게 흉내낸 아류일 뿐이다.

```java
abstract class Figure {
    abstract double area();
}

class Circle extends Figure {
    @Override
    double area();
}

class Rectangle extends Figure {
    @Override
    double area();
}
```

    - 클래스 계층 구조로 변경하면 단점을 모두 제거할 수 있다.

## 결론 : 정말 상수의 의미로 사용하고 싶을 때만 enum을 사용하자