package messageboard.filters;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class AuthorFilterTest
{
    AuthorFilter filter;

    @Mock HttpSession session;
    @Mock HttpServletRequest request;
    @Mock FilterChain chain;

    @Before
    public void setup() {
        filter = new AuthorFilter();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldSetCurrentAuthor() throws Exception {
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("author")).thenReturn("Matte");

        filter.doFilter(request, null, chain);

        verify(session, times(1)).setAttribute("author", "Matte");
    }

    @Test
    public void shouldUpdateCurrentAuthor() throws Exception {
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("author")).thenReturn("Matte");
        when(session.getAttribute("author")).thenReturn("OtherDude");

        filter.doFilter(request, null, chain);

        verify(session, times(1)).setAttribute("author", "Matte");
    }

    @Test
    public void shouldNotUpdateNullAuthor() throws Exception {
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("author")).thenReturn(null);
        when(session.getAttribute("author")).thenReturn("OtherDude");

        filter.doFilter(request, null, chain);

        verify(session, never()).setAttribute(anyString(), anyString());
    }

}
