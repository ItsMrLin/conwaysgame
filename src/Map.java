import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Map {

	private Cell[][] map;
	private int size = 10;
	private int totalSteps = 0;

	public Map(int initSize) {
		size = initSize;
		map = new Cell[size + 2][size + 2];
		for (int i = 0; i < size + 2; i++)
			for (int j = 0; j < size + 2; j++)
				map[i][j] = new Cell();
	}

	public Map(String[] input) {
		size = input.length;
		map = new Cell[size + 2][size + 2];
		for (int i = 0; i < size + 2; i++) {
			for (int j = 0; j < size + 2; j++)
				if (!(i > 0 && i <= size && j > 0 && j <= size))
					map[i][j] = new Cell();
				else if (input[i - 1].charAt(j - 1) == '*')
					map[i][j] = new Cell(true);
				else
					map[i][j] = new Cell();
		}
	}

	public Map() {
		this(10);
	}

	public void setCellState(int x, int y, boolean newState) {
		if (x > 0 && x <= size && y > 0 && y <= size)
			map[x][y].setState(newState);
	}

	public boolean getCellState(int x, int y) {
		return map[x][y].getState();
	}

	public int countNeighbours(int x, int y) {
		if (x > 0 && x <= size && y > 0 && y <= size) {
			int count = 0;
			for (int i = -1; i <= 1; i++)
				for (int j = -1; j <= 1; j++)
					if (!(i == 0 && j == 0) && map[x + i][y + j].getState())
						count++;
			return count;
		} else
			return -1;
	}

	// return number of total steps;
	public int step() {
		totalSteps++;
		Cell[][] temp = new Cell[size + 2][size + 2];
		for (int i = 0; i < size + 2; i++) {
			for (int j = 0; j < size + 2; j++)
				if (!(i > 0 && i <= size && j > 0 && j <= size))
					temp[i][j] = new Cell();
				else {
					int neighbourNumber = countNeighbours(i, j);
					switch (neighbourNumber) {
					case 3:
						temp[i][j] = new Cell(true);
						break;
					case 2:
						temp[i][j] = new Cell(getCellState(i, j));
						break;
					default:
						temp[i][j] = new Cell(false);
						break;
					}
				}
		}
		map = temp;
		return totalSteps;
	}
	
	public int getSteps(){
		return totalSteps;
	}

	public String toString() {
		String ret = "";
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++)
				if (map[i][j].getState())
					ret += "*";
				else
					ret += "0";
			ret += "\n";
		}
		return ret;
	}
}
