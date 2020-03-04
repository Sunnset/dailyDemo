package com.factory.simpleFactory.client;

import com.factory.simpleFactory.BaseOperation;

/**
 * @author zb
 */
public class OperationSub extends BaseOperation {
    private static final long serialVersionUID = -5738354350439011736L;

    /**
     * 减法操作
     * @return double
     */
    @Override
    public Double execute() {
        super.execute();
        return numberA - numberB;
    }
}
