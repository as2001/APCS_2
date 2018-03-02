Andrew Shao
APCS2 pd2
HW12 -- __+3R|\/|1|\|4|_  1|_|_|\|3$$__
2018-03-02F


0.	I can kind of see how having multiple classes in one file could be practical.
	I suppose it could make editing multiple very similar subclasses extended from a
	superclass easier in the sense that you wouldn't have to have several separate windows.
	I guess it could also help in testing in the sense that if there were a lot of files
	to compile, you could group them up and it would be more efficient to compile all of them.
	
1.	They are first passed to the main method of Demo where they are checked to be valid inputs.
	Then the first argument is used to initialize an instance of Boardasaurus.
	Both arguments are then used as parameters for invoking the Boardasaurus instance's go method.

2.	The default values, 8 and 500, are used.

3.	The recursion continously marks random positions with the continously increasing move value.
	I think it's necessary to keep the process going.

4.	I expect it to randomly choose positions out of an nxn board and then mark it with the current move number,
	and after every time it does that it increases move number by 1 until the move number exceeds
	the board area.
	
5.	DELAY * (n^2 - n + 1)

6.	ANSI stands for American National Standards Institute. ANSI escape code is a standard for issuing
	commands to video/text terminals. It's good for standardizing common fundamental functions on
	terminals that may or may not be the same.
	
7.	I did not anticipate the border of "-1"s being displayed as well as the board.

8.	I guess you could take out the random selection component of the recursion and replace it with
	a system which systemically chose positions a knight could move too.
	
	
Knight's Tour

1.	Begin at (0, 0) as starting knight position.
2.	Search in a clockwise fashion from the top for positions the knight can move too.
3.	If such a position exists, move the knight to the first position found.
	Else 
		If the knight is still at its starting position, move the knight to a new starting position.
		Else move the knight back to its previous position.
4. Go back to step 2 until solution is found.