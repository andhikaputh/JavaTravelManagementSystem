package com.lgncs.travel;

import java.util.Scanner;

import com.lgncs.missionutil.MissionUtil;

public class TravelTest {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Travel[] travels = {
                new Travel( "TRV001", "Munchen", "German Airways", Travel.INDIVIDUAL, 10),
                new Travel( "TRV002", "Prague", "Air France", Travel.INDIVIDUAL, 20),
                new Travel( "TRV003", "LA", "Delta Airlines", Travel.PACKAGE, 12),
                new Travel( "TRV004", "Osaka", "Korean Air", Travel.INDIVIDUAL, 15),
                new Travel( "TRV005", "Shanghai", "Shouthern Airlines", Travel.PACKAGE, 10)
        };
		int menu = -1;
		while(menu != 9) {
			printMenu();
			menu = MissionUtil.getUserIntegerInput();
			if(menu==1) 
			{
				printHeader();
				for(int i = 0 ; i<travels.length;i++) {
					travels[i].printTravelInfo();
				}
			}
			else if(menu==2) {
				
				for(int i = 0; i<travels.length;i++) {
					if(travels[i].getTravelType() == Travel.INDIVIDUAL ) {
						travels[i].printTravelInfo();
					}
				}
			}
			
			else if(menu==3) {
				
				for(int j = 0; j<travels.length;j++) {
					if(travels[j].getTravelType() == Travel.PACKAGE) {
						travels[j].printTravelInfo();
					}
					
				}
			}
			
			else if(menu==4) {
				System.out.print("Masukkan code travel :");
				String temp = MissionUtil.getCodeInput();
				boolean found = false;
				int index=0;
				for (int i = 0; i < travels.length; i++) {
					if(temp.equals(travels[i].getTravelCode())) {
						found = true;
						index=i;
					}
				}
				if(found) {
					System.out.print("Masukkan jumlah maksimal orang dalam reservasi untuk diubah :");
					int jmlhmax = MissionUtil.getUserIntegerInput();
					if(jmlhmax<0) {
						System.out.println("Tidak boleh minus");
					}else {
						if(jmlhmax < travels[index].getResvPeople()) {
							travels[index].setMaxPeople(travels[index].getResvPeople());
							System.out.println("[Info] Dikarenakan jumlah reservasi yang sudah ada, maka jumlah maksimal orang akan disesuaikan dengan jumlah reservasi saat ini");
							System.out.println("Jumlah maksimal reservasi diubah menjadi"+ travels[index].getResvPeople());
						}else {
							travels[index].setMaxPeople(jmlhmax);
							System.out.println("Jumlah maksimum orang dalam reservasi sudah diubah menjadi "+jmlhmax +" orang");
						}
					}
				}else {
					System.out.println("[Error] Tidak ditemukan paket yang cocok dengan code travel "+ temp);
				}
			}
			
			else if(menu==5) {
				System.out.print("Masukkan code travel :");
				String temp = MissionUtil.getCodeInput();
				boolean found = false;
				int index=0;
				for (int i = 0; i < travels.length; i++) {
					if(temp.equals(travels[i].getTravelCode())) {
						found = true;
						index=i;
					}
					
				}
				if(found) {
					System.out.print("Masukkan jumlah reservasi orang untuk diubah :");
					int jmlhmax = MissionUtil.getUserIntegerInput();
					if(jmlhmax < 0) {
						System.out.println("Tidak boleh minus");
					}else {
						if(jmlhmax>travels[index].getMaxPeople()) {
							System.out.println("[Error] Angka yang dimasukkan tidak boleh lebih besar dari jumlah maksimal reservasi "+travels[index].getMaxPeople()+" orang");
						}else {
							travels[index].setResvPeople(jmlhmax);
							System.out.println("Jumlah maksimum orang dalam reservasi sudah diubah menjadi "+jmlhmax);
						}
					}
				}
			}
			else if(menu==9) {
				System.out.println(">>Keluar !!");
				break;
			}
			else {
				System.out.println("Silahkan masukkan ulang");
			}
		}
	}
	public static void printMenu() {
        System.out.println( "========== < Menu > ==========" );
        System.out.println( " 1. Lihat semua paket perjalanan" );
        System.out.println( " 2. Pencarian paket individu" );
        System.out.println( " 3. Pencarian paket perjalanan" );
        System.out.println( " 4. Perubahan jumlah maksimal peserta" );
        System.out.println( " 5. Perubahan jumlah peserta dalam reservasi" );
        System.out.println( " 9. End" );
        System.out.println( "==============================" );
        System.out.print( "Pilih Menu : " );
    }
    public static void printHeader() {
        printSeperator();
        System.out.printf("%-12s %-15s %-20s %-10s %-20s %-20s\n",
                "Kode Travel", "Nama Kota", "Airline", "Jenis Paket",
                "Jumlah Peserta Max", "Jml Peserta Saat Ini");
        printSeperator();
    }
    public static void printSeperator() {
        System.out.println( "===============================" );
    }
}


