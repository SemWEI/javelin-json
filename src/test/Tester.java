/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

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
            String json = "{ \"name\" : \"Coffe Shop\"}";
            Object p = ObjectMapper.mapJSONtoObjects(json, new Project());
            System.out.println("out");
            System.out.println(((Project) p).name);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
