package Model;
import Entity.JenisEntity;
import Entity.KategoriEntity;
import Helper.KoneksiDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class KategoriModel {
    private String sql;
    public Connection conn07302 = KoneksiDB.getconection();

    public ArrayList<KategoriEntity> getALLKategori(){
        ArrayList arrayListKategori = new ArrayList();
        try{
            Statement stat = conn07302.createStatement();
            sql = "SELECT * FROM kategori";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                KategoriEntity kategoriEntity = new KategoriEntity();
                kategoriEntity.setKode_kategori(rs.getInt("kode_kategori"));
                kategoriEntity.setNama_kategori(rs.getString("nama_kategori"));
                kategoriEntity.setKode_jenis(rs.getInt("kode_jenis"));
                arrayListKategori.add(kategoriEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }return arrayListKategori;
    }


    /*public ArrayList<>getKategori(int kode_kategori){
        HashMap<JenisEntity, KategoriEntity> arrayListKategori = new HashMap<>();
        try{
            sql = "SELECT * FROM kategori WHERE kode_kategori=?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setInt(1,kode_kategori);
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                KategoriEntity kategoriEntity = new KategoriEntity();
                kategoriEntity.setKode_kategori(rs.getInt("kode_kategori"));
                kategoriEntity.setNama_kategori(rs.getString("nama_kategori"));
                kategoriEntity.setKode_jenis(rs.getInt("kode_jenis"));
                arrayListKategori.add(kategoriEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }return arrayListKategori;
    }*/

    public void insertKategori(KategoriEntity kategoriEntity){
        try {
            sql = "INSERT INTO kategori(kode_kategori, nama_kategori, kode_jenis) VALUES(?,?,?)";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setInt(1, kategoriEntity.getKode_kategori());
            stat.setString(2, kategoriEntity.getNama_kategori());
            stat.setInt(3, kategoriEntity.getKode_jenis());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to insert data!");
            e.printStackTrace();
        }
    }

    public void updateKategori(KategoriEntity kategoriEntity){
        try{
            sql = "UPDATE jenis SET nama_kategori =?, kode_jenis =? WHERE kode_kategori =?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, kategoriEntity.getNama_kategori());
            stat.setInt(2, kategoriEntity.getKode_jenis());
            stat.setInt(3, kategoriEntity.getKode_kategori());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to update data!");
            e.printStackTrace();
        }
    }


    public void joinJenis(){
        KategoriEntity kategoriEntity = new KategoriEntity();
        JenisEntity jenisEntity = new JenisEntity();
        try{
            sql = "SELECT kategori.*, jenis.* FROM kategori LEFT JOIN jenis ON kategori.kode_kategori = jenis.kode_jenis";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setInt(1, kategoriEntity.getKode_kategori());
            stat.setString(2, kategoriEntity.getNama_kategori());
            stat.setInt(3, kategoriEntity.getKode_jenis());
            stat.setInt(4, jenisEntity.getKode_jenis());
            stat.setString(5, jenisEntity.getNama_jenis());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        }catch (SQLException e) {
            System.out.println("failed to join data!");
            e.printStackTrace();
        }
    }

    public void deleteKategori(int kode_kategori){
        try{
            sql = "DELETE FROM kategori WHERE kode_kategori =?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setInt(1,kode_kategori);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        }catch (SQLException e) {
            System.out.println("failed to delete data!");
            e.printStackTrace();
        }
    }
}
