import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class GameWindow extends Pane {
    private Board board;
    private GridPane gridPane;





    public GameWindow(Board board) {


        this.board=board;
        // Set the background color of the window


        // Create a new grid pane to hold the game board
        GridPane gameBoardGrid = new GridPane();
        gameBoardGrid.setGridLinesVisible(true);
        gameBoardGrid.setAlignment(Pos.CENTER);
        this.gridPane=gameBoardGrid;

        // Add the squares to the grid pane

    }
    public void updateBoard(){
        Square[][] gameBoard=this.board.getField();
        this.gridPane.getChildren().clear();
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                Square square = gameBoard[i][j];
                Rectangle rectangle = new Rectangle(30, 30);
                rectangle.setFill(getColor(square));
                this.gridPane.add(rectangle, j, i);
            }
        }

        // Add the game board grid to the window
        getChildren().add(this.gridPane);
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

