/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueengui;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Harsh
 */
public class DrawSolution {

    public GridPane draw(int solution[],int n)
    {
      GridPane board = new GridPane();
      for(int row=0;row<n;row++)
      {
          for(int col=0;col<n;col++)
          {
             StackPane square = new StackPane();
             String color ; 
             if((row + col)%2 == 0)
             {
                 color = "white";
             }
             else
             {
                 color = "gray";
             }
             if(solution[row]==col)
             {
                Image queenImage = new Image(NQueenGui.class.getResourceAsStream("images/queen.png"));
                ImageView imageview = new ImageView(queenImage);
                imageview.setImage(queenImage);
                imageview.setFitWidth(600/n);
                imageview.setPreserveRatio(true);
                imageview.setSmooth(true);
                imageview.setCache(true);
                square.getChildren().add(imageview);
             }
             square.setStyle("-fx-background-color: "+color+";");
             board.add(square, col, row);
          }
      }
      for (int i = 0; i < n; i++)
      {
        board.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
        board.getRowConstraints().add(new RowConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
      }
      return board;
    }
 
}
