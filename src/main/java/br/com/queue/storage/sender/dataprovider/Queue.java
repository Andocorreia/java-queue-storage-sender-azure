package br.com.queue.storage.sender.dataprovider;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.storage.queue.QueueClient;
import com.azure.storage.queue.QueueClientBuilder;

public class Queue {

	private static String QUEUE = "queueteste";
	private static String URIQUEUE = "https://saqueuestoragetr.queue.core.windows.net/";


	public void create() {

		System.out.println("Azure Queue Storage client library - Create Queue: " + QUEUE);

		QueueClient queueClient = new QueueClientBuilder()
				.endpoint(URIQUEUE)
				.queueName(QUEUE)
				.credential(new DefaultAzureCredentialBuilder().build())
				.buildClient();

		queueClient.create();
	}

	public QueueClient getQueue() {

		System.out.println("Azure Queue Storage client library - Get Queue: " + QUEUE);

		return new QueueClientBuilder()
				.endpoint(URIQUEUE)
				.queueName(QUEUE)
				.credential(new DefaultAzureCredentialBuilder().build())
				.buildClient();
	}
}
