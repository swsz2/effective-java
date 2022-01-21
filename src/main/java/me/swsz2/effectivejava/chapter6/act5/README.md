# 확장할 수 있는 열거 타입이 필요하면 인터페이스를 사용하라

```java
public interface Operation {
    double apply(double x, double y);
}
```

```java

public enum BasicOperation implements Operation {
    Plus("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    }
}
```

    - 이번 주제를 보면서 드는 생각은 '굳이?'다.
    - 확장할 수 있는 열거 타입이 필요한 상황이 얼마나 될까라는 생각이 든다.
        - ENUM은 정말 상수 자체로 사용될 때 가장 아름답다고 생각한다.
        - 확장을 하는 순간 class나 function의 냄새가 느껴진다.
        - ENUM을 사용하는 클라이언트가 확장의 존재를 알고 있어야 사용할 수 있다.