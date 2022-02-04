# 매개변수가 유효한지 검사하라
    
## 설명
    - 메서드와 생성자 대부분은 입력 매개변수의 값이 특정 조건을 만족하기를 바란다.
        - 예를 들면 객체 참조는 null이면 안된다는 식이다.
        - 이런 제약은 반드시 문서화해야 하며 메서드 몸체가 시작되기 전에 검사해야 한다.
            - 메서드 몸체에서 특정 조건에 맞지 않아 오류가 발생하면 원인을 빠르게 찾아가기 어렵다.
        
## 수단
### Objects.requireNonNull
```java
    public static <T> T requireNonNull(T obj) {
        if (obj == null)
            throw new NullPointerException();
        return obj;
    }
```
> 타입에 관계없이 매개변수가 null인 경우 NullPointerException을 반환한다.
> 
#### 단점
    - null 외에는 처리할 수 없다.

### assert
```java
    assert a != null;
    assert offset >= 0 && offset <= a.length;
```
> assert 뒤에 오는 연산이 true일 경우에만 다음 라인을 수행한다.
> 연산의 결과가 false라면 AssertError를 반환한다.
> java를 실행할 때 -ea 옵션을 주면 런타임에서 동작한다.

#### 단점
    - 예외(Exception)가 아닌 오류(Error)를 반환하기 때문에 Throwable 처리에 미숙한 경우 의도치 않은 결과를 만들 수 있다. 

### spring framework Assert class
```java
     Assert.notNull(clazz, "The class must not be null");
     Assert.isTrue(i > 0, "The value must be greater than zero");
```
> 스프링 프레임워크에서 지원하는 Assert 클래스
> 1번 매개변수가 함수명에 따른 연상에 true일 경우 다음 라인을 수행한다.
> 연산의 결과가 false일 경우 IllegalArgumentException을 반환한다.

#### 장점
    - 여러 케이스에 대해 수행할 수 있도록 다양한 함수를 제공한다.
    - exception 메시지를 직접 설정할 수 있다.

#### 단점
    - 스프링 생태계에 종속된 클래스이다.