package com.wongsir.advanceSearch.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;

/** 
* @Description: TODO 
* @author hjd
* @date 2017��1��19�� ����9:53:35 
*  
*/
public class Config {
	public static Rule defaultRule=null;

    static{

        InputStream is = Rule.class.getResourceAsStream("/rule.json");
        defaultRule=Rule.createFromInputStream(is);
    }
}
