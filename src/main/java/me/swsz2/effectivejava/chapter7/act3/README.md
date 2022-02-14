# 표준 함수형 인터페이스를 사용하라

    - java가 람다를 지원함으로 인해 api의 모범 사례도 크게 바뀌었다.
    - 아래 케이스를 보면서 함수형 인터페이스에 대해 고민해보자

## 기본 함수형 인터페이스

### UnaryOperator\<T\>

    - T apply(T t) 함수를 시그니쳐로 한다.
    - 입력 파라미터는 1개로 제한된다.
    - String::toLowerCase

### BinaryOperator\<T>
    - T apply(T t1, T t2) 함수를 시그니쳐로 한다.
    - 입력 파라미터는 2개로 제한된다.
    - BigInteger::add

### Predicate\<T>
    - boolean test(T t) 함수를 시그니쳐로 한다.
    - 입력 파라미터는 1개로 제한된다.
    - Collection::isEmpty
    - Stream.filter 등에 사용 가능하다.
        - Stream<T> filter(Predicate<? super T> predicate);

### Function\<T,R>
    - R apply(T t) 함수를 시그니쳐로 한다.
    - 입력 파라미터는 1개로 제한된다.
    - Arrays.asList
    - Stream.map 등에 사용 가능하다.
        - <R> Stream<R> map(Function<? super T, ? extends R> mapper);

### Supplier\<T>
    - T get() 함수를 시그니쳐로 한다.
    - 내부적으로 어떠한 로직도 있으면 안되며 오직 new 구문만 있어야 한다.
    - 입력 파라미터는 없다.
    - Instant::now
    - Stream.collect 등에 사용 가능하다.
        -     <R> R collect(Supplier<R> supplier,
                  BiConsumer<R, ? super T> accumulator,
                  BiConsumer<R, R> combiner);

### Consumer\<T>
    - void accecp(T t) 함수를 시그니쳐로 한다.
    - 반환값이 없다.
        - 입력값으로 반환값이 없는 어떠한 행위를 한다.          
    - System.out::plrintln
    - Stream.forEach 등에 사용 가능하다.
        - void forEach(Consumer<? super T> action);

## 그래서 하고 싶은 말은...
    - 람다를 지원하니까 api 설계할 때 참고해라.
    - 강력한 기능의 Stream과 조합하여 사용할 수 있기 때문에 도입을 적극 검토해봐도 좋겠다.
    - 아쉬운 점은 java의 함수형 프로그래밍에 익숙하지 않다는 점 