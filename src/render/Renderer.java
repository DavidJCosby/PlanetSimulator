package render;

import render.renderObjects.*;
import bridge.Bridge;


public class Renderer {
	private RenderObjectContainer renderObjectContainer = new RenderObjectContainer();

	public Renderer() {

	}
	
	public RenderObjectContainer getRenderObjectContainer() {
		return renderObjectContainer;
	}
	
}
