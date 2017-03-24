package xyz.cafeconleche.web.aws.app.config;

import org.socialsignin.spring.data.dynamodb.core.DynamoDBOperations;
import org.socialsignin.spring.data.dynamodb.core.DynamoDBTemplate;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Configuration
@EnableDynamoDBRepositories(basePackages={"xyz.cafeconleche.web.aws.dao.**"}, dynamoDBOperationsRef="dynamoDBOperations" )
public class SpringDynamoDBConfig {

	@Value("${amazon.dynamodb.endpoint}")
	private String amazonDynamoDBEndpoint;
	
	@Value("${amazon.dynamodb.accesskey}")
	private String amazonAWSAccessKey;
	
	@Value("${amazon.dynamodb.secretkey}")
	private String amazonAWSSecretKey;
	
	@Value("${amazon.dynamodb.region}")
	private String amazonDynamoDBRegion;
	
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		
		EndpointConfiguration endpointConfiguration = new EndpointConfiguration(amazonDynamoDBEndpoint, amazonDynamoDBRegion);
		
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(endpointConfiguration)
				.build();
		
		return client;
	}
	
	@Bean
	public AWSCredentials awsCredentials() {
		return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
	}
	
	@Bean
	public DynamoDBOperations dynamoDBOperations() {
		
		final DynamoDBTemplate template = new DynamoDBTemplate(amazonDynamoDB());
		return template;
	}
	
}
