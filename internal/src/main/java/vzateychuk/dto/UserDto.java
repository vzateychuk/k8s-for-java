package vzateychuk.dto;

import java.io.Serializable;

public class UserDto  implements Serializable {
    private Long id;
    private String username;
    private int amountOfPosts;

    public UserDto() {}

    public UserDto(Long id, String username, int amountOfPosts) {
        this.id = id;
        this.username = username;
        this.amountOfPosts = amountOfPosts;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public int getAmountOfPosts() {
        return this.amountOfPosts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAmountOfPosts(int amountOfPosts) {
        this.amountOfPosts = amountOfPosts;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserDto)) return false;
        final UserDto other = (UserDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        if (this.getAmountOfPosts() != other.getAmountOfPosts()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        result = result * PRIME + this.getAmountOfPosts();
        return result;
    }

    public String toString() {
        return "UserDto(id=" + this.getId() + ", username=" + this.getUsername() + ", amountOfPosts=" + this.getAmountOfPosts() + ")";
    }
}
