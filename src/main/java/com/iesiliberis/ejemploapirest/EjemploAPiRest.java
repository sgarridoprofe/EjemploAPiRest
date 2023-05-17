/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.iesiliberis.ejemploapirest;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author sergio
 */
public class EjemploAPiRest {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        try{
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users/2"))
                .header("accept","application/json")
                .GET()
                .build();
        
            HttpResponse<String> response=HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            
            System.out.println(""+response.body());
        
            String sjson=response.body();
            JsonParser parser=new JsonParser();
            JsonElement root=parser.parse(sjson);
            JsonObject rootObject=root.getAsJsonObject();
            System.out.println("Objeto root "+rootObject.toString());
            JsonObject data=rootObject.getAsJsonObject("data");
            System.out.println("Objeto data "+data.toString());
            System.out.println("email "+data.get("email").getAsString());
        }catch(Exception e){
                
            System.out.println("Error:"+e.getMessage());
        }
    } 
}
  
