package com.longjun.cto.framework.project.pension.finance;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 抽象数据类型：树
 * 输入简单数据集合simpleDatas，输出树结构集合treeData和树结构根节点root
 * Created by wangyongjun on 2017/11/30.
 */
public class Tree<D extends TreeAvailable> {

  public static final Integer ROOT_ID = 0;  //根节点id
  public static final Integer ROOT_PARENT_ID = -1;  //根节点的父节点id

  private List<D> simpleDatas;  //简单数据集合
  private D root;  //树结构根节点

  public Tree(List<D> simpleDatas) {
    this.simpleDatas = simpleDatas;
    build();
  }

  /**
   * 将简单数据集合构建为一个根节点表示的树
   */
  private void build(){
    simpleDatas.forEach(d -> d.setChildren(getChildrenDatas(d.getId())));
    List<D> temp = simpleDatas.stream().filter(d -> Objects.equals(d.getParentId(), ROOT_ID)).collect(Collectors.toList());
    Collections.sort(temp);
    if(temp.size() == 1){
      root = temp.get(0);
    }else{
      TreeAvailable<D> treeAvailable = temp.get(0);
      root = (D) treeAvailable.buildRoot().setChildren(temp);
    }
  }

  /**
   * 获得指定id的子节点
   * @param id
   * @return
   */
  private List<D> getChildrenDatas(Integer id){
    List<D> children = simpleDatas.stream().filter(t -> Objects.equals(t.getParentId(),id)).collect(Collectors.toList());
    Collections.sort(children);
    return children;
  }

  public D getRoot() {
    return root;
  }

}
