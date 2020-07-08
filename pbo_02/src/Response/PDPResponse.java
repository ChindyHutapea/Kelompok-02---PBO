/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import model.PDP;

/**
 *
 * @author ITD
 */
public class PDPResponse {
    @SerializedName("pdp")
    private List<PDP> pdp;

    public List<PDP> getPDP() {
    return pdp;
    }
}
