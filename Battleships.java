package battleships;

public class Battleships {
    public static Board b;
    public static String hit(int coorX, int coorY){
        String message = null;
        if ((coorX > b.getEdgeLength()) || (coorY > b.getEdgeLength())){
            message = "The hit is out of the sea.";
        }else{
            for (Ship s : b.ships){
                if (s.shooting(coorX, coorY)) {
                    message = "Hit";
                    if (s.sank) b.sunkenShip++;
                }else message = "Miss";
            }
        }
        if (isGameFinish()) message = "The game is finish.";
        return message;
    }
    public static boolean isGameFinish(){
        if  (b.sunkenShip == b.ships.size()){
            return true;
        }else return false;
    }
    public static void main(String[] args) {
        b = new Board(6); // create a board as a sea
        Ship s1 = new Ship("Aircraft carrier", 5);
        Ship s2 = new Ship("Battleship", 4);
        Ship s3 = new Ship("Submarine", 3);
        Ship s4 = new Ship("Destroyer", 3);
        Ship s5 = new Ship("Patrol Boat", 2);
        
        System.out.println(b.shipPlacement(s5, 3, 1, "V")); // place first ship
        for (Cell p : s5.shipCoordinates){
            System.out.print("ship coordinate 2 " + p.placeCoorX + "," + p.placeCoorY);
            System.out.println();
        }
        System.out.println(b.shipPlacement(s3, 1, 1, "V")); // place second ship
        System.out.println(hit(1,1));        
        for (Cell p : s3.shipCoordinates){
            System.out.print("ship coordinate " + p.placeCoorX + "," + p.placeCoorY);
            System.out.println();
        }
        System.out.println(hit(1,2));
        for (Cell p : s3.shipCoordinates){
            System.out.print("ship coordinate " + p.placeCoorX + "," + p.placeCoorY);
            System.out.println();
        }
        System.out.println(hit(1,3));
        for (Cell p : s3.shipCoordinates){
            System.out.print("ship coordinate " + p.placeCoorX + "," + p.placeCoorY);
            System.out.println();
        }
        System.out.println(hit(3, 1));
        System.out.println(hit(3, 2));
    }   
}
