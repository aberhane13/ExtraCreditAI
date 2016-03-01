import java.util.*;

public class driver {
	
	//Mapping function
	public static void Mapping(ChessPiece[][] c, int initialX, int initialY, boolean obstacle, String piece)
	{
		int myT = 0;
		int tempX=0;
		int tempY=0;
		int visited = 0;
		c[initialX][initialY].setT(0);
		c[initialX][initialY].setVisit(true);
		
		if(!piece.equals("pawn"))
		{
			for(int x1=0; x1<c.length; ++x1 )
			{
				for(int x2=0; x2<c[0].length; ++x2)
				{
					if(c[x1][x2].getVisit() == true)
					{
					
						myT = c[x1][x2].getT();
						for(int y1=0; y1<c.length; ++y1)
						{
							for(int y2=0; y2<c[0].length; ++y2)
								{
								
								//Reachability for king
								if(piece.equals("king"))
								{
									if( ((Math.abs(x1 - y1) == 1 && Math.abs(x2 - y2) == 0)||
											(Math.abs(x1 - y1) == 0 && Math.abs(x2 - y2) == 1)||
											(Math.abs(x1 - y1) == 1 && (Math.abs(x2 - y2) == 1))))
									{
										if(c[y1][y2].getT() > (myT+1) && c[y1][y2].getVisit() == true)
										{
											c[y1][y2].setT(myT+1);
										}
										if(c[y1][y2].getVisit() == false)
										{
											c[y1][y2].setT(myT + 1);
											c[y1][y2].setVisit(true);
											visited++;
										}

									}
									
								}
								
								//Reachability for rook
								if(piece.equals("rook"))
								{
									if( x1 == y1 || x2 == y2)
									{	
										if(c[y1][y2].getT() > (myT+1) && c[y1][y2].getVisit() == true)
										{
											c[y1][y2].setT(myT+1);
										}
										if(c[y1][y2].getVisit() == false)
										{
											c[y1][y2].setT(myT + 1);
											c[y1][y2].setVisit(true);
											visited++;
										}
									}
								}
								
								//Reachability for bishop
								if(piece.equals("bishop"))
								{

									if( ( ((y2 - x2) == (y1 - x1)) || ((x2-y2) == (x1-y1)) 
											|| ((x2-y2)==(y1-x1))|| ((x1-y1) == (y2-x2)))) 
									{	
										if(c[y1][y2].getT() > (myT+1) && c[y1][y2].getVisit() == true)
										{
											c[y1][y2].setT(myT+1);
										}
										if(c[y1][y2].getVisit() == false)
										{
											c[y1][y2].setT(myT + 1);
											c[y1][y2].setVisit(true);
											visited++;
											
										}
									}
								}
								
								//Reachability for queen
								if(piece.equals("queen"))
								{

									if( (( ((y2 - x2) == (y1 - x1)) || ((x2-y2) == (x1-y1)) 
											|| ((x2-y2)==(y1-x1))|| ((x1-y1) == (y2-x2))))
											|| (x1 == y1 || x2 == y2)) 
									{	
										if(c[y1][y2].getT() > (myT+1) && c[y1][y2].getVisit() == true)
										{
											c[y1][y2].setT(myT+1);
										}
										if(c[y1][y2].getVisit() == false)
										{
											c[y1][y2].setT(myT + 1);
											c[y1][y2].setVisit(true);
											visited++;
											
										}
									}
								}
								
								//Reachability for knight
								if(piece.equals("knight"))
								{
									if((((y1-x1 == 1) || (x1-y1) == 1) && (((y2-x2 == 2) || (x2-y2 == 2)))) || 
											(((y1-x1 == 2) || (x1 -y1 == 2))  && ((y2-x2 == 1) || (x2-y2 ==1))))
									{
										if(c[y1][y2].getT() > (myT+1) && c[y1][y2].getVisit() == true)
										{
											c[y1][y2].setT(myT+1);
										}
										if(c[y1][y2].getVisit() == false)
										{
											c[y1][y2].setT(myT + 1);
											c[y1][y2].setVisit(true);
											visited++;
											
											
										}
									}
								}
								
								//Reachability for special piece
								if(piece.equals("special"))
								{
									if(((Math.abs(x1 - y1) == 2 && Math.abs(x2 - y2) == 0)||
											(Math.abs(x1 - y1) == 0 && Math.abs(x2 - y2) == 2)||
											(Math.abs(x1 - y1) == 2 && (Math.abs(x2 - y2) == 2))))
									{
										if(c[y1][y2].getT() > (myT+1) && c[y1][y2].getVisit() == true)
										{
											c[y1][y2].setT(myT+1);
										}
										if(c[y1][y2].getVisit() == false)
										{
											c[y1][y2].setT(myT + 1);
											c[y1][y2].setVisit(true);
											visited++;
											
											
										}
									}
								}
								}

							
					}
					myT++;
					
					
				}
				
				//Restart mapping if all respective pieces aren't accounted for
				if(x1 == (c.length -1) && x2 == (c[0].length -1))
				{
						if(tempX < c.length && tempY< c[0].length)
						{
							x1 = tempX;
							x2 = tempY;
						
							tempX++;
							tempY++;
						
						}
					
					if(tempX == (c.length-1) && tempY == (c[0].length-1))
					{
						if(piece.equals("king") || piece.equals("rook") || piece.equals("queen") || piece.equals("knight"))
						{
				
							if(visited < (c.length * c[0].length) - 1)
							{
								tempX = 0;
								tempY = 0;
							}
							
						}
						if(piece.equals("bishop"))
						{
							
							if((visited < ((c.length * c[0].length) /2) - 1) )
							{
								tempX = 0;
								tempY = 0;
							}
						}
						if(piece.equals("special"))
						{
							
							if((visited < ((c.length * c[0].length) /4) - 1) )
							{
								tempX = 0;
								tempY = 0;
							}
						}
						
					}

				}
			}

			
		}
		}
		//Reachability for pawn
		if(piece.equals("pawn"))
		{
				if(initialY < (c[0].length/2))
				{
					for(int x2 = initialY+1; x2<c[0].length; ++x2)
					{
						c[initialX][x2].setT(c[initialX][x2-1].getT() + 1);
						c[initialX][x2].setVisit(true);
					}
				}
				else
				{
					int tempT = c[initialX][initialY].getT();
					for(int x2=initialY; x2 >= 0; --x2)
					{
						c[initialX][x2].setT(tempT);
						c[initialX][x2].setVisit(true);
						tempT++;
					}
				}
		}


	}
	
