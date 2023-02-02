package kripto;

import java.util.List;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.Problem;
import dmi.vi1.search.framework.TreeSearch;
import dmi.vi1.search.uninformed.BreadthFirstSearch;

public class Main {

	public static void main(String[] args) throws Exception {
		KriptoState pocetnoStanje = new KriptoState(1, 10, 1);
		KriptoResultFunction rf = new KriptoResultFunction();
		Problem p = new Problem(
				pocetnoStanje, new KriptoActionsFunction(), rf,
				new KriptoGoalTest(), new KriptoStepCostFunction());
		BreadthFirstSearch bfs = new BreadthFirstSearch(new TreeSearch());
		List<Action> actions = bfs.search(p);
		
		KriptoState temp = pocetnoStanje;
		System.out.println(temp);
		
		for (Action a: actions) {
			System.out.println(a);
		}
		
	}
}
