package com.airhacks.resource;

import java.util.List;
import java.util.logging.Level;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.airhacks.model.Todo;
import com.airhacks.service.todo.TodoService;

@Path("hello")
@RequestScoped
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class HelloRest {

	@Inject
	TodoService service;

	@GET
	public String hello() {
		return "Hello Rest!";
	}

	@POST
	@Path("save")
	public Response save(Todo todo) {
		service.save(todo);
		return Response.created(UriBuilder.fromResource(HelloRest.class).path(String.valueOf(todo.getId())).build())
				.build();
	}

	@GET
	@Path("list")
	public Response all() {
		System.out.println("GET: {0} Listado de Todos");
		List<Todo> c = service.all();

		GenericEntity<List<Todo>> list = new GenericEntity<List<Todo>>(c) {
		};
		return Response.status(Response.Status.OK).entity(list).build();
	}
}