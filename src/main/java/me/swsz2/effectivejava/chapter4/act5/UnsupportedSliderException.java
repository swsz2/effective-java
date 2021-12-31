package me.swsz2.effectivejava.chapter4.act5;

/**
 * UnsupportedSliderException 은 아래와 같은 경우에 throw 합니다. <br>
 * 1. 지원하지 않는 슬라이더를 사용했을 경우 <br>
 * 2. 기본 슬라이더가 설정된 상태에서 키를 눌렀을 경우
 */
public class UnsupportedSliderException extends RuntimeException {
  public UnsupportedSliderException(final String message) {
    super(message);
  }
}
