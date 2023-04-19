import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main {
//    public void start(Stage primaryStage) throws Exception {
//        int xSize = 10;
//        int ySize = 22;
//        Board board=new Board(xSize, ySize);
//        Block block=new Block(board);
//        GameWindow gameWindow = new GameWindow(board);
//        gameWindow.updateBoard();
//        Scene scene = new Scene(gameWindow, 30*xSize, 30*ySize);
//        primaryStage.setScene(scene);
//
//        primaryStage.show();
//
//    }


    public static void printBoard(Square[][] board){
        for (Square[] squares : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (squares[j] == null) {
                    System.out.print(" ");
                } else if (squares[j].getIsActive()) {
                    System.out.print("o");
                } else {
                    System.out.print("+");
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------");

    }
    public static void main(String[] args) {







    }

}