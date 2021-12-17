package me.swsz2.effectivejava.chapter2.act5;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-16, 목요일
 */
public class CardReader {

  private CardReadModule cardReadModule;

  public CardReader(CardReadModule cardReadModule) {
    this.cardReadModule = cardReadModule;
  }

  public void read(Card card) throws UnsupportedCardTypeException {
    cardReadModule.read(card);
  }
}
