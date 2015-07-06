package battleships;

public class Battleships {
    public static int board(int size){
        
        return 1;
    }
    public static void main(String[] args) {
        Ship s1 = new Ship("Aircraft carrier", 5);
        Ship s2 = new Ship("Battleship", 4);
        Ship s3 = new Ship("Submarine", 3);
        Ship s4 = new Ship("Destroyer", 3);
        Ship s5 = new Ship("Patrol Boat", 2);
        System.out.println(s5.name);
        s5.placing(2, 3, "V");
        s1.placing(2,3,"H");
        for (Cell p : s1.placement){
            System.out.print(p.placeCoorX + "," + p.placeCoorY);
            System.out.println();
        }
        Board b = new Board(7);
        for(int i = 0; i < b.getEdgeLength(); i++){
            for(int j = 0; j < b.getEdgeLength(); j++){
                System.out.print(b.board[i][j]);
            }
            System.out.println();
        }
        s1.shooting(3, 3);
        s5.shooting(2, 3);
        s5.shooting(2, 4);
        System.out.println(s5.shooting(2, 2));
        System.out.println(s1.placement.size());
        for (Cell p : s5.placement){
            System.out.print(p.placeCoorX + "," + p.placeCoorY);
            System.out.println();
        }
    }   
}
