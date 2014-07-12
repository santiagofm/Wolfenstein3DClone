package com.base.engine;

public class Material 
{
	private Texture texture;
	private Vector3f color;
	private float specularIntensity;  //intensity of reflection
	private float specularPower; //how wide reflection is
	
	public Material(Texture texture)
	{
		this(texture, new Vector3f(1.f, 1.f, 1.f));
	}
	
	public Material(Texture texture, Vector3f color)
	{
		this(texture, color, 2.f, 32.f);
	}
	
	public Material(Texture texture, Vector3f color, float specularIntensity, float specularPower)
	{
		this.color = color;
		this.texture = texture;
		this.specularIntensity = specularIntensity;
		this.specularPower = specularPower;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Vector3f getColor() {
		return color;
	}

	public void setColor(Vector3f color) {
		this.color = color;
	}

	public float getSpecularIntensity() {
		return specularIntensity;
	}

	public void setSpecularIntensity(float specularIntensity) {
		this.specularIntensity = specularIntensity;
	}

	public float getSpecularPower() {
		return specularPower;
	}

	public void setspecularPower(float specularPower) {
		this.specularPower = specularPower;
	}
}
