import java.util.*;


public class StringDuplicationRemover {
    public static void main (String[]args){
        
        //Declaration of variable
        String sample1 = "a,b,c,d,e,f,a,d";
        String sample2 = "ab,cd,ab,ef,gh,cd";
        
        //call the method
        sample1 = removeDuplicate(sample1,"\\,");
        sample2 = removeDuplicate(sample2,"\\,");
        
        //Output
        System.out.println(sample1);
        System.out.println(sample2);
        
        
    }
    
    public static String removeDuplicate(String s, String splitter ){
    
       /* Store new string without splitter, remove duplicate and acts as controller*/
        List<String> newString = new ArrayList<String>();
        
        /*Remove the splitter ','*/
        String[] splitted = s.split(splitter);
       
        /*Loop the string and add it to list*/
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < splitted.length; i++){
            
            if (!newString.contains(splitted[i])){
                newString.add(splitted[i]);
                sb.append(',');
                sb.append(splitted[i]);
            }
        }
        
        /*Remove the comma*/
        return sb.substring(1);
    }
}
