package Main;
import Entity.*;
import Controller.*;
import Model.TransaksiModel;

import java.util.HashMap;
import java.util.Scanner;
public class SI_salonmobil {
    public static Scanner input = new Scanner(System.in);
    public static JenisController jenisController = new JenisController();
    public static KategoriController kategoriController = new KategoriController();
    public static PelangganController pelangganController = new PelangganController();
    public static TransaksiController transaksiController = new TransaksiController();

    public static void main(String[] args) {
        System.out.println("SALON MOBIL MAJU JAYA");
        System.out.println("SELAMAT DATANG");
        System.out.println("Silahkan login ke SISTEM terlebih dahulu");
        login();
    }

    static void login() {
        String nama, password;
        System.out.println("Masukkan nama: ");
        nama = input.nextLine();
        System.out.println("Masukkan Password: ");
        password = input.nextLine();
        if (nama != "admin" && password != "admin") {
            System.out.println("Berhasil Login");
            menu();
        } else {
            System.out.println("Gagal Login");
        }
    }

    static void menu() {
        int pil;
        do {
            System.out.println("MENU SISTEM INFORMASI");
            System.out.println("1. Lihat Data Jenis");
            System.out.println("2. Lihat Data Kategori");
            System.out.println("3. Lihat Data Pelanggan");
            System.out.println("4. Lihat Data Transaksi");
            System.out.println("5. Lihat Hasil transaksi");
            System.out.println("6. Mengisi Data Pelanggan");
            System.out.println("7. Mengisi Data Transaksi");
            System.out.println("0. Log Out");
            System.out.println("Masukkan Inputan: ");
            pil = input.nextInt();

            switch (pil) {
                case 1 -> showDataJenis();
                case 2 -> showDataKategori();
                case 3 -> showDataPelanggan();
                case 4 -> showDataTransaksi();
                case 5 -> transaksi();
                case 6 -> insertPelanggan();
                case 7 -> insertTransaksi();
            }
        } while (pil != 0);
    }

    static void transaksi(){
        TransaksiModel nta = new TransaksiModel();
        HashMap<String,String> ntx = nta.notaTransaksi();
        System.out.println(ntx.size());
        for(int i=0; i<(ntx.size()/11); i++){
            System.out.println("nomor transaksi     : "+ntx.get("no_transaksi"));
            System.out.println("tanggal             : "+ntx.get("tanggal"));
            System.out.println("nomor polisi        : "+ntx.get("no_polisi"));
            System.out.println("nama pelanggan      : "+ntx.get("nama_pelanggan"));
            System.out.println("alamat pelanggan    : "+ntx.get("alamat"));
            System.out.println("nomor telepon       : "+ntx.get("no_telp"));
            System.out.println("tipe mobil          : "+ntx.get("type_mobil"));
            System.out.println("mobil               : "+ntx.get("item"));
            System.out.println("kategori            : "+ntx.get("kategori"));
            System.out.println("layanan             : "+ntx.get("layanan"));
            System.out.println("biaya               : "+ntx.get("biaya"));
        }
        System.out.println("==========================");
        menu();
    }

    /*static void joinJenis(){
        KategoriEntity kategoriEntity = new KategoriEntity();
        JenisEntity jenisEntity = new JenisEntity();
        System.out.println("Kode Kategori : " + kategoriEntity.getKode_kategori());
        System.out.println("Nama Kategori : " + kategoriEntity.getNama_kategori());
        System.out.println("Kode Jenis : " + kategoriEntity.getKode_jenis());
        System.out.println("Kode Jenis      : " + jenisEntity.getKode_jenis());
        System.out.println("Nama Jenis      : " + jenisEntity.getNama_jenis());
    }*/



    static void insertPelanggan(){
        System.out.println("No Polisi : ");
        String no_polisi = input.nextLine();
        System.out.println("Nama Pelanggan : ");
        String nama_pelanggan = input.nextLine();
        System.out.println("Alamat : ");
        String alamat = input.nextLine();
        System.out.println("No Telepon : ");
        String no_telp = input.nextLine();
        pelangganController.insertPelanggan(no_polisi, nama_pelanggan, alamat, no_telp);
        System.out.println("==========================");
        menu();
    }


    static void insertTransaksi(){
        System.out.println("Id Transaksi : ");
        int id_transaksi = input.nextInt();
        input.nextLine();
        System.out.println("No Polisi : ");
        String no_polisi = input.nextLine();
        System.out.println("Kode Kategori : ");
        int  kode_kategori = input.nextInt();
        input.nextLine();
        System.out.println("Biaya : ");
        int biaya = input.nextInt();
        input.nextLine();
        System.out.println("Item : ");
        String item = input.nextLine();
        System.out.println("Type Mobil : ");
        String type_mobil = input.nextLine();
        System.out.println("Tanggal : ");
        String tanggal = input.nextLine();
        System.out.println("==========================");
        menu();
    }

    static void showDataPelanggan(){
        for (PelangganEntity pelangganEntity : pelangganController.getAllPelanggan()){
            System.out.println("--------------------------------------------------");
            System.out.println("No Polisi       : " + pelangganEntity.getNo_polisi());
            System.out.println("Nama Pelanggan  : " + pelangganEntity.getNama_pelanggan());
            System.out.println("Alamat          : " + pelangganEntity.getAlamat());
            System.out.println("No Telepon      : " + pelangganEntity.getNo_telp());
            System.out.println("--------------------------------------------------");
        }
        System.out.println("==========================");
        menu();
    }

    static void showDataJenis(){
        for (JenisEntity jenisEntity : jenisController.getAllJenis()){
            System.out.println("--------------------------------------------------");
            System.out.println("Kode Jenis      : " + jenisEntity.getKode_jenis());
            System.out.println("Nama Jenis      : " + jenisEntity.getNama_jenis());
            System.out.println("--------------------------------------------------");
        }
        System.out.println("==========================");
        menu();
    }

    static void showDataTransaksi(){
        for (TransaksiEntity transaksiEntity : transaksiController.getAllTransaksi()){
            System.out.println("--------------------------------------------------");
            System.out.println("Id Transaksi : " + transaksiEntity.getId_transaksi());
            System.out.println("No Polisi : " + transaksiEntity.getNo_polisi());
            System.out.println("Kode Kategori : " + transaksiEntity.getKode_kategori());
            System.out.println("Biaya : " + transaksiEntity.getBiaya());
            System.out.println("Item : " +transaksiEntity.getItem());
            System.out.println("Type Mobil : " + transaksiEntity.getType_mobil());
            System.out.println("Tanggal : " + transaksiEntity.getTanggal());
            System.out.println("--------------------------------------------------");
        }
        System.out.println("==========================");
        menu();
    }

    static void showDataKategori(){
        for(KategoriEntity kategoriEntity : kategoriController.getdataKategori()){
            System.out.println("--------------------------------------------------");
            System.out.println("Kode Kategori : " + kategoriEntity.getKode_kategori());
            System.out.println("Nama Kategori : " + kategoriEntity.getNama_kategori());
            System.out.println("Kode Jenis : " + kategoriEntity.getKode_jenis());
            System.out.println("--------------------------------------------------");
        }
        System.out.println("==========================");
        menu();
    }
}
