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
  void testSamsungCardReaderModule() {
    SamsungCardReadModule samsungCardReadModule = new SamsungCardReadModule();
    CardReader cardReader = new CardReader(samsungCardReadModule);
    Card samsungCard = new SamsungCard("sungwonkim", "2020-2021-2022");
    Card appleCard = new AppleCard("sungwonkim", "2020-2021-2022");

    Assertions.assertDoesNotThrow(() -> cardReader.read(samsungCard));
    Assertions.assertThrows(UnsupportedCardTypeException.class, () -> cardReader.read(appleCard));
  }

  @Test
  void testAppleCardReaderModule() {
    AppleCardReadModule appleCardReadModule = new AppleCardReadModule();
    CardReader cardReader = new CardReader(appleCardReadModule);
    Card samsungCard = new SamsungCard("sungwonkim", "2020-2021-2022");
    Card appleCard = new AppleCard("sungwonkim", "2020-2021-2022");

    Assertions.assertDoesNotThrow(() -> cardReader.read(appleCard));
    Assertions.assertThrows(UnsupportedCardTypeException.class, () -> cardReader.read(samsungCard));
  }
}
