import java.awt.*;
import java.util.*;


public class Block {

    private Character piece;
    private int[][] shape;
    private Square square;
    private int x;
    private int y;
    public Board board;


    public Block( Board board){


        this.board =board;
        createPiece();



    }
    private void createPiece(){
        char[] types={'I','L','J','O','S','Z','T'};

         int[][][] SHAPES = {
                {{4, 0},{3, 0},  {5, 0}, {6, 0}}, // I shape
                {{4,1},{3, 1}, {5, 1}, {5, 0}}, // L shape
                {{4, 1},{3, 1}, {5, 1}, {3, 0}}, // J shape
                {{3, 0}, {4, 0}, {4, 1}, {3, 1}}, // O shape
                {{4, 1},{3, 1},  {4, 0}, {5, 0}}, // S shape
                {{4, 1},{3, 0}, {4, 0},  {5, 1}}, // Z shape
                {{4, 1}, {3, 1},  {4, 0}, {5, 1}}  // T shape
        };
        Random rand = new Random();
        int n = rand.nextInt(7);
        this.shape=SHAPES[n];
        this.x=this.shape[0][0];
        this.y=this.shape[0][1];// x and y is the coordinate around which all blocks rotate

        this.piece=types[n];
        this.square =new Square(this.piece,true);
        for (int[] cords:this.shape){
            board.setSquare(cords,this.square);

        }

    }

    private boolean canMove(int x, int y){// checks whether a block can go left (-1,0), right (1,0), down (0,-1)
        int[][] pos= new int[4][2];
        int i=0;
        for(int[] coordinate:this.shape){
            Square square= board.getSquare(pos[i][0],pos[i][1]);
            pos[i][0]=coordinate[0]+x;
            pos[i][1]=coordinate[1]+y;
            if(pos[i][0]<0||pos[i][0]>= board.getxSize()||pos[i][1]>= board.getySize()||!(square==null||square.getIsActive())){
                return false;
            }
            i++;
        }

        this.x+=x;
        this.y+=y;
        board.move(this.shape,pos,this.square);

        this.shape=pos;
        return true;
    }
//    private boolean fallCheck(){//checks if it is possible to fall for one block down
//
//        for (int[] ints : this.shape) {
//            if (ints[1] >= this.board.getySize() || this.board.getSquare(ints[0],ints[1]) != null) {
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean fall(){//makes the block fall for one square down when possible
        return this.canMove(0, 1);
    }
    public boolean right(){
        return this.canMove(1,0);


    }
    public boolean deactivate(){
        for(int[] cord:this.shape){
            if(cord[1]<=1){
                return false;// if the block is being at the top the player has lost and the game ends
            }
            this.board.getField()[cord[1]][cord[0]].deactivateIsActive();


        }
        return true;
    }
    public boolean left(){
        return this.canMove(-1,0);

    }
    public boolean rotate(){
        if(this.piece=='O'){
            return true;
        }
        int[][] copy = Arrays.stream(this.shape).map(int[]::clone).toArray(int[][]::new);
        for (int[] square:this.shape){
            square[0]-=this.x;
            square[1]-=this.y;
            int temp=square[0]+this.y;
            square[0]=-square[1]+this.x;
            square[1]=temp;
        }
        for(int[] square: this.shape){// check if piece needs to be moved after rotation
            x=square[0];
            y=square[1];
            if(x<0){//if the block is left side out of range we try moving it one square right to adjust
                if(this.canMove(1,0)||this.canMove(2,0)){
                    return true;
                }
                else{
                    this.shape=copy;// if nothing works we are unable to rotate the shape
                    return false;
                }
            }
            else if (x>= board.getxSize()){
                if(this.canMove(-1,0)||this.canMove(-2,0)){
                    return true;
                }
                else{
                    this.shape=copy;
                    return false;
                }
            } else if (y>= board.getySize()) {
                if(this.canMove(0,1)||this.canMove(0,2)){
                    return true;
                }
                else{
                    this.shape=copy;// if nothing works we are unable to rotate the shape
                    return false;
                }
            }
            else if(board.getSquare(x,y)!=null &&!board.getSquare(x,y).getIsActive()){
                if(this.canMove(1,0)||this.canMove(2,0)||this.canMove(-1,0)||
                        this.canMove(-2,0)||this.canMove(0,1)||this.canMove(0,2)){
                    return true;
                }
                else{
                    this.shape=copy;
                    return false;
                }
            }

        }
        board.move(copy,this.shape,this.square);

        return true;
    }


}
