package me.swsz2.effectivejava.chapter2.act5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-16, 목요일
 */
public class CardReaderTest {

  @Test
  void testSamsungCardReaderWithSamsungCard() {
    SamsungCardReader cardReader = new SamsungCardReader();
    SamsungCard card = new SamsungCard("sungwonkim", "2020-2021-2022");
    Assertions.assertDoesNotThrow(() -> cardReader.read(card));
  }

  @Test
  void testSamsungCardReaderWithKakaoCard() {
    SamsungCardReader cardReader = new SamsungCardReader();
    KakaoCard card = new KakaoCard("sungwonkim", "2020-2021-2022");
    Assertions.assertThrows(UnsupportedCardTypeException.class, () -> cardReader.read(card));
  }
}
