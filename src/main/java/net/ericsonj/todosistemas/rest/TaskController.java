/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.ericsonj.todosistemas.rest;

import javax.ws.rs.Path;
import net.ericsonj.todosistemas.models.Task;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import net.ericsonj.todosistemas.models.TaskDaoFacade;
import net.ericsonj.todosistemas.models.User;
import net.ericsonj.todosistemas.models.UserDaoFacade;

/**
 *
 * @author ericson
 */
@Path("/tasks")
public class TaskController {

    private final TaskDaoFacade taskFacade;
    private final UserDaoFacade userFacade;

    public TaskController() {
        this.taskFacade = new TaskDaoFacade();
        this.userFacade = new UserDaoFacade();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTask() {
        return Response.ok(taskFacade.findAll()).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response postTask(Task task) {
        User user = userFacade.find(task.getAssignedTo());
        if (user == null) {
            return Response.status(Status.BAD_REQUEST).entity("User assigned not found").build();
        }
        Task newTask = new Task(task.getName(), task.getEndDate(), task.getAssignedTo());
        taskFacade.create(newTask);
        return Response.ok(newTask).status(Status.CREATED).build();
    }

    @PATCH
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateTask(@PathParam("id") long id, Task task) {
        Task updateTask = taskFacade.find(id);
        if (updateTask == null) {
            return Response.status(Status.BAD_REQUEST).entity("Task not found").build();
        }
        updateTask.updateTask(task);
        taskFacade.edit(updateTask);
        return Response.ok(updateTask).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTask(@PathParam("id") long id) {
        Task updateTask = taskFacade.find(id);
        if (updateTask == null) {
            return Response.status(Status.BAD_REQUEST).entity("Task not found").build();
        }
        taskFacade.remove(updateTask);
        return Response.ok().build();
    }

}
