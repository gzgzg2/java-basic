package org.example.reflection.di;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    public static <T> T getObject(Class<T> classType) {
        T instance = createInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach(f-> {
            if (f.getAnnotation(Inject.class) != null) {
                Object filedInstance = createInstance(f.getType());
                f.setAccessible(true);
                //필드의 클래스 인스턴스와 해당 필드타입과 동일한 인스턴스 넘겨주기
                try {
                    f.set(instance, filedInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
