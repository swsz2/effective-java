package me.swsz2.effectivejava.chapter2.act5;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-17, 금요일
 */
public class AppleCardReadModule extends CardReadModule {
  @Override
  public void read(Card card) throws UnsupportedCardTypeException {
    if (!(card instanceof AppleCard)) {
      throw new UnsupportedCardTypeException("unsupported card type : " + card.getClass());
    }
    System.out.println(
        "type : AppleCard, Owner : " + card.getOwner() + ", Number : " + card.getNumber());
  }
}
