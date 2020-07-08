/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import model.Informasi;
import model.Pengguna;

/**
 *
 * @author gabri
 */
public class InformasiResponse {
    @SerializedName("info")
    private List<Informasi> info;

    public List<Informasi> getInformasi() {
    return info;
    }
}
