package topovi;

import java.util.ArrayList;
import java.util.List;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.ActionsFunction;

public class TopoviActionsFunction implements ActionsFunction {

	@Override
	public List<Action> actions(Object s) {
		TopoviState state = (TopoviState) s;
		List<Action> lista = new ArrayList<Action>();
		int[][] tabla = state.getBoard();
		for (int i = 0 ; i < 8; i++) {
			for (int j = 0 ; j < 8; j++) {
				
				if (tabla[i][j] == 1) {
					if (j > 0 && tabla[i][j-1] == 0) {
						lista.add(new TopoviAction(i, j, i, j-1));
					}
					if (j < 7 && tabla[i][j+1] == 0) {
						lista.add(new TopoviAction(i, j, i, j+1));
					}
					if (i < 0 && tabla[i-1][j] == 0) {
						lista.add(new TopoviAction(i, j, i-1, j));
					}
					if (i < 7 && tabla[i+1][j] == 0) {
						lista.add(new TopoviAction(i, j, i+1, j));
					}
				}
			}
		}
		return lista;
	}

}
