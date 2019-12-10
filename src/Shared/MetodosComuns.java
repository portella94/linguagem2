package Shared;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MetodosComuns {

    public static String converterSenha(String senha) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {

        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigestSenhaAdmin[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexStringSenhaAdmin = new StringBuilder();
        for (byte b : messageDigestSenhaAdmin) {
            hexStringSenhaAdmin.append(String.format("%02X", 0xFF & b));
        }
        return hexStringSenhaAdmin.toString();
    }

    public static boolean compararSenha(String senhaDigitada, String senhaBanco) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {

        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigestSenhaAdmin[] = algorithm.digest(senhaDigitada.getBytes("UTF-8"));

        StringBuilder hexStringSenhaAdmin = new StringBuilder();
        for (byte b : messageDigestSenhaAdmin) {
            hexStringSenhaAdmin.append(String.format("%02X", 0xFF & b));
        }
        senhaDigitada = hexStringSenhaAdmin.toString();
        return senhaBanco.equals(senhaDigitada);
    }

}
