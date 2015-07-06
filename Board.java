package battleships;

public class Board {
    private int edgeLength;
    public String[][] board; 
    public Board(int n){
        this.edgeLength = n;
        this.board = new String[this.edgeLength][this.edgeLength];
        for(int i = 0; i < this.edgeLength; i++){
            for(int j = 0; j < this.edgeLength; j++){
                this.board[i][j] = " ~ ";
            }
        }
    }
    public int getEdgeLength(){
        return this.edgeLength;
    }
}
