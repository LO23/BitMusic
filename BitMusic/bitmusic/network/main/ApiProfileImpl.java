/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

/**
 *
 * @author florian
 */
public class ApiProfileImpl {
    /**
    * Singleton implementation.
    */
    private static final ApiProfileImpl APIPROFILEHMI = new ApiProfileImpl();

    /**
     * .
     * @return Unique instance of ApiProfileImpl
     */
    protected static ApiProfileImpl getInstance() {
        return APIPROFILEHMI;
    }
}
