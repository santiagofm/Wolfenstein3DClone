package com.base.engine;

public class DirectionalLight
{
	private BaseLight base;
	private Vector3f direction;
	
	public DirectionalLight(BaseLight base, Vector3f direction)
	{
		this.setBase(base);
		this.setDirection(direction.normalize());
	}

	public BaseLight getBase() {
		return base;
	}

	public void setBase(BaseLight base) {
		this.base = base;
	}

	public Vector3f getDirection() {
		return direction;
	}

	public void setDirection(Vector3f direction) {
		this.direction = direction;
	}
}