	//Draw the board
	public static void Draw(int DIMENSIONX, int DIMENSIONY, boolean obstacle)
	{
		StdDraw.setXscale(0, DIMENSIONX);
		StdDraw.setYscale(0, DIMENSIONY);
		
		for(int x1=0; x1<8; x1++)
		{
			for(int x2=0; x2<8; x2++)
			{
				if((x1+x2) % 2 == 0)
				{
					StdDraw.setPenColor(StdDraw.BLACK);
				}
				else
				{
					StdDraw.setPenColor(StdDraw.WHITE);
				}
				StdDraw.filledSquare(x1+.5, x2+.5, .5);
			}
		}
		
		//Draw obstacles
		if(obstacle == true)
		{
			StdDraw.setPenColor(StdDraw.GRAY);
			
			StdDraw.filledSquare(1+.5, 2+.5, .5);
			StdDraw.filledSquare(1+.5, 3+.5, .5);
			StdDraw.filledSquare(1+.5, 4+.5, .5);
			StdDraw.filledSquare(3+.5, 1+.5, .5);
			StdDraw.filledSquare(3+.5, 2+.5, .5);
			StdDraw.filledSquare(3+.5, 3+.5, .5);
		}
	
		
	}
	
	//Finding the sum of the trajectories
	public static void Sum(ChessPiece[][] c1, ChessPiece[][] c2, ChessPiece[][] c3, 
			int X1, int X2, int Y1, int Y2, boolean obstacle,
			String piece1, String piece2, int T)
	{
		Mapping(c1, X1, X2, obstacle, piece1);
		Mapping(c2, Y1, Y2, obstacle, piece2);
		if(c1[Y1][Y2].getVisit() == false)
		{
			System.out.println("Error, specific piece cannot reach destination");
		}
		else
		{
		for(int x1=0; x1 < c1.length; x1++)
		{
			for(int x2=0; x2 < c1[0].length; x2++)
			{
				if(c1[x1][x2].getT() + c2[x1][x2].getT() == T)
				{
					
					c3[x1][x2].setSumVisit(true);
					StdDraw.setPenColor(StdDraw.CYAN);
					StdDraw.filledCircle(x1+ .5, x2 + .5, .25);
				}
			}
		}
		}

	}
	
