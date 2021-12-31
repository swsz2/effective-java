package me.swsz2.effectivejava.chapter4.act5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RealForceKeyboardTest {

  @Test
  public void testRealForceKeyboardEnter() {
    Assertions.assertDoesNotThrow(RealForceKeyboard::new);
  }
}
