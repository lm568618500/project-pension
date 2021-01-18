package com.longjun.cto.framework.common.utils.security;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class RandomUtil {

  private static final Sequence SEQUENCE = new Sequence();

  /**
   * 使用Twitter的分布式自增ID算法snowflake生成主键id<br/>
   * 分布式环境主键，优于使用uuid做主键
   * @return
   */
  public static long createSnowflakeId(){
    return SEQUENCE.nextId();
  }

  /**
   * 获取 UUID（32位）
   */
  public static String createUUID() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  /**
   * 创建随机数
   * count 位数
   */
  public static String createRandom(int count) {
    return RandomStringUtils.randomNumeric(count);
  }

  /**
   * 获取指定范围内的随机整数值
   *
   * @param startInclusive 最小值，包括，必须是非负数
   * @param endExclusive   最大值，不包括
   * @return
   */
  public static int randomInt(int startInclusive, int endExclusive) {
    return RandomUtils.nextInt(startInclusive, endExclusive);
  }

  /**
   * 获取指定范围内的随机double数
   *
   * @param startInclusive 最小值，包括，必须是非负数
   * @param endInclusive   最大值，不包括
   * @return
   */
  public static double randomDouble(double startInclusive, double endInclusive) {
    return RandomUtils.nextDouble(startInclusive, endInclusive);
  }

  public static void main(String[] args) {
    System.out.println(randomDouble(1.0, 3.0));
  }
}
