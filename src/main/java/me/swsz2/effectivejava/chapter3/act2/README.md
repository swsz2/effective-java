# equals를 재정의하려거든 hashCode도 재정의하라

## 어쩌면 당연한 말일지도...

### hashCode 란 무엇인가

    - 해시코드란 객체를 식별하는 하나의 정수값을 뜻한다.
    - 객체의 메모리 번지를 이용해서 해시코드를 만들어 리턴하기 때문에 객체마다 다른 값을 가지고 있다.

## 그래서 왜 재정의해야 하는가

```java
public class Hashtable<K, V> extends Dictionary<K, V>
        implements Map<K, V>, Cloneable, java.io.Serializable {
    
    public synchronized V get(Object key) {
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry<?, ?> e = tab[index]; e != null; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                return (V) e.value;
            }
        }
        return null;
    }
}
```

    - hashCode를 재정의하지 않으면 같은 값의 객체라도 해시값이 다를 수 있다.
        - HashTable에서 객체가 저장된 버킷을 찾을 수 없음
    - equals를 재정의하지 않으면 버킷은 찾을 수 있지만 객체가 자신과 같은 객체인지 비교할 수 없음
    - 결론적으로는 둘 다 재정의하지 않으면 원하는 객체를 찾을 수 없다