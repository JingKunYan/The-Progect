/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class Contest {
    public static void main(String [] args){
        Connect mysql=new Connect();
        int flag=1;
        do{
        System.out.println("欢迎使用西军电学生在线管理系统....");
        System.out.println("请输入您的选择:");
        System.out.println("1、查询功能\t\t2、插入功能\t\t\n3、删除功能\t\t4、修改功能\t\t5、退出系统\n");
        Scanner in=new Scanner(System.in);
        int choose=in.nextInt();
        String pause;
        switch(choose){
            case 5:
                System.out.println("期待您再次使用本系统...\n再见...");
                flag=0;
                break;
            case 1://查询
                 System.out.println("欢迎使用查询系统...");
                 System.out.println("请输入您的选择:");
                 System.out.println("1、学生查询\t\t2、班级查询\t\t\n3、系别查询\t\t4、学会查询\n");
                 choose=in.nextInt();
                 switch(choose){
                     case 1://学生查询
                         System.out.println("请输入您的选择:");
                         System.out.println("1、姓名查询\t\t2、学号查询\t\t\n3、班号查询\t\t4、年龄查询\n");
                         choose=in.nextInt();
                         String sql=null;
                        switch(choose){
                             case 1:
                                System.out.println("请输入要查询学生的姓名:");
                                pause=in.nextLine();
                                String sqlName=in.nextLine(); 
                                sql="select sno,sname,age,student.classno,systemname,apartment from student,class,s_q where student.sname like '"+sqlName+"' and student.classno = class.classno and  class.sys = s_q.systemname ;";
                                mysql.Query(sql, 1);
                                 break;
                             case 2:
                                 System.out.println("请输入要查询学生的学号:");
                                 pause=in.nextLine();
                                 String sqlSno=in.nextLine(); 
                                 sql="select sno,sname,age,student.classno,systemname,apartment from student,class,s_q where student.sno like '"+sqlSno+"' and student.classno = class.classno and  class.sys = s_q.systemname ;";
                                 mysql.Query(sql, 1);
                                 break;
                             case 3:
                                 System.out.println("请输入要查询学生的班号:");
                                 pause=in.nextLine();
                                 String sqlCno=in.nextLine();
                                 sql="select sno,sname,age,student.classno,systemname,apartment from student,class,s_q where student.classno like '"+sqlCno+"' and student.classno = class.classno and  class.sys = s_q.systemname ;";
                                 mysql.Query(sql, 1);
                                 break;
                             case  4:
                                 System.out.println("请输入要查询学生的出生日期:");
                                 pause=in.nextLine();
                                 String sqlAge=in.nextLine(); 
                                 sql="select sno,sname,age,student.classno,systemname,apartment from student,class,s_q where student.age like '"+sqlAge+"' and student.classno = class.classno and  class.sys = s_q.systemname ;";
                                 mysql.Query(sql, 1);
                                 break;
                             default:
                                 System.out.println("请输入正确选项...");
                                 break;
                         }
                         break;//学生查询
                     
                     
                     case 2://班级查询
                         System.out.println("请输入您的选择:");
                         System.out.println("1、班号查询\t\t2、专业名查询\t\t\n3、系名查询\t\t4、入学日期查询\n");
                         choose=in.nextInt();
                         switch(choose){
                             case 1:
                                System.out.println("请输入要查询班级的班号:");
                                pause=in.nextLine();
                                String sqlCno=in.nextLine(); 
                                sql="select * from class where classno like '"+sqlCno+"';";
                                mysql.Query(sql, 2);
                                 break;
                             case 2:
                                 System.out.println("请输入要查询班级的专业名:");
                                  pause=in.nextLine();
                                 String sqlMnm=in.nextLine(); 
                                 sql="select * from class where majorname like '"+sqlMnm+"';";
                                 mysql.Query(sql, 2);
                                 break;
                             case 3:
                                 System.out.println("请输入要查询班级的系名:");
                                 pause=in.nextLine();
                                 String sqlDnm=in.nextLine();
                                 sql="select * from class where sys like '"+sqlDnm+"';";
                                 mysql.Query(sql, 2);
                                 break;
                             case  4:
                                 System.out.println("请输入要查询班级的入学日期:");
                                pause=in.nextLine();
                                 String sqlEdt=in.nextLine(); 
                                 sql="select * from class where dataSchool like '"+sqlEdt+"';";
                                 mysql.Query(sql, 2);
                                 break;
                         }
                         break;//班级查询
                     
                     
                     
                     case 3://系别查询
                         System.out.println("请输入您的选择:");
                         System.out.println("1、系号查询\t\t2、系名查询\t\t3、系办公地点\t\t4.住宿区查询\n");
                         choose=in.nextInt();
                         switch(choose){
                             case 1:
                                System.out.println("请输入要查询系别的系号:");
                               pause=in.nextLine();
                                String sqlDno=in.nextLine(); 
                                sql="select * from department where systemno like '"+sqlDno+"';";
                                mysql.Query(sql, 3);
                                 break;
                             case 2:
                                 System.out.println("请输入要查询系别的系名:");
                                 pause=in.nextLine();
                                 String sqlDnm=in.nextLine(); 
                                 sql="select * from department where systemname like '"+sqlDnm+"';";
                                mysql.Query(sql, 3);
                                 break;
                             case 3:
                                 System.out.println("请输入要查询系别的办公地点:");
                                pause=in.nextLine();
                                 String sqlDof=in.nextLine(); 
                                 sql="select * from department where systemoffice like '"+sqlDof+"';";
                                mysql.Query(sql, 3);
                                 break;
                         }
                         break;//系别查询
                     
                     
                     
                     case 4://学会查询
                         System.out.println("请输入您的选择:");
                         System.out.println("1、学会号查询\t\t2、学会名称查询\t\t\n3、学会成立时间查询\t4、学会活动区域查询\t5、学会人数查询\n");
                         choose=in.nextInt();
                         switch(choose){
                             case 1:
                                System.out.println("请输入要查询学会的学会号:");
                                pause=in.nextLine();
                                String sqlUno=in.nextLine(); 
                                sql="select * from society where unionno like '"+sqlUno+"';";
                                mysql.Query(sql, 4);
                                break;
                             case 2:
                                 System.out.println("请输入要查询学会的名称:");
                                 pause=in.nextLine();
                                 String sqlUnm=in.nextLine(); 
                                 sql="select * from society where unionname like '"+sqlUnm+"';";
                                mysql.Query(sql, 4);
                                 break;
                             case 3:
                                 System.out.println("请输入要查询学会的成立时间:");
                                 pause=in.nextLine();
                                 String sqlUdt=in.nextLine(); 
                                 sql="select * from society where dataunion like '"+sqlUdt+"';";
                                mysql.Query(sql, 4);
                                 break;
                              case 4:
                                 System.out.println("请输入要查询学会的活动区域:");
                                 pause=in.nextLine();
                                 String sqlUpl=in.nextLine(); 
                                 sql="select * from society where unionplace like '"+sqlUpl+"';";
                                 mysql.Query(sql, 4);
                                 break;
                              case 5:
                                 System.out.println("请输入要查询人数学会的学会名称:");
                                 pause=in.nextLine();
                                 String number=in.nextLine();
                                 mysql.querySociety(number);
                                  break;
                              default:
                                  System.out.println("请输入正确选项...");
                                  break;
                         }
                         break;//学会查询
                 
                 }
                break;//查询
            case 2://插入功能
                 System.out.println("欢迎使用插入系统...");
                 System.out.println("请输入您的选择:");
                 System.out.println("1、插入新的学生\t\t2、插入新的学会\t\t\n3、插入新的班级\t\t4、插入新的专业\t5.插入新的系别\n");          
                 choose=in.nextInt();
                 switch(choose){
                     case 1://插入学生
                         System.out.println("请输入要插入学生的信息...\n");
                         System.out.println("请输入新增学生的学号:");
                         pause=in.nextLine();
                         String sqlSno=in.nextLine();
                         System.out.println("请输入新增学生的姓名:");
                         String sqlSnm=in.nextLine();
                         System.out.println("请输入新增学生的年龄:");
                         String sqlSage=in.nextLine();
                         System.out.println("请输入新增学生的班号:");
                         String sqlScno=in.nextLine();
                         mysql.insertStudent(sqlSno, sqlSnm, sqlSage, sqlScno);
                         break;//插入学生
                     case 2:
                         System.out.println("请输入要插入学会的信息...\n");
                         System.out.println("请输入新增学会的学会号:");
                         pause=in.nextLine();
                         String sqlUnionNo=in.nextLine();
                         System.out.println("请输入新增学会的学会名:");
                         String sqlUnionName=in.nextLine();
                         System.out.println("请输入新增学会的创建日期:");
                         String sqlDataUnion=in.nextLine();
                         System.out.println("请输入新增学会的活动地点:");
                         String sqlUnionPlace=in.nextLine();
                         mysql.insertSociety(sqlUnionNo, sqlUnionName, sqlDataUnion, sqlUnionPlace);
                         break;
                     case 3:
                         System.out.println("请输入要插入班级的信息...\n");
                         System.out.println("请输入新增班级的班号:");
                         pause=in.nextLine();
                         String classNo=in.nextLine();
                         System.out.println("请输入新增班级的专业名称:");
                         String majorName=in.nextLine();
                         System.out.println("请输入新增班级的系名:");
                         String Sys=in.nextLine();
                         System.out.println("请输入新增班级的入校年份:");
                         String dataSchool=in.nextLine();
                         mysql.insertClass(classNo, majorName, Sys, dataSchool);
                         break;
                     case 4:
                          System.out.println("十分抱歉，本功能尚未开通\n");
                         break;  
                    case 5:
                          System.out.println("十分抱歉，本功能尚未开通\n");
                         break;  
                     default:
                         System.out.println("请选择正确选项...");
                 }
                
                break;//插入功能
                
                
            case 3://删除功能
                System.out.println("欢迎使用删除系统...");
                System.out.println("请输入您的选择:");
                System.out.println("1、学生删除\t\t2、班级删除\t\t\n3、学会删除\t\t4、专业删除\t\t5、系别删除\n");
                choose=in.nextInt();
                switch(choose){
                    case 1://学生删除      
                    System.out.println("请选择删除学生的依据...");
                    System.out.println("1.学生学号\t\t2.学生班级号\n");
                    choose=in.nextInt();
                    if(choose==1){
                        pause=in.nextLine();
                        System.out.println("请输入学号:");
                        String sqlSno=in.nextLine();
                        mysql.DeleteStudent(sqlSno, sqlSno,1);
                        
                    }
                    else if(choose==2){
                        pause=in.nextLine();
                        System.out.println("请输入班级号:");
                        String sqlCno=in.nextLine();
                        mysql.DeleteStudent(sqlCno, sqlCno, 2);
                            }
                   else
                        System.out.println("请输入正确选项...\n");
                    break;//学生删除
                    
                    
                    
                    case 2://班级删除
                        System.out.println("请选择删除班级的依据...");
                        System.out.println("1.班级班号\t\t2.专业名称\t\t3.系别名称\n");
                        choose=in.nextInt();
                         if(choose==1){
                            pause=in.nextLine();
                            System.out.println("请输入班号:");
                            String sqlCno=in.nextLine();
                            mysql.DeleteClass(sqlCno, sqlCno, sqlCno, 1);
                    }
                    else if(choose==2){
                            pause=in.nextLine();
                            System.out.println("请输入专业名称:");
                            String majorName=in.nextLine();
                            mysql.DeleteClass(majorName, majorName, majorName, 2);
                            }
                    else if(choose==3){
                            pause=in.nextLine();
                            System.out.println("请输入系别名称:");
                            String Sys=in.nextLine();
                           mysql.DeleteClass( Sys,  Sys, Sys, 3);
                    }
                   else
                            System.out.println("请输入正确选项...\n");
                             break;//班级删除
                        
                  
                    
                    case 3://学会删除
                        System.out.println("请选择待删除学会的依据...");
                        System.out.println("1.学会号\t\t2.学会名称\t\t3.学会活动地点\n");
                        choose=in.nextInt();
                         if(choose==1){
                            pause=in.nextLine();
                            System.out.println("请输入学会号:");
                            String sqlUno=in.nextLine();
                            mysql.DeleteSociety(sqlUno, sqlUno, sqlUno, 1);
                    }
                    else if(choose==2){
                            pause=in.nextLine();
                            System.out.println("请输入学会名称:");
                            String sqlUnm=in.nextLine();
                            mysql.DeleteSociety(sqlUnm, sqlUnm, sqlUnm, 2);
                            }
                    else if(choose==3){
                            pause=in.nextLine();
                            System.out.println("请输入学会活动地点:");
                            String sqlPlace=in.nextLine();
                           mysql.DeleteSociety(sqlPlace, sqlPlace, sqlPlace,3);
                            }
                   else
                             System.out.println("请输入正确选项...\n");
                        break;//学会删除
                       
                        
                    case 4://专业删除
                        System.out.println("十分抱歉，本功能尚未开通\n");
                        /*System.out.println("请输入要删除的系别名称...");
                        pause=in.nextLine();
                        String Dnm=in.nextLine();
                        System.out.println("");*/
                        break;//专业删除
                        
                    case 5://系别删除
                         System.out.println("十分抱歉，本功能尚未开通\n");
                      break;//系别删除
                
                    default:
                        System.out.println("请选择正确选项...");                  
                }
                break;//删除功能
                
                
                
                
            case 4://修改功能
                System.out.println("欢迎使用修改系统...");
                System.out.println("请输入您的选择:");
                System.out.println("1、学生信息修改\t\t2、班级信息修改\t\t\n3、系别信息修改\t\t4、学会信息修改");
                choose=in.nextInt();
                switch(choose){
                    case 1://学生修改
                        System.out.println("请输入要修改学生的学号...");
                        pause=in.nextLine();
                        String sqlSno=in.nextLine();
                        System.out.println("请选择要修改的信息...");
                        System.out.println("1.学生姓名\t\t2.年龄\t\t3.学生班号");
                        choose=in.nextInt();
                        switch(choose){
                            case 1:
                                pause=in.nextLine();
                                System.out.println("请输入学生姓名:");
                                String sqlSnm=in.nextLine();
                                mysql.updateStudent(sqlSno, sqlSnm, sqlSnm, sqlSnm, 1);
                                break;
                            case 2:
                                pause=in.nextLine();
                                System.out.println("请输入学生出生年月:");
                                String sqlSage=in.nextLine();
                                mysql.updateStudent(sqlSno, sqlSage, sqlSage, sqlSage, 2);
                                break;
                            case 3:
                                pause=in.nextLine();
                                System.out.println("请输入学生班号:");
                                String sqlScno=in.nextLine();
                                mysql.updateStudent(sqlSno, sqlScno, sqlScno, sqlScno, 3);
                                break;
                            default:
                                System.out.println("请选择正确选项...");
                        
                        }
                        break;//学生修改
                        
                        
                    case 2://班级修改
                        System.out.println("请输入要修改班级的班号...");
                        pause=in.nextLine();
                        String sqlCno=in.nextLine();
                        System.out.println("请选择要修改的信息...");
                        System.out.println("1.专业名称\t\t2.系别名称\t\t3.入校年份");
                        choose=in.nextInt();
                        switch(choose){
                            case 1:
                                pause=in.nextLine();
                                System.out.println("请输入专业名称:");
                                String sqlMnm=in.nextLine();
                                mysql.updateClass(sqlMnm, sqlMnm, sqlMnm, sqlCno, 1);
                                break;
                            case 2:
                                pause=in.nextLine();
                                System.out.println("请输入系别名称:");
                                String sqlDnm=in.nextLine();
                                mysql.updateClass(sqlDnm, sqlDnm, sqlDnm, sqlCno, 2);
                                break;
                            case 3:
                                pause=in.nextLine();
                                System.out.println("请输入入校年份:");
                                String sqlCdt=in.nextLine();
                                mysql.updateClass(sqlCdt, sqlCdt, sqlCdt, sqlCno, 3);
                                break;
                            default:
                                System.out.println("请选择正确选项...");
                        
                        }
                        break;//班级修改
                        
                        
                    case 3://系别修改
                        System.out.println("请输入要修改系别的系号...");
                        pause=in.nextLine();
                        String sqlDno=in.nextLine();
                        System.out.println("请选择要修改的信息...");
                        System.out.println("1.系别名称\t\t2.系别办公地点\t\t3.系别住宿区");
                        choose=in.nextInt();
                        String sqlDnm=null;
                        switch(choose){           
                            case 1:
                                pause=in.nextLine();
                                System.out.println("请输入系别名称:");
                                sqlDnm=in.nextLine();
                                mysql.updateDepartment(sqlDnm, sqlDnm,sqlDnm, sqlDno, 1);
                                break;
                            case 2:
                                pause=in.nextLine();
                                System.out.println("请输入系别办公地点:");
                                String sqlDpl=in.nextLine();
                                mysql.updateDepartment(sqlDpl, sqlDpl, sqlDpl, sqlDno, 2);
                                break;
                            case 3:
                                pause=in.nextLine();
                                System.out.println("请输入系别名称:");
                                sqlDnm=in.nextLine();
                                System.out.println("请输入系别住宿区:");
                                String sqlDdp=in.nextLine();
                                mysql.updateDepartment(sqlDnm, sqlDnm, sqlDdp, sqlDno, 3);
                                break;
                            default:
                                System.out.println("请选择正确选项...");
                        
                        }
                        break;//系别修改
                        
                        
                    case 4://学会修改
                        System.out.println("请输入要修改学会的学会号...");
                        pause=in.nextLine();
                        String sqlUno=in.nextLine();
                        System.out.println("请选择要修改的信息...");
                        System.out.println("1.学会名称\t\t2.学会活动地点\t\t3.学会建立日期");
                        choose=in.nextInt();
                        switch(choose){
                            case 1:
                                pause=in.nextLine();
                                System.out.println("请输入学会名称:");
                                String sqlUnm=in.nextLine();
                                mysql.updateSociety(sqlUnm, sqlUnm, sqlUnm, sqlUno, 1);
                                break;
                            case 2:
                                pause=in.nextLine();
                                System.out.println("请输入学会活动地点:");
                                String sqlUpl=in.nextLine();
                                mysql.updateSociety(sqlUpl, sqlUpl, sqlUpl, sqlUno, 2);
                                break;
                            case 3:
                                pause=in.nextLine();
                                System.out.println("请输入学会建立日期:");
                                String sqlUdt=in.nextLine();
                                mysql.updateSociety(sqlUdt, sqlUdt, sqlUdt, sqlUno, 3);
                                break;
                            default:
                                System.out.println("请选择正确选项...");
                        
                        }
                        break;//学会修改
                        

                }
                       
                break;//修改功能
                
        }
        }
        while(flag!=0);
        mysql.close();
    }
}

