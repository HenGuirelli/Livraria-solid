package br.com.fatec.DNS;

import br.com.fatec.view.fragment.HomeFragment;
import br.com.fatec.view.fragment.LoginFragment;
import br.com.fatec.view.fragment.NotFoundFragment;
import java.util.HashMap;
import javax.swing.JPanel;

public class DNS {
    private HashMap<String, JPanel> map = new HashMap<>();

    public DNS(){
        map.put("/", new HomeFragment());
        map.put("/home", new HomeFragment());
        map.put("/login", new LoginFragment());
    }
    
    public JPanel getPanel(String route) {
        try {
            return map.get(route);
        }catch (Exception ex){
            return new NotFoundFragment();
        }
    }
}
