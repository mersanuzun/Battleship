package battleships;

import java.util.* ;

public class Ship {
    protected String name;
    protected int size;
    protected Boolean sank;
    ArrayList<Cell> placement = new ArrayList<Cell>();
    public Ship(String name, int size){
        this.name = name;
        this.size = size;
    }
    public boolean shooting(int hitX, int hitY){
        if (this.placement.isEmpty()){
            this.sank = true;
            return false;
        }else{
            for(int i = 0; i < this.placement.size(); i++){
                if ((hitX == this.placement.get(i).placeCoorX) && 
                    (hitY == this.placement.get(i).placeCoorY)){
                       this.placement.remove(i);
                }
            }
        }
        return true;
    }
    public void placing(int coorX, int coorY, String direction){
        switch(direction){
            case "H" : 
                for (int i = 0; i < this.size; i++){
                    Cell c = new Cell(coorX + i, coorY);
                    this.placement.add(c);
                }
                break;
            case "V" : 
                for (int i = 0; i < this.size; i++){
                    Cell c = new Cell(coorX, coorY + i);
                    this.placement.add(c);
                }
                break;
        }  
    }
}