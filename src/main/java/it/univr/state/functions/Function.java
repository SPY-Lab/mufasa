package it.univr.state.functions;

import java.util.HashMap;
import java.util.Vector;

import org.antlr.v4.runtime.misc.Pair;

import it.univr.domain.AbstractDomain;
import it.univr.domain.AbstractValue;
import it.univr.main.MuJsParser;
import it.univr.main.MuJsParser.StmtContext;
import it.univr.state.Variable;

public class Function {

	private Variable name; 
	private Vector<Variable> formalParameters;
	private MuJsParser.StmtContext body;
	public HashMap<KCallStrings, Pair<ActualParameters, AbstractValue>> envs;
	private AbstractDomain domain;
	
	public Function(Variable name, Vector<Variable> formalParameters, StmtContext bod, AbstractDomain domain) {
		this.name = name;
		this.formalParameters = formalParameters;
		this.body = bod;
		this.domain = domain;
		this.envs = new HashMap<KCallStrings, Pair<ActualParameters,AbstractValue>>();
	}

	public Vector<Variable> getFormalParameters() {
		return formalParameters;
	}

	public void setFormalParameters(Vector<Variable> formalParameters) {
		this.formalParameters = formalParameters;
	}

	public MuJsParser.StmtContext getBody() {
		return body;
	}

	public void setBody(MuJsParser.StmtContext body) {
		this.body = body;
	}

	public Variable getFunctionName() {
		return name;
	}

	public void setId(Variable name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String result = "function " + name + "(";

		for (Variable v : formalParameters)
			result += v + ",";


		result = result.substring(0, result.length() - 1) + ") " + body.getText();
		return result;
	}

	public ActualParameters getActualParametersAtCallString(KCallStrings cs) {
		return envs.get(cs).a;
	}

	public AbstractValue getReturnValueAtCallString(KCallStrings cs) {
		return envs.get(cs).b;
	}

	public void addReturnValueAtCallString(KCallStrings cs, ActualParameters pars, AbstractValue ret) {
		if (hasCallString(cs)) {
			AbstractValue oldRet = envs.get(cs).b;
			envs.remove(cs);
			envs.put(cs, new Pair<ActualParameters, AbstractValue>(pars, domain.leastUpperBound(oldRet,ret)));
		} else {
			envs.put(cs, new Pair<ActualParameters, AbstractValue>(pars, ret));
		}
	}

	public void addReturnValueAtCallString(KCallStrings cs, AbstractValue ret) {
		if (hasCallString(cs)) {
			AbstractValue oldRet = envs.get(cs).b;
			ActualParameters oldPars = envs.get(cs).a;
			envs.remove(cs);
			envs.put(cs, new Pair<ActualParameters, AbstractValue>(oldPars, domain.leastUpperBound(oldRet,ret)));
		} else {
			envs.put(cs, new Pair<ActualParameters, AbstractValue>(new ActualParameters(), ret));
		}
	}

	
	public boolean hasCallString(KCallStrings cs) {
		return envs.keySet().contains(cs);
	}
}
