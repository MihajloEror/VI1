package kripto;

import dmi.vi1.search.framework.GoalTest;

public class KriptoGoalTest implements GoalTest {

	@Override
	public boolean isGoalState(Object state) {
		KriptoState s = (KriptoState) state;
		return s.getBal() >= 35 && s.getDan() == 10;
	}

}
