package br.com.queue.storage.sender.dataprovider;

import com.azure.storage.queue.QueueClient;

import java.util.List;
import java.util.stream.Collectors;

public class AzureQueueMessage {

	public void send(QueueClient queueClient, String message){
		System.out.println("Adding messages to the queue..." + queueClient.getQueueName());

		// Send several messages to the queue
		queueClient.sendMessage(message);
	}

	public List<String> peek(QueueClient queueClient){
		System.out.println("Peek at the messages in the queue..." + queueClient.getQueueName());

		// Peek at messages in the queue
		return queueClient.peekMessages(10, null, null).stream()
				.map(peekedMessageItem -> peekedMessageItem.getBody().toString()).collect(Collectors.toList());

	}
}
