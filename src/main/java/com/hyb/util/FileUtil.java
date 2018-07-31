package com.hyb.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Li yi
 * @date 2017年8月11日
 */
public class FileUtil {

	private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

	/**
	 * @param fileName
	 * @return 有扩展名返回扩展名，没有的话返回空字符串
	 *
	 * @author Liyi
	 * @date 2017年8月15日
	 */
	public static String getFileExtension(String fileName) {
		int index = fileName.lastIndexOf(".");
		if (index == -1) {
			return "";
		} else {
			return fileName.substring(index + 1).toLowerCase();
		}
	}

	public static String getFileNameFromPath(String filePath, String pathSeparator) {
		int index = filePath.lastIndexOf(pathSeparator);
		if (index == -1) {
			return "";
		} else {
			return filePath.substring(index + 1);
		}
	}

	public static void clearDir(String path) {
		File file = new File(path);
		LOG.info("清理:{}", path);
		if (!file.exists() || !file.isDirectory()) {
			LOG.error("清空文件夹路径不合法：{}", path);
			return;
		}

		for (File one : file.listFiles()) {
			if (one.isDirectory()) {
				clearDir(one.getAbsolutePath());
			}
			if (!one.delete()) {
				LOG.error("删除失败:{}", one.getAbsolutePath());
			}
		}
	}

	public static boolean isFileExist(String path) {
		File file = new File(path);
		return file.exists() && file.isFile();
	}

	public static boolean isFolderExist(String path) {
		File file = new File(path);
		return file.exists() && file.isDirectory();
	}

	public static void copyFolder(String source, String target, boolean isSkipError) throws IOException {
		LOG.info("copy from {} to {}", source, target);
		File sourceFolder = new File(source);
		copyFolder(sourceFolder, target, isSkipError);
	}

	public static void copyFolder(File sourceFolder, String target, boolean isSkipError) throws IOException {
		LOG.info("copy from {} to {}", sourceFolder.getAbsolutePath(), target);
		File[] subFiles = sourceFolder.listFiles();
		File targetFolder = new File(target);
		createDir(targetFolder);
		for (File one : subFiles) {
			if (one.isFile()) {
				try {
					copyFile(one, targetFolder + File.separator + one.getName());
				} catch (IOException e) {
					if (!isSkipError) {
						throw e;
					} else {
						LOG.error(e.getMessage(), e);
					}
				} // 调用文件拷贝的方法
			} else if (one.isDirectory()) {
				copyFolder(one.getPath(), targetFolder + File.separator + one.getName(), isSkipError);
			}
		}
	}

	public static void copyFile(File fromFile, File toFile) throws IOException {
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileInputStream = new FileInputStream(fromFile);
			fileOutputStream = new FileOutputStream(toFile);
			byte[] temp = new byte[1024];
			int count = 0;
			while ((count = fileInputStream.read(temp)) != -1) {
				fileOutputStream.write(temp, 0, count);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			closeResources(fileInputStream, fileOutputStream);
		}
	}

	public static void copyFile(File fromFile, String targetFilePath) throws IOException {
		File targetFile = new File(targetFilePath);
		copyFile(fromFile, targetFile);
	}

	public static void copyFile(String sourcePath, String targetFilePath) throws IOException {
		File sourceFile = new File(sourcePath);
		File targetFile = new File(targetFilePath);
		LOG.info("copy from {} to {}", sourcePath, targetFile);
		copyFile(sourceFile, targetFile);
	}

	public static boolean createDir(File file) {
		if (!file.exists() || !file.isDirectory()) {
			return file.mkdirs();
		} else {
			return true;
		}
	}

	public static void closeResources(Closeable... resources) {
		for (Closeable one : resources) {
			if (one != null) {
				try {
					one.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
