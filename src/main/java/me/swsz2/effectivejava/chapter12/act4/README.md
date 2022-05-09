# readObject 메서드는 방어적으로 작성하라
 - private 이어야 하는 객체 참조 필드는 각 피륻가 가리키는 객체를 방어적으로 복사하라.  
 - 모든 불변식을 검사하여 어긋나는 게 발견되면 InvalidObjectException 을 던진다.  
 - 역직렬화 후 객체 그래프 전체의 유효성을 검사해야 한다면 ObjectInputValidation 인터페이스를 사용하라  
 - 직접적이든 간접적이든, 재정의할 수 있는 메서드는 호출하지 말자  