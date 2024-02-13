package br.com.queue.storage.sender.rest;

import br.com.queue.storage.sender.dataprovider.Queue;
import br.com.queue.storage.sender.dataprovider.AzureQueueMessage;
import com.azure.storage.queue.QueueClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QueueController {

	@PostMapping("/createQueue")
	public void createQueue() {
		Queue createClient = new Queue();
		createClient.create();
	}

	@PostMapping("/sendMessage")
	public void sendMessage(@RequestBody final String message) {

		Queue createClient = new Queue();
		QueueClient queue = createClient.getQueue();

		AzureQueueMessage sendMessage = new AzureQueueMessage();
		sendMessage.send(queue, message);

	}

	@GetMapping("/peekMessage")
	public List<String> peekMessage() {

		Queue createClient = new Queue();
		QueueClient queue = createClient.getQueue();

		AzureQueueMessage sendMessage = new AzureQueueMessage();
		return sendMessage.peek(queue);

	}


}
