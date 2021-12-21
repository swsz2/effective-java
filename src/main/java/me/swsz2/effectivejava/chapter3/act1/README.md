# equals는 일반 규약을 지켜 재정의하라

## 재정의를 추천하지 않는 객체의 특징
    - 각 인스턴스가 본질적으로 고유하다.
        - 어떠한 값을 표현하기 위한 인스턴스가 아닌 행동을 표현하는 인스턴스를 얘기한다.
            - Thread (Runnable, Callable)
    - 인스턴스의 논리적 동치성을 검사할 일이 없다.
    - 상위 클래스에서 재정의한 equals가 하위 클래스에도 어울린다.

## equals 메서드가 만족해야 하는 조건
    - 반사성
        - null 이 아닌 모든 참조 x에 대해, x.equals(x)는 true다.
    - 대칭성
        - null 이 아닌 모든 참조 x, y에 대해, x.equals(y)가 true면 y.equals(x)도 true다.
    - 추이성
        - null이 아닌 모든 참조 x, y, z에 대해, x.equals(y)가 true면 y.equals(z)도 true이면 x.equals(z)도 true이다.
    - 일관성
        - null 이 아닌 모든 참조 x, y에 대해, x.equals(y)를 반복해서 호출하면 항상 true이거나 항상 false이다.
    - Not null
        - null 이 아닌 모든 참조 x에 대해, x.equals(null)은 false이다.

## 그래서 김성원이 생각하는 equals를 재정의하는 것을 추천하는 곳은?
    - 데이터베이스 엔티디
        - 데이터베이스에 존재하는 어떠한 row를 참조하고 조작할 때
            - commit을 기준으로 어떠한 컬럼의 값이 변경되더라도 둘은 서로 같은 row라고 생각한다.
            - 그래서 나는 데이터베이스의 엔티티를 정의할 때 equals 함수를 primary key 끼리 비교하도록 재정의하는 것을 추천한다.
    - 컬렉션 
        - ArrayList 안의 요소의 순서와 관계없이 동일한 요소로 구성돼있다면 동일한 ArrayList로 판단하고 싶을 때가 있다.