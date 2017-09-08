package com.itzixi.common.utils;

//import org.csource.common.NameValuePair;
//import org.csource.fastdfs.ClientGlobal;
//import org.csource.fastdfs.StorageClient1;
//import org.csource.fastdfs.StorageServer;
//import org.csource.fastdfs.TrackerClient;
//import org.csource.fastdfs.TrackerServer;

public class FastDFSClient {

	/*private TrackerClient trackerClient = null;
	private TrackerServer trackerServer = null;
	private StorageServer storageServer= null;
	private StorageClient1 storageClient= null;
	
	public FastDFSClient(String config) throws Exception {
		if (config.contains("classpath:")) {
			config = config.replace("classpath:", this.getClass().getResource("/").getPath());
		}
		ClientGlobal.init(config);
		
		trackerClient = new TrackerClient();
		trackerServer = trackerClient.getConnection();
		storageServer = null;
		storageClient = new StorageClient1(trackerServer, storageServer);
	}

	*//**
	 * 
	 * @Description: 上传文件
	 * @param fileName	文件全路径名
	 * @param extName	文库扩展名，不包含(.)
	 * @param matas		文件扩展信息
	 * @return
	 * @throws Exception
	 * 
	 * @author leechenxiang
	 * @date 2016年4月19日 下午2:39:52
	 *//*
	public String uploadFile(String fileName, String extName, NameValuePair[] matas) throws Exception {
		String result = storageClient.upload_file1(fileName, extName, matas);
		return result;
	}
	
	public String uploadFile(String fileName) throws Exception {
		String result = uploadFile(fileName, null, null);
		return result;
	}
	
	public String uploadFile(String fileName, String extName) throws Exception {
		String result = uploadFile(fileName, extName, null);
		return result;
	}
	
	*//**
	 * 
	 * @Description: 上传文件
	 * @param fileContent	文件内容，字节数组
	 * @param extName		文库扩展名，不包含(.)
	 * @param matas			文件扩展信息
	 * @return
	 * @throws Exception
	 * 
	 * @author leechenxiang
	 * @date 2016年4月19日 下午2:43:05
	 *//*
	public String uploadFile(byte[] fileContent, String extName, NameValuePair[] matas) throws Exception {
		String result = storageClient.upload_file1(fileContent, extName, matas);
		return result;
	}
	
	public String uploadFile(byte[] fileContent) throws Exception {
		String result = uploadFile(fileContent, null, null);
		return result;
	}
	
	public String uploadFile(byte[] fileContent, String extName) throws Exception {
		String result = uploadFile(fileContent, extName, null);
		return result;
	}*/
}
