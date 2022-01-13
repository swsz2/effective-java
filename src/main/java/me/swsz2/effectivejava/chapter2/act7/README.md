# 다 쓴 객체 참조를 해제하라

## 예제

```java
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() throws Exception {
        if (size == 0) {
            throw new IllegalStateException("stack 사이즈가 0일 경우 오류가 발생합니다");
        }
        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
```

### 예제에 대한 나의 생각
    -  주제와 예제가 서로 어울리지 않는다고 생각함
        - Stack이라는 자료구조에서 pop()이라는 함수는 스택의 맨 위 데이터를 반환함과 동시에 스택에서 데이터를 제거한다.  
        - 그런데 예제에서는 함수의 행동과 코드가 일치하지 않는다.
            - pop() 인데 peek()을 써놓은 느낌이다.
                - peek()이라는 함수는 스택의 맨 위 데이터를 반환하면서 스택에서 제거하지 않는다.
        - 설명을 위한 예제였겠으나 별로 좋지 않다고 생각한다.
        - 정리하자면 pop() 함수에 참조 해제 (null)를 하는 것은 메모리 누수를 방지하는 것이라기보다 함수 설계에 맞는 기능을 추가한 것으로 보인다.
            - 물론 null 처리해서 gc가 일하게 하는 것도 맞는 말이긴 하다.
        
## 메모리 누수 방지 방법
### 더 이상 사용하지 않을 객체를 null로 처리한다.
    - 방법이다.
    - 좋은 방법은 아니라고 생각한다.
        - Managed Language의 강점을 활용하지 못 하는 방법이라고 생각한다.
            - gc에게 "이 객체는 더 이상 사용하지 않아요"라고 알려줄 수 있다.
            - 그런데 이것은 "내가 직접 메모리 관리를 하겠다." 와 비슷한 맥락이라고 생각한다.
            - 결과적으로 Managed Language의 강점을 활용하지 못 한 상황이 됐다.
            - (2022-01-13) 오히려 Managed Language를 잘 이용하고 있을 수도 있다는 생각을 했다.
                - null로 처리하면 gc가 회수한다는 것을 이해하고 있다는 것일 수도 있다.

### 참조 범위 (scope)를 작게 만들어 이를 벗어나는 순간 gc 대상이 되게 한다.
    - 방법이다.
    - 굳이 비교하자면 위 방법보다 좋은 방법이라고 생각한다.
        - 단일 책임의 원칙(함수 기준)을 지키면 자연스럽게 지역 변수로 작성된 객체들이 함수가 종료됨에 따라 gc 대상이 될 것이다.
    - 메소드 바디에 블록을 사용하여 지역변수화 시키는 것도 방법이다.
        - {}

## 결론
    - Managed Language를 사용하더라도 메모리에 신경을 써야 한다.
