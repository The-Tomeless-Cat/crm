package com.model.system;

public class Menu {
    private String menuId;

    private String menuPid;

    private String menuName;

    private String menuDesc;

    private String menuUrl;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(String menuPid) {
        this.menuPid = menuPid;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuPid=" + menuPid + ", menuName=" + menuName + ", menuDesc=" + menuDesc
				+ ", menuUrl=" + menuUrl + "]";
	}
    
    
}