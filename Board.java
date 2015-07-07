package battleships;
import java.util.*;
public class Board {
    private int edgeLength;
    public String[][] board;
    ArrayList<Ship> ships = new ArrayList<Ship>();
    int sunkenShip = 0;
    public static final String[] letters= {" A ", " B ", " C ", " D ", " E ", " F ", " G ", " H ", " I ", " J ", " K ", " L "};
    public static final String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    public Board(int n){
        this.edgeLength = n;
        this.board = new String[this.edgeLength + 1][this.edgeLength + 1];
        for(int i = 0; i < this.board.length; i++){
            for(int j = 0; j < this.board.length ; j++){
                this.board[i][j] = " ~ ";
            }
            System.out.println();
        }
    }
    public int getEdgeLength(){
        return this.edgeLength;
    }
    public void print(){
        for(int i = 0; i < this.board.length ; i++){
            for(int j = 0; j < this.board.length ; j++){
                if (i == this.board.length - 1){
                    if ((i == this.board.length - 1) & (j == 0)) System.out.print(" ");
                    else System.out.print(letters[j - 1]);
                }else{
                    if (j == 0) System.out.print(numbers[this.board.length - 2 - i]);
                    else System.out.print(this.board[i][j]);
                }
            }
            System.out.println();
        }
    }
    private boolean isThereShip(Cell c){
        boolean result = false;
        for(Ship ship : this.ships){
            for(Cell cell : ship.shipCoordinates){
                if ((c.placeCoorX == cell.placeCoorX) && (c.placeCoorY == cell.placeCoorY)) {
                    result = true;
                    break;
                }
                if (result) break;
            }
        }
        return result;
    } 
    public String shipPlacement(Ship s, int coorX, int coorY, String direction){
        String err = s.name + " is placed";
        switch(direction){
            case "H" : 
                for (int i = 0; i < s.size; i++){
                    if ((coorX > this.edgeLength) || (coorY > this.edgeLength) ||
                            (coorX + s.size - 1> this.edgeLength)){
                        err = s.name + " is out of the sea.";
                        break;
                    }else{
                        Cell c = new Cell(coorX + i, coorY);
                        if (this.isThereShip(c)) break;
                        else s.shipCoordinates.add(c);
                    }
                }
                if (s.shipCoordinates.size() != 0){
                    this.ships.add(s);                    
                }else err = "There is a ship in there.";
                break;
            case "V" : 
                for (int i = 0; i < s.size; i++){
                    if ((coorX > this.edgeLength) || (coorY > this.edgeLength) ||
                            (coorY + s.size - 1> this.edgeLength)){
                        err = s.name + " is out of the sea.";
                        break;
                    }else{
                        Cell c = new Cell(coorX, coorY + i);
                        if (this.isThereShip(c)) break;
                        else s.shipCoordinates.add(c);
                    }
                }
                if (s.shipCoordinates.size() != 0){
                    this.ships.add(s);
                }else err = "There is a ship in there.";
                break;
        }  
        return err;
    }
}
