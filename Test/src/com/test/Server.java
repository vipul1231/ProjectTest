package com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author vtiwari
 *
 */
public class Server {

	static class Info {
		String server;
		String type;
		String software;
		String version;
		
		Info(String server, String type, String software, String version){
			this.server = server;
			this.software = software;
			this.type = type;
			this.version = version;
		}
		
	}
	
	
	public static void main(String[] args){
		Server server = new Server();
		List<Info> info = new ArrayList<>();
		try{
			Scanner in = new Scanner(new BufferedReader(new FileReader(new File("input.txt"))));
			
			while(in.hasNextLine()) {
                String line = in.nextLine().trim();
                if (!line.isEmpty()) // Ignore blank lines
                {
                	String[] data = line.split(",");
                	info.add(new Info(data[0], data[1].trim(), data[2].trim(), data[3].trim()));
                }
            }
			in.close();
			info.sort(server.returnComp());
			
			int count=0;
			for(int i=1;i<info.size();i++){
				Info info1 = info.get(i);
				Info info2 = info.get(i-1);
				
				if(info1.version.equals(info2.version) && !info1.server.equals(info2.server)){
					count++;
				}
				
				System.out.println(info1.server+" "+info1.software+" "+info1.type+" "+info1.version);
			}
			
			System.out.println("Answer: "+count);
			
			PrintWriter output;
			try {
				output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
				output.println("" + count);
		        output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		}
		catch(Exception e){
			
		}
		
		
	}
	
	
	
	private Comparator<Info> returnComp(){
		Comparator<Info> comp = new Comparator<Server.Info>() {

			@Override
			public int compare(Info o1, Info o2) {
				// TODO Auto-generated method stub
				if(o1.software.equals(o2.software)){
					
					String version1 = o1.version.trim();
					String version2 = o2.version.trim();
					
					String[] array1 = version1.split("\\.");
					String[] array2 = version2.split("\\.");
					
					if(array1.length == 2 && array2.length==2){
						
						if(Integer.parseInt(array1[0]) == Integer.parseInt(array2[0])){
							
							if(Integer.parseInt(array1[1]) == Integer.parseInt(array2[1])){
								return 0;
							}
							else {
								return Integer.parseInt(array1[1]) - Integer.parseInt(array2[1]);
							}
						}
						else {
							return Integer.parseInt(array1[0]) - Integer.parseInt(array2[0]);
						}
					}
					else {
						if(Integer.parseInt(array1[0]) == Integer.parseInt(array2[0])){
							
							if(Integer.parseInt(array1[1]) == Integer.parseInt(array2[1])){
									
								if(Integer.parseInt(array1[2]) == Integer.parseInt(array2[2])){
									return 0;
								}
								else {
									return Integer.parseInt(array1[2]) - Integer.parseInt(array2[2]);
								}
							}
							else {
								return Integer.parseInt(array1[1]) - Integer.parseInt(array2[1]);
							}
						}
						else {
							return Integer.parseInt(array1[0]) - Integer.parseInt(array2[0]);
						}
					}
				}
				else {
					return o1.software.compareTo(o2.software);
				}
			}
		};
		
		return comp;
	}
}
