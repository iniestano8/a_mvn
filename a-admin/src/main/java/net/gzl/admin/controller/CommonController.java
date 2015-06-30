package net.gzl.admin.controller;

import javax.servlet.http.HttpServletRequest;

import net.gzl.admin.util.UploadUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/common")
public class CommonController {

	@ResponseBody
	@RequestMapping(value = "/uploadImg", method = { RequestMethod.POST })
	public String upload(HttpServletRequest request) throws Exception {

		request.setCharacterEncoding("utf-8");
		UploadUtil up = new UploadUtil(request);
		up.setSavePath("upload");
		String[] fileType = { ".gif", ".png", ".jpg", ".jpeg", ".bmp" };
		up.setAllowFiles(fileType);
		up.setMaxSize(10000); // 单位KB
		up.upload();
		String callback = request.getParameter("callback");
		String result = "{\"name\":\"" + up.getFileName()
				+ "\", \"originalName\": \"" + up.getOriginalName()
				+ "\", \"size\": " + up.getSize() + ", \"state\": \""
				+ up.getState() + "\", \"type\": \"" + up.getType()
				+ "\", \"url\": \"" + up.getUrl() + "\"}";
		result = result.replaceAll("\\\\", "\\\\");
		if (callback == null) {
		} else {
			result = "<script>" + callback + "(" + result + ")</script>";
		}
		return result;
	}

}
