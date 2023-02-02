package topovi;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.ResultFunction;

public class TopoviResultFunction implements ResultFunction {

	@Override
	public Object result(Object s, Action a) {
		TopoviAction ta = (TopoviAction) a;
		TopoviState ts = (TopoviState) s;
		
		TopoviState newState = ts.clone();
		newState.getBoard()[ta.getFromRow()][ta.getFromCol()] = 0;
		newState.getBoard()[ta.getToRow()][ta.getToCol()] = 1;
		return newState;
	}

}
