    import java.io.IOException;  
    import java.io.PrintWriter;    
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet; 
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
```sh
    @WebServlet("/EditServlet2")  

    public class EditServlet2 extends HttpServlet 
    {  
        protected void doPost(HttpServletRequest request, HttpServletResponse response)   
              throws ServletException, IOException 
              {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();   
            String name=request.getParameter("name");  
            String password=request.getParameter("password");  
            String email=request.getParameter("email");  
            String country=request.getParameter("country");   
            Emp e=new Emp();  
            e.setName(name);  
            e.setPassword(password);  
            e.setEmail(email);  
            e.setCountry(country);    
            int status=EmpDao.update(e); 
```
```sh 
            if(status>0)
            {  
                response.sendRedirect("ViewServlet"); 
                 out.println("yesssss"); 
            }
            else
            {  
                out.println("Sorry! unable to update record");  
            }  
            out.close();  
        }  
      
    }  