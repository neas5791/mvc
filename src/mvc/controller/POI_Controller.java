/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvc.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import mvc.model.POI;

/**
 *
 * @author Seaboard
 */
public class POI_Controller {
    
    public static void main (String[] args){
        
    BufferedReader br;
        String line;
        
        // Sets up arraylist to store POI objects
        ArrayList <POI> pts = new ArrayList<>();
        
        try{
            // creates a BufferedRaeder to access File with Object data as supplied by ITC313
            br = new BufferedReader(new FileReader("Ass1_Task1_POIs.txt"));
            
            // loop through the file reading each line
            while ((line = br.readLine()) != null){
                
                // breaks the line into parts
                String[] t1 = line.split("\t");
                                
                // tests the string to make sure line conforms to data format
                if (t1.length != 2 ) break;
                
                String[] t2 = t1[1].split(",");
                
                // tests the string to make sure line conforms to data format
                if (t2.length != 2) break;

                pts.add(new POI(Integer.parseInt(t1[0]),Double.parseDouble(t2[0]),Double.parseDouble(t2[1])));
            }
            
            Iterator it = pts.iterator();
            
            while (it.hasNext()){
                System.out.println(it.next());
            }
        }
        catch (IOException e){
            System.err.println( "Error - cant create the file." );
            return;
        }
    }
    
}
