package it.univr.state;

/**
 * Variable class
 * @author  * @author <a href="vincenzo.arceri@univr.it">Vincenzo Arceri</a>
 *
 */
public class Variable {
	
	private boolean isLocal;
	
	/**
	 * Name Variable
	 */
	private String name;
	
	/**
	 * Variable constructor
	 * @param name name of the variable
	 */
	public Variable(String name) {
		this.name = name;
	}

	/**
	 * Get name of the variable
	 * @return name of the variable
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set name of the variable
	 * @param name name of the variable
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Variable)
			return name.equals(((Variable) other).getName());
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
