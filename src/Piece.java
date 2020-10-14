public abstract class Piece {

    private boolean white = false;

    public Piece(boolean white)
    {
        this.setWhite(white);
    }

    public boolean isWhite()
    {
        return this.white;
    }

    public void setWhite(boolean white)
    {
        this.white = white;
    }

    public boolean isEnemy(Piece p)
    {
        if (p.isWhite() != this.isWhite())
            return true;
        return false;
    }

    public abstract boolean canMove(Spot[][] boxes, Spot start, Spot end);
}