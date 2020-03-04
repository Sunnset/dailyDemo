package com.factory.simpleFactory.client;

import com.factory.simpleFactory.BaseOperation;

/**
 * @author zb
 */
public class OperationDiv extends BaseOperation {
    private static final long serialVersionUID = 6475473300763264863L;

    /**
     * 执行操作获取结果
     *
     * @return double
     */
    @Override
    public Double execute() {
        super.execute();
        if (numberB == 0) {
            throw new RuntimeException("除法中除数不能为0，但是此时numberB = 0");
        }
        return numberA / numberB;
    }
}
