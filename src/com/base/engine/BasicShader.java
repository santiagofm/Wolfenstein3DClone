package com.base.engine;

public class BasicShader extends Shader
{
	private static final BasicShader instance = new BasicShader();
	
	public static BasicShader getInstance()
	{
		return instance;
	}
	
	public BasicShader()
	{
		super(); //call shader constructor
		
		addVertexShaderFromFile("basicShader.vs");
		addFragmentShaderFromFile("basicShader.fs");
		
		compileShader();
		
		addUniform("transform");
		addUniform("color");
	}
	
	public void updateUniforms(Matrix4f worldMatrix, Matrix4f projectedMatrix, Material material)
	{
		if(material.getTexture() != null)
		{
			material.getTexture().bind();
		}
		else
		{
			RenderUtil.unBindTextures();
		}
		
		setUniform("transform", projectedMatrix);
		setUniform("color", material.getColor());
	}
}
