package pl.wit.lab2;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Klasa z przykładami metod operującymi na HashMapie i HashSet
 */
public class Lab2SetAndMapExample {

    private Set<String> setCars = null;
    private Map<String, Integer> mapCarPower = null;
    protected static final Logger log = LogManager.getLogger(Lab2SetAndMapExample.class.getName());

    public Lab2SetAndMapExample() {
        setCars = new HashSet<String>();
        mapCarPower = new HashMap<String, Integer>();
    }

    public void printSetToLog() {
        if (setCars != null) {
            for (String el : setCars) {
                log.info("" + el + ", ");
            }
        }
    }

    public void printMapToLog() {
        if (mapCarPower != null) {
            for (String el : mapCarPower.keySet()) {
                log.info("" + el + "=" + mapCarPower.get(el) + ", ");
            }
        }
    }

    public void addElement(String element) {
        if (setCars != null) {
            setCars.add(element);
        }
    }

    public void addElement(String key, Integer value) {
        if (mapCarPower != null) {
            mapCarPower.put(key, value);
        }
    }

    public Integer getMapValue(String key) {
        return mapCarPower.get(key);
    }

    public Boolean isSetContains(String element) {
        return setCars.contains(element);
    }

    /////////////////////////////////
    // getters and setters
    /////////////////////////////////
    public Set<String> getSetCars() {
        return setCars;
    }

    public void setSetCars(Set<String> setCars) {
        this.setCars = setCars;
    }

    public Map<String, Integer> getMapCarPower() {
        return mapCarPower;
    }

    public void setMapCarPower(Map<String, Integer> mapCarPower) {
        this.mapCarPower = mapCarPower;
    }
}
