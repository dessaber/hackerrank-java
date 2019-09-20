package getconstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Solution {
    private int a;
    public int b;
    protected int c;
    int d;
    public int aa;

    public static void main(String[] args) {
        //System.out.println(checkPublicParameterlessConstructor(findclosest.Solution.class));
        for (String field : getPublicFields(new Solution())) {
            System.out.println(field);
        }
    }

    private static boolean checkPublicParameterlessConstructor(Class<?> clazz) {
        for (Constructor constructor : clazz.getConstructors()) {
            if (constructor.getParameterCount() == 0) {
                return true;
            }
        }
        return false;
    }

    public static String[] getPublicFields(Object object) {
        return Arrays.stream(object.getClass().getDeclaredFields()).filter(f -> f.getModifiers() == Modifier.PUBLIC)
                                                                   .map(Field::getName).sorted().toArray(String[]::new);
    }
}
