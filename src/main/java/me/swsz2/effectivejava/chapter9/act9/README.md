# 리플렉션보다는 인터페이스를 사용하라

> 현재까지 리플렉션을 실무에서 사용해본 적이 없어 크게 느낀 점이 없다.

## 정리
리플렉션은 특수한 시스템을 개발할 때 필요한 강력한 기능이나 단점이 많다. <br>
(주로 컴파일타임에는 알 수 없는 클래스를 사용하는 프로그램을 작성할 때 사용한다.) <br>
그렇기 때문에 되도록 객체 생성에만 사용하고, 생성한 객체를 이용할 때는 적절한 인터페이스나 컴파일타임에 알 수 있는 상위 클래스로 형변환해 사용해야 한다. <br>


## 리플렉션의 단점
    - 컴파일타임 타입 검사가 주는 이점을 누릴 수 없다.
    - 리플렉션을 이용하면 코드가 지저분하고 장황해진다.
    - 성능이 떨어진다.