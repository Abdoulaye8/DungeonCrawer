package cell;

public class EmptyCell extends Cell {
    public EmptyCell(int pos) {
        super(pos);
    }
    @Override
    public String toString() {
        return "Case vide (" +getPosition() + ")";
    }
}
