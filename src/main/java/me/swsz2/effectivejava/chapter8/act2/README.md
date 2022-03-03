# 적시에 방어적 복사본을 만들어라
    - 객체의 허락 없이 외부에서 변경할 수 없도록 만들라는 뜻

## 요약
    - 클래스가 클라이언트로부터 받는 혹은 클라이언트로 반환하는 구성요소가 가변이라면그 요소는 반드시 방어적으로 복사해야 한다.
    - 복사 비용이 너무 크거나 클라이언트가 그 요소를 잘못 수정할 일이 없음을 신뢰한다면 방어적 복자를 수행하는 대신 해당 구성요소를 수정했을 때의 책임이 클라이언트에 있음을 문서에 명시하도록 하자

## 김성원의 생각
    - 방어적으로 프로그램을 작성할 필요는 있지만 이 정도로 생각해보진 않았다.
    - 이번 주제는 라이브러리/오픈소스 개발자에게 크게 적용되는 이야기가 아닐까 싶다.  