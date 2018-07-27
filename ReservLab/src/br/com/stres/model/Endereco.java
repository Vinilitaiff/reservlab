package br.com.stres.model;

import javax.persistence.Embeddable;


@Embeddable
public class Endereco {
   private String endereco;
   private int numero;
   
   private String bairro;
   private String cep;
   private String cidade;
   
   
	public String getEndereco() {
	      return endereco;
    }
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
		public int getNumero() {
			return numero;
		}
		public void setNumero(int numero) {
			this.numero = numero;
		}
	
		public String getBairro() {
			return bairro;
		}
		public void setBairro(String bairro) {
			this.bairro = bairro;
		}
		public String getCep() {
			return cep;
		}
		public void setCep(String cep) {
			this.cep = cep;
		}
		public String getCidade() {
			return cidade;
		}
		public void setCidade(String cidade) {
			this.cidade = cidade;
		}		   
   
   
}
