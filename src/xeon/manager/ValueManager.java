package xeon.manager;

import java.util.ArrayList;

import xeon.value.Type;
import xeon.value.Value;

public class ValueManager {
	private ArrayList<Value> values = new ArrayList<Value>();
	
	public ValueManager() {
		this.values.add(new Value(Type.prefixCmd, "xeon."));
	}
	
	public ArrayList<Value> getValues() {
		return values;
	}
}
