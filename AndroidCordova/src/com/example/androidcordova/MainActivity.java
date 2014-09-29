package com.example.androidcordova;

import java.io.File;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.cordova.Config;
import org.apache.cordova.CordovaActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;

public class MainActivity extends CordovaActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		 super.init();
	        // Set by <content src="index.html" /> in config.xml
		    load();
		    System.out.println("her");
		    try{
		    	System.out.println("her");
		        super.loadUrl("file://"+Environment.getExternalStorageDirectory()+"/Filecntaineer/www/index.html");
		    }
		    catch(Exception e){
		    	System.out.println("her");
		    }
		 
	      
	}

	public void load(){
	

				// TODO Auto-generated method stub

				   try {
					   File folder = new File(Environment.getExternalStorageDirectory() + "/Filecntaineer");
					   boolean success = true;
					   if (!folder.exists()) {
					       success = folder.mkdir();
					   }
				    	JarExtacter.copy(MainActivity.this);
				    	File  file1 = new File(Environment.getExternalStorageDirectory()+"/Filecntaineer/www.jar");
				    	if(file1.exists()){
				    		System.out.println("here");
				    	}
				    	
				    	///////////////////////////////////////
				    	@SuppressWarnings("resource")
				    	
						java.util.jar.JarFile jarfile = null;
						
						
				    	jarfile = new java.util.jar.JarFile(file1); //jar file path(here sqljdbc4.jar)
				        java.util.Enumeration<java.util.jar.JarEntry> enu= jarfile.entries();
				        while(enu.hasMoreElements())
				        {
				            String destdir =Environment.getExternalStorageDirectory()+"/Filecntaineer";     //abc is my destination directory
				            java.util.jar.JarEntry je = enu.nextElement();

				            System.out.println(je.getName());

				            java.io.File fl = new java.io.File(destdir, je.getName());
				            if(!fl.exists())
				            {
				                fl.getParentFile().mkdirs();
				                fl = new java.io.File(destdir, je.getName());
				            }
				            if(je.isDirectory())
				            {
				                continue;
				            }
				            java.io.InputStream is = jarfile.getInputStream(je);
				            java.io.FileOutputStream fo = new java.io.FileOutputStream(fl);
				            while(is.available()>0)
				            {
				                fo.write(is.read());
				            }
				            fo.close();
				            is.close();
				        }
				    	
				    	
				   
				    	
				    	//////////////////////////////////////
					
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
	
		
		
		
	}
	
	Handler  handler = new Handler(){
	   public void handleMessage(android.os.Message msg) {
//		   MainActivity.this.loadUrl(Environment.getExternalStorageDirectory()+"/Filecntaineer/www/index.html");
		   
		   
	   };	
	};
	
	
	
}

