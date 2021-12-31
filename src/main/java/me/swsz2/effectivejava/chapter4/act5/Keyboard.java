package me.swsz2.effectivejava.chapter4.act5;

public class Keyboard {

  protected final int keySize;
  protected final Slider slider;

  public Keyboard(int keySize) {
    this.keySize = keySize;
    this.slider = Slider.DEFAULT;
    enter();
  }

  public Keyboard(int keySize, Slider slider) {
    this.keySize = keySize;
    this.slider = slider;
    enter();
  }

  enum Slider {
    BLACK,
    BLUE,
    RED,
    DEFAULT,
    CONTACTLESS
  }

  /**
   * @implSpec <br>
   *     해당 메소드는 키보드 객체가 생성됐을 때 키보드 슬라이더 테스트 용으로 1회 호출됩니다. <br>
   *     해당 메소드를 재정의할 경우 테스트가 정상적으로 수행되지 않을 수 있습니다. <br>
   */
  public void enter() {
    if (Slider.DEFAULT.equals(this.slider)) {
      throw new UnsupportedSliderException("Unsupported Slider : " + this.slider);
    }
    System.out.println("Supported Slider : " + this.slider);
  }
}
