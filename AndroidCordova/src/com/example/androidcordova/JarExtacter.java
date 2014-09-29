package com.example.androidcordova;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;

public class JarExtacter {
	
	
	
	
	
	

	
	public static void copy(Context ctx){
		 AssetManager assetManager = ctx.getAssets();
	        String[] files = null;
	        try {
	            files = assetManager.list("Files");
	        } catch (IOException e) {
	            Log.e("tag", e.getMessage());
	        }
	        
	        for(String filename : files) {
	        	System.out.println("File name => "+filename);
	            InputStream in = null;
	            OutputStream out = null;
	            try {
	              in = assetManager.open("Files/"+filename);   // if files resides inside the "Files" directory itself
	              out = new FileOutputStream(Environment.getExternalStorageDirectory().toString() +"/Filecntaineer/" + filename);
	              copyFile(in, out);
	              in.close();
	              in = null;
	              out.flush();
	              out.close();
	              out = null;
	            } catch(Exception e) {
	                Log.e("tag", e.getMessage());
	            }       
	    }
	}
	
	
	  public static void copyFile(InputStream in, OutputStream out) throws IOException {
	        byte[] buffer = new byte[1024];
	        int read;
	        while((read = in.read(buffer)) != -1){
	          out.write(buffer, 0, read);
	        }
	    }
	
	
}


