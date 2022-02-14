# 익명 클래스보다는 람다를 사용하라

## 익명 클래스?

    - 익명의 성질을 가진 클래스
    - 이름이 없다는 것은 나중에 다시 불릴 이유/필요가 없는 클래스를 의미. 즉 재사용성이 없는 클래스

## 람다와 비교

```java
public class AnonymousClassTest {

    @Test
    public void testAnonymousClass() {
        List<Integer> integers = Arrays.asList(13, 67, 3, 45, 5, 346, 34, 63);
        Collections.sort(
                integers,
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return Integer.compare(o1, o2);
                    }
                });
        System.out.println("integers = " + integers);
    }

    @Test
    public void testLambda() {
        List<Integer> integers = Arrays.asList(13, 67, 3, 45, 5, 346, 34, 63);
        Collections.sort(integers, (o1, o2) -> Integer.compare(o1, o2));
        System.out.println("integers = " + integers);
    }

    @Test
    public void testLambda2() {
        List<Integer> integers = Arrays.asList(13, 67, 3, 45, 5, 346, 34, 63);
        Collections.sort(integers, Comparator.comparingInt(o -> o));
        System.out.println("integers = " + integers);
    }
}

```

    - 익명클래스를 사용할 때보다 람다식을 사용할 때 코드가 짧아진다.
        - 코드의 수가 길어질 수록 가독성은 떨어진다.
    - 익명클래스는 문서화로 설명하기 쉬우나 람다를 사용할 경우 동작의 정의가 함수명으로 완벽히 설명돼야 한다.

## 김성원의 생각
    - 확실히 익명 클래스는 람다와 비교했을 때 뒤떨어지는 부분이 많다.
        - 간결하지 못함
        - 분석이 필요
    - 함수형 인터페이스는 함수명을 매우 잘 지어야 한다.
        - 내가 개발을 하면서 가장 시간을 많이 사용하는 부분 중 하나가 변수, 함수명을 짓는 부분이다.
        - 제 3자가 보더라도 한눈에 알 수 있는 함수명으로 작성해야 한다는 것이 상당히 어려운 부분이 아닐까 생각해본다.
