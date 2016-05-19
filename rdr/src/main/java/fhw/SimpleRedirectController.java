package fhw;

import java.io.IOException;
import java.util.Enumeration;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class SimpleRedirectController
{

    public SimpleRedirectController() {}

    @PostConstruct
    private void init()
    {

    }
    
    
    public void doSomethingAndRedirect()
            throws IOException
    {
        System.out.println("-----");
        System.out.println( " pretending that I am doing something and then redirecting");
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext(); 
        HttpServletRequest r = (HttpServletRequest)ec.getRequest();
        System.out.println("ec.getRequestServerName() : " +  ec.getRequestServerName());         
        System.out.println("r host server name " + r.getServerName());
        Enumeration<String> hnames = r.getHeaderNames(); 
        while(hnames.hasMoreElements())
        {
            String n = hnames.nextElement(); 
            System.out.format("Header Name:  [%s] value: [%s]\n",n, r.getHeader(n) );
        }
        System.out.println( "redirecting...");        
        System.out.println("-----");        
        ec.redirect("/rdr-4/error.xhtml");
    }


}
