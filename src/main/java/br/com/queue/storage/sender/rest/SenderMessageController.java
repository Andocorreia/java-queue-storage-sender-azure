package br.com.queue.storage.sender.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SenderMessageController {

	@PostMapping("/sendMessage")
	public void sendMessage() {
		System.out.println("Enviando a mensagem");

	}
}
