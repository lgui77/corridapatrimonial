package com.github.awvalenti.corridapatrimonial.cliente;

import java.io.IOException;
import java.net.Socket;

public class ConectorDoClienteComServidor {

	private String enderecoIpServidor;
	private int portaServidor;

	public ConectorDoClienteComServidor(String enderecoIpServidor, int portaServidor) {
		this.enderecoIpServidor = enderecoIpServidor;
		this.portaServidor = portaServidor;
	}

	public void enviarLinhaComando(String linhaComando) throws IOException {
		Socket socket = new Socket(enderecoIpServidor, portaServidor);
		new SaidaParaServidorViaOutputStream(socket.getOutputStream()).enviarLinhaComando(linhaComando);
		socket.close();
	}
}