# 인터페이스는 타입을 정의하는 용도로만 사용해라

    - 인터페이스는 자신을 구현한 클래스의 인스턴스를 참조할 수 있는 타입 역할은 한다.
    - 다른 말로는 자신의 인스턴스로 어떠한 행위를 할 수 있는지 알려준다는 뜻이다.

## 안티패턴

### 상수 인터페이스

    - 사용하지 않는 상수 변수가 네임스페이스를 오염시킬 수 있다.
    - 적용할 때는 문제가 아니지만 다음 릴리즈때 상수가 필요없어도 이전 버전과의 호환성을 위해 제거할 수 없다.
    - ide의 도움이 없으면 변수 트래킹이 어렵다.
    - 외부에 제공할 때 구현 방식이 보일 수 있다. 
    - 인터페이스와 클래스 내부 상수가 충돌할 수 있다.