package net.ericsonj.todosistemas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import net.ericsonj.todosistemas.models.User;
import net.ericsonj.todosistemas.models.UserDaoFacade;
import java.util.List;

/**
 *
 * @author ericson
 */
@Path("/users")
public class UserController {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> getUsers() {
        UserDaoFacade userFacade = new UserDaoFacade();
        return userFacade.findAll();
    }     
            
}
