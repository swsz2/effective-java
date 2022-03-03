# 메소드 시그니처를 신중히 설계하라

## 내용
### 메소드 이름을 신중히 짓자
    - 항상 표준 명명 규칙을 따라야 한다.
        - 메소드, 필드 이름의 첫 글자는 소문자로 작성한다 등
    - 같은 패키지에 속한 다름 이름들과 일관되게 짓는 것이 최우선 목표
    - 개발자 커뮤니티에서 널리 받아들여지는 이름을 사용하는 것
    - 긴 이름을 피하는 것
        - 애매하면 java api를 참조하라

### 편의 메소드를 너무 많이 만들지 말자
    - 모든 메소드는 각각 자신의 소임을 다해야 한다.
    - 메소드가 너무 많은 클래스는 익히고, 사용하고, 문서화하고, 테스트하고, 유지보수하기 힘들다.

### 매개변수 목록은 짧게 유지하자
    - 4개 이하가 좋다.
    - 같은 타입의 매개변수 여러 개가 연달아 나오는 경우는 특히 해롭다.

### 매개변수의 타입으로는 클래스보다는 인터페이스가 낫다.
    - 정확히는 매개변수로 적합한 인터페이스가 있다면 그 인터페이스를 사용하자

### boolean 보다 enum이 낫다.

## 김성원의 생각
    - 모든 내용이 공감된다.
    - 특히 공감되는 내용은 "편의 메소드를 너무 많이 만들지 말자"
        - 이번 주제에 명확히 들어 맞는 이야기는 아니지만 마이크로 서비스화 관점에서 공감했다.
        - 편의 메소드(자신의 소임에서 조금이라도 벗어난)라는 것은 오버 스펙을 말한다고 생각한다.
        - 내 역할 외의 것들을 수행하다 보면 전문성/모듈화 관점에서 크게 해롭다.
            - 본분이 아닌 기능에 대한 유지보수를 해야 하는 경우가 다반사
            - 클라이언트의 편의를 위해 나의 본분을 망치는 경우가 생김