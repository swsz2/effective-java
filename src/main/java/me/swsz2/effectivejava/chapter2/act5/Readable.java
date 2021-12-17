package me.swsz2.effectivejava.chapter2.act5;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-16, 목요일
 */
public interface Readable {
  void read(Card card) throws UnsupportedCardTypeException;
}
