package vzateychuk.dto;

import java.time.LocalDate;

public class PostDto {
    private Long id;
    private long authorId;
    private String text;
    private LocalDate postedAt;

    public PostDto() {
    }

    public PostDto(Long id, long authorId, String text, LocalDate postedAt) {
        this.id = id;
        this.authorId = authorId;
        this.text = text;
        this.postedAt = postedAt;
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PostDto)) return false;
        final PostDto other = (PostDto) o;
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
        return other instanceof PostDto;
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