class Connect{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/yjk";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "yjk100544";
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement preparedStatement = null;
    Connect(){
    try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("正在连接主机请等候...");
            this.conn = DriverManager.getConnection(DB_URL,USER,PASS);      
            // 执行查询
            System.out.println("连接成功...");
    }
    catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
            // 关闭资源
    
}//connect
     void querySociety(String societyNo){
       try{
           String sql="select * from unionmessage where unionname like ?;";
           preparedStatement=this.conn.prepareStatement(sql);
           preparedStatement.setString(1, societyNo);
           ResultSet rs=preparedStatement.executeQuery();
           if(rs.next()){
             String societyName=rs.getString("unionname");
             String societyNum=rs.getString("unionpersonnum");
             System.out.println("学会名称:"+societyName+"\n"+"学会人数:"+societyNum);
            while(rs.next()){
             societyName=rs.getString("unionname");
             societyNum=rs.getString("unionpersonnum");
             System.out.println("学会名称:"+societyName+"\n"+"学会人数:"+societyNum);  
           }
           }
          else
               System.out.println("不存在该学会名称...");
       }
       catch(SQLException e){
       System.out.println(e.toString());
       }
     
     
     }
     
    void Query(String sql,int choose) {
       try{
        stmt=this.conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        switch(choose){
            case 1://学生查询
                if(rs.next()){
                     String Sno=rs.getString("sno");
                     String Sname=rs.getString("sname");
                     String Sage=rs.getString("age");
                     String classNo=rs.getString("classno");
                     String systemName=rs.getString("systemname");
                     String apartMent=rs.getString("apartment");
                     System.out.println("学生姓名:"+Sname+"\n"+"学生学号:"+Sno+"\n"+"学生年龄:"+Sage+"\n"+"学生班号:"+classNo+"\n"+"学生系别:"+systemName+"\n"+"学生住宿区:"+apartMent);
                while(rs.next()){
                     Sno=rs.getString("sno");
                     Sname=rs.getString("Sname");
                     Sage=rs.getString("birth");
                     classNo=rs.getString("classno");
                     systemName=rs.getString("systemname");
                     apartMent=rs.getString("apartment");
                     System.out.println("学生姓名:"+Sname+"\n"+"学生学号:"+Sno+"\n"+"学生年龄:"+Sage+"\n"+"学生班号:"+classNo+"\n"+"学生系别:"+systemName+"\n"+"学生住宿区:"+apartMent);
            }
           }
        else{
            System.out.println("不存在该同学信息...");
        }
        break;//学生查询
        
            case 2:
                if(rs.next()){
                String classNo=rs.getString("classno");
                String majorName=rs.getString("majorname");
                String Sys=rs.getString("sys");
                String personNum=rs.getString("personnum");
                String dataSchool=rs.getString("dataSchool");
                System.out.println("班级班号:"+classNo+"\n"+"专业名称:"+majorName+"\n"+"系别名称:"+Sys+"\n"+"班级人数:"+personNum+"\n"+"入校年份:"+dataSchool);
                while(rs.next()){
                   classNo=rs.getString("classno");
                    majorName=rs.getString("majorname");
                    Sys=rs.getString("sys");
                    personNum=rs.getString("personnum");
                    dataSchool=rs.getString("dataSchool");
                    System.out.println("班级班号:"+classNo+"\n"+"专业名称:"+majorName+"\n"+"系别名称:"+Sys+"\n"+"班级人数:"+personNum+"\n"+"入校年份:"+dataSchool);
                }
                }
                else{
                    System.out.println("不存在该班级信息");
                }
                break;//班级查询
                
                
            case 3:
                if(rs.next()){
                String systemNo=rs.getString("systemno");
                String systemName=rs.getString("systemname");
                String systemOffice=rs.getString("systemoffice");
                String systemNum=rs.getString("systemnum");
                System.out.println("系别号:"+systemNo+"\n"+"系别名称:"+systemName+"\n"+"系办公地点:"+systemOffice+"\n"+"系别人数:"+systemNum+"\n");
                while(rs.next()){
                     systemNo=rs.getString("systemno");
                     systemName=rs.getString("systemname");
                     systemOffice=rs.getString("systemoffice");
                     systemNum=rs.getString("systemnum");
                     System.out.println("系别号:"+systemNo+"\n"+"系别名称:"+systemName+"\n"+"系办公地点:"+systemOffice+"\n"+"系别人数:"+systemNum+"\n");
                }
                }
                else{
                    System.out.println("不存在该系别信息");
                }
                break;//系查询
                
                
            case 4:
                if(rs.next()){
                    String unionNo=rs.getString("unionno");
                    String unionName=rs.getString("unionname");
                    String dataUnion=rs.getString("dataunion");
                    String unionPlace=rs.getString("unionplace");
                    System.out.println("学会号:"+unionNo+"\n"+"学会名称:"+unionName+"\n"+"学会建立日期:"+ dataUnion+"\n"+"学会活动地点:"+ unionPlace+"\n");
                while(rs.next()){
                     unionNo=rs.getString("unionno");
                     unionName=rs.getString("unionname");
                    dataUnion=rs.getString("dataunion");
                    unionPlace=rs.getString("unionplace");
                    System.out.println("学会号:"+unionNo+"\n"+"学会名称:"+unionName+"\n"+"学会建立日期:"+ dataUnion+"\n"+"学会活动地点:"+ unionPlace+"\n");
                }
                }
                else{
                    System.out.println("不存在该学会信息");
                }
                break;//学会查询
       }
         rs.close();
         stmt.close();
}
      catch(SQLException e){
          System.out.println(e.toString());
      }
    }
    void insertStudent(String sqlSno,String sqlSnm,String sqlSage,String sqlScno){
        
        try{
        String sql="insert into student values(?,?,?,?);";
        preparedStatement=this.conn.prepareStatement(sql);
        preparedStatement.setString(1, sqlSno);
        preparedStatement.setString(2, sqlSnm);
        preparedStatement.setString(3, sqlSage);
        preparedStatement.setString(4, sqlScno);
        if(preparedStatement.executeUpdate()==0)
            System.out.println("插入学生失败");
        else
            System.out.println("插入学生成功...");
        preparedStatement.close();
        }
        catch(SQLException e){
          System.out.println("插入失败");
          System.out.println(e.toString());
        }      
    }
    
    
    void insertClass(String classNo,String majorName,String Sys,String dataSchool){
     try{
        String sql="insert into class values(?,?,?,?,?);";
        preparedStatement=this.conn.prepareStatement(sql);
        preparedStatement.setString(1, classNo);
        preparedStatement.setString(2, majorName);
        preparedStatement.setString(3, Sys);
        preparedStatement.setInt(4, 0);
        preparedStatement.setString(5, dataSchool);
       if(preparedStatement.executeUpdate()==0)
            System.out.println("插入班级失败");
       else
            System.out.println("插入班级成功...");
        preparedStatement.close();
        }
        catch(SQLException e){
          System.out.println("插入失败");
          System.out.println(e.toString());
        }      
    
    
    }
    
     void insertSociety(String unionNo,String unionName,String dataUnion,String unionPlace){
     try{
        String sql="insert into society values(?,?,?,?);";
        preparedStatement=this.conn.prepareStatement(sql);
        preparedStatement.setString(1, unionNo);
        preparedStatement.setString(2, unionName);
        preparedStatement.setString(3, dataUnion);
        preparedStatement.setString(4, unionPlace);
       if(preparedStatement.executeUpdate()==0)
            System.out.println("插入学会失败");
       else
            System.out.println("插入学会成功...");
        preparedStatement.close();
        }
        catch(SQLException e){
          System.out.println("插入失败");
          System.out.println(e.toString());
        }      
    
    
    }
    
    
    
    void DeleteStudent(String sqlSno,String sqlCno,int choose){
        String sql;
     try{
         switch(choose){
             case 1: //学生删除
                 sql="delete from student where sno like ?;";
                 preparedStatement=conn.prepareStatement(sql);
                 preparedStatement.setString(1, sqlSno);
                if(preparedStatement.executeUpdate()==0)
                     System.out.println("删除学生失败");
                else
                    System.out.println("删除学生成功...");
                 preparedStatement.close();
                 break;//学生删除
             case 2:
                 sql="delete from student where classno like ?;";
                 preparedStatement=conn.prepareStatement(sql);
                 preparedStatement.setString(1, sqlCno);
                if(preparedStatement.executeUpdate()==0)
                     System.out.println("删除学生失败");
                else
                    System.out.println("删除学生成功...");
                 preparedStatement.close();
                 break;
            /* case 21:
                 sql="delete from society where unionno like ?";
                 preparedStatement=conn.prepareStatement(sql);
                 preparedStatement.setString(1, sqlUno);
                 preparedStatement.executeUpdate();
                 preparedStatement.close();
                 System.out.println("删除学会成功...");
                 preparedStatement.close();
                 break;
             case 22:
                 sql="delete from society where unionname like ?";
                 preparedStatement=conn.prepareStatement(sql);
                 preparedStatement.setString(1, sqlUnm);
                 preparedStatement.executeUpdate();
                 preparedStatement.close();
                 System.out.println("删除学会成功...");
                 preparedStatement.close();
                 break;*/
        }
     }
        catch(SQLException e){
          System.out.println(e.toString());
        }
    }
    
    void DeleteClass(String classNo,String majorName,String Sys,int choose){
    try{
        String sql;
        switch(choose){
            case 1:
                sql="delete from class where classno like ?;";
                preparedStatement=this.conn.prepareStatement(sql);
                preparedStatement.setString(1, classNo);
                if(preparedStatement.executeUpdate()==0)
                     System.out.println("删除班级失败");
                else
                    System.out.println("删除班级成功...");
                preparedStatement.close();
                break;
            case 2:
                sql="delete from class where majorname like ?;";
                preparedStatement=this.conn.prepareStatement(sql);
                preparedStatement.setString(1, majorName);
                if(preparedStatement.executeUpdate()==0)
                     System.out.println("删除班级失败");
                else
                    System.out.println("删除班级成功...");
                preparedStatement.close();
                break;
            case 3:
                sql="delete from class where sys like ?;";
                preparedStatement=this.conn.prepareStatement(sql);
                preparedStatement.setString(1, Sys);
               if(preparedStatement.executeUpdate()==0)
                     System.out.println("删除班级失败");
                else
                    System.out.println("删除班级成功...");
                preparedStatement.close();
                break;
        
        }
    }catch(SQLException e){
        System.out.println(e.toString());
    
    }
    
    }
   
    
    
    void DeleteSociety(String unionNo,String unionName,String unionPlace,int choose){
    try{
        String sql;
        switch(choose){
            case 1:
                sql="delete from society where unionno like ?;";
                preparedStatement=this.conn.prepareStatement(sql);
                preparedStatement.setString(1, unionNo);
                if(preparedStatement.executeUpdate()==0)
                     System.out.println("删除学会失败");
                else
                    System.out.println("删除学会成功...");
                preparedStatement.close();
                break;
            case 2:
                sql="delete from society where unionname like ?;";
                preparedStatement=this.conn.prepareStatement(sql);
                preparedStatement.setString(1, unionName);
                 if(preparedStatement.executeUpdate()==0)
                     System.out.println("删除学会失败");
                else
                    System.out.println("删除学会成功...");
                preparedStatement.close();
                break;
            case 3:
                sql="delete from society where unionplace like ?;";
                preparedStatement=this.conn.prepareStatement(sql);
                preparedStatement.setString(1, unionPlace);
                if(preparedStatement.executeUpdate()==0)
                     System.out.println("删除学会失败");
                else
                    System.out.println("删除学会成功...");
                preparedStatement.close();
                break;
        
        }
    }
    catch(SQLException e){
     System.out.println(e.toString());
    }
    
    }
    
    
    void updateStudent(String sno,String sname,String age,String classno,int choose){
         try{
              String sql=null;
          switch(choose){
              case 1://学生姓名
                sql="update student set sname = ? where sno like ?";
                preparedStatement=conn.prepareStatement(sql);
                preparedStatement.setString(1, sname);
                preparedStatement.setString(2, sno);
                if(preparedStatement.executeUpdate()==0)
                    System.out.println("更改错误...");
                else
                    System.out.println("更改成功...");
                preparedStatement.close();
             break;//学生姓名
             
              case 2://学生出生年月
                sql="update student set age = ? where sno like ?";
                preparedStatement=conn.prepareStatement(sql);
                preparedStatement.setString(1, age);
                preparedStatement.setString(2, sno);
                if(preparedStatement.executeUpdate()==0)
                    System.out.println("更改错误...");
                else
                    System.out.println("更改成功...");
                preparedStatement.close();
                  break;//学生出生年月
                  
              case 3://学生班号
                sql="update student set classno = ? where sno like ?";
                preparedStatement=conn.prepareStatement(sql);
                preparedStatement.setString(1,classno);
                preparedStatement.setString(2, sno);
                if(preparedStatement.executeUpdate()==0)
                    System.out.println("更改错误...");
                else
                    System.out.println("更改成功...");
                preparedStatement.close();
                  break;//学生班号
              default:
                  System.out.println("请选择正确选项...");
                  
            /*  case 21://专业名称
                  break;//专业名称
              case 22://系别名称
                  break;//系别名称
              case 23://入校年份
                  break;//入校年份
                  
              case 31://系别名称
                  break;//系别名称
              case 32://系别办公地点
                  break;//系别办公地点
              case 33://系别住宿区
                  break;//系别住宿区
                  
              case 41://学会名称
                  break;//学会名称
              case 42://学会活动地点
                  break;//学会活动地点
              case 43://学会建立日期
                  break;//学会建立日期*/
        }
         }
        catch(SQLException e){
          System.out.println(e.toString());
        }
    }
    
    
     void updateClass(String majorname,String sys,String dataSchool,String classno,int choose){
         try{
          String sql=null;
          switch(choose){
              case 1://专业名
                sql="update class set majorname = ? where classno like ?";
                preparedStatement=conn.prepareStatement(sql);
                preparedStatement.setString(1, majorname);
                preparedStatement.setString(2, classno);
                if(preparedStatement.executeUpdate()==0)
                    System.out.println("更改错误...");
                else
                    System.out.println("更改成功...");
                preparedStatement.close();
             break;//专业名
             
              case 2://系名
               sql="update class set sys = ? where classno like ?";
                preparedStatement=conn.prepareStatement(sql);
                preparedStatement.setString(1, sys);
                preparedStatement.setString(2, classno);
                if(preparedStatement.executeUpdate()==0)
                    System.out.println("更改错误...");
                else
                    System.out.println("更改成功...");
                preparedStatement.close();
                  break;//系名
                  
              case 3://入校年份
                sql="update class set dataSchool = ? where classno like ?";
                preparedStatement=conn.prepareStatement(sql);
                preparedStatement.setString(1, dataSchool);
                preparedStatement.setString(2, classno);
                if(preparedStatement.executeUpdate()==0)
                    System.out.println("更改错误...");
                else
                    System.out.println("更改成功...");
                preparedStatement.close();
                  break;//入校年份
              default:
                  System.out.println("请选择正确选项...");
                  
            /*  case 21://专业名称
                  break;//专业名称
              case 22://系别名称
                  break;//系别名称
              case 23://入校年份
                  break;//入校年份
                  
              case 31://系别名称
                  break;//系别名称
              case 32://系别办公地点
                  break;//系别办公地点
              case 33://系别住宿区
                  break;//系别住宿区
                  
              case 41://学会名称
                  break;//学会名称
              case 42://学会活动地点
                  break;//学会活动地点
              case 43://学会建立日期
                  break;//学会建立日期*/
        }
         }
        catch(SQLException e){
          System.out.println(e.toString());
        }
    }
    
     
     
         
     void updateDepartment(String systemname,String systemoffice,String apartment,String systemno,int choose){
         try{
          String sql=null;
          switch(choose){
              case 1://系名
                sql="update department set systemname = ? where systemno like ?";
                preparedStatement=conn.prepareStatement(sql);
                preparedStatement.setString(1, systemname);
                preparedStatement.setString(2, systemno);
                if(preparedStatement.executeUpdate()==0)
                    System.out.println("更改错误...");
                else
                    System.out.println("更改成功...");
                preparedStatement.close();
             break;//系名
             
              case 2://系办公地点
                sql="update department set systemoffice = ? where systemno like ?";
                preparedStatement=conn.prepareStatement(sql);
                preparedStatement.setString(1, systemoffice);
                preparedStatement.setString(2, systemno);
                if(preparedStatement.executeUpdate()==0)
                    System.out.println("更改错误...");
                else
                    System.out.println("更改成功...");
                preparedStatement.close();
                  break;//系办公地点
                  
              case 3://系住宿区
                sql="update s_q set apartment = ? where systemname like ?";
                preparedStatement=conn.prepareStatement(sql);
                preparedStatement.setString(1, apartment);
                preparedStatement.setString(2, systemname);
                if(preparedStatement.executeUpdate()==0)
                    System.out.println("更改错误...");
                else
                    System.out.println("更改成功...");
                preparedStatement.close();
                  break;//系住宿区
              default:
                  System.out.println("请选择正确选项...");
                  
            /*  case 21://专业名称
                  break;//专业名称
              case 22://系别名称
                  break;//系别名称
              case 23://入校年份
                  break;//入校年份
                  
              case 31://系别名称
                  break;//系别名称
              case 32://系别办公地点
                  break;//系别办公地点
              case 33://系别住宿区
                  break;//系别住宿区
                  
              case 41://学会名称
                  break;//学会名称
              case 42://学会活动地点
                  break;//学会活动地点
              case 43://学会建立日期
                  break;//学会建立日期*/
        }
         }
        catch(SQLException e){
          System.out.println(e.toString());
        }
    }
     
    
     
     void updateSociety(String unionName,String dataUnion,String unionPlace,String unionNo,int choose){
         try{
          String sql=null;
          switch(choose){
              case 1://学会名
                sql="update society set unionname = ? where unionno like ?";
                preparedStatement=conn.prepareStatement(sql);
                preparedStatement.setString(1, unionName);
                preparedStatement.setString(2, unionNo);
                if(preparedStatement.executeUpdate()==0)
                    System.out.println("更改错误...");
                else
                    System.out.println("更改成功...");
                preparedStatement.close();
             break;//学会名
             
              case 2://学会建立日期
                sql="update society set dataunion = ? where unionno like ?";
                preparedStatement=conn.prepareStatement(sql);
                preparedStatement.setString(1, dataUnion);
                preparedStatement.setString(2, unionNo);
                if(preparedStatement.executeUpdate()==0)
                    System.out.println("更改错误...");
                else
                    System.out.println("更改成功...");
                preparedStatement.close();
                  break;//学会建立日期
                  
              case 3://学会活动区
                sql="update society set unionplace = ? where unionno like ?";
                preparedStatement=conn.prepareStatement(sql);
                preparedStatement.setString(1, unionPlace);
                preparedStatement.setString(2, unionNo);
                if(preparedStatement.executeUpdate()==0)
                    System.out.println("更改错误...");
                else
                    System.out.println("更改成功...");
                preparedStatement.close();
                  break;//学会活动区
              default:
                  System.out.println("请选择正确选项...");
                  
            /*  case 21://专业名称
                  break;//专业名称
              case 22://系别名称
                  break;//系别名称
              case 23://入校年份
                  break;//入校年份
                  
              case 31://系别名称
                  break;//系别名称
              case 32://系别办公地点
                  break;//系别办公地点
              case 33://系别住宿区
                  break;//系别住宿区
                  
              case 41://学会名称
                  break;//学会名称
              case 42://学会活动地点
                  break;//学会活动地点
              case 43://学会建立日期
                  break;//学会建立日期*/
        }
         }
        catch(SQLException e){
          System.out.println(e.toString());
        }
    }
     
     
    
    void close(){
     try{
            if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
    }
    
}

