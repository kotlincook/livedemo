package de.javaccok;
import java.util.*;

public class DoSomething {

    public Map itDoesSomething(Enumeration elements) {
        Map result = new HashMap();
        while (elements.hasMoreElements()) {
            Object element = elements.nextElement();
            Integer j = (Integer)result.get(element);
            if (j == null) {
                result.put(element, 1);
            } else {
                result.put(element, new Integer(Integer.valueOf(j) + 1));
            }
        }
        return result;
    }





    public static void main(String[] args) {
        Enumeration numbers = Collections.enumeration(
                Arrays.asList(1,5,3,5,7,8,7,5,3,24,5,6,3,2,5,6));
        final Map map = new DoSomething().itDoesSomething(numbers);
        System.out.println(map);


    }

}
