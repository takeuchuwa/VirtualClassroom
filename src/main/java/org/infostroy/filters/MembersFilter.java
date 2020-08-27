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
@WebFilter(filterName = "membersFilter",
        urlPatterns = {"/views/members.xhtml"})
public class MembersFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * Redirect user to login.xhtml if hasn't active session
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);

        // если сессия не была, или у сессии отсутствует атрибут user, перенаправляем пользователя на страницу с логином
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/views/login.xhtml");
        }
        // отдаем запрос дальше в цепочку фильтров
        filterChain.doFilter(request, response);


    }

    @Override
    public void destroy() {

    }

}
