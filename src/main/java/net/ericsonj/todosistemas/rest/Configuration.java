/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.ericsonj.todosistemas.rest;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author ericson
 */
@ApplicationPath("api")
public class Configuration extends ResourceConfig {

    public Configuration() {
        packages("net.ericsonj.todosistemas.rest");
    }

}
