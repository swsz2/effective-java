# try-finally보다는 try-with-resources를 사용하라

## try-finally & try-with-resources를 왜 쓰는가

    - 어떠한 리소스에 대한 접근 또는 사용에 대해서 직접 닫아야 하는 경우
        - 두 스레드는 하나의 파일에 대한 Write를 동시에 진행할 수 없기 때문에 권한을 얻고 작업이 종료될 경우 권한을 직접 반환한다.

## 물론 try-finally도 방법이다.

    - try-finally로도 충분히 리소스에 대한 접근 또는 사용을 관리할 수 있다.

## 왜 try-with-resources를 추천하는가?

    - 생산성의 문제
    - 가독성의 문제
    - close 행위를 해야 한다는 사실을 잊어버리더라도 클래스 수준에서 한번만 구현하면 자동으로 close 처리된다.
        - 그렇다고 close 행위가 필요하다는 사실을 쉽게 잊어서는 안 된다.
            - 내부 구현에 대한 이해가 부족하다는 뜻이다.

### try-finally

```java
   try {
   ...
   } finally {
       if (stream == null) {
           return;
       }

       if (!stream.isClosed()) {
           stream.close();
       }
       stream = null;
   }
```

### try-with-resources

```java
    try(Stream stream=new Stream()) {

    }
```