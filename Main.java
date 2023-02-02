package topovi;

import java.util.List;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.GraphSearch;
import dmi.vi1.search.framework.Problem;
import dmi.vi1.search.uninformed.BreadthFirstSearch;

public class Main {

	public static void main(String[] args) throws Exception {
		TopoviState state = new TopoviState(new int[][] {
			{ 0, 0, 0, 0, 0, 0, 0, 0},
			{ 0, 0, 0, 1, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0, 0, 0},
			{ 0, 1, 0, 1, 0, 0, 1, 0},
			{ 0, 0, 0, 0, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0, 0, 0}
		});
		Problem p = new Problem(state, new TopoviActionsFunction(), new TopoviResultFunction(), new TopoviGoalTest(), new TopoviStepCostFunction());
		BreadthFirstSearch bfs = new BreadthFirstSearch(new GraphSearch());
		
		List<Action> actions = bfs.search(p);
		for (Action a:actions) {
			System.out.println(a);
		}
	}
}
