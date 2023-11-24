package lk.ijse.dep.service;
public class BoardImpl implements Board{
    private static CubeColor[][] pieces = new CubeColor[NUM_OF_COLS][NUM_OF_ROWS];
    private BoardUI boardUI;

    public BoardUI getBoardUI() {return boardUI;}
    public static CubeColor[][] getPieces() {
        return pieces;
    }

    public BoardImpl(BoardUI boardUI){
        this.boardUI = boardUI;
        for (int i=0; i<6; i++){
            for (int j=0; j<5; j++) {
                pieces[i][j] = CubeColor.EMPTY;
            }
        }
    }
    @Override
    public int findNextAvailableSpot(int col){
        for (int i = 0; i < 5; i++) {
            if (pieces[col][i].equals(CubeColor.EMPTY)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {
        if(findNextAvailableSpot(col)==-1) {
            return false;
        }else{return true;}
    }

    @Override
    public boolean existLegalMoves() {
        for (int i=0; i<6; i++) {
            if (isLegalMove(i)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateMove(int col, CubeColor move) {

        for (int i=0; i<5; i++){
            if(pieces[col][i]==CubeColor.EMPTY){
                pieces[col][i]=move;
                break;
            }
        }
    }

    @Override
    public void updateMove(int col, int row, CubeColor move) {
        pieces[col][row]=move;
    }

    @Override
    public Winner findWinner() {
        Winner win;
        for (int row=0; row<5; row++){

            if(pieces[0][row]==CubeColor.GREEN && pieces[1][row]==CubeColor.GREEN && pieces[2][row]==CubeColor.GREEN && pieces[3][row]==CubeColor.GREEN){
                win = new Winner(CubeColor.GREEN,0,row,3,row);
                return win;
            }else if(pieces[0][row]==CubeColor.BLUE && pieces[1][row]==CubeColor.BLUE && pieces[2][row]==CubeColor.BLUE && pieces[3][row]==CubeColor.BLUE){
                win = new Winner(CubeColor.BLUE,0,row,3,row);
                return win;
            }else if(pieces[1][row]==CubeColor.GREEN && pieces[2][row]==CubeColor.GREEN && pieces[3][row]==CubeColor.GREEN &&pieces[4][row]==CubeColor.GREEN){
                win = new Winner(CubeColor.GREEN,1,row,4,row);
                return win;
            }else if(pieces[1][row]==CubeColor.BLUE && pieces[2][row]==CubeColor.BLUE && pieces[3][row]==CubeColor.BLUE &&pieces[4][row]==CubeColor.BLUE){
                win = new Winner(CubeColor.BLUE,1,row,4,row);
                return win;
            }else if(pieces[2][row]==CubeColor.GREEN && pieces[3][row]==CubeColor.GREEN && pieces[4][row]==CubeColor.GREEN &&pieces[5][row]==CubeColor.GREEN){
                win = new Winner(CubeColor.GREEN,2,row,5,row);
                return win;
            }else if (pieces[2][row]==CubeColor.BLUE && pieces[3][row]==CubeColor.BLUE && pieces[4][row]==CubeColor.BLUE &&pieces[5][row]==CubeColor.BLUE){
                win = new Winner(CubeColor.BLUE,2,row,5,row);
                return win;
            }
        }

        for (int col=0; col<6; col++){

            if(pieces[col][0]==CubeColor.GREEN && pieces[col][1]==CubeColor.GREEN && pieces[col][2]==CubeColor.GREEN &&pieces[col][3]==CubeColor.GREEN){
                win = new Winner(CubeColor.GREEN,col,0,col,3);
                return win;
            }else if(pieces[col][0]==CubeColor.BLUE && pieces[col][1]==CubeColor.BLUE && pieces[col][2]==CubeColor.BLUE &&pieces[col][3]==CubeColor.BLUE){
                win = new Winner(CubeColor.BLUE,col,0,col,3);
                return win;
            }else if(pieces[col][1]==CubeColor.GREEN && pieces[col][2]==CubeColor.GREEN && pieces[col][3]==CubeColor.GREEN &&pieces[col][4]==CubeColor.GREEN){
                win = new Winner(CubeColor.GREEN,col,1,col,4);
                return win;
            }else if(pieces[col][1]==CubeColor.BLUE && pieces[col][2]==CubeColor.BLUE && pieces[col][3]==CubeColor.BLUE &&pieces[col][4]==CubeColor.BLUE){
                win = new Winner(CubeColor.BLUE,col,1,col,4);
                return win;
            }

        }
        return null;
    }

}


