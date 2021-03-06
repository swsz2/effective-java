# 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라

## @Autowired vs @RequiredArgsConstructor
    - 주로 스프링 프레임워크에서 작업을 하는 나에게는 위 두 가지 어노테이션의 문제로 느껴졌다.

## @Autowired 장, 단점
### 장점
    - 간단하다.

### 단점
    - 단일 책임의 원칙을 위반한다.
        - 의존성을 주입하기 쉬우니 쉽게 사용할 수 있고 이는 클래스의 책임이 많아진다는 것
        - 자신의 책임이 아니여도 책임이 나한테 온다.
    - 의존성을 확인하기 어렵다.
        - 생성자에 명시가 됐다면 `아 이 클래스에서 이러한 의존성을 사용하는구나` 라고 알 수 있다.
        - 그렇지 않은 경우에는 `왜 여기서 이 클래스에 대한 오류가 발생하지?`
        - 직관적이지 않다는 말이다.
    - 상수화할 수 없다.
    - 순환 참조가 될 가능성이 생긴다.

## @RequiredArgsConstructor 장점

    - 순환 참조 방지
    - 상수화할 수 있다
    - 테스트 코드 작성이 쉽다.

    
