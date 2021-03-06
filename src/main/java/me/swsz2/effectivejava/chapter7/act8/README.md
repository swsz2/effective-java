# 스트림 병렬화는 주의해서 적용하라
    - 주류 언어 중 java는 동시성 프로그래밍 층면에서 앞서갔다.
        - wait/notify, executor, fork-join, parallel 등

## 병렬 처리에서 주의해야 할 점
    - 안정성
    - 응답 가능 상태 유지

## Stream.parallel() 사용 시 주의 사항
    - 데이터 소스가 Stream.iterate이면 성능 개선이 어렵다.
        - 인덱스 기반의 순차 처리를 기본으로 하기 때문에 병렬로 처리하기 어려워 그런 거 같다. 
    - 중간 연산으로 limit을 사용하면 성능 개선이 어렵다.
        - 어떠한 순서에 의한 limit일텐데 병렬로 처리하면 순서를 판가름하기 어려워 그런 거 같다.

## 언제 써야 성능 개선을 볼 수 있는가?
    - ArrayList, HashMap, HashSet, ConcurrentHashMap의 인스턴스일 때
    - 배열일 때
    - int or long 범위일 때

    * 컴퓨터가 원하는 크기로 쉽게 나눌 수 있을 때 성능 개선을 기대할 수 있다. *
    * 참조 지역성 (메모리 내에서 연속적으로 저장)이 뛰어날 때 성능 개선을 기대할 수 있다*