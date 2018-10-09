package main.java.com.myFile;

import java.io.*;


public class RunPythonUtil {


	public String runPython(String video) {
	    String line = "";
        String lastLine = "";
        try{
            String pythonPath = "//Users//yaminiaggarwal//Documents//temp//emotion_recognition1.py";
            ProcessBuilder pb = new ProcessBuilder("python", pythonPath, video);
            Process p = pb.start();

            BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            System.out.println("Running Python starts: " + line);
            line = bfr.readLine();
            System.out.println("First Line: " + line);
            while ((line = bfr.readLine()) != null){
                System.out.println("Python Output: " + line);
                lastLine = line;
            }

        } catch(Exception e) {
            System.out.println(e);
        }
        return lastLine;
    }


}