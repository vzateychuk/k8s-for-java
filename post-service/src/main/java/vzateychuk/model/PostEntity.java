package vzateychuk.model;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@ToString
@Entity
@Table(name = "posts")
public class PostEntity {

    private @Id @GeneratedValue Long id;
    private long authorId;
    private String text;
    private LocalDate postedAt;
    private String topic;

    public PostEntity() {}

    public PostEntity(Long id, long authorId, String text, LocalDate postedAt, String topic) {
        this.id = id;
        this.authorId = authorId;
        this.text = text;
        this.postedAt = postedAt;
        this.topic = topic;
    }

    public Long getId() {
        return this.id;
    }

    public long getAuthorId() {
        return this.authorId;
    }

    public String getText() {
        return this.text;
    }

    public LocalDate getPostedAt() {
        return this.postedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPostedAt(LocalDate postedAt) {
        this.postedAt = postedAt;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PostEntity)) return false;
        final PostEntity other = (PostEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        if (this.getAuthorId() != other.getAuthorId()) return false;
        final Object this$text = this.getText();
        final Object other$text = other.getText();
        if (this$text == null ? other$text != null : !this$text.equals(other$text)) return false;
        final Object this$postedAt = this.getPostedAt();
        final Object other$postedAt = other.getPostedAt();
        if (this$postedAt == null ? other$postedAt != null : !this$postedAt.equals(other$postedAt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PostEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final long $authorId = this.getAuthorId();
        result = result * PRIME + (int) ($authorId >>> 32 ^ $authorId);
        final Object $text = this.getText();
        result = result * PRIME + ($text == null ? 43 : $text.hashCode());
        final Object $postedAt = this.getPostedAt();
        result = result * PRIME + ($postedAt == null ? 43 : $postedAt.hashCode());
        return result;
    }
}
