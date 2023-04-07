public class Game {
    public static void printBoard(Square[][] board){
        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(board[i][j]==null){
                    System.out.println();
                }
                else if(board[i][j].getIsActive()){
                    System.out.println("o");
                }
                else{
                    System.out.println("+");
                }
            }
            System.out.println("\n");
        }

    }
    public static void main(String[] args) {
        int[][] piece={{3,0},{4,0},{5,0},{6,0}};
        Board board=new Board(10,22);
        Block block=new Block(piece,4,0,'I',board);
        printBoard(board.getField());
        System.out.println("hi");
        block.fall();
        printBoard(board.getField());
        block.left();
        printBoard(board.getField());
        block.right();
        printBoard(board.getField());
        block.fall();
        printBoard(board.getField());

    }

}