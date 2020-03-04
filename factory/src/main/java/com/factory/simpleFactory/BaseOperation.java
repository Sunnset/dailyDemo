package com.factory.simpleFactory;

import java.io.Serializable;

/**
 * 运算基类
 * @author zb
 */
public class BaseOperation implements Serializable {

    private static final long serialVersionUID = 3007290063352157488L;

    public Double numberA;
    public Double numberB;

    /**
     * 执行操作获取结果
     *
     * @return double
     */
    public Double execute() {
        return null;
    }

    public void check(){
        if (numberA == null || numberB == null) {
            throw new RuntimeException("请给参与运算的数值赋值...");
        }
    }

}
