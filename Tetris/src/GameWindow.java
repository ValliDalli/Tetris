import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class GameWindow extends Pane {
    public Board board;
    private final static int PIXEL = 30;
    private  GridPane gridPane;





    public GameWindow(Board board) {


        this.board=board;
        // Set the background color of the window


        // Create a new grid pane to hold the game board
        gridPane = new GridPane();
        gridPane.getStyleClass().add("grid");
        gridPane.getStyleClass().add("background");
        gridPane.setGridLinesVisible(true);
        gridPane.setAlignment(Pos.CENTER);

        for (int i=0;i<board.getxSize();i++){
            gridPane.getColumnConstraints().add(new ColumnConstraints(PIXEL));
        }
        for (int i=0;i<board.getySize();i++){
            gridPane.getRowConstraints().add(new RowConstraints(PIXEL));
        }




    }
    public void updateBoard(){
        gridPane.getChildren().clear();
        Square[][] gameBoard=this.board.getField();

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                Square square = gameBoard[i][j];
                Rectangle rectangle = new Rectangle(30, 30);
                rectangle.setFill(getColor(square));
                gridPane.add(rectangle, j, i);
            }
        }

        // Add the game board grid to the window
        //getChildren().add(this.gridPane);
    }

    private Color getColor(Square square) {
        if(square==null){
            return Color.BLACK;
        }
        switch (square.getShape()) {
            case 'O' -> {
                return Color.YELLOW;
            }

            case 'I' -> {
                return Color.CYAN;
            }
            case 'L' -> {
                return Color.BLUE;
            }
            case 'J' -> {
                return Color.ORANGE;
            }
            case 'S' -> {
                return Color.GREEN;
            }
            case 'Z' ->{
                return Color.RED;
            }
            default ->{
                return  Color.MAGENTA;
            }
        }
    }
}

