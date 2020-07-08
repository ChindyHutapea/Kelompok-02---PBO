/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import model.Pengguna;

/**
 *
 * @author gabri
 */
public class PenggunaResponse {
    
    @SerializedName("pengguna")
    private List<Pengguna> pengguna;

    public List<Pengguna> getPengguna() {
    return pengguna;
    }
}
