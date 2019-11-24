package two.x.two.repository.entry;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class Word {

    @MongoId
    UUID id = UUID.randomUUID();

    String tag;
    List<String> namePart = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<String> getNamePart() {
        return namePart;
    }

    public void setNamePart(List<String> namePart) {
        this.namePart = namePart;
    }

    public void addNamePart(String namePart) {
        this.namePart.add(namePart);
    }
}
