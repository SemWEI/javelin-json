/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author Kasun Gamage
 */
public class Project {

    public String name;
    public int testInt;
    ArrayList<Page> pages;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the pages
     */
    public ArrayList<Page> getPages() {
        return pages;
    }

    /**
     * @param pages the pages to set
     */
    public void addPage(ArrayList<Page> pages) {
        this.pages = pages;
    }
}
