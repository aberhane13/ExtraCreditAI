
//Chess Piece class
public class ChessPiece {

	//Trajectory number
	public int t;

	//Flag that a piece has been visited by mapping
	public boolean visited;

	//Flag that a piece has been visited by the SUM operation
	public boolean sumFlag;

	//Flag that a piece has been visited by the ST operation
	public boolean ST;


	public boolean intersect;

	//Flag that a piece is an obstacle
	public boolean obstacle;

		//Default values
		public ChessPiece()
		{
			t = 9;
			visited = false;
			sumFlag = false;
			ST = false;
			intersect = false;
			obstacle= false;
		}	
	
		//Setters and getters for respective variables
		public void setT(int someT)
		{
			t = someT;
		}
		public int getT()
		{
			return t;
		}
		public void setVisit(boolean someVisit)
		{
			visited = someVisit;
		}
		public boolean getVisit()
		{
			return visited;
		}
		public void setSumVisit(boolean someVisit)
		{
			sumFlag = someVisit;
		}
		public boolean getSumVisit()
		{
			return sumFlag;
		}
		public void setST(boolean someST)
		{
			ST = someST;
		}
		public boolean getST()
		{
			return ST;
		}

		public void setIntersect(boolean someIntersect)
		{
			intersect = someIntersect;
		}
		public boolean getIntersect()
		{
			return intersect;
		}
		public void setObstacle(boolean someObstacle)
		{
			obstacle = someObstacle;
		}
		public boolean getObstacle()
		{
			return obstacle;
		}
	
}
