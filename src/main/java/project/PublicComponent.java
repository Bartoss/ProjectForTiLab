package project;

import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.*;

/**
 * Created by Bartus on 25.05.2017.
 */
public class PublicComponent extends CustomComponent {

    public PublicComponent() {
        TextField username = new TextField("Username");
        username.focus();

        PasswordField password = new PasswordField("Password");

        CheckBox rememberMe = new CheckBox("Remember me");

        Button button = new Button("Login", e -> onLogin(username.getValue(), password.getValue(), rememberMe.getValue()));
        button.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        FormLayout formLayout = new FormLayout(username, password, button, rememberMe);
        formLayout.setSizeUndefined();

        VerticalLayout layout = new VerticalLayout(formLayout);
        layout.setSizeFull();
        layout.setComponentAlignment(formLayout, Alignment.MIDDLE_CENTER);

        setCompositionRoot(layout);
        setSizeFull();
    }

    private void onLogin(String username, String password, boolean rememberMe) {
        if (AuthService.login(username, password, rememberMe)) {
            VaadinUI ui = (VaadinUI) UI.getCurrent();
            ui.showPrivateComponent();
        } else {
            Notification.show("Invalid credentials (for demo use: admin/password)", Notification.Type.ERROR_MESSAGE);
        }
    }

}