	//Finding ST
	public static void ST(ChessPiece[][] c, int X1, int X2, boolean obstacle,
			String piece, int T0, int T)
	{
		
		Mapping(c, X1, X2, obstacle, piece);
		for(int x1=0; x1 < c.length; x1++)
		{
			for(int x2=0; x2 < c[0].length; x2++)
			{
			
				if(c[x1][x2].getT() == (T0 - T + 1))
				{
					c[x1][x2].setST(true);
				}
			}
			
		}
		
		
	}
	
	//Drawing the shortest trajectories
	public static void Move(ChessPiece[][] c1, ChessPiece[][] c2, ChessPiece[][] c3, ChessPiece[][] c4,
			ChessPiece[][] c5, int X1, int X2, int Y1, int Y2, boolean obstacle,
			String piece1, String piece2, int T)
	{
		ArrayList<Integer> xCoords = new ArrayList<Integer>();
		ArrayList<Integer> yCoords = new ArrayList<Integer>();
		ArrayList<Integer> trajectories = new ArrayList<Integer>();
		
		xCoords.add(X1);
		yCoords.add(X2);
		trajectories.add(T);

		if(!piece1.equals("pawn"))
		{
		Sum(c1, c2, c3, X1, X2, Y1, Y2, obstacle, piece1, piece2, T);
		
		for(int i=0; i<xCoords.size(); ++i){
		
		//ST for the original point
		ST(c4, xCoords.get(0), yCoords.get(0), obstacle, piece1, T, trajectories.get(i));
		
		//ST for the new point
		ST(c5, xCoords.get(i), yCoords.get(i), obstacle, piece1, T, T);
		
		System.out.println("Paths for coordinate: " + xCoords.get(i) + "," + yCoords.get(i) + ". Number of trajectories: " + trajectories.get(i) +": ");
		for(int x1=0; x1 < c3.length; ++x1)
		{
			for(int x2=0; x2 < c3[0].length; ++ x2)
			{

				if(c4[x1][x2].getST() == true && c3[x1][x2].getSumVisit() == true && c5[x1][x2].getST() == true)
				{
					//Draw the paths
					StdDraw.setPenColor(StdDraw.MAGENTA);
					StdDraw.filledCircle(x1 + .5, x2 + .5, .25);
					StdDraw.line(xCoords.get(i) + .5, yCoords.get(i) + .5, x1 + .5, x2 + .5);
					System.out.println(x1 + ", " + x2);
					
					//Store the x and y coordinate of the paths
					xCoords.add(x1);
					yCoords.add(x2);
					
					//Add coordinates to the list of trajectories
					trajectories.add(trajectories.get(i) - 1);

				}

			}
		}
		
		//Flag to restart the coordinates as not visited. This is used to redo the calls to the ST functions
		for(int x1=0; x1 < c3.length; ++x1)
		{
			for(int x2=0; x2 < c3[0].length; ++ x2)
			{
				c4[x1][x2].setVisit(false);
				c4[x1][x2].setT(9);
				c4[x1][x2].setST(false);
				
				c5[x1][x2].setVisit(false);
				c5[x1][x2].setT(9);
				c5[x1][x2].setST(false);
			}
		}

		}
		}
		
		//Shortest trajectories if your piece is a pawn
		else
		{
			if(X1 == Y1)
			{
				if(Math.abs(Y2-X2) == T)
				{
				StdDraw.setPenColor(StdDraw.CYAN);
				StdDraw.filledCircle(X1 + .5, X2 + .5, .25);
				if(X2 < Y2)
				{
					for(int x2 = X2+1; x2 <= Y2; ++x2)
					{
						StdDraw.setPenColor(StdDraw.MAGENTA);
						StdDraw.filledCircle(X1 + .5, x2 + .5, .25);
						StdDraw.line(X1 + .5, x2-1 + .5, X1 + .5, x2 + .5);
						System.out.println(X1 + ", " + x2);
					}
					StdDraw.filledCircle(X1 + .5, Y2 + .5, .25);
				}
				else
				{
					for(int x2 = X2; x2 > Y2; --x2)
					{
						StdDraw.setPenColor(StdDraw.MAGENTA);
						StdDraw.filledCircle(X1 + .5, x2 + .5, .25);
						StdDraw.line(X1 + .5, x2 + .5, X1 + .5, x2-1 + .5);
						System.out.println(X1 + ", " + x2);
					}
					StdDraw.filledCircle(X1 + .5, Y2 + .5, .25);
					System.out.println(X1 + ", " + Y2);
				}
				}
			}
			//Error message for pawn
			else
			{
				System.out.println("Error: specific piece cannot reach this destination");
			}
			
		}
	}
	
