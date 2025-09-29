package com.praktikum.testing.util;

import com.praktikum.testing.model.Buku;
import com.praktikum.testing.model.Anggota;

public class ValidationUtils {

    // Validasi email
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        // Regex sederhana untuk email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }

    // Validasi nomor telepon (format Indonesia)
    public static boolean isValidNomorTelepon(String telepon) {
        if (telepon == null || telepon.trim().isEmpty()) {
            return false;
        }
        // Hapus spasi dan tanda hubung
        String teleponBersih = telepon.replaceAll("[\\s-]", "");
        // Harus dimulai dengan 08 atau +628 dan panjang 10–13 digit
        return teleponBersih.matches("^(\\+628|08)\\d{8,11}$");
    }

    // Validasi ISBN (10 atau 13 digit)
    public static boolean isValidISBN(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            return false;
        }
        // Hapus tanda hubung dan spasi
        String isbnBersih = isbn.replaceAll("[\\s-]", "");
        return isbnBersih.matches("^\\d{10}$") || isbnBersih.matches("^\\d{13}$");
    }

    // Validasi Buku
    public static boolean isValidBuku(Buku buku) {
        if (buku == null) {
            return false;
        }
        return isValidISBN(buku.getIsbn())
                && isValidString(buku.getJudul())
                && isValidString(buku.getPengarang())
                && buku.getJumlahTotal() > 0
                && buku.getHarga() >= 0;
    }

    // Validasi Anggota
    public static boolean isValidAnggota(Anggota anggota) {
        if (anggota == null) {
            return false;
        }
        return isValidString(anggota.getIdAnggota())
                && isValidString(anggota.getNama())
                && isValidEmail(anggota.getEmail())
                && isValidNomorTelepon(anggota.getTelepon())
                && anggota.getTipeAnggota() != null;
    }

    // Validasi String (tidak null, tidak kosong)
    public static boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    // Validasi angka positif
    public static boolean isAngkaPositif(double angka) {
        return angka > 0;
    }

    // Validasi angka non-negatif
    public static boolean isAngkaNonNegatif(double angka) {
        return angka >= 0;
    }
}
