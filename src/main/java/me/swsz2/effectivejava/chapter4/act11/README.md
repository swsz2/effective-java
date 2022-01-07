# 톱레벨 클래스는 한 파일에 하나만 담아라

    - JLS에서 톱레벨 클래스를 정의했다. (https://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html)
        - A top level class is a class that is not a nested class.
            - 톱레벨 클래스는 중첩 클래스가 아닌 클래스다.
        - A nested class is any class whose declaration occurs within the body of another class or interface.
            - 중첩 클래스는 선언이 다른 클래스 또는 인터페이스의 본문 내에서 발생하는 모든 클래스다.

## Dessert.java
```java
class Utensil {
    static final String NAME = "pot";
}

class Dessert {
    static final String NAME = "pie";
}
```

## Utensil.java

```java
class Utensil {
    static final String NAME = "pan";
}

class Dessert {
    static final String NAME = "cake";
}
```

```java
public class Main {
    public static void main(String... args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
    }
}
```

## 결과
```
javac Main.java Dessert.java -> potpie
javac Main.java Utensil.java -> pancake
```

## 결론
    - 톱레벨 클래스가 2개 이상인 경우 원치 않는 결과가 나올 수 있으니 톱레벨 클래스를 하나로 설정하자
        - 파일명과 동일한 클래스만 선언하자