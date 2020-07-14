package com.entity;

import java.util.ArrayList;
import java.util.List;

public class QuerryVo {
    UserCustom userCustom;

    List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public QuerryVo(UserCustom userCustom){
        this.userCustom=userCustom;
    }
    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
