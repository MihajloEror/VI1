package topovi;

import dmi.vi1.search.framework.GoalTest;

public class TopoviGoalTest implements GoalTest {

	@Override
	public boolean isGoalState(Object state) {
		TopoviState ts = (TopoviState) state;
		for(int row = 0; row < 8; row++) {
			int sumRow = 0;
			for (int column=0; column<8; column++) {
				sumRow += ts.getBoard()[row][column];
			}
			if (sumRow > 1)
				return false;
		}
		for(int column = 0; column < 8; column++) {
			int sumCol = 0;
			for (int row=0; row<8; row++) {
				sumCol += ts.getBoard()[row][column];
			}
			if (sumCol > 1)
				return false;
		}
		return true;
	}

}
