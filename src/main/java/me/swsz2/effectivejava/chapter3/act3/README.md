# toString을 항상 재정의하라

## 재정의하지 않으면?
    - {className}@{hashCode}로 출력된다.
    - 유효한 정보를 얻기 힘들다.

## 재정의하면?
    - 디버깅이 쉽다.
    - 객체가 가진 주요 요소를 쉽게 확인할 수 있다.

## 사실...
    - lombok의 사용이 거의 필수가 된 이 시점에서 toString을 재정의하는 것보다 @ToString 어노테이션을 사용하는 것을 잊지 않는 것이 좋겠다. 
