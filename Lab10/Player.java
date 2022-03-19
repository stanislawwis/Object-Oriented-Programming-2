public class Player {
  private Integer x;
  private Integer y;
  private SquareBoard board;

  public Integer x() { return x; }
  public Integer y() { return y; }

  public Player(Integer x, Integer y, SquareBoard board) {
    this.x = x; this.y = y; this.board = board;
  }

  public static Direction char2Dir(Character c) {
    switch(c) {
      case 'l':
        return Direction.LEFT;
      case 'r':
        return Direction.RIGHT;
      case 'g':
        return Direction.UP;
      case 'd':
        return Direction.DOWN;
      default:
        return Direction.DOWN;
    }
  }

  public void move(Direction where) throws GameOverException, VictoryException {
    Integer nx = x;
    Integer ny = y;
    switch(where) {
      case UP:
        ny = y-1;
        break;
      case DOWN:
        ny = y+1;
        break;
      case LEFT:
        nx = nx-1;
        break;
      case RIGHT:
        nx = nx+1;
        break;
    }
    if(nx < 0 || nx >= board.getSize() || ny < 0 || ny >= board.getSize()) {
      throw new CantMoveHereException();
    }
    else if(board.isSquareWater(nx,ny)) { throw new GameOverException(); }
    else if(board.isSquareTreasure(nx,ny)) { throw new VictoryException(); }
    else {
      x = nx;
      y = ny;
    }
  }
}