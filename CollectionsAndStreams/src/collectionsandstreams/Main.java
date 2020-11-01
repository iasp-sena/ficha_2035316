/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionsandstreams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Ismael
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario u = new Usuario(1L,"Carlos");
        Usuario u2 = new Usuario(1L,"Carlos3");
        
        List<Usuario> miLista = new ArrayList<>();
        miLista.add(u);
        miLista.add(u);
        miLista.add(u);
        miLista.add(u);
        miLista.add(u);
        miLista.remove(0);
        List<Usuario> otraLista = miLista.subList(1, 2);
        
        for(Usuario obj: miLista){
            System.out.println(obj);
        }
        
        //miLista.forEach(obj -> System.out.println(obj));
        System.out.println("*************************");
        
        for(Usuario obj: otraLista){
            System.out.println(obj);
        }
        
        System.out.println("##########################################################");
        
        
        Set<Usuario> miSet = new HashSet<>();
        miSet.add(u);
        miSet.add(u2);
        //miSet.remove(u);
        
        for(Usuario obj: miSet){
            System.out.println(obj);
        }
        
        System.out.println("##########################################################");
        
        Map<String, Usuario> miMap = new HashMap<>();
        miMap.put("C", u);
        miMap.put("C2", u);
        
        miMap.forEach((k,v) -> System.out.println(k + " - " + v));
        
        for(String key: miMap.keySet()){
            System.out.println(miMap.get(key));
        }
        
    }
    
}
