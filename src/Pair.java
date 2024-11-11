import java.util.Objects;

public class Pair<K, V> {
    public K key;
    public V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    public int hashCode() {
        return Objects.hash(key, value);
    }
}
