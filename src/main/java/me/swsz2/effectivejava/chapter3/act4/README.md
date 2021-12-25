# clone 재정의는 주의해서 진행하라

## cloneable

    - 개체 자신을 복제하는 메서드를 제공할 때 Cloneable 인터페이스를 기반으로 구현 클래스를 정의하는 것을 권고함
        - 해당 인터페이스에는 아무런 메소드가 없음
        - 왜냐면 본제가 가능하다고 알려만 주는 인터페이스이기 때문이다.

## clone()
    - clone() 메소드는  java.lang.Object 클래스에 존재
        - protected native Object clone() throws CloneNotSupportedException;
    - 기본적으로는 메모리를 복사한다.


## 재정의가 필요한 이유?
    - 고민을 해본 문제가 아니라 지금 당장 좋은 예제가 떠오르질 않는다.
    - 추상 객체를 맴버 변수로 가지고 있는 클래스에 대해 clone() 기능을 제공 할 때 ?
        - List 에는 clone() 메소드가 없으나 ArrayList에는 clone() 메소드가 있다.
    - 제대로된 deep copy를 하기 위해서...

## 주의할 것
    - x.clone() != x 는 true여야 한다.
    - x.clone().getClass() == x.getClass()는 true여야 한다.
        - 하지만 항상 필요한 조건은 아니다.
    - x.clone().equals(x) 는 true여야 한다.
        - 논리적 동치성 보장 
        
    - x.clone().getClass() == x.getClass()는 true여야 한다.
    - Cloneable을 implement하지 않으면 CloneNotSupportedException이 발생한다.
    
```java
    /**
     * Creates and returns a copy of this object.  The precise meaning
     * of "copy" may depend on the class of the object. The general
     * intent is that, for any object {@code x}, the expression:
     * <blockquote>
     * <pre>
     * x.clone() != x</pre></blockquote>
     * will be true, and that the expression:
     * <blockquote>
     * <pre>
     * x.clone().getClass() == x.getClass()</pre></blockquote>
     * will be {@code true}, but these are not absolute requirements.
     * While it is typically the case that:
     * <blockquote>
     * <pre>
     * x.clone().equals(x)</pre></blockquote>
     * will be {@code true}, this is not an absolute requirement.
     * <p>
     * By convention, the returned object should be obtained by calling
     * {@code super.clone}.  If a class and all of its superclasses (except
     * {@code Object}) obey this convention, it will be the case that
     * {@code x.clone().getClass() == x.getClass()}.
     * <p>
     * By convention, the object returned by this method should be independent
     * of this object (which is being cloned).  To achieve this independence,
     * it may be necessary to modify one or more fields of the object returned
     * by {@code super.clone} before returning it.  Typically, this means
     * copying any mutable objects that comprise the internal "deep structure"
     * of the object being cloned and replacing the references to these
     * objects with references to the copies.  If a class contains only
     * primitive fields or references to immutable objects, then it is usually
     * the case that no fields in the object returned by {@code super.clone}
     * need to be modified.
     * <p>
     * The method {@code clone} for class {@code Object} performs a
     * specific cloning operation. First, if the class of this object does
     * not implement the interface {@code Cloneable}, then a
     * {@code CloneNotSupportedException} is thrown. Note that all arrays
     * are considered to implement the interface {@code Cloneable} and that
     * the return type of the {@code clone} method of an array type {@code T[]}
     * is {@code T[]} where T is any reference or primitive type.
     * Otherwise, this method creates a new instance of the class of this
     * object and initializes all its fields with exactly the contents of
     * the corresponding fields of this object, as if by assignment; the
     * contents of the fields are not themselves cloned. Thus, this method
     * performs a "shallow copy" of this object, not a "deep copy" operation.
     * <p>
     * The class {@code Object} does not itself implement the interface
     * {@code Cloneable}, so calling the {@code clone} method on an object
     * whose class is {@code Object} will result in throwing an
     * exception at run time.
     *
     * @return     a clone of this instance.
     * @throws  CloneNotSupportedException  if the object's class does not
     *               support the {@code Cloneable} interface. Subclasses
     *               that override the {@code clone} method can also
     *               throw this exception to indicate that an instance cannot
     *               be cloned.
     * @see java.lang.Cloneable
     */
    @HotSpotIntrinsicCandidate
    protected native Object clone() throws CloneNotSupportedException;
```