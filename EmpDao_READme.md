    import java.util.*; 
    import java.sql.*; 
  ```sh    
    public class EmpDao {  
        public static Connection getConnection()
        {  
            Connection con=null;  
         try{  
                Class.forName( "com.mysql.jdbc.Driver");  
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_registration", "root", "");  
            }
            catch(Exception e)
            {
                System.out.println(e);
            }  
            return con;  
        }  
```
```sh
        public static int save(Emp e){  
            int status=0;  
         try{  
                Connection con=EmpDao.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                             "insert into emp_list(name,password,email,country) values (?,?,?,?)");  
                ps.setString(1,e.getName());  
                ps.setString(2,e.getPassword());  
                ps.setString(3,e.getEmail());  
                ps.setString(4,e.getCountry());       
                status=ps.executeUpdate();       
                con.close();  
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }     
            return status;  
        }  
```
```sh
        public static int update(Emp e){  
            int status=0;  
        try{  
                Connection con=EmpDao.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                   "update emp_list set password=?,email=?,country=? where name=?");
                ps.setString(1,e.getPassword());  
                ps.setString(2,e.getEmail());  
                ps.setString(3,e.getCountry());  
                ps.setString(4,e.getName());          
                status=ps.executeUpdate();             
                con.close();  
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }     
            return status;  
        }  
```
```sh
        public static int delete(String name){  
            int status=0;  
        try{  
                Connection con=EmpDao.getConnection();  
                PreparedStatement ps=con.prepareStatement("delete from emp_list where name=?");  
                ps.setString(1,name);  
                status=ps.executeUpdate();  
                  
                con.close();  
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }    
            return status;  
        }  
```
```sh
        public static Emp getEmployeeById(String name)
        {  
            Emp e=new Emp();  
              e.setName(name);
        try{  
                Connection con=EmpDao.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from emp_list where name=?");  
                ps.setString(1,name);  
                ResultSet rs=ps.executeQuery();  
                if(rs.next())
                {  
                    e.setName(rs.getString(1));
                    e.setPassword(rs.getString(2));  
                    e.setEmail(rs.getString(3));  
                    e.setCountry(rs.getString(4));  
                }  
                con.close();  
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }         
            return e;  
        } 
```
```sh
        public static List<Emp> getAllEmployees(){  
            List<Emp> list=new ArrayList<Emp>();  
         try{  
                Connection con=EmpDao.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from emp_list");
                ResultSet rs=ps.executeQuery();  
                while(rs.next())
                {  
                    Emp e=new Emp();  
                    e.setName(rs.getString(1));  
                    e.setPassword(rs.getString(2));  
                    e.setEmail(rs.getString(3));  
                    e.setCountry(rs.getString(4));  
                    list.add(e);  
                }  
                con.close();  
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }   
            return list;  
        }  
    }  
    