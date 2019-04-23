package br.com.fatec.DAO;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class DAO<T> {
    private ArrayList<T> data = new ArrayList<>();
    
    public void add(T obj){
        data.add(obj);
    }
    
    public void remove(T obj) {
        data.remove(obj);
    }
    
    public void pretty(String nomeAtributo){
        for (T obj : data){
            String result = getValueByAtributeName(obj, nomeAtributo);
            System.out.println(nomeAtributo + ": " + result);
        }
    }
    
    public ArrayList<T> filter(String nomeAtributo, String valorEsperado){
        ArrayList<T> result = new ArrayList<>();
        for (T obj : this.data){
            String valorAtributo = getValueByAtributeName(obj, nomeAtributo);   
            if (valorAtributo != null && valorAtributo.equals(valorEsperado)){
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
            Method method = obj.getClass().getMethod("get" + capitalize(atributeName));
            return method.invoke(obj).toString();
        } catch (InvocationTargetException | NoSuchMethodException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
