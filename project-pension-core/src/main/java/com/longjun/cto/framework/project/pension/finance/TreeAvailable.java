package com.longjun.cto.framework.project.pension.finance;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * 可使用双亲表示法构建树形数据接口
 * Created by wangyongjun on 2017/11/30.
 */
public interface TreeAvailable<D> extends Comparable<D> {

  /**
   * 获得节点id
   * @return
   */
  Integer getId();

  /**
   * 获得父节点id
   * @return
   */
  Integer getParentId();

  /**
   * 设置子节点集合
   * @param children
   * @return
   */
  D setChildren(List<D> children);

  /**
   * 获得子节点集合
   * @return
   */
  List<D> getChildren();

  /**
   * 构建一个根节点
   * @return
   */
  D buildRoot();

}
