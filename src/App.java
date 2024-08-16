import UserInterface.Form.CJLoginPanel;
import UserInterface.Form.CJSplash;

public class App {
    public static void main(String[] args) throws Exception {
        CJSplash.show();
        CJLoginPanel loginForm = new CJLoginPanel();
        loginForm.setVisible(true);
    }
}
