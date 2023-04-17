package vzateychuk.map;

public interface Mapper<T, R> {

    R toDto(T t);

    T toEntity(R r);
}
