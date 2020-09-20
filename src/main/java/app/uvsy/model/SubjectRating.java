package app.uvsy.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGenerateStrategy;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedTimestamp;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@DynamoDBTable(tableName = "subjects-rating")
public class SubjectRating {

    @DynamoDBHashKey(attributeName = "subject_id")
    private String subjectId;

    @DynamoDBAttribute(attributeName = "ratings")
    private Map<String, Integer> ratings;

    @DynamoDBAttribute(attributeName = "updated_at")
    @DynamoDBAutoGeneratedTimestamp(strategy = DynamoDBAutoGenerateStrategy.ALWAYS)
    private Date updatedAt;

    @DynamoDBAttribute(attributeName = "created_at")
    @DynamoDBAutoGeneratedTimestamp(strategy = DynamoDBAutoGenerateStrategy.CREATE)
    private Date createdAt;

    public SubjectRating() {
        this.ratings = new HashMap<>();
    }

    public SubjectRating(String subjectId) {
        this();
        this.subjectId = subjectId;
    }
}