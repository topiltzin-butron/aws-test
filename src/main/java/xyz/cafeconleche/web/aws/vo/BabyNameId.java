package xyz.cafeconleche.web.aws.vo;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

public class BabyNameId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@DynamoDBHashKey
	private Integer id;
	
	@DynamoDBRangeKey
	private String name;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "id: " + id + ", name: " + name;
	}
}
