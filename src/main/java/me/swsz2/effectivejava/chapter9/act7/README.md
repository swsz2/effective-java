# 문자열 연결은 느리니 주의하라.

> 책의 내용은 제외하고 내 생각을 작성하고자 한다.

단순히 문자열 연결 관점에서 보는 것보다 불변 객체 처리에 대한 관점으로 이해하는 것이 좋겠다. <br>
String은 immutable 하다는 특성을 가지고 있어 할당한 값을 변경할 수 없다. <br>
따라서 **+** 연산을 할 때 새로운 String 객체를 생성하여 반환하기 때문에 다량의 문자열 연결을 수행할 경우 불필요한 객체가 생성될 수 있다. <br>
따라서 mutable한 특성을 가지고 있는 StringBuilder, StringJoiner 등을 사용하면 불필요한 객체를 생성하지 않아도 된다. <br>


```java
public final class StringJoiner {
    /** Contains all the string components added so far. */
    private String[] elts;
}
```

```java
public final class StringBuilder
        extends AbstractStringBuilder
        implements java.io.Serializable, Comparable<StringBuilder>, CharSequence {
}

abstract class AbstractStringBuilder implements Appendable, CharSequence {
    /** The value is used for character storage. */
    byte[] value;
}
```

```java
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
    private final byte[] value;
}
```