package com.hdc.util;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FileUtil {
	private static String seperator = System.getProperty("file.separator");
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat(
			"yyyyMMddHHmmss"); // 时间格式化的格式
	private static final Random r = new Random();

	public static String getBasePath(HttpServletRequest request, Integer collegeId, Integer teacherId) {
		String basePath = request.getServletContext().getRealPath("/upload/declarationFile/"+collegeId+"/"+teacherId)+"/";
		basePath = basePath.replace("/", seperator);
		return basePath;
	}

	public static String getBasePath(HttpServletRequest request) {
		String basePath = request.getServletContext().getRealPath("/");
		basePath = basePath.replace("/", seperator);
		return basePath;
	}

	public static String getBaseURl(Integer collegeId, Integer teacherId) {
		String baseURL = "/upload/declarationFile/"+collegeId+"/"+teacherId+"/";
		return baseURL;
	}


	public static String getRandomFileName() {
		// 随机文件名：时间+五位随机数（防止重名）
		int rannum = (int) (r.nextDouble() * (99999 - 10000 + 1)) + 10000; // 获取随机数
		String nowTimeStr = sDateFormat.format(new Date()); // 当前时间
		return nowTimeStr + rannum;
	}

	
}
