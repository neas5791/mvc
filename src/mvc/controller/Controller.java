/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.AbstractButton;
import javax.swing.JTextField;
import mvc.model.*;
import mvc.view.TaskView;


/**
 *
 * @author Seaboard
 */
public class Controller {

    private Rectangle theModel;
    private TaskView theView;
    
    public Controller(TaskView theView, Rectangle theModel){
        this.theModel = theModel;
        this.theView = theView;
        
        this.theView.addCalculateListener(new CalculateListener());
        this.theView.addRadioListener(new RadioListener());
        this.theView.addFocusListener(new TextListener());
    }
    
    class RadioListener implements ItemListener{
        /*String lastSelected;*/
        @Override
        public void itemStateChanged(ItemEvent e) {
            AbstractButton aButton = (AbstractButton) e.getSource();
           
            if (aButton.getText() == "Square" && e.getStateChange() ==  ItemEvent.SELECTED) {
                theModel =  new Square(theView.getBaseValue());
                theView.setShape(e);
                updateView();
            }
            else if (aButton.getText() == "Rectangle" && e.getStateChange() ==  ItemEvent.SELECTED) {
                theModel = new Rectangle(theView.getBaseValue(),theView.getHeightValue() );
                theView.setShape(e);
                updateView();
            }
        }
    }

    class CalculateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
                        
            try {
                theModel.setBase(theView.getBaseValue());
                if (!(theModel instanceof mvc.model.Square))
                    theModel.setHeight(theView.getHeightValue());
                theView.setArea(theModel.area());
                updateView();
            }
            catch(NumberFormatException ex){
                System.out.println(ex);
                theView.displayErrorMessage("You need to enter 2 Integers");
            }
            catch (IllegalArgumentException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("You have toenter positive numbers silly!");
            }
           
        }
        
    }
    
    class TextListener implements FocusListener{
        
        @Override
        public void focusGained(FocusEvent e) {
            // Selects all of the text in the current component
            ((JTextField)(e.getSource())).selectAll();
        }

        @Override
        public void focusLost(final FocusEvent e) {
            try {
                if (isInteger( (((JTextField) e.getSource()).getText())))
                    System.out.println("the string is an Integers");
                else
                    System.out.println("No Integers here man");
/*                
                // Before updating model and view the JText field is checked
                // if a Double is found the field value is cast back to Integer
                if (isDouble(((JTextField) e.getSource()).getText())) {
                    double temp = Double.parseDouble(((JTextField)(e.getSource())).getText());
                    String str = String.format("%s", (int) temp);
                    ((JTextField)(e.getSource())).setText(str);
                }
                // Updates the model with new characteristics
                updateModel();
                // Updates the view to reflect new model
                updateView();
  */          }
            catch(NumberFormatException ex){
                System.out.println(ex);
                theView.displayErrorMessage("You need to enter 2 Integers");
            }
            catch (IllegalArgumentException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("You have toenter positive numbers silly!");
            }
        }
    }    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TaskView theView = new TaskView();
        Rectangle theModel = new Rectangle();
        
        // Setup object as Rectangle with dimensions
        theModel.setBase(6);
        theModel.setHeight(4);
        
        // Setup up initial view contents
        theView.setBase(theModel.getBase());
        theView.setHeight(theModel.getHeight());
        theView.setArea(theModel.area());
        
        Controller theController = new Controller(theView, theModel);
                
        theView.setVisible(true);
    }
    
    private void updateView(){
        theView.setBase(theModel.getBase());
        theView.setHeight(theModel.getHeight());
        theView.setArea(theModel.area());
    }
    
    private void updateModel(){
        theModel.setHeight(theView.getHeightValue());
        theModel.setBase(theView.getBaseValue());
    }
    
    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isInteger(String str){
        return str.matches("[0-9]+");
    }
    
    private String convertDbl (String str){
        return str.replaceAll(".\\d+", "");
    }
}
