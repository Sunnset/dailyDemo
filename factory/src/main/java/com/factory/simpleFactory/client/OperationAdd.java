package com.factory.simpleFactory.client;

import com.factory.simpleFactory.BaseOperation;

/**
 * @author zb
 */
public class OperationAdd extends BaseOperation {
    private static final long serialVersionUID = -5633739582192058801L;

    /**
     * 加法操作
     * @return double
     */
    @Override
    public Double execute() {
        super.execute();
        System.out.println("执行了加法操作...");
        return  numberA + numberB;
    }
}
