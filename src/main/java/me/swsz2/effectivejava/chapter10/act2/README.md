# 복구할 수 있는 상황에는 검사 예외를, 프로그래밍 오류에는 런타임 예외를 사용하라.

> 결국 CheckedException, UncheckedException 에 대한 내용이라고 생각한다. <br>
> 따라서 내가 최근에 정리한 글을 공유하는 것으로 대체한다..


**[정리]**
|타입|설명|예시|롤백 <br>여부|
|:---:|:---:|:---:|:---:|
|Error|소프트웨어가 포착하려고 하면<br>안 되는 심각한 오류|OutOfMemory<br>StackOverFlow|X|
|CheckedException|명시적으로 처리해야 하는 예외|IOException|X|
|UncheckedException|명시적으로 처리하지 않아도 되는 예외|RuntimeException<br>  NullPointerException|O|

**Error**
> OutOfMemory, StackOverFlow 등 소스 코드의 수정 외에는 해결 방법이 없는 경우는 수 별도 처리하지 않는다.
> 개발자에 의해 롤백은 하지 않으나 프레임워크 특성에 따라 롤백된다.

**CheckedException**
> IOException 등 발생 가능성을 미리 알 수 있고 처리하기로 정한 예외는 적절한 예외 처리를 추가하고 롤백을 하지 않는다.

**UncheckedException**
> RuntimeException, NullPointerException 등 명시적으로 처리하지 않아도 되는 예외는 오류 메시지만 저장하고 진행 프로세스는 롤백한다.