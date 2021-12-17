package me.swsz2.effectivejava.chapter2.act5;

public class SamsungCardReadModule extends CardReadModule {
  @Override
  public void read(Card card) throws UnsupportedCardTypeException {
    if (!(card instanceof SamsungCard)) {
      throw new UnsupportedCardTypeException("unsupported card type : " + card.getClass());
    }
    System.out.println(
        "type : SamsungCard, Owner : " + card.getOwner() + ", Number : " + card.getNumber());
  }
}
