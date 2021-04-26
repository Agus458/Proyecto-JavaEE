package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;

@ManagedBean
@ViewScoped
public class Bean implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> values;

    @PostConstruct
    public void init() {
        values = new ArrayList<String>();
        values.add("");
        values.add("");
        values.add("");
        values.add("");
        values.add("");
        values.add("");
        values.add("");
    }

    public void submit() {
        // save values in database
    }

    public void extend(AjaxBehaviorEvent e) {
    	System.out.println("oisdgjoi");
        values.add("");
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public List<String> getValues() {
        return values;
    }
}