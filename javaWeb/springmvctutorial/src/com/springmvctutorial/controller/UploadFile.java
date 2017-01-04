package com.springmvctutorial.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/")
public class UploadFile {
	@RequestMapping(value = "upload-file-no-ajax", method = RequestMethod.POST)
	@ResponseBody
	public String uploadFile(@RequestParam("myfile") MultipartFile file,
			@RequestParam("myFileName") String fileName) {
		StringBuilder rs = new StringBuilder();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();//

				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + File.separator
						+ "FILE_UPLOAD");
				if (!dir.exists()) {
					dir.mkdirs();
				}

				// Create the file on server

				File fileToSave = new File(dir.getAbsolutePath()
						+ File.separator + fileName);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(fileToSave));
				stream.write(bytes);
				stream.close();

				rs.append("the file ").append(fileName)
						.append(" uploaded into").append(dir.getAbsolutePath())
						.append(" Successfully");

			} catch (Exception e) {
				rs.append("Error: ").append(e.getMessage());

			}
		} else {
			rs.append("The file").append(fileName).append("Was failed");
		}
		return rs.toString();
	}

	@RequestMapping(value = "upload-file-with-ajax", method = RequestMethod.POST)
	@ResponseBody
	public String uploadFileAjax(MultipartHttpServletRequest request) {
		String fileName = request.getParameter("fileName");
		MultipartFile multiFile = request.getFile("file");
		StringBuilder rs = new StringBuilder();
		try {
			String rootPath = System.getProperty("catalina.home");
			File dir = new File(rootPath + File.separator + "webapps"
					+ File.separator + "FILE_UPLOAD");
			if (!dir.exists()) {
				dir.mkdir();
			}

			File file = new File(dir.getAbsolutePath()
					+ System.getProperty("file.separator") + fileName);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(file));

			byte[] bytes = multiFile.getBytes();
			stream.write(bytes);
			stream.close();

			rs.append("The file ").append(fileName).append("uploaded into")
					.append(dir.getAbsolutePath()).append("successully");
		} catch (Exception e) {
			rs.append("Error: ").append(e.getMessage());

		}
		return rs.toString();
	}

}
