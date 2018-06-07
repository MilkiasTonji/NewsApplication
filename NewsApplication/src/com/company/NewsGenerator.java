package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.TimerTask;

public class NewsGenerator extends TimerTask {
    FileWriter fileWriter;
    FileReader fileReader;

//    String fileName = "News.html";

    @Override
    public void run() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://edition.cnn.com/");
        driver.manage().window().maximize();

        WebElement webElement = driver.findElement(By.tagName("body"));
        dataWriter(webElement.getAttribute("innerHTML") + "$body");
        driver.close();


    }

    public void dataWriter(String elements){
         String fileName = "myNews.html";
         String htmlFile = dataReader().replace("$body",elements);

         try {
             fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             bufferedWriter.write(htmlFile);
             bufferedWriter.close();

         }catch (Exception exception){
             System.out.println("Could not write to the file: " + fileName);
         }
    }

    private String dataReader(){
        String fileName = "myNews.html";
        String countLines;
        String htmlFileTemplate = "";

        try {
            fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((countLines = bufferedReader.readLine()) != null){
                htmlFileTemplate += countLines;
            }
            bufferedReader.close();

        } catch (Exception e) {
            System.out.println("Could not Read the File: " + fileName);
            e.printStackTrace();
        }
        return htmlFileTemplate;
    }
}
