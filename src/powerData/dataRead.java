package powerData;

import java.util.*;
import java.io.*;
import java.util.regex.*;

public class dataRead {
	public static void main(String args[]) throws FileNotFoundException{
//		config config= new config();
		Scanner s=new Scanner(new File("src/¸£½¨_20111219_2301.QS"));
		String line;
		boolean in=false;
		Map<String,commonType> IObjRegister=new HashMap();
		String mapName= new String();			//the key of IObjRegister
		Map<String,String> vectorElement=new HashMap();
		commonType tmp=new commonType();	//the value of thee IObjRegister, to store the tmp of one commontype,
		Vector<String> index=new Vector();				//to store the index of the tmp
		Vector<String> value=new Vector();				//to store the value of the tmp
		while(s.hasNextLine()){					//analyse the data, store it in IObjRegister
			line=s.nextLine();
			if(!in){						//the handler is out of block
//				System.out.println(line);
				line=line.trim();
//				System.out.println(line);
				if((line.length()!=0)&&(line.charAt(1)!='!')&&(line.charAt(0)!='@')&&(line.charAt(0)!='/')&&(line.charAt(0)!='#')){			//exclude the first line and empty line
					Pattern pattern=Pattern.compile("\\w+"); 
					Matcher matcher=pattern.matcher(line);
					while(matcher.find()){
						mapName=matcher.group();		//get the key of IObjRegister
			//			System.out.print(mapName);
						if(  new config().test(mapName))		//this block is to analyse
							{
							in=true;
//							IObjRegister= new HashMap();
							tmp=new commonType();
							vectorElement= new HashMap();
							value=new Vector();
							index=new Vector();
							}
						break;
					}					
				}
				
			}		//if(!in)
			else{
				line=line.trim();
				if(!line.isEmpty()){
				if(line.charAt(0)=='<' && line.charAt(1)=='/')		//analysis finished
					{
						in=false;						//add the remaining
						IObjRegister.put(mapName, tmp);	//the cleanup and initiallization of each variables is finished when "in= true"
					}
				else if(line.charAt(0)=='/')						//omit this line if it is interpretation
				{}
				else {
					if(index.isEmpty())						//read the index
					{
						for(String str :line.trim().split("\\s+"))
							index.add(str);
					}
					else
					{
						String [] data = line.trim().split("\\s+");
						for(int iter=1;iter!=data.length;iter++)				//read each line to the vectorElement
							vectorElement.put(index.get(iter), data[iter]);
						tmp.addEle(vectorElement);
						vectorElement=new HashMap();
					}						
					}			//end of the block
			}}
		}
		
	System.out.println("Data analyses is finished!\n");							//give the brief information of each tag
	System.out.println("The analyses result is as followed:");
	for(Map.Entry<String,commonType> entry : IObjRegister.entrySet() )
	{
		String key= entry.getKey();
		commonType type=entry.getValue();
		System.out.println("Tag = " + key + ", number = " + type.size());
	}
	
	//test
/*	for(Map.Entry<String, String> entry : IObjRegister.get("BaseValue").idGet(1).entrySet()){
		String key = entry.getKey();
		String valueT=entry.getValue();
		System.out.print("\n" + key + ": " + valueT);
	}*/
	
	
	while(true){
		System.out.println("\nPlease input the Tag of data you want to know:");
		Scanner sin= new Scanner(System.in);
		String inTag= sin.next();
//		System.out.print(inTag);
		System.out.println("Please input the ID of data you want to know:");
		int inID=sin.nextInt();
//		System.out.print(inID);
		System.out.println("The relevant information is as followed:");
//		boolean is=IObjRegister.get(inTag).idTest(inID);
//		if(is) System.out.print("Hello");
		if(IObjRegister.get(inTag).idTest(inID)){				//if the information is wrong, the program will be stopped-- see chapter 7 exception
			for(Map.Entry<String, String> entry : IObjRegister.get(inTag).idGet(inID).entrySet()){
				String key = entry.getKey();
				String valueT=entry.getValue();
				System.out.println(key + ": " + valueT);
			}
		}
		else
			System.out.println("No found!");
	}
	
		
	}
}
