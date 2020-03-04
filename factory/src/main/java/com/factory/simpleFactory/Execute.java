package com.factory.simpleFactory;

public class Execute {

    public static void main(String[] args) {
        BaseOperation operation = OperationFactory.createOperation("+");
        operation.numberA = 1d;
        operation.numberB = 2d;
        System.out.println("运行结果：" + operation.execute());
    }

}
