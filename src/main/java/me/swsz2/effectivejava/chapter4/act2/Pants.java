package me.swsz2.effectivejava.chapter4.act2;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-28, 화요일
 */
public class Pants {

  public final int length;
  public final int width;
  public final int rise;

  public Pants(final Builder builder) {
    this.length = builder.length;
    this.width = builder.width;
    this.rise = builder.rise;
  }

  public static class Builder {
    private final int length;
    private final int width;
    private int rise = 10;

    public Builder(final int length, final int width) {
      this.length = length;
      this.width = width;
    }

    public Builder rise(final int rise) {
      this.rise = rise;
      return this;
    }

    public Pants build() {
      return new Pants(this);
    }
  }
}
