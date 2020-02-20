package unitConversion;

/**
 * Unit conversion rates following the metric system. <br>
 * Follows format : UNIT1_TO_UNIT2 = rate <br>
 * where UNIT2 = UNIT1 * rate
 * @author David Cosby
 */
public final class Rates {
	/**
	 * g/cm^3 -> kg/km^3
	 */
	public static final double G_OVER_CM3_TO_KG_OVER_KM3 = 1.0E+12;
	/**
	 * kg/km^3 -> g/cm^3
	 */
	public static final double KG_OVER_KM3_TO_G_OVER_CM3 = 1.0E-12;

}
