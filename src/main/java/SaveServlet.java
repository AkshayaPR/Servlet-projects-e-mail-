    import java.io.IOException;  
    import java.io.PrintWriter;  
      
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
   

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;






 @WebServlet("/SaveServlet")  
    public class SaveServlet extends HttpServlet {  
        protected void doPost(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
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
              
            int status=EmpDao.save(e);  
            
            if(status>0){  
                out.print("<p>Record saved successfully!</p>");  
                request.getRequestDispatcher("index.html").include(request, response);  
            }else{  
                out.println("Sorry! unable to save record");  
            }  
              
            out.close();  

 response.setContentType("text/html;charset=UTF-8");

String toMail = request.getParameter("email");


try {
SaveServlet javaEmail = new SaveServlet();
final String username = "akshaya.pr@kggroup.com";
final String password1 = "Akshayapr@11";
Properties props = new Properties();
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "false");
props.put("mail.smtp.host", "webmail.kggroup.com");
props.put("mail.smtp.port", "25");
Session session = Session.getInstance(props,
new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(username, password1);
}
});
try {
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress("akshaya.pr@kggroup.com"));
message.setRecipients(Message.RecipientType.TO,
InternetAddress.parse(toMail));

message.setSubject("Event Registration Succesful");
message.setContent("<h1>Hi "+name+"</h1><br><br><h2>Your Registration Is Succesful</h2>","text/html" );
Transport.send(message);
System.out.println("Done");
}
catch (MessagingException e2)
{
throw new RuntimeException(e2);
}

//javaEmail.sendEmail(toMail);
out.println("Process Completed\n");
} catch (Exception e1) {
e1.printStackTrace();
}
out.println("event registered successfully");
}




        }  
      
    