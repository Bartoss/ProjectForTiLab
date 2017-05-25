package project;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;

/**
 * Created by Bartus on 25.05.2017.
 */
public class VaadinUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        if (!AuthService.isAuthenticated()) {
            showPublicComponent();
        } else {
            showPrivateComponent();
        }
    }

    public void showPublicComponent() {
        setContent(new PublicComponent());
    }

    public void showPrivateComponent() {
        setContent(new PrivateComponent());
    }
}
