    import java.io.IOException;  
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    @WebServlet("/DeleteServlet")  
    public class DeleteServlet extends HttpServlet {  
        protected void doGet(HttpServletRequest request, HttpServletResponse response)   
                 throws ServletException, IOException {  
            String name=request.getParameter("name");  
            //int id=Integer.parseInt(sid);  
            EmpDao.delete(name);  
            response.sendRedirect("ViewServlet");  
        }  
    }  