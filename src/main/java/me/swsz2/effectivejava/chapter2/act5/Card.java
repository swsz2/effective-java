package me.swsz2.effectivejava.chapter2.act5;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-16, 목요일
 */
public abstract class Card implements Readable {
  protected final String owner;
  protected final String number;

  public Card(String owner, String number) {
    assert owner != null && number != null : "empty required args";
    this.owner = owner;
    this.number = number;
  }
}
