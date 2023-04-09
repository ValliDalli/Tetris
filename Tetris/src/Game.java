public class Game {
    public static void printBoard(Square[][] board){
        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(board[i][j]==null){
                    System.out.print(" ");
                }
                else if(board[i][j].getIsActive()){
                    System.out.print("o");
                }
                else{
                    System.out.print("+");
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------");

    }
    public static void main(String[] args) {

        Board board=new Board(10,10);
        Block block=new Block(board);
        printBoard(board.getField());

        block.fall();
        printBoard(board.getField());
        block.fall();
        printBoard(board.getField());
        block.right();
        block.right();
        printBoard(board.getField());
        block.rotate();
        printBoard(board.getField());
        block.rotate();
        printBoard(board.getField());
        block.rotate();
        printBoard(board.getField());


    }

}