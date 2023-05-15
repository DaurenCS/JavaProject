package utilPackage;

import java.util.HashMap;
import java.util.Vector;

import userPackage.CanBeAdded;
import userPackage.Mark;

/**
 * @generated
 */
public class RequestToAdd extends Request {

	private static final long serialVersionUID = 1L;
	/**
	 * @generated
	 */
	private CanBeAdded whatToAdd;
	private HashMap whereToAdd;
	private String name;

	public RequestToAdd(CanBeAdded wta, HashMap where, String name) {
		this.whatToAdd = wta;
		this.whereToAdd = where;
		this.name = name;
	}

	/**
	 * @generated
	 */
	public CanBeAdded getWhatToAdd() {
		return this.whatToAdd;
	}

	/**
	 * @generated
	 */
	public void setWhatToAdd(CanBeAdded whatToAdd) {
		this.whatToAdd = whatToAdd;
	}
	/**
	 * Special method to complete request
	 */
	public void complete() {
		if (!whereToAdd.containsKey(whatToAdd))
			whereToAdd.put(whatToAdd, new Mark());
	}

	public String toString() {
		return name + " 𝕨𝕒𝕟𝕥❜𝕤 𝕥𝕠 𝕓𝕖 𝕒𝕕𝕕𝕖𝕕 𝕥𝕠 " + whatToAdd;
	}

	// Operations
	public boolean equals(Object o) {
		if (super.equals(o) == false) {
			return false;
		}
		RequestToAdd rta = (RequestToAdd) o;
		return this.getWhatToAdd().equals(rta.getWhatToAdd()) && this.name == rta.name;
	}

}
