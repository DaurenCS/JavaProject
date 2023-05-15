package utilPackage;

public enum DayType {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

	public static int inNum(DayType dt) {
		if (dt == DayType.MONDAY)
			return 1;
		if (dt == DayType.TUESDAY)
			return 2;
		if (dt == DayType.WEDNESDAY)
			return 3;
		if (dt == DayType.THURSDAY)
			return 4;
		if (dt == DayType.FRIDAY)
			return 5;
		if (dt == DayType.SATURDAY)
			return 6;
		return 0;
	}
}