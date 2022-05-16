package com.java.prep.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Design an in-memory file system to simulate the following functions:
 * 
 * ls: Given a path in string format. If it is a file path, return a list that
 * only contains this file's name. If it is a directory path, return the list of
 * file and directory names in this directory. Your output (file and directory
 * names together) should in lexicographic order.
 * 
 * mkdir: Given a directory path that does not exist, you should make a new
 * directory according to the path. If the middle directories in the path don't
 * exist either, you should create them as well. This function has void return
 * type.
 * 
 * addContentToFile: Given a file path and file content in string format. If the
 * file doesn't exist, you need to create that file containing given content. If
 * the file already exists, you need to append given content to original
 * content. This function has void return type.
 * 
 * readContentFromFile: Given a file path, return its content in string format.
 * 
 * Example: Input:
 * ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
 * [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
 * 
 * Output: [null,[],null,null,["a"],"hello"]
 * 
 * Explanation: filesystem
 * 
 * Note: You can assume all file or directory paths are absolute paths which
 * begin with / and do not end with / except that the path is just "/".
 * 
 * You can assume that all operations will be passed valid parameters and users
 * will not attempt to retrieve file content or list a directory or file that
 * does not exist.
 * 
 * You can assume that all directory names and file names only contain
 * lower-case letters, and same names won't exist in the same directory.
 */
public class FileSystem {

	private static final String ROOT_DIR = "/";
	private Map<String, List<Item>> directoryMap;

	public FileSystem() {
		directoryMap = new HashMap<>();
		directoryMap.put(ROOT_DIR, new ArrayList<>());
	}

	public List<String> ls(String path) {
		return directoryMap.getOrDefault(path, new ArrayList<>()).stream().map(item -> item.name)
				.collect(Collectors.toList());
	}

	public void mkdir(String path) {
		String directoryPath = path.charAt(path.length() - 1) == '/' ? path : path + "/";
		if (checkIfPathExists(directoryPath)) {
			return;
		}
		createdDirectoryHierarchy(path);
		System.out.println(directoryMap);
	}

	/**
	 * This method creates directory hierarchy provided.
	 */
	private void createdDirectoryHierarchy(String path) {
		String directories[] = path.split("/");
		String parentDirectory = ROOT_DIR;
		for (String directory : directories) {
			if ("".equals(directory)) {
				continue;
			}
			String currentDirectory = appendDirectory(parentDirectory, directory);
			if (!checkIfPathExists(currentDirectory)) {
				createDirectory(parentDirectory, currentDirectory);
			}
			parentDirectory = currentDirectory;
		}
	}

	/**
	 * This method creates the directory hierarchy name by appending to the parent
	 * directory.
	 */
	private String appendDirectory(String parentDirectory, String directory) {
		return new StringBuilder(parentDirectory).append(directory).append("/").toString();
	}

	/**
	 * This method creates the file path hierarchy name by appending to the parent
	 * directory.
	 */
	private String appendFileName(String parentDirectory, String fileName) {
		return new StringBuilder(parentDirectory).append(fileName).toString();
	}

	/**
	 * This method creates the directory and adds it to the file system.
	 */
	private void createDirectory(String parentDirectory, String currentDirectory) {
		List<Item> directoryItems = directoryMap.getOrDefault(parentDirectory, new ArrayList<>());
		directoryItems.add(new Item(currentDirectory, "", ItemType.DIRECTORY));
		directoryItems.sort(new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		directoryMap.put(parentDirectory, directoryItems);
		directoryMap.put(currentDirectory, new ArrayList<>());
	}

	/**
	 * This method creates the directory and adds it to the file system.
	 */
	private void createFile(String parentDirectory, String filePath, String content) {
		List<Item> directoryItems = directoryMap.getOrDefault(parentDirectory, new ArrayList<>());
		directoryItems.add(new Item(filePath, content, ItemType.FILE));
		directoryMap.put(parentDirectory, directoryItems);
		directoryMap.put(filePath, new ArrayList<>());
	}

	public void addContentToFile(String filePath, String content) {
		if (checkIfPathExists(filePath) && checkIfFile(filePath)) {
			updateFileContent(filePath, content);
		} else {
			addFileToFileSystem(filePath, content);
		}
	}

	private void addFileToFileSystem(String filePath, String content) {
		String directories[] = filePath.split("/");
		String parentDirectory = ROOT_DIR;
		for (int i = 1; i < directories.length - 1; i++) {
			String currentDirectory = appendDirectory(parentDirectory, directories[i]);
			if (!checkIfPathExists(currentDirectory)) {
				createDirectory(parentDirectory, currentDirectory);
			}
			parentDirectory = currentDirectory;
		}
		createFile(parentDirectory, appendFileName(parentDirectory, directories[directories.length - 1]), content);
	}

	/**
	 * This method updates the file content.
	 */
	private void updateFileContent(String filePath, String content) {
		directoryMap.get(filePath).get(0).setContent(content);
	}

	/**
	 * This method reads the content from the file provided in file path.
	 */
	public String readContentFromFile(String filePath) {
		if (checkIfPathExists(filePath) && checkIfFile(filePath)) {
			return directoryMap.get(filePath).get(0).content;
		}
		return null;
	}

	/**
	 * This method checks if path exists in the file system or not.
	 */
	private boolean checkIfPathExists(String filePath) {
		return directoryMap.containsKey(filePath);
	}

	/**
	 * This method checks if file path given is a file or not.
	 */
	private boolean checkIfFile(String filePath) {
		return directoryMap.get(filePath).size() == 1 && directoryMap.get(filePath).get(0).itemType == ItemType.FILE;
	}

	public static void main(String[] args) {
		FileSystem f = new FileSystem();
		System.out.println(f.ls("/"));
		f.mkdir("/a/b/c");
		f.mkdir("/c/b/e");
		System.out.println(f.ls("/"));
		System.out.println(f.ls("/c/"));
		f.addContentToFile("/a/b/c/d", "Hi This is a file with name d");
		f.addContentToFile("/a/b/e/d", "Hi This is a file with name d on path e");
		f.mkdir("/a/b/e/d");
		f.mkdir("/a/b/e/c");
		f.mkdir("/a/b/e/f");
		System.out.println(f.ls("/a/b/e/"));
		System.out.println(f.ls("/a/b/c/"));
		f.addContentToFile("/a/b/c/d", "Hi This is a file with name d and it is modified");
	}

}

class Item {
	String name;
	String content;
	ItemType itemType;

	public Item(String name, String content, ItemType itemType) {
		this.name = name;
		this.itemType = itemType;
		if (itemType.equals(ItemType.FILE)) {
			this.content = content;
		}
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ItemType getItemType() {
		return itemType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((itemType == null) ? 0 : itemType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (itemType != other.itemType)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

enum ItemType {
	FILE, DIRECTORY
}