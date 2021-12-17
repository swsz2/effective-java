# private 생성자나 열거 타입으로 싱글턴임을 보증해라

## 고민해본 기억이 없음

    - 지금까지 했던 대부분의 개발은 스프링 부트 기반의 개발이였다.  
    - 따라서 @Component 계열의 어노테이션을 통해 애플리케이션 컨텍스트 내 싱글턴화했다.
        - @Service, @Contoller 등...

## 방법
### public static final 필드 (OperatingSystemProperties.java)
    - 싱글턴화 하고자 하는 클래스의 private 생성자는 public static final 필드의 인스턴스를 초기화할 때 딱 1회 호출된다.
    - private 생성자 외 생성자가 없다면 클래스 초기화시 생성된 인스턴스가 하나임을 보장한다.
    - 단, 리플렉션 API인 AccessibleObject.setAccessible을 사용해 생성할 수 있다.
        - 위와 같은 경우 인스턴스가 중복 생성되려 할 때 예외를 던지면 된다.

### 정적 팩터리 방식 (OperatingSystemProperties2.java)
    - 책에서 제시한 장점은 나에게 장점으로 느껴지지 않는다. 그냥 선택 사항정도?
        - 팩터리 메서드 참조를 공급자로 사용할 수 있다.
            - 그렇게 쓸 수는 있지만 functional 프로그래밍을 아름답게 사용하기 위한 적용은 좀 아쉽다...
        - 스레드별로 다른 인스턴스를 제공할 수 있다.
            - 스레드별로 다른 인스턴스를 제공하려면 왜 싱글턴으로 구현했지... 
        - 싱글턴을 싱글턴이 아니게 변경할 수 있다.
            - 그러면 왜 싱글턴으로 처음부터 구현했지...
    - 역직렬화 과정에서 싱글턴이 중복으로 생성될 수 있다.
        - 따라서 직렬화 객체가 인스턴스화될 때 호출되는 함수인 private Object readResolve 함수에서 인스턴스를 반환하도록 변경하여 이를 예방한다.

### 열거 (Enum) 타입  (OperatingSystemProperties3.java)
    - 확실히 간결하다.