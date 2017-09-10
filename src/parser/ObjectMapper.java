/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.lang.reflect.InvocationTargetException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Kasun Gamage
 */
public class ObjectMapper {

    public static final int PERFECT_MATCH = 1;
    public static final int STRICT_JSON = 2;
    public static final int STRICT_MODEL = 3;
    public static final int NONE = 0;

    public static Object mapJSONtoObjects(String json, Object objectToMapTo) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        json = json.substring(1, json.length() - 1);
        StringTokenizer defaultTokenizer = new StringTokenizer(json, ",");
        StringTokenizer defaultTokenizer2;

        while (defaultTokenizer.hasMoreTokens()) {

            String token = defaultTokenizer.nextToken();

            defaultTokenizer2 = new StringTokenizer(token, ":");

            String fieldName = "";
            String value = "";

            Pattern p = Pattern.compile("\".*?\"");
            Matcher m = p.matcher(defaultTokenizer2.nextToken());
            if (m.find()) {
                fieldName = (String) m.group().subSequence(1, m.group().length() - 1);
            }
            String valueString = defaultTokenizer2.nextToken();
            m = p.matcher(valueString);
            if (m.find()) {
                value = (String) m.group().subSequence(1, m.group().length() - 1);
                objectToMapTo.getClass().getDeclaredField(fieldName).set(objectToMapTo, value);
            } else { // value is not a String
                //check if numeric object or boolean
                valueString = valueString.trim();
                Class c = objectToMapTo.getClass().getDeclaredField(fieldName).getType();
                objectToMapTo.getClass().getDeclaredField(fieldName).set(objectToMapTo, c.getConstructor(new Class[]{String.class}).newInstance(valueString));
            }
            

        }
        return objectToMapTo;
    }
}
