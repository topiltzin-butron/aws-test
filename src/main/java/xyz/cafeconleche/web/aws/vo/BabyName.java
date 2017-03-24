package xyz.cafeconleche.web.aws.vo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "BabyNames")
public class BabyName implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private BabyNameId babyNameId;
	@DynamoDBAttribute
	private String gender;
	@DynamoDBAttribute
	private String meaning;
	@DynamoDBAttribute
	private String origin;

	@DynamoDBHashKey(attributeName = "id")
	public Integer getId() {
		return babyNameId != null ? babyNameId.getId() : null;
	}

	public void setId(Integer id) {
		if (babyNameId == null) {
			babyNameId = new BabyNameId();
		}

		babyNameId.setId(id);
	}

	@DynamoDBRangeKey(attributeName = "name")
	public String getName() {
		return babyNameId != null ? babyNameId.getName() : null;
	}

	public void setName(String name) {
		if (babyNameId == null) {
			babyNameId = new BabyNameId();
		}
		babyNameId.setName(name);
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		return babyNameId + ", gender: " + gender + ", meaning: " + meaning + ", origin: " + origin;
	}

}
