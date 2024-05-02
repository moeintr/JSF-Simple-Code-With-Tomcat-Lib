package bean;

import javax.faces.bean.*;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

@ManagedBean//(name = "x")
@SessionScoped  //90 %
//@ViewScoped  // per load page with ajax
//@RequestScoped  // per request
//@ApplicationScoped  // singleton shared to all
public class IndexBean implements Serializable {
    private HtmlInputText name;
    private HtmlInputText family;
    private String message;

    public HtmlInputText getName() {
        return name;
    }

    public void setName(HtmlInputText name) {
        this.name = name;
    }

    public HtmlInputText getFamily() {
        return family;
    }

    public void setFamily(HtmlInputText family) {
        this.family = family;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void execute1( )
    {
        synchronized (this) {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        }

        message = name.getValue()+" "+family.getValue();
        name.setDir("rtl");
        name.setDisabled(true);
        family.setOnclick("alert('salam')");
    }

}
