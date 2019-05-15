package pl.qceyco.web.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private String charsetEncoding;
    private String contentType;


    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(charsetEncoding);
        resp.setCharacterEncoding(charsetEncoding);
        resp.setContentType(contentType);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        String charsetEncoding = config.getInitParameter("charsetEncoding");
        String contentType = config.getInitParameter("contentType");
        if (StringUtils.isNotBlank(charsetEncoding) && StringUtils.isNotBlank(contentType)) {
            this.charsetEncoding = charsetEncoding;
            this.contentType = contentType;
        }
    }

}
