public class DynamicProgramming {
	public String sequence1;
	public String sequence2;
	
	public static final int MATCH = 1;
	public static final int MISMATCH = -1;
	public static final int GAP = -2;
	
	public Cell[][] matrix;
	public String[] alignments;	

	public DynamicProgramming(String sequence1, String sequence2) {
		this.sequence1 = sequence1;
		this.sequence2 = sequence2;
		this.matrix = new Cell[sequence2.length() + 1][sequence1.length() + 1];
		
		initialize();
		fillIn();
		traceback();
	}

	private void initialize() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = new Cell(i, j);
			}
		}
		//initializeScores
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j].value = getInitialScore(i, j);
			}
		}
		//initializePointers
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j].prevCell = getInitialPointer(i, j);
			}
		}
	}

	private Cell getInitialPointer(int row, int col) {
		if (row == 0 && col != 0) {
			return matrix[row][col - 1];
		} else if (col == 0 && row != 0) {
			return matrix[row - 1][col];
		} else {
			return null;
		}
	}

	private int getInitialScore(int row, int col) {
		if (row == 0 && col != 0) {
			return col * GAP;
		} else if (col == 0 && row != 0) {
			return row * GAP;
		} else {
			return 0;
		}
	}
	
	private void fillIn() {
		for (int row = 1; row < matrix.length; row++) {
			for (int col = 1; col < matrix[row].length; col++) {
				Cell currentCell = matrix[row][col];
				Cell cellAbove = matrix[row - 1][col];
				Cell cellToLeft = matrix[row][col - 1];
				Cell cellAboveLeft = matrix[row - 1][col - 1];
				fillInCell(currentCell, cellAbove, cellToLeft, cellAboveLeft);
			}
		}
	}

	private void fillInCell(Cell currentCell, Cell cellAbove, Cell cellToLeft, Cell cellAboveLeft) {
		int rowSpaceScore = cellAbove.value + GAP;
		int colSpaceScore = cellToLeft.value + GAP;
		int matchOrMismatchScore = cellAboveLeft.value;
		if (sequence2.charAt(currentCell.row - 1) == sequence1.charAt(currentCell.col - 1)) {
			matchOrMismatchScore += MATCH;
		} else {
			matchOrMismatchScore += MISMATCH;
		}
		if (rowSpaceScore >= colSpaceScore) {
			if (matchOrMismatchScore >= rowSpaceScore) {
				currentCell.value = matchOrMismatchScore;
				currentCell.prevCell = cellAboveLeft;
			} else {
				currentCell.value = rowSpaceScore;
				currentCell.prevCell = cellAbove;
			}
		} else {
			if (matchOrMismatchScore >= colSpaceScore) {
				currentCell.value = matchOrMismatchScore;
				currentCell.prevCell = cellAboveLeft;
			} else {
				currentCell.value = colSpaceScore;
				currentCell.prevCell = cellToLeft;
			}
		}
	}

	private void traceback() {
		StringBuffer align1Buf = new StringBuffer();
		StringBuffer align2Buf = new StringBuffer();
		Cell currentCell = matrix[matrix.length - 1][matrix[0].length - 1];
		while (currentCell.prevCell != null) {
			if (currentCell.row - currentCell.prevCell.row == 1) {
				align2Buf.insert(0, sequence2.charAt(currentCell.row - 1));
			} else {
				align2Buf.insert(0, ' ');
			}
			if (currentCell.col - currentCell.prevCell.col == 1) {
				align1Buf.insert(0, sequence1.charAt(currentCell.col - 1));
			} else {
				align1Buf.insert(0, ' ');
			}
			currentCell = currentCell.prevCell;
		}

		alignments = new String[] { align1Buf.toString(), align2Buf.toString() };
	}

	private void printScoreTable() {
		for (int i = 0; i < sequence2.length() + 2; i++) {
			for (int j = 0; j < sequence1.length() + 2; j++) {
				if (i == 0) {
					if (j == 0 || j == 1) {
						System.out.print("  ");
					} else {
						if (j == 2) {
							System.out.print("     ");
						} else {
							System.out.print("   ");
						}
						System.out.print(sequence1.charAt(j - 2));
					}
				} else if (j == 0) {
					if (i == 1) {
						System.out.print("  ");
					} else {
						System.out.print(" " + sequence2.charAt(i - 2));
					}
				} else {
					String toPrint = " ";
					Cell currentCell = matrix[i - 1][j - 1];						
					int score = currentCell.value;
					String s = String.format("%1$3d", score);
					toPrint += s;
					System.out.print(toPrint);
				}

				System.out.print(' ');
			}
			System.out.println();
		}
	}
	
	public String alignmentScore() {		
		for (String string : alignments) {
			System.out.println(string);
		}

		int score = 0;
		String rep = "";
		for (int i = 0; i < alignments[0].length(); i++) {
			char c1 = alignments[0].charAt(i);
			char c2 = alignments[1].charAt(i);
			if (c1 == ' ' || c2 == ' ') {
				score += GAP;
				rep += '*';
			} else if (c1 == c2) {
				score += MATCH;
				rep += '+';
			} else {
				score += MISMATCH;
				rep += '-';
			}
		}

		return rep+" ("+score+")";
	}
	
	public static void main(String[] args) {
		DynamicProgramming dpr = new DynamicProgramming("CAATGTGAATC", "GATCGGCAT");
		dpr.printScoreTable();
		System.out.println(dpr.alignmentScore());
	}
}
