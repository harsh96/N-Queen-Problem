/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueengui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Harsh
 */
public class NQueenGui extends Application {
    
    private Text result = new Text();
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("N Queen Problem");
        
        Label inputNLabel = new Label();
        inputNLabel.setText("Enter the value of N");
        TextField N = new TextField();
        HBox inputLayout = createHBox(Pos.CENTER);
        HBox.setHgrow(N, Priority.ALWAYS);
        inputLayout.getChildren().addAll(inputNLabel,N);
        
        Button solve = new Button("Solve!");
        solve.setOnAction(e -> {
            
            if(N.getText().isEmpty())
            {
                result.setText("Enter a number first");
                result.setStyle("-fx-font-size:18;");
                result.setFill(Color.RED);
            }
            else if(N.getText().matches("[0-9]+"))
            {
               int n = Integer.parseInt(N.getText());
               solve(n); 
            }
            else
            {
               result.setText(N.getText()+" is not a Number"); 
               result.setStyle("-fx-font-size:18;");
               result.setFill(Color.RED);
            }
            
        });
        
        VBox center = new VBox();
        center.setAlignment(Pos.CENTER);
        center.getChildren().addAll(inputLayout,solve,result);
        BorderPane layout = new BorderPane();
        layout.setCenter(center);
        Scene scene = new Scene(layout, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
        

    }
    
    public static HBox createHBox(Pos position ){
    
        HBox newHBox = new HBox();
        newHBox.setSpacing(20);
        newHBox.setAlignment(position);
        newHBox.setPadding(new Insets(20, 20, 20, 20));
        return newHBox;
    }
    
    private void solve(int n)
    {
        ChessBoard chessboard= new ChessBoard(n);
        chessboard.check(0); 
        if(chessboard.count==0)
        {
            System.out.println("No Solutions Exist");
            result.setText("No Solutions Exist");
            result.setStyle("-fx-font-size:18;");
            result.setFill(Color.RED);
        }
        else
        {
            int i = 0;
            display(chessboard,n,i);
            result.setText(chessboard.count+" Solutions found");
            result.setStyle("-fx-font-size:18;");
            result.setFill(Color.GREEN);
        }
        
    }
    
    public void display(ChessBoard chessboard,int n,int i)
    {
        GridPane newBoard;
        DrawSolution tool = new DrawSolution();
        newBoard = tool.draw(chessboard.solutions.get(i),n);

        Stage window = new Stage();
        BorderPane layout = new BorderPane();
        layout.setCenter(newBoard);
        Button next = new Button("Next ->");
        Button previous = new Button("<- Previous");
        HBox options = createHBox(Pos.BOTTOM_CENTER);
//        options.getChildren().addAll(previous,next);
        previous.setOnAction(e ->
        {
            window.close();
            if((i-1)>=0)
            {
               display(chessboard,n,i-1);  
            }
        });
        next.setOnAction(e ->
        {
            window.close();
            if((i+1)<chessboard.count)
            {
               display(chessboard,n,i+1); 
            }
        });
        if(i != 0)
        {
            options.getChildren().add(previous);
        }
        if(i != (chessboard.count-1) )
        {
            options.getChildren().add(next);
        }
//        HBox options = createHBox(Pos.BOTTOM_CENTER);
//        options.getChildren().addAll(previous,next);
        layout.setBottom(options);
        Scene scene = new Scene(layout, 600, 600);
        window.setScene(scene);
        window.setTitle("Solution "+(i+1)+" of "+chessboard.count);
        window.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
