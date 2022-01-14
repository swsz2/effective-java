# 한정적 와일드카드를 사용해 API 유연성을 높여라

## 생산자와 와일드카드

    - Stack<Number>에 List<Integer>를 삽입하려니 아래와 같은 메시지가 반환된다.

```java
    public void pushAll(Iterable<E> src) {
        for(E e:src){
        push(e);
        }
    }
```

```shell
    java: incompatible types: java.lang.Iterable<java.lang.Integer> cannot be converted to java.lang.Iterable<java.lang.Number>
```

    - 당연하다. 제네릭의 매개변수 타입은 불공변이기 때문에 상-하위 관계가 없다.
    따라서 이를 해결하려면 매개변수에 바운디드 와일드카드 자료형을 사용하면 된다.

```java
    public void pushAll(Iterable<?extends E> src) {
        for(E e:src){
        push(e);
        }
    }
```

    - Iterable<?extends E>는 E의 하위 타입의 Iterable이라는 뜻이다.
        - 예제에서는 Number를 상속하는 클래스를 의미한다.


## 소비자와 와일드카드

    - Stack<Number>에서 요소를 뽑아 Collection<Object>에 모두 넣기를 시도하면 유사한 오류가 발생한다.
        - Stack<Number>.popAll(Collection<Object>);
```java
    public void popAll(Collection<E> destination) {
        while(!isEmpty()) {
            destination.add(pop());
        }
    }
```

    - Number 클래스는 최상위 Object클래스를 상속하지만 매개변수 타입은 불공변이기 때문에 상속 관계가 무의미하다.
        - 이때는 (Collection<? super E> destination) 을 선언하여 해결한다.
            - E의 상위 타입 Collection을 의미한다.

## PECS
    - Producer Extends + Consumer Super
        - 메서드의 매개변수 타입이 생산자를 나타내면 extends
        - 소비자를 나타낸다면 <? super T>