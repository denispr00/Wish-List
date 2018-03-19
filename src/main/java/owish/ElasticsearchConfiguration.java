package owish;

//@Configuration
public class ElasticsearchConfiguration {

	/*@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		return new ElasticsearchTemplate(client());
	}
	
	@Bean
	public Client client() {
		// TransportClient client = new TransportClient();
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
		TransportAddress address = new InetSocketTransportAddress("localhost", 9200);
		client.addTransportAddress(address);
		return client;
	}*/

}
