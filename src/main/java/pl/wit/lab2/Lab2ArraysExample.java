package pl.wit.lab2;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;

//Klasa z przykładami metod operującymi na tablicach
public class Lab2ArraysExample {

    private int[] intNumbers = null;
    private String[] stringElements = null;
    private boolean[] boolElements = null;

    private Lab2ArraysExample(){
        intNumbers = new int[0];
        stringElements = new String[0];
        boolElements = new boolean[0];
    }

    public Lab2ArraysExample(int intValue){
        this();
        intNumbers = Arrays.copyOf(intNumbers, 1);
        intNumbers[0] = intValue;
    }

    public Lab2ArraysExample(String stringValue){
        this();
        stringElements = Arrays.copyOf(stringElements, 1);
        stringElements[0] = stringValue;
    }

    public Lab2ArraysExample(boolean boolValue){
        this();
        boolElements = Arrays.copyOf(boolElements, 1);
        boolElements[0] = boolValue;
    }

    protected static final Logger log = LogManager.getLogger(Lab2ArraysExample.class.getName());

    public void printArraysToLog(){
        if(intNumbers != null){
            for(int el : intNumbers)
                log.info(""+el+", ");
        }

        if(stringElements != null){
            for(String el : stringElements)
                log.info(""+el+", ");
        }

        if(boolElements != null){
            for(boolean el : boolElements){
                log.info((""+el+", "));
            }
        }
    }

    public void addElement(int element){
        intNumbers = Arrays.copyOf(intNumbers, intNumbers.length+1);
        intNumbers[intNumbers.length - 1] = element;
    }

    public void addElement(String element){
        stringElements = Arrays.copyOf(stringElements, stringElements.length+1);
        stringElements[stringElements.length - 1] = element;
    }

    public void addElement(boolean element){
        boolElements = Arrays.copyOf(boolElements, boolElements.length+1);
        boolElements[boolElements.length - 1] = element;
    }

    public int getIntArraySize(){
        if(intNumbers != null) {
            return intNumbers.length;
        } else
            return -1;
    }

    public int getStringArraySize(){
        if(stringElements != null){
            return stringElements.length;
        }else
            return  -1;
    }

    public int getBooleanArray(){
        if(boolElements != null){
            return boolElements.length;
        } else
            return -1;
    }

    public int getIntArrayElement(int index){
        if(intNumbers != null && index < intNumbers.length && index >= 0){
            return intNumbers[index];
        } else
            return -1;
    }

    public String getStringArrayElement(int index){
        if(stringElements != null && index < intNumbers.length && index >= 0){
            return stringElements[index];
        } else
            return "-1";
    }

    public boolean getBooleanArrayElement(int index){
        if(boolElements != null && index < intNumbers.length && index >= 0){
            return boolElements[index];
        } else
            return false;
    }

    public int[] getIntNumbers() {
        return intNumbers;
    }

    public void setIntNumbers(int[] intNumbers) {
        this.intNumbers = intNumbers;
    }

    public String[] getStringElements() {
        return stringElements;
    }

    public void setStringElements(String[] stringElements) {
        this.stringElements = stringElements;
    }

    public boolean[] getBoolElements() {
        return boolElements;
    }

    public void setBoolElements(boolean[] boolElements) {
        this.boolElements = boolElements;
    }
}
