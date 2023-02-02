package kripto;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.ResultFunction;

public class KriptoResultFunction implements ResultFunction {

	@Override
	public Object result(Object s, Action a) {
		KriptoState state = (KriptoState) s;
		KriptoAction action = (KriptoAction) a;
		
		int kripto = state.getKripto();
		int bal = state.getBal();
		if(action.getAkcija().equals("kupi")) {
			bal -= state.getCenaZaDan(state.getDan());
			kripto += 1;
		} else if (action.getAkcija().equals("prodaj")) {
			bal += state.getCenaZaDan(state.getDan());
			kripto -= 1;
		}
		
		KriptoState newState = new KriptoState(kripto, bal, state.getDan()+1);
		return newState;
	}

}
