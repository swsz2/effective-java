package me.swsz2.effectivejava.chapter2.act5;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-16, 목요일
 */
public class SamsungCardReader extends CardReader {
  @Override
  public void read(Card card) throws UnsupportedCardTypeException {
    if (!(card instanceof SamsungCard)) {
      throw new UnsupportedCardTypeException("unsupported card type : " + card.getClass());
    }
    card.read();
  }
}
