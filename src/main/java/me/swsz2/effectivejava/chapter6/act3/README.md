# ordinal 인덱싱 대신 EnumMap을 사용하라
    - 이전 아이템인 'ordinal 메서드 대신 인스턴스 필드를 사용하라'에서 ordinal에 대해서 알아봤으니 쓰지 말아야 할 이유는 알아보지 않겠다.
    - 해당 장에서는 EnumMap에 대해 탐색해보겠다.

## EnumMap?
    - Map에서 키를 특정 열거 타입만 사용하도록 하는 구현체이다.


```java
    public EnumMap(Class<K> keyType) {
        this.keyType = keyType;
        keyUniverse = getKeyUniverse(keyType);
        vals = new Object[keyUniverse.length];
    }
```
    - 생성자에서 열거형의 길이만큼 배열을 생산하는 것을 볼 수 있다.
    - Object 배열을 생성하기 때문에 null이 허용되지 않는다.

### 장점?
    - HashMap 대비 성능이 좋다.
        - 해시키 검색이 없고 열거형에 대한 인덱스로 객체를 찾기 때문이다.