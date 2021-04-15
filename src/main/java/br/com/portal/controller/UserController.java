package br.com.portal.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;



import br.com.portal.model.User;
import br.com.portal.repository.UserRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("user")
public class UserController {

	
	private UserRepository userRepository = new UserRepository();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> findAll(){
		List<User> userList = userRepository.findAll();
		
		return userList;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id) {
		User user = userRepository.findById(id);
		
		GenericEntity<User> entity = new GenericEntity<User>(user, User.class);
		return Response.ok().entity(entity).build();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response  save(User user) throws URISyntaxException {
		User user1 = userRepository.save(user);
		
		GenericEntity<User> entity = new GenericEntity<User>(user, User.class);
		return Response.created(new URI("/portal/api/user/"+user1.getUser_id())).entity(entity).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response  save(@PathParam("id") Long id,User user){
		User user1 = userRepository.update(id, user);
		
		GenericEntity<User> entity = new GenericEntity<User>(user1, User.class);
		return Response.ok().entity(entity).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		userRepository.delete(id);
		
		return Response.status(202).entity("Deleted user"+id).build();
	}
	

}
