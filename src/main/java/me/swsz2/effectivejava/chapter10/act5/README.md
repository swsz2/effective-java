# 추상화 수준에 맞는 예외를 던져라

> 아래 계층의 예외를 예방하거나 스스로 처리할 수 없고, 그 예외를 상위 계층에 그대로 노출하기 곤란하다면 예외 번역을 사용하라. <br>
> 이때 예외 연쇄를 이용하면 상위 계층에는 맥락에 어울리는 고수준 예외를 던지면서 근본 원인도 함께 알려주어 오류를 분석하기에 좋다

## 예외 연쇄

```java
public class Printer {
    public void print() {
        try {
            // ...
        } catch (LowerLevelException e) {
            // 저수준 예외를 고수준 예외에 실어 보낸다.
            throw new HighLevelException(e);
        }
    }
}
```