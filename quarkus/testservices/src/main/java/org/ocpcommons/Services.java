package org.ocpcommons;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.io.*;
import java.util.*;

@Path("/services")
public class Services 
{
  @GET
  @Path("/heartbeat")
  @Produces(MediaType.TEXT_PLAIN)
  public String heartbeat() 
  {
    return "Heartbeat " + System.currentTimeMillis();
  }

  @GET
  @Path("/fetch")
  @Produces(MediaType.TEXT_HTML)
  public String fetch(@QueryParam("target") String target)
  {
    StringBuffer buffer = new StringBuffer();

    try
    {
      File targetFile = new File( target );
      Scanner scanner = new Scanner( targetFile );
      while( scanner.hasNextLine() )
      {
        String data = scanner.nextLine();
        buffer.append( data + "<br/>");
      }

      scanner.close();
    }
    catch( Exception exc )
    {
      buffer.append( "[ERROR] " + exc.toString() + "<br/>" );
    }

    return buffer.toString();
  }

  @GET
  @Path("/append")
  @Produces(MediaType.TEXT_HTML)
  public String append(@QueryParam("target") String target, @QueryParam("addition") String addition)
  {
    String response = "";

    try
    {
      FileWriter writer = new FileWriter( target, true );
      BufferedWriter bwriter = new BufferedWriter( writer );

      bwriter.write( addition );
      bwriter.newLine();
      bwriter.close();

      response = "[ADDED] " + addition;
    }
    catch( Exception exc )
    {
      response = "<b>[ERROR]</b> " + exc.toString();
    }

    return response;
  }
}
