package com;

import java.io.File;
import java.util.Scanner;

public class SubMenu {
	
	static String fileFolder;
	static File ff;

	public static void SubMenuOptions() {
		fileFolder = System.getProperty("user.dir");
	    ff = new File(fileFolder+"/LockedMeFileFolder");
        System.out.println("Please choose one from the business level operations below");
        System.out.println("1) Add a user specified file to the application");
        System.out.println("2) Delete a user specified file from the application");
        System.out.println("3) Search a user specified file from the application");
        System.out.println("4) Return to Main Menu");
        Scanner sc = new Scanner(System.in);
        try {
			int input = sc.nextInt();
			switch (input) {
				case 1:{
					System.out.println("Please enter the file name:");
					String fileName = sc.next();				
					String newPath = ff.getPath()+"\\"+fileName;				
					ff = new File(newPath);
					if(ff.exists()) {
						System.out.println("File with same name already exists");
					}else {
						ff.createNewFile();
						System.out.println("New file created named as "+fileName);
					}	
					SubMenuOptions();
					}
				case 2:{
					System.out.println("Please enter the file name():");
					String fileName = sc.next();				
					String newPath = ff.getPath()+"\\"+fileName;	
						ff = new File(newPath);
					if(ff.exists()) {
						ff.delete();
						System.out.println("file deleted successfully");
					}else {
						System.out.println("file not present with name as "+fileName);
						}
					SubMenuOptions();
					}
				case 3:{
					System.out.println("Please enter name of the file to search for:");
					String fileName = sc.next();
					String newPath = ff.getPath()+"\\"+fileName;
						ff = new File(newPath);
					if(ff.exists()) {
						System.out.println("File: "+fileName+" is present.");
					}else {
						System.out.println("File: "+fileName+" was not found.");
					}
					SubMenuOptions();
					}
				case 4:
					MainMenu.MainMenuOptions();
				default:
					SubMenuOptions();
								}
			} catch (Exception e) {
				System.out.println("Wrong input, please type number of desired option.");
				SubMenuOptions();
		}
	}
}