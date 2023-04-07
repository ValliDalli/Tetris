import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class Board {

    private Square[][] field;
    private final int xSize;
    private final int ySize;

    public Board(int xSize,int ySize){
        this.xSize=xSize;
        this.ySize=ySize;
        this.createField(xSize, ySize);
    }
    private void createField(int xSize,int ySize){
        this.field = new Square[ySize][xSize];
        for(int i=0;i<ySize;i++){
            for (int j=0;j<xSize;j++){

                this.field[i][j]=null;
            }
        }
    }

    public int getxSize() {
        return xSize;
    }
    public int getySize(){
        return ySize;
    }

    public Square[][] getField(){
        return this.field;
    }
    public Square getSquare(int x,int y){
        return this.field[y][x];
    }
    public void move(int[] oldCords,int[] newCords,Square square){
        this.field[newCords[1]][newCords[0]]=square;
        this.field[oldCords[1]][oldCords[0]]=null;
    }
    public void setSquare(int[] Cords,Square square){
        this.field[Cords[1]][Cords[0]]=square;
    }

}
