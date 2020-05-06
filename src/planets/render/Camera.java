package planets.render;

import vector.Vector;

/**
 * In charge of transferring coordinates from metric space to screen space.
 * @author David Cosby
 */
public class Camera {
	/**
	 * Coordinates at which the center of the camera will be aimed. (kilometers, kilometers)
	 */
	private Vector position = new Vector();
	/**
	 * Camera center will be offset by this amount. (kilometers, kilometers)
	 */
	private Vector offset = new Vector();
	/**
	 * Zoom factor. (pixels/kilometers)
	 */
	private double pixelsPerKilometer = 0.1;
	
	
	public Camera() {
		
	}
	
	public Camera(Vector position) {
		setPosition(position);
	}
	
	public Vector getPosition() {
		return position;
	}
	
	public void setPosition(Vector newPosition) {
		position.set(newPosition.getX(), newPosition.getY());
	}
	
	public Vector getOffset() { 
		return offset;
	}
	
	public void setOffset(Vector newOffset) { 
		offset.set(newOffset.getX(), newOffset.getY());
	}
	
	public double getZoom() {
		return pixelsPerKilometer;
	}
	
	public void setZoom(double newPixelsPerKilometer) {
		pixelsPerKilometer = newPixelsPerKilometer;
	}
	
	/**
	 * @param location (kilometers, kilometers) vector that we want to map to screen space
	 * @return delta - location's coordinates on the screen (pixels, pixels), measured as distance from the center of the screen
	 */
	public Vector getScreenDisplacementFromCenter(Vector location) {
		Vector delta = location.sub(position.add(offset));
		delta = delta.mul(pixelsPerKilometer);
		return delta;
	}
	
	/**
	 * @param kilometerLength (kilometers)
	 * @return pixelLength - kilometerLength cast to screen space using the zoom factor
	 */
	public double getScreenPixelLength(double kilometerLength) {
		return kilometerLength * pixelsPerKilometer;
	}
	
	/**
	 * @param pixelDisplacement (pixels, pixels)
	 * @return kilometerVector - pixelDisplacement cast to kilometer-scale vector using the zoom factor
	 */
	public Vector getVectorDisplacementFromPixelDisplacement(Vector pixelDisplacement) {
		return pixelDisplacement.div(pixelsPerKilometer);
	}
	
	/**
	 * @param pixelLength (pixels)
	 * @return VectorLength - PixelLength cast to kilometers using the zoom factor
	 */
	public double getVectorLengthFromPixelLength(double pixelLength) {
		return pixelLength / pixelsPerKilometer;
	}
	
}
