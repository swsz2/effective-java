# Comparable을 구현할지 고려하라

## Comparable
    - 알파벳, 숫자, 연대 같이 순서가 명확한 값 클래스를 작성할 때 유용하게 사용할 수 있는 인터페이스

```java
public interface Comparable<T> {
    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param   o the object to be compared.
     * @return  a negative integer, zero, or a positive integer as this object
     *          is less than, equal to, or greater than the specified object.
     *
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException if the specified object's type prevents it
     *         from being compared to this object.
     */
    public int compareTo(T o);
}

```

    - 모든 x, y에 대해 sgn(x.compareTo(y)) == -sgn(y.compareTo(x))을 만족해야 한다
    - x.compareTo(y) 가 exception을 throw한다면  y.compareTo(x) 도 exception을 throw해야 한다.
    - x.compareTo(y) > 0 && y.compareTo(z) > 0 이라면 x.compareTo(z) > 0 이다.
    - x.compareTo(y)==0 이면 sgn(x.compareTo(z)) == sgn(y.compareTo(z))
    

## 그래서 뭐가 중요한데?
    - 기본적으로 compareTo 함수에 대한 제약은 무조건 중요하다. 
        - 그런데 이건 함수에 대한 이야기이고 개발에 대한 이야기를 해보자면...

    - "순서가 명확한 클래스를 구현할 때 정렬하는 유틸을 생성하지 말고 Comparable 인터페이스를 사용해서 간결하게 구현해라" 라는 것이다.
        - 가끔 개발을 하다보면 어떠한 값에 대한 정렬을 하는 유틸을 보는 경우가 있다.
            - 어떤 필드의 값을 가지고 와서...
            - 어떤 연산을 해서...
        - '정렬이 된다'라는 사실이 중요하지 사용자는 어떻게 정렬하는지 궁금하지 않다. 
        - 사용자가 필요로 하는 부분만 제공할 수 있도록 코드를 작성해야 한다.