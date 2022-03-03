# 정확한 답이 필요하다면 float과 double은 피하라
>크게 와닿은 글이 없어 핵심만 작성한다.

float과 double은 과학과 공학 계산용으로 설계됐다. <br>
이진 부동소수점 연상에 사용되며 넓은 범위의 수를 빠르게 정밀한 **근사치**로 계산하도록 설계됐다. <br>

소수점 추적은 시스템에 맡기고 코딩 시의 불편함이나 성능 저하를 쓰지 않겠따면 BigDecimal을 사용하라 <br>
만약 소수점을 직접 추적할 수 있고 숫자가 너무 크지 않다면 int나 long을 사용하라 <br>

다시 말하지면 정확한 답이 필요하다면 근사치를 사용하는 float과 double보다 BigDecimal, int, long을 사용하라.