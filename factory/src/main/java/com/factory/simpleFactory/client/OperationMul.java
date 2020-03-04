package com.factory.simpleFactory.client;

import com.factory.simpleFactory.BaseOperation;

/**
 * @author zb
 */
public class OperationMul extends BaseOperation {
    private static final long serialVersionUID = -8160023551667317931L;

    /**
     * 乘法操作
     *
     * @return double
     */
    @Override
    public Double execute() {
        super.execute();
        return numberA * numberB;
    }
}
