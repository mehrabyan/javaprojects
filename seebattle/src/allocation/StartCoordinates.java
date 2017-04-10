package allocation;

import java.util.Random;

public class StartCoordinates {
	Random rd1 = new Random();
	
	protected	int[] statrCoordinateFor4(int dir) {
		int[] start = {0,0};
		int[] x = {1, 3, 4, 5, 6, 8};
		int[] y = {1, 3, 5};
		switch (dir) {
		case 0:
			start[0] = x[rd1.nextInt(x.length)];
			start[1] = y[rd1.nextInt(y.length)];
			break;
		case 1:
			start[0] = y[rd1.nextInt(y.length)];
			start[1] = x[rd1.nextInt(x.length)];
			break;
		}
		return start;
     }

	protected	int[] statrCoordinateFor3(int dir) {
		int[] start = {0,0};
		int[] x = {1, 3, 4, 5, 6, 8};
		int[] y = {1, 3, 4, 6};
		switch (dir) {
		case 0:
			start[0] = x[rd1.nextInt(x.length)];
			start[1] = y[rd1.nextInt(y.length)];
			break;
		case 1:
			start[0] = y[rd1.nextInt(y.length)];
			start[1] = x[rd1.nextInt(x.length)];
			break;
		}
		return start;
     }
	
	protected	int[] statrCoordinateFor2(int dir) {
		int[] start = {0,0};
		int[] x = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] y = {1, 2, 3, 4, 5, 6, 7};
		switch (dir) {
		case 0:
			start[0] = x[rd1.nextInt(x.length)];
			start[1] = y[rd1.nextInt(y.length)];
			break;
		case 1:
			start[0] = y[rd1.nextInt(y.length)];
			start[1] = x[rd1.nextInt(x.length)];
			break;
		}
		return start;
     }
}