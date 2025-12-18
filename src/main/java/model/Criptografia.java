package model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
    
    public static final String SHA256 = "SHA-256";
    public static final String MD5 = "MD5";
    
    private String informacaoOriginal;
    private String padrao;
    private String hashResultante; // Adicione este campo
    
    public Criptografia(String informacao, String padrao) {
        this.informacaoOriginal = informacao;
        this.padrao = padrao;
        this.hashResultante = criptografar(); 
    }
    
    public String getHash() {
        return hashResultante;
    }
    
    public String getInformacao() {
        return hashResultante; 
    }
    
    public String getInformacaoOriginal() {
        return informacaoOriginal;
    }
    
    public void setInformacao(String informacao) {
        this.informacaoOriginal = informacao;
        this.hashResultante = criptografar(); 
    }
    
    public String getPadrao() {
        return padrao;
    }
    
    public void setPadrao(String padrao) {
        this.padrao = padrao;
    }
    
    private String criptografar() {
        String informacao = this.informacaoOriginal;
        MessageDigest messageDigest;
        StringBuilder hexString = null;
        
        try {
            messageDigest = MessageDigest.getInstance(getPadrao());
            byte[] hash = messageDigest.digest(
                informacao.getBytes(StandardCharsets.UTF_8));
            hexString = new StringBuilder(2 * hash.length);
            
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append("0");
                }
                hexString.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        
        return hexString.toString().toUpperCase();
    }
    
    public static String gerarHash(String texto, String algoritmo) {
        Criptografia cripto = new Criptografia(texto, algoritmo);
        return cripto.getHash();
    }
    
    public static boolean verificarSenha(String senhaDigitada, String hashArmazenado, String algoritmo) {
        String hashDigitado = gerarHash(senhaDigitada, algoritmo);
        return hashDigitado.equals(hashArmazenado);
    }
}
