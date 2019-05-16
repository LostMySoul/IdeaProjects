package omsu.javaprojects.reflection;

import omsu.javaprojects.exec.Executable;
import omsu.javaprojects.models.Human;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ReflectionDemo {

    public static int countHuman(List<Object> objectList) {
        int count = 0;
        for (Object item : objectList) {
            if (item instanceof Human) {
                count++;

            }

        }
        return count;
    }

    public static List<String> listName(Object object) {
        List<String> result = new ArrayList<String>();
        for (Method method : object.getClass().getMethods()) {
            result.add(method.getName());
        }
        return result;

    }

    public static List<String> superClassName(Object object) {
        List<String> result = new ArrayList<String>();
        Class cl = object.getClass().getSuperclass();
        while (cl != null) {
            result.add(cl.getSimpleName());
            cl = cl.getSuperclass();


        }
        return result;
    }

    public static int findExecutable(List<Object> list) {
        int count = 0;
        for (Object o : list) {
            if (o instanceof Executable) {
                ((Executable) o).execute();
                count++;
            }
        }
        return count;
    }

    public static boolean isGetter(Method method) {
        if (!Modifier.isStatic(method.getModifiers()) && method.getParameters().length == 0) {
            if (method.getAnnotatedReturnType().getType() != void.class && method.getName().startsWith("get")) {
                return true;
            }

            if ((method.getAnnotatedReturnType().getType() == boolean.class || method.getAnnotatedReturnType().getType() == Boolean.TYPE)
                    && (method.getName().startsWith("has") || method.getName().startsWith("is"))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSetter(Method method) {
        if (!Modifier.isStatic(method.getModifiers()) && method.getParameters().length == 1) {
            if (method.getAnnotatedReturnType().getType() == void.class && method.getName().startsWith("set")) {
                return true;
            }
        }
        return false;

    }

    public static List<String> getGetAndSet(Object obj) {
        List<String> list = new ArrayList<>();
        for (Method method : obj.getClass().getMethods()) {
            if (isGetter(method) || isSetter(method)) {
                list.add(method.toString());

            }
        }
        return list;
    }
}
