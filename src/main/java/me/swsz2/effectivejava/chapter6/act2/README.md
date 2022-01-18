# ordinal 메서드 대신 인스턴스 필드를 사용하라

## ordinal 메서드?
```
    The ordinal of this enumeration constant (its position in the enum declaration, where the initial constant is assigned an ordinal of zero).
    Most programmers will have no use for this field.
    It is designed for use by sophisticated enum-based data structures, such as java.util.EnumSet and java.util.EnumMap.
```
    -열거 타입에서 몇 번째 위치인지 나타내는 값
        - 대부분의 프로그래머는 해당 값을 사용하지 않는다고 함
    
```java
  enum Ensemble {
    SOLO,
    DUET,
    TRIO;

    public int numberOfMusicians() {
      return ordinal() + 1;
    }
  }
```

    - 현 상태에서 numberOfMusicians() 메서드는 의도와 동일한 값을 반환한다.
    - 그러나 SOLO와 DUET의 선언 순서가 변경되면 의도와 다른 값을 반환한다.
        - DUET.numberOfMusicians() = 1
        - SOLO.numberOfMusicians() = 2

## 의견
    - ordinal 값의 존재를 이번에 처음 알게 됐다.
    - 내가 원하는 순서로 enum이 작성됐다는 보장이 없으니 절대 사용하지 않는 것으로 하자.
        - 보장되더라도 필드값을 선언해서 쓰자