/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtres;

import java.io.IOException;
import static java.rmi.server.LogStream.log;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entities.User;

/**
 *
 * @author Arianne
 */
@WebFilter(filterName = "filterIndex", urlPatterns = {"/index.xhtml"})
public class FilterIndex implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        
        if(request.getParameter("logout")!=null){
            session.setAttribute("user", null);
        }
        
        if(request.getParameter("faces-redirect") == "true"){
            servletResponse.sendRedirect(request.getContentType() + "/index.xhtml");
        }

        if (session.getAttribute("user") != null) {

            User usr = ((User) session.getAttribute("user"));

            if (usr.getType().equals("employe")) {
                servletResponse.sendRedirect(servletRequest.getContextPath() + "/employe");
            } else if (usr.getType().equals("admin")) {
                servletResponse.sendRedirect(servletRequest.getContextPath() + "/admin");
            } else {
                servletResponse.sendRedirect(servletRequest.getContextPath() + "/index.xhtml");
            }

        } else {
            /*servletResponse.sendRedirect(servletRequest.getContextPath() + "/index.xhtml");*/
            chain.doFilter(request, response);
        }
        
        if(servletRequest.getParameter("faces-redirect")=="true"){
            
        }
    }

    @Override
    public void destroy() {

    }

}
