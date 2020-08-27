package org.infostroy.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter check user authentication
 */
@WebFilter(filterName = "loginFilter",
        urlPatterns = {"/views/login.xhtml", "/views/loginfailed.xhtml"})
public class LogInFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * Redirect user to members.xhtml if has active session
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            response.sendRedirect(request.getContextPath() + "/views/members.xhtml");
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
