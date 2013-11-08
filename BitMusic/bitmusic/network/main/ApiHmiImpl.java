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
public final class ApiHmiImpl {
    /**
    * Singleton implementation.
    */
    private static final ApiHmiImpl APIHMIIMPL = new ApiHmiImpl();

    /**
     * Private constructor for singleton pattern.
     */
    private ApiHmiImpl() { }

    /**
     * .
     * @return Unique instance of ApiHmiImpl
     */
    protected static ApiHmiImpl getInstance() {
        return APIHMIIMPL;
    }

}
