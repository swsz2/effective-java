package me.swsz2.effectivejava.chapter2.act2;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : swsz2
 * @mailto : swsz@kakao.com
 * @created : 2021-12-13, 월요일
 */
@ToString
@AllArgsConstructor
public class Promotion {
  /** 학생 * */
  private final boolean student;
  /** 수능 * */
  private final boolean sat;
  /** 정부, 처 * */
  private final boolean ministry;
  /** 지인 추천 * */
  private final boolean recommender;

  private Promotion(final Builder builder) {
    this.student = builder.student;
    this.sat = builder.sat;
    this.ministry = builder.ministry;
    this.recommender = builder.recommender;
  }

  @NoArgsConstructor
  public static class Builder {

    private boolean student = false;
    private boolean sat = false;
    private boolean ministry = false;
    private boolean recommender = false;

    public Builder student() {
      this.student = true;
      return this;
    }

    public Builder sat() {
      this.sat = true;
      return this;
    }

    public Builder ministry() {
      this.ministry = true;
      return this;
    }

    public Builder recommender() {
      this.recommender = true;
      return this;
    }

    public Promotion build() {
      return new Promotion(this);
    }
  }
}
