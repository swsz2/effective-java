#  public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라
    - public 클래스에서는 패키지 바깥에서 접근할 수 있는 접근자를 제공한다.
    - 객체 지향 프로그래머는 public 필드를 사용하는 클래스를 상당히 싫어해서 필드를 모두 private으로 바꾸고 public 접근자를 추가한다.

## public 클래스는 절대 가변 필드를 직접 노출해서는 안 된다?
    - 사실 이 주제에는 고민이 많다.
    - getter, setter vs public final

### getter, setter
    - 직접 필드에 접근할 수 없다.
        - 안정성 추구
        - 객체지향스럽다...

### public final
    - 필드에 접근할 때 콜스택이 한 단계 줄어든다.
        - 성능상 이점

### 실제 코드를 작성하면서 비교해보자 
    - getter, setter : me.swsz2.effectivejava.chapter4.act2.Outer.java
    - public final   : me.swsz2.effectivejava.chapter4.act2.Pants.java

### 김성원의 선택은?
    - public final + builder 패턴 나쁘지 않다.
    - getter, setter 패턴 나쁘지 않다.
    - 개인적으로는 필드값을 직접 세팅할 필요가 없다는 조건에서는 public final을 사용할 거 같다.
        - 의외로 가독성이 좋다.
        - 당장 엄청난 성능에 대한 차이가 있진 않겠지만 반복될 수록 효과적일 수도 있을 거 같다.
        - 다만 public final을 도입하기 위해서는 객체 선언이 매우 신중하게 이루어질 수 있도록 하는 것이 좋겠다.
    