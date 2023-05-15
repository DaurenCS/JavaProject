package utilPackage;

import java.util.HashMap;
import java.util.Vector;

import userPackage.CanBeAdded;
import userPackage.Mark;

/**
 * @generated
 */
public class RequestToChange extends Request {

	private static final long serialVersionUID = 1L;
	/**
	 * @generated
	 */
	private CanBeAdded oldThing;
	private CanBeAdded newThing;
	private HashMap whereToAdd;
	private String name;

	public RequestToChange(CanBeAdded oldT, CanBeAdded newT, HashMap where, String name) {
		this.oldThing = oldT;
		this.newThing = newT;
		this.whereToAdd = where;
		this.name = name;
	}

	/**
	 * @generated
	 */
	public CanBeAdded getOld() {
		return this.oldThing;
	}

	/**
	 * @generated
	 */
	public void setOld(CanBeAdded old) {
		this.oldThing = old;
	}

	public CanBeAdded getNew() {
		return this.newThing;
	}

	/**
	 * @generated
	 */
	public void setNew(CanBeAdded newT) {
		this.newThing = newT;
	}

	public void complete() {
		if (!whereToAdd.containsKey(oldThing))
			whereToAdd.remove(oldThing, new Mark());
		whereToAdd.put(newThing, new Mark());
	}

	public String toString() {
		return name + " 𝕨𝕒𝕟𝕥❜𝕤 𝕥𝕠 𝕓𝕖 removed from " + oldThing + " and added to " + newThing;
	}

	// Operations

	public boolean equals(Object o) {
		if (super.equals(o) == false) {
			return false;
		}
		RequestToChange rtc = (RequestToChange) o;
		return this.getOld().equals(rtc.getOld()) && this.getNew().equals(rtc.getNew()) && this.name == rtc.name;
	}
}
