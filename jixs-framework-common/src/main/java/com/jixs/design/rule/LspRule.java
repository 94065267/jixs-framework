package com.jixs.design.rule;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 说明
 *
 * @author jixs
 * @date 2021-12-07 14:10
 */
public class LspRule {
    public static class Father {
        public Collection doSomething(HashMap map) {
            System.out.println("父类被执行...");
            return map.values();
        }
    }

    public static class son extends Father {
        //缩小输入参数范围
        public Collection doSomething(Map map) {
            System.out.println("子类被执行...");
            return map.values();
        }
    }

    public static void main(String[] args) {
        //有父类的地方就有子类
        Father father = new Father();
        HashMap map = new HashMap();
        father.doSomething((HashMap)map);

        son son = new son();
        son.doSomething(map);
    }
}
