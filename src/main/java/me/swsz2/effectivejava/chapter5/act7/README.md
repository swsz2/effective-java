# 제네릭과 가변인수(인자)를 함께 쓸 때는 신중하라

## 가변인수(인자)란?
    - 개수와 타입이 미리 정해져있지 않은 인수(인자)
        - 아래 예제에서 a에 해당한다.
    
```java
public class Arrays {
  @SafeVarargs
  @SuppressWarnings("varargs")
  public static <T> List<T> asList(T... a) {
    return new ArrayList<>(a);
  }
}
```
## 근데 왜 함께 쓸 때 신중해야 하는가?
    - 제네릭은 타입을 지정하지 않기 때문에 캐스팅 오류가 발생하기 쉽다.
        -  이는 Heap Pollution을 발생시킬 가능성이 크다.

    - 오류 발생 가능이 쉬우나 활용도는 매우 높다.
        - 예제인 Arrays.toList만 봐도 이미 편안하지 않은가... 

### Heap Pollution?
    - 단순한 해석으로는 힙 오염
    - 어떠한 이유에서든 힙에 문제가 생기면 그것을 Heap Pollution이라고 한다.

## 제네릭과 가변인수를 사용하면서 Heap Pollution 을 방지하려면?
    - 가변인수 배열이 호출자로부터 그 메서드로 순수하게 인수들은 전달하는 일만 하게 하라
        - 메서드가 가변인수 배열에 아무것도 저장하지 않게 하라
        - 가변인수 배열의 참조가 밖으로 노출되지 않게 하라
 

## 김성원의 생각...
    - 하위 호환성을 보장하기 위한 엄청난 노력이 보인다.
    - 유틸 성격의 오픈소스를 작성하는 엔지니어들이 멋지다.  

## 참고
    - https://parkadd.tistory.com/130