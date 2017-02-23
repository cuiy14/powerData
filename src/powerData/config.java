package powerData;

import java.util.*;

public class config {
	
	 public config(){
		 tags.put("BaseValue", "T");
		 tags.put("Substation","T");
		 tags.put("Bus", "F");
		 tags.put("ACline", "F");
		 tags.put("Unit", "F");
		 tags.put("Transformer", "F");
		 tags.put("Compensator_P", "F");
		 tags.put("Compensator_S", "F");
		 tags.put("Converter", "F");
		 tags.put("DCline", "F");
		 tags.put("Island", "F");
		 tags.put("TopoNode", "F");				 
	 }
	 
     private  static Map<String, String> tags = new HashMap();
       
     public static void main(String args []){
    	 config con=new config();
    	 if(con.tags.get("BaseValue").equals("T"))
    		 System.out.print("Hello, world!");
    	 else
    		 System.out.print("Sorry");
    		 
     }
}
