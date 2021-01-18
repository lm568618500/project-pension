package com.longjun.cto.framework.sm.sys.entity.view;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

public class ShowMenuView implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -311349511355775805L;
	private Long id;
    private  Long pid;
    private String title;
    private String icon;
    private String href;
    private Boolean spread = false;
    private List<ShowMenuView> children = Lists.newArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ShowMenuView> getChildren() {
        return children;
    }

    public void setChildren(List<ShowMenuView> children) {
        this.children = children;
    }
}
