package messageboard.filters;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public class AuthorFilter implements Filter {

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        String currentAuthor = (String) session.getAttribute("author");
        String author = request.getParameter("author");
        if(author != null && !Objects.equals(currentAuthor, author)) {
            session.setAttribute("author", author);
        }
        chain.doFilter(request, response);
    }

	@Override
	public void destroy() {
	}

}
