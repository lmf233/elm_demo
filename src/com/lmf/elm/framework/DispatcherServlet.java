package com.lmf.elm.framework;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * 前端控制器，请求分发并返回json数据
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String path = req.getServletPath();
        String className = path.substring(1,path.lastIndexOf("/"));
        String methodName = path.substring(path.lastIndexOf("/")+1,path.lastIndexOf("?") == -1?path.length():path.lastIndexOf("?")+1);

        PrintWriter out = null;
//        HttpSession session = req.getSession();
        try{
            Class clazz = Class.forName("com.lmf.elm.controller."+className);
            Object controller = clazz.newInstance();
            Method method = clazz.getMethod(methodName,new Class[]{HttpServletRequest.class});
            Object result = method.invoke(controller,new Object[]{req});
            ObjectMapper om = new ObjectMapper();
//            session.setAttribute(className+methodName,om.writeValueAsString(result));
//            System.out.println(session.getAttribute("OrderTypeControllerfindOrderTypeList"));
            out = resp.getWriter();
            out.print(om.writeValueAsString(result));
//            System.out.println(om.writeValueAsString(result));
            System.out.println(className+":"+methodName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
