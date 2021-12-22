package com.consulting.action;

import java.io.File;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.consulting.common.FileUploadUtil;

public class StrutsFileUploadAction extends BaseAction {

    private File upload;// The actual file

    private String uploadContentType; // The content type of the file

    private String uploadFileName; // The uploaded file name  
    
    private String fileCaption;// The caption of the file entered by user

    private String targetFolder;

    private static Properties properties = FileUploadUtil.FILE_UPLOAD_UTIL_PROPS;

    private String currentItemPreFix;

    private String assetId;

    public String getFileCaption() {
	return fileCaption;
    }

    public void setFileCaption(String fileCaption) {
	this.fileCaption = fileCaption;
    }

    public File getUpload() {
	return upload;
    }

    public void setUpload(File upload) {
	this.upload = upload;
    }

    public String getUploadContentType() {
	return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
	this.uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
	return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
	this.uploadFileName = uploadFileName;
    }

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

    public String getTargetFolder() {
	return targetFolder;
    }

    public void setTargetFolder(String targetFolder) {
	this.targetFolder = targetFolder;
    }

   
    public String add() {
	 
	return null;
    }

   
    public String delete() {
	 
	return null;
    }

    
    public String edit() {
	 
	return null;
    }

    
    public String execute() {

	try {
	   
	   
	    
	    if(uploadContentType.equals("application/octet-stream"))
	    {
		addActionError(getText("error.conentTypeExe"));
		
		return INPUT;
	    }
	    
		 
		targetFolder = ServletActionContext.getServletContext().getRealPath("/");
		targetFolder = targetFolder
			+ properties.getProperty("struts.multipart.saveDir");
		 
		
		
		if (targetFolder == null)
		    targetFolder = "C:\\temp";
		// Adding prefix with file name
		StringBuffer fileNameToSave = new StringBuffer("");
		// fileNameToSave.append(assetId).append("_").append(getCurrentItemPreFix()).append("_").append(uploadFileName);
		Long systime = System.currentTimeMillis();
		System.out.println("extention"+uploadFileName);
		uploadFileName = systime + "_" + uploadFileName.replaceAll("[^a-zA-Z0-9._]", "");;
		fileNameToSave.append(uploadFileName);
		// String fullFileName =
                // targetFolder+File.separator+uploadFileName;
		String fullFileName = targetFolder + File.separator
			+ fileNameToSave.toString();

		File theFile = new File(fullFileName);
		System.out.println("upload"+upload);
		
		FileUtils.copyFile(upload, theFile);
              
              
	} catch (Exception e)
	{
		 
        e.printStackTrace();
	    addActionError(e.getMessage());
	    
           log.equals("Error in uploading files"+e);     
	    return INPUT;
	}

	return SUCCESS;

    }

    
    public String save() {
	 
	return null;
    }

  
    public String search() {
	 
	return null;
    }

   
    public String update() {
	 
	return null;
    }

    public void setRequest(Map arg0) {
	 

    }

    

}