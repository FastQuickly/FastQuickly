package com.qmui.quick.base;




import com.alibaba.fastjson.JSON;

import java.io.Serializable;


public class BaseEntity implements Serializable {

    public String toJson(){
        return JSON.toJSONString(this);
    }
}
