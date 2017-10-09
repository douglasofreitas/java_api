package com.example.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/customers")
public class CustomerService {

  private final CopyOnWriteArrayList<Customer> cList = CustomerList.getInstance();

  @GET
  @Path("/all/json")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Customer> getAllCustomersJson() {
	List listCustomer = new ArrayList();
	Iterator<Customer> customerIter = cList.iterator();
    while (customerIter.hasNext()){
      listCustomer.add(customerIter.next());
    }
    return listCustomer;	
  }
  
  @GET
  @Path("/all/text")
  @Produces(MediaType.TEXT_PLAIN)
  public String getAllCustomersText() {
    return "---Customer List---\n"
        + cList.stream()
        .map(c -> c.toString())
        .collect(Collectors.joining("\n"));
  }
  
  @GET
  @Path("{id}/json")
  @Produces(MediaType.APPLICATION_JSON)
  public Customer getCustomerJson(@PathParam("id") long id) {
    Optional<Customer> match
        = cList.stream()
        .filter(c -> c.getId() == id)
        .findFirst();
    
    if (match.isPresent()) {
      return match.get();
    } else {
      return null;
    }
  }
  
  @GET
  @Path("{id}/text")
  @Produces(MediaType.TEXT_PLAIN)
  public String getCustomerText(@PathParam("id") long id) {
    Optional<Customer> match
        = cList.stream()
        .filter(c -> c.getId() == id)
        .findFirst();
    
    if (match.isPresent()) {
      return "---Customer---\n" + match.get().toString();
    } else {
      return "Customer not found";
    }
  }
}
