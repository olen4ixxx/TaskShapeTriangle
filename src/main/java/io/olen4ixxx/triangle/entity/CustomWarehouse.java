package io.olen4ixxx.triangle.entity;

import java.util.Map;

public class CustomWarehouse {
    private Map<Integer, CustomShape> map;
//    public class Singleton {
//        private Singleton {}
//        private static class SingletonHolder {
//            private static final Singleton INSTANCE = new Singleton();
//        }
//
//        public static Singleton getInstance() {
//            return SingletonHolder.INSTANCE;
//        }
//    }
    @Override
    public final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
