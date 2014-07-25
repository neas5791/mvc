/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvc.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;


/**
 *
 * @author Seaboard
 */
public class TaskView extends JFrame{
    private final JLabel welcomeLbl = new JLabel("Welcome to the Task GUI");
    private JLabel baseLbl;
    private JLabel heightLbl;
    private JLabel areaLbl;
    private JTextField baseTxt;// = new JTextField();
    private JTextField heightTxt;// = new JTextField();
    private JTextField areaTxt;// = new JTextField();
    private JButton calculateButton;
    private ButtonGroup buttonGroup;
    private JRadioButton rectangleRadio;
    private JRadioButton squareRadio;
    //private JToggleButton returnBtn;
    
    
    public TaskView(){
        initComponents(); 
    }
    
    private void initComponents(){
        // Set up the view and add the components
        JPanel taskPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        
        JLabel label1 = new JLabel(
                    String.format("%-55s", "Welcome to task two!"), FlowLayout.LEFT);
        taskPanel.add(label1);
        
        buttonGroup = new ButtonGroup();
        rectangleRadio = new JRadioButton("Rectangle",true);
        squareRadio = new JRadioButton("Square");
        JLabel fillLabel = new JLabel(String.format("%-25s", " "));

        // Sets up radio buttons as group
        buttonGroup.add(rectangleRadio);
        buttonGroup.add(squareRadio);
        taskPanel.add(rectangleRadio);
        taskPanel.add(squareRadio);
        taskPanel.add(fillLabel);
        
        
        baseLbl = new JLabel(String.format("%-8s", "Base:"),FlowLayout.LEFT);
        baseTxt = new JTextField(17);
        taskPanel.add(baseLbl);
        taskPanel.add(baseTxt);
        
        heightLbl = new JLabel(String.format("%-8s", "Height:"),FlowLayout.LEFT);
        heightTxt = new JTextField(17);
        taskPanel.add(heightLbl);
        taskPanel.add(heightTxt);
        
        areaLbl = new JLabel(String.format("%-8s","Area:"));
        areaTxt = new JTextField(17);
        areaTxt.setEditable(false);
        taskPanel.add(areaLbl);
        taskPanel.add(areaTxt); 
        
        calculateButton = new JButton("Calculate");
        taskPanel.add(calculateButton, BorderLayout.SOUTH);
        
        this.add(taskPanel);
        
        pack();
        setTitle("ITC313 Assignment Two");
        setSize(275,300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public int getBaseValue(){
        return Integer.parseInt(baseTxt.getText());
    }
    
    public int getHeightValue(){
        return Integer.parseInt(heightTxt.getText());
    }
    
    public void setArea(int solution){
        areaTxt.setText(Integer.toString(solution));
    }
    
    public void setBase(int base){
        baseTxt.setText(Integer.toString(base));
    }
    
    public void setHeight(int height){
        heightTxt.setText(Integer.toString(height));
    }

    public void addCalculateListener(ActionListener listenForCalcButton){
        calculateButton.addActionListener(listenForCalcButton);
    }
    
    public void addRadioListener(ItemListener listenForRadio) {
        rectangleRadio.addItemListener(listenForRadio);
        squareRadio.addItemListener(listenForRadio);
    }
    
    public void addFocusListener(FocusListener listenForText){
        baseTxt.addFocusListener(listenForText);
        heightTxt.addFocusListener(listenForText);
    }
    
    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public void setShape(ItemEvent e) {
        
        AbstractButton aButton = (JRadioButton) e.getSource();
        
        if (aButton.getText() == "Square" && e.getStateChange() ==  ItemEvent.SELECTED) 
            heightTxt.setEditable(false);
        else
            heightTxt.setEditable(true);
    }


}
