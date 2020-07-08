/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import model.ODP;

/**
 *
 * @author ITD
 */
public class ODPResponse {
    @SerializedName("odp")
    private List<ODP> odp;

    public List<ODP> getODP() {
    return odp;
    }
}
