import java.awt.*;
import java.util.*;
import java.util.List;

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

    public int removeLine(int[][] cords){
        Square[] empty_line=new Square[this.xSize];
        for(int i=0;i<this.xSize;i++){
            empty_line[i]=null;
        }
        List<Integer> list = new ArrayList<Integer>();
        boolean status;

        for(int[]cord:cords){
            status=true;
            if(list.contains(cord[1])){
                continue;
            }
            for (Square square:this.field[cord[1]]){
                if(square==null){
                    status=false;
                }
            }
            if(status){
                list.add(cord[1]);
            }

        }
        Collections.sort(list);
        for(int line:list){
            for(int i=0; i<line;i++){
                this.field[i+1]=this.field[i];
            }
            this.field[0]=empty_line;
        }
        return list.size();
    }

    public Square[][] getField(){
        return this.field;
    }
    public Square getSquare(int x,int y){
        return this.field[y][x];
    }
    public void move(int[][] oldCords,int[][] newCords,Square square){
        for(int[] cord:oldCords){
            this.field[cord[1]][cord[0]]=null;
        }
        for(int[] cord:newCords){
            this.field[cord[1]][cord[0]]=square;
        }


    }
    public void setSquare(int[] Cords,Square square){
        this.field[Cords[1]][Cords[0]]=square;
    }

}
