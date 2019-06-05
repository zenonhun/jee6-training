/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.iqjb2.remote.client;

import hu.iqjb2.domain.model.Department;
import hu.iqjb2.remote.intf.DepartmentServiceInterface;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author IQJB
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Context context = new InitialContext();
            //DepartmentServiceInterface dsi = (DepartmentServiceInterface) context.lookup("java:global/server1-ear/server1-ejb-1.0-SNAPSHOT/DepartmentService!hu.iqjb2.remote.intf.DepartmentServiceInterface");
            DepartmentServiceInterface dsi = (DepartmentServiceInterface) context.lookup("hu.iqjb2.remote.intf.DepartmentServiceInterface");
            dsi.add(new Department("TESZT1"));
            dsi.add(new Department("TESZT2"));

            dsi.getAll().forEach(d -> System.out.println(d.getName()));
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
