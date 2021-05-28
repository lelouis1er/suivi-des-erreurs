/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtres;

import entities.User;
import java.io.IOException;
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

/**
 *
 * @author Arianne
 */
@WebFilter(filterName = "filterEmploye", urlPatterns = {"/employe/*"})
public class FilterEmploye implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        if (session.getAttribute("user") != null) {

            User usr = ((User) session.getAttribute("user"));
            if (usr.getType().equals("employe")) {
                chain.doFilter(request, response);
            } else {
                servletResponse.sendRedirect(servletRequest.getContextPath() + "/index.xhtml");
            }

        } else {
            servletResponse.sendRedirect(servletRequest.getContextPath() + "/index.xhtml");
        }

    }

    @Override
    public void destroy() {

    }

}
