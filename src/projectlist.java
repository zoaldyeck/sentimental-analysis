package test;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.io.FileWriter;

public class projectlist {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("/Users/joe/Documents/text/text/english.stop"));// stop words.txt path
		Scanner s1 = new Scanner(new File("/Users/joe/Documents/text/text/pos-words.txt"));
		Scanner s2 = new Scanner(new File("/Users/joe/Documents/text/text/neg-words.txt"));
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> pos_list = new ArrayList<String>();
		ArrayList<String> neg_list = new ArrayList<String>();
		while (s.hasNext()){
		    list.add(s.next());
		}
		s.close();
		//boolean is_equal = false;
		while (s1.hasNext()){
		    pos_list.add(s1.next());
		}
		s1.close();
		
		while (s2.hasNext()){
		    neg_list.add(s2.next());
		}
		s2.close();
		
		File folder = new File("/Users/joe/Documents/text/text/hw_reviews_copy/hw8/");// the path to files that need to clean stop words
		File[] listofiles = folder.listFiles();
		for(int i=0;i<listofiles.length;i++){
			File file = listofiles[i];
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = null;
			ArrayList<String> list1 = new ArrayList<String>();
	        while( (line = br.readLine())!= null ){
	    	    String[] tokens = line.split("\\s+");
	    	    for(int m=0;m<tokens.length;m++){
	    	    	boolean is_equal = false;
	    	    	for(int n=0;n<list.size();n++){
	    	    		if(tokens[m].equals(list.get(n))){
	    	    			is_equal=true;
	    	    		}
	    	    	}
	    	    	if(is_equal==false){
	    	    		list1.add(tokens[m]);
	    	    	}
	    	    	
	    	    }
	        }
	        br.close();
	        
	        FileWriter writer = new FileWriter(file); 
	        String str1 = list1.get(0);
	        writer.write(str1+"\t");
	        list1.remove(0);
	        for(String str: list1) {
	            writer.write(str+" ");
	          }
	        
	        writer.close();
	        
		}
		}


}
