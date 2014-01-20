
package com.agungsetiawan.smsbroadcaster.backgroundservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author blinkawan
 */
public class BackgroundService {
    
    public int checkStatus(){
        try {
            Process process=Runtime.getRuntime().exec("sc query GammuSMSD");
            BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream())); 
            
            String line;
            while((line=reader.readLine())!=null){
                if(line.trim().startsWith("STATE")){
                    if(line.trim().substring(line.trim().indexOf(":")+1, line.trim().indexOf(":")+4).trim().equals("1")){
                        return 1;
                    }else if(line.trim().substring(line.trim().indexOf(":")+1, line.trim().indexOf(":")+4).trim().equals("4")){
                        return 4;
                    }
                }
            }
            
            return 0;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return 0;
    }
}
