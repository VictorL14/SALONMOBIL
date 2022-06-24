package Model;
import Entity.KategoriEntity;
import Entity.PelangganEntity;
import Entity.TransaksiEntity;
import Helper.KoneksiDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TransaksiModel {
    private String sql;
    public Connection conn07302 = KoneksiDB.getconection();

    public HashMap<String,String> notaTransaksi (){
        HashMap<String,String> nta = new HashMap();
        try{
            sql = "SELECT transaksi.id_transaksi as no_transaksi, transaksi.tanggal, pelanggan.*, transaksi.type_mobil, transaksi.item, kategori.nama_kategori as kategori, jenis.nama_jenis as layanan, transaksi.biaya from transaksi join pelanggan on transaksi.no_polisi = pelanggan.no_polisi join kategori on transaksi.kode_kategori = kategori.kode_kategori join jenis  on kategori.kode_jenis = jenis.kode_jenis";
            Statement s = conn07302.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                nta.put("no_transaksi", String.valueOf(rs.getInt("no_transaksi")));
                nta.put("tanggal", String.valueOf(rs.getString("tanggal")));
                nta.put("no_polisi", String.valueOf(rs.getString("no_polisi")));
                nta.put("nama_pelanggan", String.valueOf(rs.getString("nama_pelanggan")));
                nta.put("alamat", String.valueOf(rs.getString("alamat")));
                nta.put("no_telp", String.valueOf(rs.getString("no_telp")));
                nta.put("type_mobil", String.valueOf(rs.getString("type_mobil")));
                nta.put("item", String.valueOf(rs.getString("item")));
                nta.put("kategori", String.valueOf(rs.getString("kategori")));
                nta.put("layanan", String.valueOf(rs.getString("layanan")));
                nta.put("biaya", String.valueOf(rs.getString("biaya")));
            }
        }catch (SQLException e){System.out.println(e);}return nta;
    }

    public ArrayList<TransaksiEntity> getALLTransaksi(){
        ArrayList arrayListTransaksi = new ArrayList();
        try{
            Statement stat = conn07302.createStatement();
            sql = "SELECT * FROM transaksi";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                TransaksiEntity transaksiEntity = new TransaksiEntity();
                transaksiEntity.setId_transaksi(rs.getInt("id_transaksi"));
                transaksiEntity.setNo_polisi(rs.getString("no_polisi"));
                transaksiEntity.setKode_kategori(rs.getInt("kode_kategori"));
                transaksiEntity.setBiaya(rs.getInt("biaya"));
                transaksiEntity.setItem(rs.getString("item"));
                transaksiEntity.setType_mobil(rs.getString("type_mobil"));
                transaksiEntity.setTanggal(rs.getString("tanggal"));
                arrayListTransaksi.add(transaksiEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }return arrayListTransaksi;
    }

    public ArrayList<TransaksiEntity>getTransaksi(int id_transaksi) {
        ArrayList arrayListTransaksi = new ArrayList();
        try{
            sql = "SELECT * FROM transaksi WHERE id_transaksi=?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setInt(1, id_transaksi);
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                TransaksiEntity transaksiEntity = new TransaksiEntity();
                transaksiEntity.setId_transaksi(rs.getInt("id_transaksi"));
                transaksiEntity.setNo_polisi(rs.getString("no_polisi"));
                transaksiEntity.setKode_kategori(rs.getInt("kode_kategori"));
                transaksiEntity.setBiaya(rs.getInt("biaya"));
                transaksiEntity.setItem(rs.getString("item"));
                transaksiEntity.setType_mobil(rs.getString("type_mobil"));
                transaksiEntity.setTanggal(rs.getString("tanggal"));
                arrayListTransaksi.add(transaksiEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }return arrayListTransaksi;
    }

    public void insertTransaksi(TransaksiEntity transaksiEntity){
        try {
            sql = "INSERT INTO transaksi(id_transaksi, no_polisi, kode_kategori, biaya, item, type_mobil, tanggal) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setInt(1, transaksiEntity.getId_transaksi());
            stat.setString(2, transaksiEntity.getNo_polisi());
            stat.setInt(3, transaksiEntity.getKode_kategori());
            stat.setInt(4, transaksiEntity.getBiaya());
            stat.setString(5, transaksiEntity.getItem());
            stat.setString(6, transaksiEntity.getType_mobil());
            stat.setString(7, transaksiEntity.getTanggal());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to insert data!");
            e.printStackTrace();
        }
    }

    public void updateTransaksi(TransaksiEntity transaksiEntity){
        try{
            sql = "UPDATE transaksi SET no_polisi =?, kode_kategori =?, biaya =?, item =?, type_mobil =?, tanggal =? WHERE id_transaksi =?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, transaksiEntity.getNo_polisi());
            stat.setInt(2, transaksiEntity.getKode_kategori());
            stat.setInt(3, transaksiEntity.getBiaya());
            stat.setString(4, transaksiEntity.getItem());
            stat.setString(5, transaksiEntity.getType_mobil());
            stat.setString(6, transaksiEntity.getTanggal());
            stat.setInt(7, transaksiEntity.getId_transaksi());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to update data!");
            e.printStackTrace();
        }
    }

    public void deleteTransaksi(int id_transaksi){
        try{
            sql = "DELETE FROM transaksi WHERE id_transaksi =?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setInt(1, id_transaksi);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        }catch (SQLException e) {
            System.out.println("failed to delete data!");
            e.printStackTrace();
        }
    }



}
