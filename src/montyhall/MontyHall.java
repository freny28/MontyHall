/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Freny Patel, 000744054
 * SOA- The edited code is doone by me with my own stragery and haven't copied it 
 * from anywhere without acknoweledgement .
 */
package montyhall;

import java.util.Random;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author patel
 */
public class MontyHall extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Random random = new Random();
        
        int win100 = 0;
        int win10 = 0;
        int win3 = 0;
        
        for(int i =0; i<1000000; i++){
            int winningDoor100 = random.nextInt(100) + 1;
            int choosenDoor100 = random.nextInt(100) + 1;
           
            if(winningDoor100 != choosenDoor100){
                win100++;
            }

            int winningDoor10 = random.nextInt(10) + 1;
            int choosenDoor10 = random.nextInt(10) + 1;

            if(winningDoor10 != choosenDoor10){
                win10++;
            }

            int winningDoor3 = random.nextInt(10) + 1;
            int choosenDoor3 = random.nextInt(10) + 1;

            if(winningDoor3 != choosenDoor3){
                win3++;
            }
        }
        
        int loose100 = 1000000 - win100;
        int loose10 = 1000000 - win10;
        int loose3 = 1000000 - win3;
        
        ObservableList<PieChart.Data> pieChartData100 = FXCollections.observableArrayList( 
        new PieChart.Data("Wins: " + ((float)win100*100)/1000000,win100), 
        new PieChart.Data("Loss: " + ((float)loose100*100)/1000000,loose100));
        
        ObservableList<PieChart.Data> pieChartData10 = FXCollections.observableArrayList( 
        new PieChart.Data("Wins: " + ((float)win10*100)/1000000,win10), 
        new PieChart.Data("Loss: " + ((float)loose10*100)/1000000,loose10));
        
        ObservableList<PieChart.Data> pieChartData3 = FXCollections.observableArrayList( 
        new PieChart.Data("Wins: " + ((float)win3*100)/1000000,win3), 
        new PieChart.Data("Loss: " + ((float)loose3*100)/1000000,loose3));
        
        PieChart pieChart100 = new PieChart(pieChartData100); 
        PieChart pieChart10 = new PieChart(pieChartData10); 
        PieChart pieChart3 = new PieChart(pieChartData3); 
        
        pieChart100.setTitle("Monte Hall Simulation 100 Doors"); 
        pieChart100.setClockwise(true); 
        pieChart100.setLabelLineLength(50);  
        pieChart100.setLabelsVisible(true);  
        pieChart100.setStartAngle(180); 
        pieChart100.setLayoutX(50);
        
        pieChart10.setTitle("Monte Hall Simulation 10 Doors"); 
        pieChart10.setClockwise(true); 
        pieChart10.setLabelLineLength(50);  
        pieChart10.setLabelsVisible(true);  
        pieChart10.setStartAngle(180); 
        pieChart10.setLayoutX(500);
        
        pieChart3.setTitle("Monte Hall Simulation 3 Doors"); 
        pieChart3.setClockwise(true); 
        pieChart3.setLabelLineLength(50);  
        pieChart3.setLabelsVisible(true);  
        pieChart3.setStartAngle(180); 
        pieChart3.setLayoutX(900);
        
        Group root = new Group(pieChart100,pieChart10,pieChart3); 
        Scene scene = new Scene(root, 1400, 600);  
        primaryStage.setTitle("Pie chart"); 
        primaryStage.setScene(scene);
        primaryStage.show();
          
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
