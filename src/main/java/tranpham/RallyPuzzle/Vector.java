package tranpham.RallyPuzzle;

public class Vector {
	Coordinate _start;
	Coordinate _end;
	public Vector(Coordinate start, Coordinate end) {
		_start=start;
		_end=end;
	}
	
	public Vector(int startRow,int startColumn, int endRow,int endColumn){
		_start = new Coordinate(startRow,startColumn);
		_end = new Coordinate(endRow,endColumn);
	}
}
