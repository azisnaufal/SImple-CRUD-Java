/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleCrud;

import java.sql.Connection;

/**
 *
 * @author oazisn
 */
public class PenyimpananData {
    private Connection koneksi;

    public Connection getKoneksi() {
        return koneksi;
    }

    public void setKoneksi(Connection koneksi) {
        this.koneksi = koneksi;
    }
}
