package utils;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aasx .
 */
public class Stash {

    private static Map<String, Object> stash = new HashMap<>();


    public static final String itemName = "itemName";
    public static final String itemPrice = "itemPrice";

    public static Object get (String key){
        return stash.get(key);
    }

    public static void put(String key, Object value){
        stash.put(key, value);
    }

    public static WebDriver getDriver(){
        return (WebDriver) stash.get("driver");
    }

    public static boolean exist(){
        if(stash.containsKey("Наушники"))return true;
        else return false;
    }


}
