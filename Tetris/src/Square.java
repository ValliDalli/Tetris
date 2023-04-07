import java.awt.*;

public class Square {
    private final Character color;
    private boolean isActive;
    public Square(Character color, boolean isActive) {
        this.color = color;
        this.isActive = isActive;
    }
    public Character getColor(){
        return this.color;
    }
    public boolean getIsActive(){
        return this.isActive;
    }
    public void deactivateIsActive(){
        this.isActive=false;
    }
}
