/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import parser.ObjectMapper;

/**
 *
 * @author Kasun Gamage
 */
public class Tester {

    public static void main(String[] args) {
        try {
            String json = "{ \"name\" : \"Coffe Shop\", \"count\" : 5, \"price\" : 4.7f }";
            Object p = ObjectMapper.mapJSONtoObjects(json, new Project());
            System.out.println("out");
            System.out.println(((Project) p).name);
            System.out.println(((Project) p).count);
            System.out.println(((Project) p).price);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
