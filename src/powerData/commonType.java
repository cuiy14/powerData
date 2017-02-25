package powerData;

import java.util.*;

public class commonType {
	private int count=0;
	private String name;
	Vector<Map<String,String>> records= new Vector();
	
	public void rename(String aname){
		name=aname;
	}
	
	public void addEle(Map<String,String> aelement){
		records.addElement(aelement);
		count++;
	}
	
	public boolean idTest(int it){
		if(it>records.size())
		   return false;
		else if(records.get(it).get("id").equals(Integer.toString(it)))		//to test the equality of two strings, use equal method instead of "=="
			return true;
		else if(records.get(it-1).get("id").equals(Integer.toString(it)))
			return true;
		else 
			return false;
	}
	
	public Map<String,String> idGet(int it){
		if(records.get(it).get("id").equals(Integer.toString(it)))	//the error of many things
			return records.get(it);
		else //if(records.get(it-1).get("id")==Integer.toString(it-1))
			return records.get(it-1);
//		else 
//			return records.get(it+1);
	}
	
	public int size(){
		return count;
	}
	
}
