package tranpham.RallyPuzzle;

public class Coordinate implements Comparable<Coordinate>{
	int _column;
	int _row;
	public Coordinate(int row, int col) {
		// TODO Auto-generated constructor stub
		_row=row;
		_column=col;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj.getClass().equals(Coordinate.class)){
			if(((Coordinate)obj)._column==_column&&((Coordinate)obj)._row==_row)
				return true;
		}
		return false;
	}

	public int compareTo(Coordinate obj) {
		// TODO Auto-generated method stub
		if(this.equals(obj))
			return 0;
		
		return 1;
	}
}
