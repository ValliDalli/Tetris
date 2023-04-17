import java.awt.*;

public class Square {
    private final Character shape;
    private boolean isActive;
    public Square(Character shape, boolean isActive) {
        this.shape = shape;
        this.isActive = isActive;
    }
    public Character getShape(){
        return this.shape;
    }
    public boolean getIsActive(){
        return this.isActive;
    }
    public void deactivateIsActive(){
        this.isActive=false;
    }
}
