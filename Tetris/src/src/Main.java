import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {
    private final int xSize=10;
    private final int ySize=22;
    public void start(Stage primaryStage) throws Exception {
        Board board=new Board(xSize,ySize);
        Block block=new Block(board);
        GameWindow gameWindow = new GameWindow(board);
        primaryStage.setScene(new Scene(gameWindow, xSize*30, ySize*30));
        gameWindow.updateBoard();
        primaryStage.show();
        block.fall();
        gameWindow.updateBoard();

        primaryStage.show();
//        block.fall();
//        primaryStage.show();
//        block.right();
//        block.right();
//        primaryStage.show();
//        block.rotate();
//        primaryStage.show();
//        block.rotate();
//        primaryStage.show();
//        block.rotate();
//        primaryStage.show();
    }


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


        launch(args);




    }

}