package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class Filter1
 */
@WebFilter(urlPatterns = { "/*" }, initParams = { @WebInitParam(name = "cc", value = "dd") })
public class Filter2 implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy of " + getClass().getName());
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// pre processing
		System.out.println("pre processing done by " + getClass().getName());
		// place your code here

		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("post processing done by " + getClass().getName());
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		System.out.println("in init of " + getClass().getName());
		System.out
				.println("init param value " + fConfig.getInitParameter("cc"));

	}

}
