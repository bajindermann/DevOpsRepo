package com.consulting.action;

import java.util.Map;


public class StrutsShowUploadAction extends BaseAction{

	
	private String currentItemPreFix;
	private String assetId;
	
	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getCurrentItemPreFix() {
		return currentItemPreFix;
	}

	public void setCurrentItemPreFix(String currentItemPreFix) {
		this.currentItemPreFix = currentItemPreFix;
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute() {
		System.out.println("StructShowUploadAction");
		
		return SUCCESS;
	}

	@Override
	public String save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String search() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRequest(Map arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
