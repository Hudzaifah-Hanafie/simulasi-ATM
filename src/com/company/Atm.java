package com.company;

import java.util.Scanner;

public class Atm {

    Scanner inputan = new Scanner(System.in);
    Cekpin cp = new Cekpin();
    int saldo = 10000000;
    int[] rek = {18250, 18248, 18255, 18276, 18231};
    int j=1;

    public static void main(String[] args) {
        Atm obj = new Atm();
        obj.masuk();
    }

    public void masuk() {
        int x = 0;
        int pinAtm;
        cp.setPin(1812345);
        while (x < 3) {
            System.out.printf("Masukkan Pin : ");
            pinAtm = inputan.nextInt();
            if (cp.getPin() == pinAtm) {
                System.out.println("Berhasil");
                menu();
            } else {
                System.out.println("Pin yang dimasukkan salah");
            }
            x++;
        }
        System.out.println("ATM Terblokir");
    }

    public void menu() {
        int pl;
        System.out.println("Pilih Transaksi yang Diinginkan : ");
        System.out.println("1. Info Saldo");
        System.out.println("2. Penarikan Tunai");
        System.out.println("3. Transfer");
        System.out.println("4. Exit");
        System.out.printf("Pilihan : ");
        pl = inputan.nextInt();
        System.out.println("");
        switch (pl) {
            case 1:
                menusaldo();
                break;
            case 2:
                penarikan();
                break;
            case 3:
                transfer();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public void menusaldo() {
        int p;
        System.out.println("Sisa saldo anda : " + saldo);
        System.out.println("Lanjut Transaksi ? :");
        System.out.println("1. YA");
        System.out.println("2. TIDAK");
        System.out.printf("Pilihan : ");
        p = inputan.nextInt();
        System.out.println("");
        switch (p) {
            case 1:
                menu();
                break;
            case 2:
                System.exit(0);
                break;
        }
    }

    public void penarikan() {
        int jumlah;
        int pil;
        int putusan;
        System.out.printf("Masukkan Jumlah Penarikan Tunai : ");
        jumlah = inputan.nextInt();
        System.out.println("Yakin ? : ");
        System.out.println("1. YA");
        System.out.println("2. Tidak");
        System.out.printf("Pilihan : ");
        pil = inputan.nextInt();
        switch (pil) {
            case 1:
                if (jumlah > saldo) {
                    System.out.println("");
                    System.out.println("Maaf saldo anda tidak mencukupi");
                    System.out.println("Lanjut penarikan tunai ? : ");
                    System.out.println("1. YA");
                    System.out.println("2. TIDAK");
                    System.out.printf("Pilihan : ");
                    putusan = inputan.nextInt();
                    System.out.println("");
                    switch (putusan) {
                        case 1:
                            penarikan();
                            break;
                        default:
                            menu();
                            break;
                    }
                } else {
                    saldo = saldo - jumlah;
                    System.out.println("Penarikan Berhasil");
                    System.out.println("");
                    menusaldo();
                }
                break;
            default:
                System.out.println("");
                menu();
                break;
        }
    }

    public void transfer() {
        int tran;
        int pilih;
        int tindak;
        int norek;
        int biaya = 3000;
        System.out.printf("Masukkan jumlah uang yang ingin ditransfer : ");
        tran = inputan.nextInt();
        if (tran > saldo) {
            System.out.println("Maaf saldo anda tidak mencukupi");
            System.out.println("Lanjut transer ? : ");
            System.out.println("1. YA");
            System.out.println("2. TIDAK");
            System.out.printf("Pilihan : ");
            tindak = inputan.nextInt();
            System.out.println("");
            switch (tindak) {
                case 1:
                    transfer();
                    break;
                default:
                    menu();
                    break;
            }
        } else {
            System.out.printf("Masukkan no rekening tujuan : ");
            norek = inputan.nextInt();
            for (int i = 0; i < 5; i++){
                if (norek==rek[i]){
                    System.out.println("Transfer tunai berhasil");
                    System.out.println("transfer ke : " +j);
                    if (j%4 == 0){
                        biaya = biaya/2;
                    }
                    System.out.println("Biaya transfer : " +biaya);
                    System.out.println("");
                    saldo = saldo - tran - biaya;
                    j++;
                    menusaldo();
                }
            }
            System.out.println("no rek tujuan tidak terdaftar");
            System.out.println("Lanjut transer ? : ");
            System.out.println("1. YA");
            System.out.println("2. TIDAK");
            System.out.printf("Pilihan : ");
            tindak = inputan.nextInt();
            switch (tindak) {
                case 1:
                    transfer();
                    break;
                default:
                    menu();
                    break;
            }
        }
    }

}
