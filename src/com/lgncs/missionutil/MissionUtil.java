package com.lgncs.missionutil;

import java.util.Scanner;

public class MissionUtil {

	public static int getUserIntegerInput() {
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}
	
	public static double getUserDoubleInput() {
		Scanner s = new Scanner(System.in);
		return s.nextDouble();
	}
	
	public static String getCodeInput() {
		Scanner s = new Scanner(System.in);
		return s.next();
	}
}
