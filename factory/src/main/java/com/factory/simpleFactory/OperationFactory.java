package com.factory.simpleFactory;

import com.factory.simpleFactory.client.OperationAdd;
import com.factory.simpleFactory.client.OperationDiv;
import com.factory.simpleFactory.client.OperationMul;
import com.factory.simpleFactory.client.OperationSub;

import java.io.Serializable;

/**
 * @author zb
 */
public class OperationFactory implements Serializable {

    private static final long serialVersionUID = 1324279999003763816L;

    public static BaseOperation createOperation (String operate) {
        BaseOperation oper = null;
        switch (operate){
            case "+" :
                oper = new OperationAdd();
                break;
            case "-" :
                oper = new OperationSub();
                break;
            case "*" :
                oper = new OperationMul();
                break;
            case "/" :
                oper = new OperationDiv();
                break;
            default:
                break;
        }
        if (oper == null) {
            throw new RuntimeException("您输入的运算符号有误，请输入‘+-*/’其中的一个...");
        }
        return oper;
    }

}
