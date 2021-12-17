# 불필요한 객체 생성을 피하라

## 방법

### 정적 팩터리 메서드를 이용하라

    - me.swsz2.effectivejava.chapter2.act1 를 참고하길 바란다.
    - 미리 생성된 인스턴스를 참조하여 사용할 수 있으면 그렇게 해라
        - Boolean.valueOf, me.swsz2.effectivejava.chapter2.act1.Human.from 

### 캐싱을 이용한 불필요 객체 생성 방지

    - 생성 비용이 아주 비싼 객체인 경우, 그리고 이 비싼 객체가 반복해서 필요한 상황이라면 캐싱하여 재사용한다.
        - 흔히 사용하는 메서드
            - Pattern.matches()
            - Arrays.asList()

### 어댑터를 사용하여 불필요 객체 생성 방지

    - 어댑터란 제 2의 인터페이스이면서 뒷단 객체를 관리하는 패턴
```java
public class HashMap<K, V> extends AbstractMap<K, V>
        implements Map<K, V>, Cloneable, Serializable {
    public Set<K> keySet() {
        Set<K> ks = keySet;
        if (ks == null) {
            ks = new KeySet();
            keySet = ks;
        }
        return ks;
    }
}
```
```java
public class ConcurrentHashMap<K, V> extends AbstractMap<K, V>
        implements ConcurrentMap<K, V>, Serializable {
    public KeySetView<K, V> keySet() {
        KeySetView<K, V> ks;
        if ((ks = keySet) != null) return ks;
        return keySet = new KeySetView<K, V>(this, null);
    }
}
```
    - keySet 메서드는 호출될 때마다 같은 인스턴스(keySet)를 반환한다.
        - 불필요한 객체 생성을 방지하긴 했다.
        - 그런데 만약 여기서 동시 접근 문제가 발생한다면 어떻게 해야 하는가?
            - Set 인스턴스를 받아서 사용했는데 다른 곳에서 이 값을 변경시켜버렸다면 내가 가지고 있는 Set과 실제 Set은 같지 않을 수도 있다.
                - 일반적으로 Set 인스턴스가 생성된다고 해도 성능에 이슈를 미칠 가능성을 낮을 거 같다.
                - 필요할 때마다 객체를 복제? 복사? 한 후 새로운 인스턴스를 받는 거로 나쁘지 않을 거 같다.

### 기본 타입을 이용한 불필요 객체 생성 방지
    - Integer to int
        - public static final Class<Integer>  TYPE = (Class<Integer>) Class.getPrimitiveClass("int");
    - Long to long 
        - public static final Class<Long>     TYPE = (Class<Long>) Class.getPrimitiveClass("long");
    - Character to char
        - public static final Class<Character> TYPE = (Class<Character>) Class.getPrimitiveClass("char");