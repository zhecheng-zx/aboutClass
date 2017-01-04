package com.aboutClass.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropetiesUtils {
	public final static String CONFIG   = "shortmessage.properties";   
    
    public static Object getKeyInfo(String filePath,String keyName){   
//        InputStream proIn = PropetiesUtils.class.getClassLoader().getResourceAsStream(filePath);   
        Properties pro = new Properties();   
        try {   
            pro.load(new InputStreamReader(PropetiesUtils.class.getClassLoader().getResourceAsStream(filePath), "UTF-8"));   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
        //back = pro.getProperty(keyName);   
        return pro.get(keyName);   
    }   
}
