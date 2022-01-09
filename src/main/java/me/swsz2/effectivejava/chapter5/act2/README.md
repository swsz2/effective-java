# 비검사 경고를 제외하라
    - 우선 비검사 경고라고 하니 단어가 이상하다.
        - 영어로 표현하자면 unchecked warnning이다.
        - 컴파일러가 형식(타입) 안정성을 보장할 수 없음을 나타내는 경고다.
        - 종류 
            - unchecked cast warning
            - unchecked method invocation warning
            - unchecked generic array creation warning
            - unchecked conversion warning
            - 등...

## 형식 안정성을 보장해야 하는 이유
    - ClassCastException이 발생할 일이 없다.
    - 작성 의도와 동일하게 동작할 것이라고 확신할 수 있다.

## 경고를 없앨 방법을 찾지 못하겠다면
    - 코드가 형식 안정성을 보장한다는 것을 증명해라
    - @SuppressWarnings("unchecked") 어노테이션으로 경고를 숨겨라
    - 경고를 숨긴 근거를 주석으로 작성해라

### 주의사항
    - 근거가 참이면서 형식 안정성을 보장하는 경우에만 사용해라
    - 그렇지 않으면 실제로 문제가 발생했을 경우 이를 찾기 어려워진다.


### 참고
    - What is an "unchecked" warning?  http://www.angelikalanger.com/GenericsFAQ/FAQSections/TechnicalDetails.html#FAQ001