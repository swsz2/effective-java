# 상속보다는 컴포지션을 사용하라
    
## 상속
    - 기존의 클래스에 기능을 추가하거나 재정의하여 새로운 클래스를 정의하는 것
        - 기존의 클래스를 부모 클래스, 새롭게 작성되는 클래스를 자식 클래스라고 함
    - is-a 관계일 때 사용
    
## 컴포지션
    - 다른 객체의 인스턴스를 자신의 인스턴스 변수로 포함해서 메서드를 호출하는 것
        
## 김성원이 생각하기에 이 글에서 하고자 하는 말은 이런 것이 아닐까
    - 상속의 오용은 위험하다.
    - 상속을 사용할 때와 컴포지션을 사용할 때를 잘 구분해야 한다.
    
    - 번역의 문제일 수도 있지만 상속보다는 컴포지션을 사용하라는 표현 자체는 무의미하다고 생각한다.
        - 상속이 필요한 상황도 있고 컴포지션이 필요한 상황도 있다.
        - 컴포지션을 사용해야 할 상황에 상속을 사용하는 경우가 종종 있기 때문에 올바른 사용을 유도하기 위한 표현이라고 생각
        - 어떤 기법이든 잘 이해하고 목적에 맞게 사용하는 것이 중요하다고 생각한다.