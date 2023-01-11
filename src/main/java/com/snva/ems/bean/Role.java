package com.snva.ems.bean;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Role {
    private Long roleId;
    private String roleName;
    private String roleDescription;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
    @PostConstruct
    public void init(){
        System.out.println("Role has been initialized");
    }
    @PreDestroy
    public void destroy(){
        System.out.println(this.roleName + "role with "+ this.roleId + " Id has been destroyed");
    }
    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }
}
