package br.com.fatec.DAO;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO<T> {
    private ArrayList<T> data = new ArrayList<>();
    
    protected void add(T obj){
        data.add(obj);
    }
    
    protected void remove(T obj) {
        data.remove(obj);
    }
    
    protected void pretty(String nomeAtributo){
        for (T obj : data){
            String result = getValueByAtributeName(obj, nomeAtributo);
            System.out.println(nomeAtributo + ": " + result);
        }
    }
    
    protected List<T> getAll(){
        return data;
    }
    
    protected List<T> filter(String nomeAtributo, String valorEsperado){
        ArrayList<T> result = new ArrayList<>();
        for (T obj : this.data){
            String valorAtributo = getValueByAtributeName(obj, nomeAtributo);   
            if (valorAtributo != null && valorAtributo.toLowerCase().equals(valorEsperado.toLowerCase())){
                result.add(obj);
            }
        }
        return result;
    }
 
    private String capitalize(String str){
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
    }
    
    private String getValueByAtributeName(T obj, String atributeName){
        try{
            String getterName = "get" + capitalize(atributeName);
            Method method = obj.getClass().getMethod(getterName);
            Object result = method.invoke(obj);
            if (result != null)
                return result.toString();
            return null;
        } catch (InvocationTargetException | NoSuchMethodException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
