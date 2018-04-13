package com.web.common;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/03/21.
 */
@SuppressWarnings("serial")
public abstract class BaseServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        //获取方法名称
        String methodname =req.getParameter("method");
        if( methodname == null || methodname.trim().isEmpty()){
            throw new RuntimeException("没有传递method参数，没有调用函数");
        }
        Class c = this.getClass();
        Method Method =null;

        //调用方法
        try {
            JdbcUtils.beginTransaction();
            Method= c.getMethod(methodname,HttpServletRequest.class,HttpServletResponse.class);
        }catch (Exception e ){

            throw  new  RuntimeException("你要调用的方法"+methodname+"不存在");
        }
         try {
             String result =(String) Method.invoke(this,req,res);

             if (result==null || result.trim().isEmpty()){
                 return ;
             }
             if (result.contains(":")){
                int index =result.indexOf(":");
                 String s =result.substring(0,index);
                 String path =result.substring(index+1);
                 if (s.equalsIgnoreCase("f") ){


                     RequestDispatcher rd = req.getRequestDispatcher(path);
                     rd.forward(req ,res);
                     JdbcUtils.commitTransaction();
                 }else if(s.equalsIgnoreCase("r")){

                        res.sendRedirect(req.getContextPath()+path);
                       JdbcUtils.commitTransaction();
                 }else{


                         JdbcUtils.rollbackTransaction();
                     throw new  RuntimeException("指定操作："+s+"不支持");

                 }

             }else{



                    req.getRequestDispatcher(result).forward(req ,res);
                 JdbcUtils.commitTransaction();
             }
         }catch (Exception e){
                try {
                    JdbcUtils.rollbackTransaction();
                }catch ( Exception es){
                    throw  new RuntimeException("方法"+methodname+"数据回滚有异常/"+es.toString());

                }
              throw  new RuntimeException("方法"+methodname+"内部有异常/"+e.toString());
         }

    }



}
