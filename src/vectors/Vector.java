package vectors;

/**
 * @author David Cosby
 *
 */
public class Vector {
	private double x;
	private double y;
	
	public Vector() {
		x = 0.0;
		y = 0.0;
	}
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public void setX(double newX) {
		x = newX;
	}

	public void setY(double newY) {
		y = newY;
	}
	
	public void set(double newX, double newY) {
		x = newX;
		y = newY;
	}
	
	/**
	 * @param secondVector Vector to add
	 * @return new Vector: (x+secondVector.x, y+secondVector.y)
	 */
	public Vector add(Vector secondVector) {
		return new Vector(x + secondVector.getX(), y + secondVector.getY());
	}
	
	/**
	 * @param deltaX double to be added to the x component
	 * @param deltaY double to be added to the y component
	 * @return new Vector: (x+deltaX, y+deltaY)
	 */
	public Vector add(double deltaX, double deltaY) {
		return new Vector(x + deltaX, y + deltaY);
	}
	
	/**
	 * @param secondVector Vector to subtract
	 * @return new Vector: (x-secondVector.x, y-secondVector.y)
	 */
	public Vector sub(Vector secondVector) {
		return new Vector(x - secondVector.getX(), y - secondVector.getY());
	}
	
	/**
	 * @param deltaX double to be subtracted from the x component
	 * @param deltaY double to be subtracted from the y component
	 * @return new Vector: (x-deltaX, y-deltaY)
	 */
	public Vector sub(double deltaX, double deltaY) {
		return new Vector(x - deltaX, y - deltaY);
	}
	
	
	/**
	 * @param secondVector Vector to be multiplied
	 * @return new Vector: (x*secondVector.x, y*secondVector.y)
	 */
	public Vector mul(Vector secondVector) {
		return new Vector(x * secondVector.getX(), y * secondVector.getY());
	}
	
	/**
	 * @param xMultiplier double x is multiplied by
	 * @param yMultiplier double y is multiplied by
	 * @return new Vector: (x*xMultiplier, y*yMultiplier)
	 */
	public Vector mul(double xMultiplier, double yMultiplier) {
		return new Vector(x * xMultiplier, y * yMultiplier);
	}
	
	/**
	 * @param multiplier double x and y is multiplied by
	 * @return new Vector: (x*multiplier, y*multiplier)
	 */
	public Vector mul(double multiplier) {
		return new Vector(x * multiplier, y * multiplier);
	}

	/**
	 * @param secondVector Vector to be divided
	 * @return new Vector: (x/secondVector.x, y/secondVector.y)
	 */
	public Vector div(Vector secondVector) {
		return new Vector(x * secondVector.getX(), y * secondVector.getY());
	}
	
	/**
	 * @param xMultiplier double x is multiplied by
	 * @param yMultiplier double y is multiplied by
	 * @return new Vector: (x/xMultiplier, y/yMultiplier)
	 */
	public Vector div(double xMultiplier, double yMultiplier) {
		return new Vector(x / xMultiplier, y / yMultiplier);
	}
	
	/**
	 * @param multiplier double x and y is multiplied by
	 * @return new Vector: (x/multiplier, y/multiplier)
	 */
	public Vector div(double multiplier) {
		return new Vector(x / multiplier, y / multiplier);
	}	
	
	
	/**
	 * @return length of the vector
	 */
	public double magnitude() {
		return Math.hypot(x, y);
	}
	
	/**
	 * Note: if the magnitude of the vector is zero, returns (0, 0)
	 * @return new Vector where Vector.magnitude() == 0
	 */
	public Vector unit() {
		double magnitude = magnitude();
		
		if (magnitude == 0) 
			return new Vector(0, 0);
		else
			return new Vector(x / magnitude(), y / magnitude());
	}

	/**
	 * @see java.lang.Object#toString()
	 * Follows format: Vector [x=?, y=?]
	 */
	@Override
	public String toString() {
		return "Vector [x=" + x + ", y=" + y + "]";
	}
	
}
