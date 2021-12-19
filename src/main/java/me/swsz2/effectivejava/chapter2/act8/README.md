# Finalizer & Cleaner 사용을 피하라

## Finalizer

```
Finalizers get invoked when JVM figures out that this particular instance should be garbage collected. Such a finalizer may perform any operations, including bringing the object back to life.
The main purpose of a finalizer is, however, to release resources used by objects before they're removed from the memory. A finalizer can work as the primary mechanism for clean-up operations, or as a safety net when other methods fail.
```
```
public class Object {
    @Deprecated(since="9")
    protected void finalize() throws Throwable { }
}
```
    - Finalizer는 JVM이 특정 인스턴스에 대해서 GC를 해야 한다고 판단하면 호출된다.
    - Finalizer의 주 목적은 개체를 메모리에서 제거하기 전에 리소스를 해제하는 것이다.
    - Java 9부터 Deprecate 됐다.

## Cleaner

```
The cleaner creates a daemon thread to process the phantom reachable objects and to invoke cleaning actions. The context class loader of the thread is set to the system class loader.
The thread has no permissions, enforced only if a SecurityManager is set.
The cleaner terminates when it is phantom reachable and all of the registered cleaning actions are complete.
```

    - 클리너는 연결 가능한 팬텀 오브젝트를 처리하고 제거 작업을 하는 데몬 스레드를 생성한다
    - 생성된 데몬 스레드는 권한이 없으며 시큐리티 매니저가 설정된 경우에 적용된다.
        - 처리 권한을 이야기 하는 거 같다.
    - 클리너는 등록된 모든 제거 작업이 끝나면 종료된다.

```java 
public final class CleanerImpl implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        InnocuousThread mlThread = (t instanceof InnocuousThread)
                ? (InnocuousThread) t
                : null;
        while (!phantomCleanableList.isListEmpty() ||
                !weakCleanableList.isListEmpty() ||
                !softCleanableList.isListEmpty()) {
            if (mlThread != null) {
                // Clear the thread locals
                mlThread.eraseThreadLocals();
            }
            try {
                // Wait for a Ref, with a timeout to avoid getting hung
                // due to a race with clear/clean
                Cleanable ref = (Cleanable) queue.remove(60 * 1000L);
                if (ref != null) {
                    ref.clean();
                }
            } catch (Throwable e) {
                // ignore exceptions from the cleanup action
                // (including interruption of cleanup thread)
            }
        }
    }
    ...
}
```

## 문제점
    - Finalizer, Cleaner로는 제때 실행되어야 하는 작업은 절대 할 수 없다.
        -  JVM이 GC 대상으로 선정하기 전까지는 메모리에 남아 있는다.
    - 상태를 영구적으로 수정하는 작업에서 사용하기 부적절하다.
        - 쓰레드 스탑 이슈
    - 성능 이슈
        - Autoclosable 과 비교했을 때 약 50배 정도 수행 속도 차이가 남
    - Finalizer는 직렬화 과정에서 보안 이슈를 야기시킬 수 있다.
    - Cleaner는 실행을 보장하지 않는다.
        - 불완전하다는 이야기
```
 * The behavior of cleaners during {@link System#exit(int) System.exit} is implementation specific. No guarantees are made relating to whether cleaning actions are invoked or not.
```
    - System.exit에 따른 실행은 구현에 따라 다르다.
    - 실행 여부에 대해서는 어떠한 보증도 하지 않는다. 


## 좋은 방법은 Closeable, AutoCloseable을 사용하라
```java
public class BufferedWriter extends Writer {
    
    @SuppressWarnings("try")
    public void close() throws IOException {
        synchronized (lock) {
            if (out == null) {
                return;
            }
            try (Writer w = out) {
                flushBuffer();
            } finally {
                out = null;
                cb = null;
            }
        }
    }
}
```
    1. BufferedWriter의 lock을 획득한다.
    2. out 의 존재 여부에 따른 처리
        - out (Writer)이 null 이라면 아무런 행동을 하지 않고 종료한다.
        - 그렇지 않다면 버퍼에 남은 데이터에 대해서 flush한다.
    3. out 객체와 cb (CharacterBuffer)를 null로 참조 해제한다.
        - gc 대상으로 선정
            - chapter2의 act7 (item7) 다 쓴 객체 참조를 해제하라 참고

### 참고 
    - Closeable은 IOException으로 캐치
    - AutoCloseable은 Exception으로 캐치
    - Closeable extends AutoCloseable

