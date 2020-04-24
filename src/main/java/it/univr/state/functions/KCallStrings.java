package it.univr.state.functions;

import java.util.Vector;

public class KCallStrings extends Vector<CallString> {


	public KCallStrings(CallString cs) {
		super();
		add(cs);
	}
	
	public KCallStrings() {
		super();
	}

	@Override
	public String toString() {
		String res = "";

		for (int i = 0; i < size(); i++)
			res += get(i).toString();
		return res;
	}

	@Override
	public boolean equals(Object other) {
		return super.equals(other);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public KCallStrings clone() {
		KCallStrings result = new KCallStrings();

		for (int i = 0; i < size(); i++)
			result.add(get(i).clone());
		return result;
	}
}
