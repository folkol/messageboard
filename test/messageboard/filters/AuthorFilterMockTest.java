package messageboard.filters;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.Part;

import org.junit.Before;
import org.junit.Test;


public class AuthorFilterMockTest
{
    AuthorFilter filter;
    TestRequest request;
    FilterChain chain;

    @Before
    public void setup() {
        filter = new AuthorFilter();
        request = new TestRequest();
        chain = new TestChain();
    }

    @Test
    public void shouldSetCurrentAuthor() throws Exception {
        request.setParameter("author", "Matte");

        filter.doFilter(request, null, chain);

        assertEquals("Matte", request.getSession().getAttribute("author"));
    }

    @Test
    public void shouldUpdateCurrentAuthor() throws Exception {
        request.setParameter("author", "Matte");
        request.getSession().setAttribute("author", "OtherDude");

        filter.doFilter(request, null, chain);

        assertEquals("Matte", request.getSession().getAttribute("author"));
    }

    @Test
    public void shouldNotUpdateNullAuthor() throws Exception {
        request.setParameter("author", null);
        request.getSession().setAttribute("author", "Matte");

        filter.doFilter(request, null, chain);

        assertEquals("Matte", request.getSession().getAttribute("author"));
    }

    static class TestSession implements HttpSession {
        Map<String, Object> attributes = new HashMap<>();

        @Override
        public Object getAttribute(String key) {
            return attributes.get(key);
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getCreationTime() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public String getId() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getLastAccessedTime() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int getMaxInactiveInterval() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public ServletContext getServletContext() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public HttpSessionContext getSessionContext() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Object getValue(String arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String[] getValueNames() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void invalidate() {
            // TODO Auto-generated method stub

        }

        @Override
        public boolean isNew() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void putValue(String arg0, Object arg1) {
            // TODO Auto-generated method stub

        }

        @Override
        public void removeAttribute(String arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void removeValue(String arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void setAttribute(String key, Object val) {
            attributes.put(key, val);
        }

        @Override
        public void setMaxInactiveInterval(int arg0) {
            // TODO Auto-generated method stub

        }

    }
    static class TestRequest implements HttpServletRequest {

        TestSession session = new TestSession();
        Map<String, Object> parameters = new HashMap<>();

        @Override
        public AsyncContext getAsyncContext() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Object getAttribute(String arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getCharacterEncoding() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int getContentLength() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public String getContentType() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public DispatcherType getDispatcherType() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getLocalAddr() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getLocalName() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int getLocalPort() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public Locale getLocale() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Enumeration<Locale> getLocales() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getParameter(String arg0) {
            return (String) parameters.get(arg0);
        }

        public void setParameter(String key, String value) {
            parameters.put(key, value);
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Enumeration<String> getParameterNames() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String[] getParameterValues(String arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getProtocol() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public BufferedReader getReader() throws IOException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getRealPath(String arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getRemoteAddr() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getRemoteHost() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int getRemotePort() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public RequestDispatcher getRequestDispatcher(String arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getScheme() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getServerName() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int getServerPort() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public ServletContext getServletContext() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean isAsyncStarted() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isAsyncSupported() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isSecure() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void removeAttribute(String arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void setAttribute(String arg0, Object arg1) {
            // TODO Auto-generated method stub

        }

        @Override
        public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {
            // TODO Auto-generated method stub

        }

        @Override
        public AsyncContext startAsync() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean authenticate(HttpServletResponse arg0) throws IOException, ServletException {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public String getAuthType() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getContextPath() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Cookie[] getCookies() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getDateHeader(String arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public String getHeader(String arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Enumeration<String> getHeaderNames() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Enumeration<String> getHeaders(String arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int getIntHeader(String arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public String getMethod() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Part getPart(String arg0) throws IOException, IllegalStateException, ServletException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Collection<Part> getParts() throws IOException, IllegalStateException, ServletException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getPathInfo() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getPathTranslated() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getQueryString() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getRemoteUser() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getRequestURI() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public StringBuffer getRequestURL() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getRequestedSessionId() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getServletPath() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public HttpSession getSession() {
            return session;
        }

        @Override
        public HttpSession getSession(boolean arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Principal getUserPrincipal() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean isRequestedSessionIdFromCookie() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isRequestedSessionIdFromURL() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isRequestedSessionIdFromUrl() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isRequestedSessionIdValid() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isUserInRole(String arg0) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void login(String arg0, String arg1) throws ServletException {
            // TODO Auto-generated method stub

        }

        @Override
        public void logout() throws ServletException {
            // TODO Auto-generated method stub

        }
    }

    static class TestChain implements FilterChain {
        @Override
        public void doFilter(ServletRequest req, ServletResponse resp)
            throws IOException, ServletException
        {
        }
    }

}
