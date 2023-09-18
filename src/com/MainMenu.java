package com;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class MainMenu {
	
	static String fileFolder;
	static File ff;

	public static void MainMenuOptions() {
		fileFolder = System.getProperty("user.dir");
	    ff = new File(fileFolder+"/LockedMeFileFolder");
		if (!ff.exists())
        	ff.mkdirs();
		System.out.println("Select from the following by typing coresponding number");
		System.out.println("1) Display all files in ascending order");
		System.out.println("2) Add, Delete or Search for specific file");
		System.out.println("3) Quit program");
		Scanner sc = new Scanner(System.in);
			try {
				int input = sc.nextInt();
				switch (input) {
					case 1:{
						String listOfFiles[] = ff.list();
						Arrays.sort(listOfFiles);
						for(String name:listOfFiles) 
						System.out.println(name);				
						if (listOfFiles == null || listOfFiles.length == 0)
			            System.out.println("Folder is empty.");
						MainMenuOptions();
					}
					case 2:{
						SubMenu.SubMenuOptions();
					}
					case 3:{
						System.out.println("Goodbye");
						System.exit(0);
					}
					default:
						MainMenuOptions();
				}
			}
			catch (Exception e) {
				System.out.println("Wrong input, please type number of desired option.");
				MainMenuOptions();
			}
	}
}