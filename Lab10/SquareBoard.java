import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class SquareBoard {
  private List<List<Entity>> board;
  private Integer size;

  public enum Entity {
    GROUND(0,'*'),
    WATER(1,'W'),
    TREASURE(2,'S');
    private final Integer value;
    private final Character repr;
    Entity(Integer value, Character repr) { 
      this.value = value; this.repr = repr;
    }
    public Character getChar() { return repr; }
    public Integer getInt() { return value; }
    public String toString() { return String.valueOf(repr); }
  }
  
  public SquareBoard(Integer size, Double pw) throws TooSmallGameSizeException {
    if(size < 3) { throw new TooSmallGameSizeException(); }
    this.size = size;
    board = new ArrayList<>(size);
    for(int i = 0; i < size; i++) {
      board.add(new ArrayList<>(size));
      for(int j = 0; j < size; j++) {
        board.get(i).add(Math.random() > pw ? Entity.GROUND : Entity.WATER);
      }
    }
    Integer tx = Long.valueOf(Math.round(Math.random() * size-1)).intValue();
    Integer ty = Long.valueOf(Math.round(Math.random() * size-1)).intValue();
    if(tx == -1) { tx = 0; }
    if(ty == -1) { ty = 0; }
    board.get(tx).set(ty, Entity.TREASURE);
  }

  public Integer getSize() { return size; }

  public Entity getSquare(Integer x, Integer y) {
    return board.get(y).get(x);
  }

  public Boolean isSquareWater(Integer x, Integer y) {
    return board.get(y).get(x) == Entity.WATER;
  }

  public Boolean isSquareTreasure(Integer x, Integer y) {
    return board.get(y).get(x) == Entity.TREASURE;
  }

  public void printBoard(Integer px, Integer py) {
    for(int j = 0; j < size; j++) {
      for(int i = 0; i < size; i++) {
        if(i == px && j == py) { System.out.print('G'); continue; }
        System.out.print(board.get(j).get(i));
      }
      System.out.print("\n");
    }
  }
}