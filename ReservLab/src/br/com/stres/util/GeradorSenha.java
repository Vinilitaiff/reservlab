package br.com.stres.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeradorSenha {
	
	private static GeradorSenha geradorSenha;
	
	public String encriptar(String senha) throws NoSuchAlgorithmException
    {
        if (senha.length()==0)
        {
            return null;
        }
        else
        {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(senha.getBytes());
            byte[] hash = md.digest();
            StringBuffer senhaEncrip = new StringBuffer();
            for (int i=0;i<hash.length;i++)
            {
                senhaEncrip.append(Integer.toHexString(hash[i]&0xff));
            }
            return senhaEncrip.toString();
        }
    }
	
	public static GeradorSenha getInstance(){
	 	if (geradorSenha==null) {
	 		geradorSenha = new GeradorSenha();
	 	}
	 	return geradorSenha;
	 }
	
	/*
	public String encrypt(String pText) {
		BasicPasswordEncryptor passwordEncript = new BasicPasswordEncryptor();
		return passwordEncript.encryptPassword(pText);
	}
	
	public boolean checkEncrypted(String pText, String encryptedText) {
		BasicPasswordEncryptor passwordEncript = new BasicPasswordEncryptor();
		return passwordEncript.checkPassword(pText, encryptedText);
	}
	*/		

	public static void main(String[] args) {
		GeradorSenha gerador = GeradorSenha.getInstance();
		String senha = "mmv123@";
		try {
			String senhaEncriptada = gerador.encriptar(senha);
			System.out.println("Senha : " + senha + " / Encriptada = " + senhaEncriptada);
			// c2e3c9865495ed86e648c40673d2972d2842759
			if (gerador.encriptar(senha).equals("c2e3c9865495ed86e648c40673d2972d2842759")) {
				System.out.println("SEnha ok");
			}else {System.out.println("SEnha não confere");}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
