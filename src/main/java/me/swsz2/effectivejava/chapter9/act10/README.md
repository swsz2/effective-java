#  네이티브 메소드는 신중히 사용하라

> 네이티브 메소드 이야기가 나와서 과거를 되돌아보며...

2020년에 JNI를 활용해서 현재 열려있는 프로그램들의 정보를 추출하는 애플리케이션을 만들 적이 있었다. <br>
당시에 사용할 수 있던 언어가 Java 밖에 없었고 dll을 직접 콜해야 하는 상황이여서 JNI를 사용했었다. <br>

지금 생각해보면 끔찍한 선택이었다. <br>
Java 생태계에서 외부 언어 라이브러리를 호출해서 다루려고 하다니... <br>
기능 개발이 **가능**은 하겠으나 안정성/언어 정체성 관점에서 아주 큰 리스트가 있는 것도 모르고 되는 대로 했으니 말이다. <br>
지금 나에게 다시 만들라고 한다면 절대 JNI를 선택하지 않을 것이다. <br> 