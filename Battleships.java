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
                    break;
                }else message = "Miss";
            }
        }
        if (isGameFinish()) message = "All ships are sunken.";
        show();
        return message;
    }
    public static boolean isGameFinish(){
        if  (b.sunkenShip == b.ships.size()){
            return true;
        }else return false;
    }
    public static void show(){
        for (Ship s : b.ships){
            for (Cell c : s.shipCoordinates){
                System.out.println("Name: " + s.name + " Sank= " + s.sank +  " " + c.placeCoorX + " " + c.placeCoorY);
            }
        }
    }
    public static void main(String[] args) {
        b = new Board(6); // create a board as a sea
        Ship s1 = new Ship("Aircraft carrier", 5);
        Ship s2 = new Ship("Battleship", 4);
        Ship s3 = new Ship("Submarine", 3);
        Ship s4 = new Ship("Destroyer", 3);
        Ship s5 = new Ship("Patrol Boat", 2);
        
        System.out.println(b.shipPlacement(s5, 1, 1, "H")); // place first ship
        System.out.println(b.shipPlacement(s2, 2, 2, "H")); // place second ship
        //System.out.println(b.shipPlacement(s2, 4, 3, "V")); // place first ship
        //System.out.println(b.shipPlacement(s5, 3, 2, "V")); // place first ship
        show();
        System.out.println("STARTED");
        System.out.println(hit(3,1));
        
        System.out.println(hit(4,1));
        System.out.println(hit(2,1));
        System.out.println(hit(1,1));

    }   
}
