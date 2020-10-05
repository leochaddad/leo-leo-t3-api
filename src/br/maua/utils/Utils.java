package br.maua.utils;

public class Utils {

    public static boolean validadeText(String text){
        return text.matches("^[a-zA-Z0-9 -]*$");
    }
    public static boolean validateOption(String option){
        try{
            int res = Integer.parseInt(option);
            return (res>=0 && res<4);
        }
        catch (Exception e){
            return false;
        }

    }
}
