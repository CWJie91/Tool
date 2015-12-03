
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHAN
 */
public class SimpleWorkingHourCalculator {
    public  static void main(String[]args){
       
    	//Declaration of variable
       String workingHourCode = "000000000000000000000000000000000000000000000000";
       String operationHour = "";
       String dayDesc = "";
       String openingTime = "";
       String closingTime  = "";
       String initialTime = "12:00 AM";
       final String allTime = "24HOURS";
       final String offTime = "CLOSED";
       boolean opening = false;
       boolean closed = false;
       int opencount = 1;
       int closedcount = 1 ;
       
       //Store a list of time
       ArrayList<String> timeList = new ArrayList<>();
       ArrayList<String> optHourList = new ArrayList<>();

   
        for(int i = 0; i < workingHourCode.length()-1; i++){
        	
            
            
           /*Method of adding 30 minutes*/
            SimpleDateFormat df = new SimpleDateFormat("h:mm a");
            
            Date d = null;
            try {
                d = df.parse(initialTime);
            } catch (ParseException ex) {
                Logger.getLogger(SimpleWorkingHourCalculator.class.getName()).log(Level.SEVERE, null, ex);
            }

            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            cal.add(Calendar.MINUTE, 30 );
            String nextTime = df.format(cal.getTime());
            
            /* Method of set the operation hour*/
            
            /*Checking the value whether is opening or closed*/
            if(workingHourCode.charAt(i) != '0'){
            	timeList.add(initialTime);
            	openingTime = timeList.get(0);
            	opening = true;
                opencount++;
            }else {
            	opening =false;
                closedcount++;
            }
            
            if(opening){
            	if(workingHourCode.charAt(i+1) != '1'){
            		closingTime = nextTime;
            		operationHour = openingTime + "-" + closingTime;
            		timeList.clear();
            	}
            }
            
            optHourList.add(operationHour);
            initialTime = nextTime;
            
            
           } 
        
        /*Remove duplicate element*/
        Object[] optHourLst = optHourList.toArray();
        for(Object s : optHourLst){
        	if(optHourList.indexOf(s) != optHourList.lastIndexOf(s)){
        		optHourList.remove(optHourList.lastIndexOf(s));
        	}
        }
        
        /*Display business hour*/
        for(int j=0; j<optHourList.size(); j++){
        	dayDesc += optHourList.get(j)+"," ;
        }
        /*Remove the first comma*/
        dayDesc = dayDesc.substring(1);
        
        /*Checking whether 24hours*/
        if(opencount == workingHourCode.length()){
               dayDesc = allTime; 
        }

        /*Checking whether closed*/
        if(closedcount == workingHourCode.length()){
            dayDesc = offTime;
        }
        
        System.out.println(dayDesc);
    }
 }


       


