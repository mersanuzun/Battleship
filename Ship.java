package battleships;

import java.util.* ;

public class Ship {
    protected String name;
    protected int size;
    protected Boolean sank = false;
    ArrayList<Cell> shipCoordinates = new ArrayList<Cell>();
    public Ship(String name, int size){
        this.name = name;
        this.size = size;
    }
    public boolean shooting(int hitX, int hitY){
        boolean result = false;
        if (this.shipCoordinates.isEmpty()){
            result = false;
        }else{
            for(int i = 0; i < this.shipCoordinates.size(); i++){
                if ((hitX == this.shipCoordinates.get(i).placeCoorX) && 
                    (hitY == this.shipCoordinates.get(i).placeCoorY)){
                       this.shipCoordinates.remove(i);
                       result = true;
                        if (this.shipCoordinates.isEmpty()){
                            this.sank = true;
                        }
                        break;
                }else {
                    result = false;
                }
            }
            
        }
        return result;
    }
}