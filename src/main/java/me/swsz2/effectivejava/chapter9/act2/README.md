# 전통적인 for문보다는 for-each문을 사용하라

## 책에서의 추천 이유
* 반복자와 인덱스 변수를 사용하지 않아 코드가 깔끔해지고 오류가 날 일도 적어진다.
* 하나의 관용구로 컬렉션과 배열을 모두 처리할 수 있어서 어떤 커테이너를 다루는지 신경 쓰지 않아도 된다.

## 김성원의 추천 이유 (추가 설명)
for/for-each문을 사용하는 이유는 배열/컬렉션을 순회하며 내부 요소를 사용하고 싶기 때문이다. <br>
for문은 인덱스를 기준으로 배열/컬렉션에서 요소를 peek 해서 작업하는 모습이라면 <br>
for-each문은 요소들을 나열한 후 하나의 요소씩 next 해서 작업하는 모습이라고 생각한다. <br>

다른 표현을 사용하자면 이렇게 할 수 있을 거 같다. <br>
`컬렉션에 있는 요소들을 하나씩 가지고 와서~~~` vs `요소를 사용해서~~`  

<small>추후 고민을 좀 해보고 추가 설명이 필요하다면 다시 수정하겠다..</small> 

## for-each문을 사용할 수 없는 경우
* 파괴적인 필터링 (컬렉션을 순회하면서 선택된 원소를 제거해야 하는 경우)
* 변형 (리스트나 배열을 순회하면서 그 원소의 값 일부 혹은 전체를 교체해야 하는 경우)
* 병렬 반복 (여러 컬랙션을 병렬로 순회해야 하는 경우)