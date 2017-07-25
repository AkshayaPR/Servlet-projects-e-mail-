    import java.io.IOException;  
    import java.io.PrintWriter;  
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
```sh
  @WebServlet("/EditServlet")  

   public class EditServlet extends HttpServlet
   {  
        protected void doGet(HttpServletRequest request, HttpServletResponse response)   
        throws ServletException, IOException
        {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
            out.println("<h1>Update Employee</h1>");  
            String name=request.getParameter("name");                
            Emp e=EmpDao.getEmployeeById(name);  
            out.print("<form action='EditServlet2' method='post'>");  
            out.print("<table>");   
```
```sh
            out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
```
```sh
            out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");
```
```sh  
            out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");  
```
```sh
            out.print("<tr><td>Country:</td><td>");  
            out.print("<select name='country' style='width:150px'>");  
            out.print("<option>India</option>");  
            out.print("<option>USA</option>");  
            out.print("<option>UK</option>");  
            out.print("<option>Other</option>");  
            out.print("</select>");  
            out.print("</td></tr>"); 
```
```sh 
            out.print("<input type='submit' value='Edit & Save '/></td></tr>");  
            out.print("</table>");  
            out.print("</form>");  
            out.close();  
        }  
    }  
   