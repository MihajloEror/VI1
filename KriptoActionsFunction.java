package kripto;

import java.util.ArrayList;
import java.util.List;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.ActionsFunction;

public class KriptoActionsFunction implements ActionsFunction {

	@Override
	public List<Action> actions(Object s) {
		List<Action> lista = new ArrayList<Action>();
		KriptoState state = (KriptoState) s;
		
		if (state.getBal() > state.getCenaZaDan(state.getDan())) {
			lista.add(new KriptoAction("kupi"));
		}
		if (state.getKripto() > 0) {
			lista.add(new KriptoAction("prodaj"));	
		}
		lista.add(new KriptoAction("cekaj"));
		return lista;
	}

}