	public static void main(String[] args)
	{
		//Dimensions of board
		int DIMENSIONX;
		int DIMENSIONY;
		
		//Initial x and y coordinates
		int initialX;
		int initialY;
		
		//Destination x and y coordinates
		int destinationX;
		int destinationY;
		
		//Trajectory number
		int T;
		
		//Flag to indicate irregular board
		boolean boardFlag;
		
		//Flag to indicate obstacle
		boolean obstacle;
		
	    Scanner input = new Scanner(System.in);

	    
	    //Instructions to the user regarding input
	    System.out.println("Enter first type of piece (for the special piece, type the word special): ");
	    String piece1 = input.nextLine();
	    
	    System.out.println("Enter second type of piece: ");
	    String piece2 = input.nextLine();
	    
	    System.out.println("Irregular 6 X 6 board? (true or false): ");
	    boardFlag = input.nextBoolean();
	    
	    System.out.println("Obstacles? (true or false): ");
	    obstacle = input.nextBoolean();
	    
	    System.out.println("Enter the initial x axis: ");
	    initialX = input.nextInt();
	    
	    System.out.println("Enter the initial y axis: ");
	    initialY = input.nextInt();
	    
	    System.out.println("Enter the destination x axis: ");
	    destinationX = input.nextInt();
	    
	    System.out.println("Enter the destination y axis: ");
	    destinationY = input.nextInt();
	    
	    System.out.println("Enter number of trajectories: ");
	    T = input.nextInt();
	    

	    
		ChessPiece[][] c = new ChessPiece[8][8];
		
		//Set dimensions
		if(boardFlag == true)
		{
			DIMENSIONX = 6;
			DIMENSIONY = 6;
		}
		else
		{
			DIMENSIONX = 8;
			DIMENSIONY = 8;
		}
		
		//Initialize board
	    ChessPiece[][] c1 = new ChessPiece[DIMENSIONX][DIMENSIONY];
	    ChessPiece[][] c2 = new ChessPiece[DIMENSIONX][DIMENSIONY];
	    ChessPiece[][] c3 = new ChessPiece[DIMENSIONX][DIMENSIONY];
	    ChessPiece[][] c4 = new ChessPiece[DIMENSIONX][DIMENSIONY];
	    ChessPiece[][] c5 = new ChessPiece[DIMENSIONX][DIMENSIONY];
		
		for(int x1=0; x1<DIMENSIONX; ++x1)
		{
			for(int x2=0; x2<DIMENSIONY; ++x2)
			{
				c[x1][x2] = new ChessPiece();
				
				c1[x1][x2] = new ChessPiece();
				c2[x1][x2] = new ChessPiece();
				c3[x1][x2] = new ChessPiece();
				c4[x1][x2] = new ChessPiece();
				c5[x1][x2] = new ChessPiece();
			}
		}
		
		//If required, initialize obstacles
		if(obstacle == true)
		{
			c1[1][2].setObstacle(true);
			c1[1][3].setObstacle(true);
			c1[1][4].setObstacle(true);
			c1[3][1].setObstacle(true);
			c1[3][2].setObstacle(true);
			c1[3][3].setObstacle(true);

			c2[1][2].setObstacle(true);
			c2[1][3].setObstacle(true);
			c2[1][4].setObstacle(true);
			c2[3][1].setObstacle(true);
			c2[3][2].setObstacle(true);
			c2[3][3].setObstacle(true);
			
			c3[1][2].setObstacle(true);
			c3[1][3].setObstacle(true);
			c3[1][4].setObstacle(true);
			c3[3][1].setObstacle(true);
			c3[3][2].setObstacle(true);
			c3[3][3].setObstacle(true);
			
			c4[1][2].setObstacle(true);
			c4[1][3].setObstacle(true);
			c4[1][4].setObstacle(true);
			c4[3][1].setObstacle(true);
			c4[3][2].setObstacle(true);
			c4[3][3].setObstacle(true);
			
			c5[1][2].setObstacle(true);
			c5[1][3].setObstacle(true);
			c5[1][4].setObstacle(true);
			c5[3][1].setObstacle(true);
			c5[3][2].setObstacle(true);
			c5[3][3].setObstacle(true);
		}
		
		//Draw board
		Draw(DIMENSIONX, DIMENSIONY, obstacle);
	
		//Shortest path trajectories
	    Move( c1, c2, c3, c4, c5, initialX, initialY, 
	    		destinationX, destinationY, obstacle,
	    		piece1, piece2, T);
	    
		
		
	}
	


}
