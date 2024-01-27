package com.utils;
import com.pdfcrowd.*;
import java.io.*;

public class ApiTest {
	public static String website1;
	public static String filename1;
	
	public ApiTest(String website , String filename){
		ApiTest.filename1=filename;
		ApiTest.website1=website;
		
		
	}
    public static void main(String[] args) throws IOException, Pdfcrowd.Error {
        try {
            // create the API client instance
            Pdfcrowd.HtmlToPdfClient client = new Pdfcrowd.HtmlToPdfClient("danny329", "db8b17cbc6c766c4345f94809cd60531");

            // run the conversion and write the result to a file
            client.convertUrlToFile(website1, filename1);
        }
        catch(Pdfcrowd.Error why) {
            // report the error
            System.err.println("Pdfcrowd Error: " + why);

            // handle the exception here or rethrow and handle it at a higher level
            throw why;
        }
        catch(IOException why) {
            // report the error
            System.err.println("IO Error: " + why.getMessage());

            // handle the exception here or rethrow and handle it at a higher level
            throw why;
        }
    }
}