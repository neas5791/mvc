/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvc.model;

/**
 * @author SeAN MaTKOVICH
 * 
 * The diagram shows a class Rectangle. An object of this class represents a 
 * shape which has two sides (base and height). These two sides should be kept
 * in private to avoid misuse and set to zero when a rectangle object is first 
 * created. There should be a function to set the value of these two sides. 
 * Another function should calculate the area (base * height) of the rectangle.
 * 
 * Part 1 (rectangle):
 * Write a JAVA source code, to declare the Rectangle class considering above 
 * mentioned specifications.
 * Write, in JAVA, the complete definition of the Rectangle class based on your
 * declaration. Write a fragment of client code which creates a Rectangle 
 * object, sets its base and height value to 8 and 6 respectively and displays 
 * its area.
 * 
 */
public class Rectangle implements Shape {
    private int base;
    private int height;
    
    public Rectangle() {
        this.base = 0;
        this.height = 0;
    }
    
    public Rectangle(int base, int height) { 
        if(base < 0 || height < 0)
            throw new IllegalArgumentException
                ("The height and base value must be positive integers silly!");
        
        this.base = base;
        this.height = height;
    }
    
    @Override
    public void setBase(int newBase){
        if (newBase < 0)
            throw new IllegalArgumentException
                ("The base value must be positive silly!");
        this.base = newBase;
    }

    public void setHeight(int newHeight){
        if (newHeight < 0)
            throw new IllegalArgumentException
                ("The height value must be positive silly!");
        this.height = newHeight;
    }
    
    @Override
    public int getBase(){  return base;  }
    
    public int getHeight(){  return height;  }
    
    @Override
    public int area() {  return base * height;  }
    
    @Override
    public String toString(){
     return String.format("base: %s\nheight:%s\narea:%s\n", base, height, area());
    }
}
