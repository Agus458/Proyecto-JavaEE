package filters;

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

import web_service.DataAdmin;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("/AdminFilter")
public class AdminFilter implements Filter {


	
    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@SuppressWarnings("unused")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        if (session!=null&&session.getAttribute("usuario")!=null) {     
            try {
				DataAdmin admin = (DataAdmin) session.getAttribute("usuario");
	        	chain.doFilter(request, response);

			} catch (Exception e) {
	            res.sendRedirect(req.getContextPath() + "/index.xhtml");
			}

        }
       
        else {
            res.sendRedirect(req.getContextPath() + "/index.xhtml");
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
