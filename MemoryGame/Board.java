import java.util.Random;

class Board {
	private int[] board;
	private int n = 0;
	private int[] numbers;
	private String dash = "-";
	private Random rndNumber = new Random();
	// private int[] seed = {2,1,0,0,1,2};

	// constructor
	public Board(int n) {
		this.n = n;

		numbers = new int[2 * n];
		for (int i = 0; i < n; i++) {
			numbers[i] = i;
			numbers[i + n] = i;
		}

		board = new int[2 * n];
		for (int i = 0; i < 2 * n; i++) {
			int randomNumber = rndNumber.nextInt(2 * n);
			if (numbers[randomNumber] >= 0) {
				board[i] = numbers[randomNumber];
				numbers[randomNumber] = -1;
			} else {
				i -= 1;
			}
			// board[i] = seed[i];
		}
	}

	// print
	public void print() {
		System.out.print("\n");
		for (int j = 0; j < 2 * n; j++) {
			System.out.printf("%3d ", j);
		}
		System.out.print("\n" + dash.repeat(8 * n) + "\n");
		for (int i = 0; i < 2 * n; i++) {
			if (board[i] >= 0) {
				System.out.printf("%3s ", "*");
			} else {
				System.out.printf("%3s ", " ");
			}
		}
	}

	private void delay(int sec) {
		try {
			Thread.currentThread().sleep(1000 * sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// flash
	public void flash(int a, int b) {
		System.out.print("\n");
		for (int x = 0; x < 2 * n; x++) {
			System.out.printf("%3d ", x);
		}
		System.out.print("\n" + dash.repeat(8 * n) + "\n");
		int intSwap = 0;
		if (a > b) {
			intSwap = a;
			a = b;
			b = intSwap;
		}
		for (int i = 0; i < a; i++) {
			if (board[i] >= 0) {
				System.out.printf("%3s ", "*");
			} else {
				System.out.printf("%3s ", " ");
			}
		}
		System.out.printf("%3d", board[a]);
		for (int j = a + 1; j < b; j++) {
			if (board[j] >= 0) {
				System.out.printf("%3s ", "*");
			} else {
				System.out.printf("%3s ", " ");
			}
		}
		System.out.printf("%3d", board[b]);
		if (b < 2 * n - 1) {
			for (int z = b + 1; z < 2 * n; z++) {
				if (board[z] >= 0) {
					System.out.printf("%3s ", "*");
				} else {
					System.out.printf("%3s ", " ");
				}
			}
		}

		delay(3);
		System.out.print("\r");
		for (int i = 0; i < 2 * n; i++) {
			if (board[i] >= 0) {
				System.out.printf("%3s ", "*");
			} else {
				System.out.printf("%3s ", " ");
			}
		}
	}

	// openPositions
	public boolean openPositions(int a, int b) {
		if (board[a] == board[b]) {
			System.out.print("\n");
			System.out.println("Found pair " + "(" + board[a] + "," + board[a] + ")");
			board[a] = -1;
			board[b] = -1;
			print();
			return true;
		} else {
			flash(a, b);
			return false;
		}
	}

	// getRandomPosition
	public int getRandomPosition() {
		int randomPosition = rndNumber.nextInt(2 * n);
		while (board[randomPosition] < 0) {
			randomPosition = rndNumber.nextInt(2 * n);
		}
		return randomPosition;
	}

	// getRandomPositionOverloaded
	public int getRandomPosition(int e) {
		int randomPosition = rndNumber.nextInt(2 * n);
		while (board[randomPosition] < 0 || randomPosition == e) {
			randomPosition = rndNumber.nextInt(2 * n);
		}
		return randomPosition;
	}

	// containsCard
	public boolean containsCard(int c) {
		if (board[c] >= 0) {
			return true;
		} else {
			return false;
		}
	}

	// getCard
	public int getCard(int d) {
		return board[d];
	}

	// allPairsFound
	public boolean allPairsFound() {
		int sum = 0;
		for (int i = 0; i < 2 * n; i++) {
			sum += board[i];
		}
		if (sum == -2 * n) {
			return true;
		} else {
			return false;
		}
	}
}
