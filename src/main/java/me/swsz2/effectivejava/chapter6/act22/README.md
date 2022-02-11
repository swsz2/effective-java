#Optional 반환은 신중히 하라
이전 주제인 **null이 아닌, 빈 컬렉션이나 배열을 반환하라**에서 
> `Optional<T>` 도 유사한 맥락으로 사용할 수 있다.

라고 언급하고 넘어갔었는데 Optional 반환은 신중히 하라고 한다. <br>

## 메소드가 특정 조건에서 값을 반환할 수 없을 때 
### java 8 이전
* 예외를 던진다.
  * 예외는 진짜 예외인 경우에만 던져야 한다.
  * 예외 반환 시 스택 트레이스에 대한 비용이 비싸다.
* null을 반환한다.
  * 클라이언트가 null 처리에 대한 부담을 가진다.
    
두 방법 모두 단점이 있는 방법이다. 

### 이후
* Optional<T> 를 반환한다.
    * null을 반환하는 대신 Optional<T>에 아무것도 담지 않고 반환하면 된다.
    * 반환할 수 없는 상황 중 예외가 아닌 상황을 대변할 수 있다.

라고 하는데 Optional은 무엇인가 알아보자.

## Optional\<T>
### document 
```
A container object which may or may not contain a non-null value.
If a value is present, isPresent() returns true.
If no value is present, the object is considered empty and isPresent() returns false.
Additional methods that depend on the presence or absence of a contained value are provided, such as orElse() (returns a default value if no value is present) and ifPresent() (performs an action if a value is present).
This is a value-based class; use of identity-sensitive operations (including reference equality (==), identity hash code, or synchronization) on instances of Optional may have unpredictable results and should be avoided.
Optional is primarily intended for use as a method return type where there is a clear need to represent "no result," and where using null is likely to cause errors.
A variable whose type is Optional should never itself be null;
it should always point to an Optional instance.
```
### 해석
> Optional은 null이거나 null이 아닌 값을 포함할 수 있는 컨테이너 개체이다. <br>
> 만약 값이 존재한다면, isPresent() 는 true를 반환할 것이다. <br>
> 만약 값이 존재하지 않는다면, 객체는 빈 것으로 간주되고 isPresent() 는 false를 반환할 것이다. <br>
> 값이 없을 경우 default값을 반환하는 orElse() 함수나 값이 있을 경우 어떠한 행위를 하는 ifPresent() 함수와 같이 값의 존재 여부에 따라 달라지는 메소드를 제공한다. <br>   
> Optional은 값 기반 클래스다. reference equality (==) 와 해시코드, 동기화를 포함한 identity-sensitive 연산을 사용하면 예측 불가능한 결과가 나올 수 있으므로 사용을 지양해야 합니다. <br>
> Optional은 'no result'을 표시해야 하거나 null을 사용하면 오류가 발생할 가능성이 있는 경우에 메서드 반환 유형으로 사용하기 위한 것입니다. <br> 
> Optional은 자체적으로 null이 되어서는 안 됩니다. <br>
> 항상 Optional 인스턴스를 가리켜야 합니다.  <br>

### 핵심
Optional은 객체 자체가 아닌 값으로 대화하는 value-based class이다. <br> 
Optional은 비어있는 상태를 지원하기 때문에 Optioanl을 반환하는 메소드는 null을 반환하면 안 된다. <br>

위 내용을 주의해서 사용하면 Optional을 잘 사용할 수 있다. <br>