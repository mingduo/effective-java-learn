package effectivejava;

import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author : weizc
 * @description:
 * @since 2019/7/30
 */
public class HashCodeDemo {

    public static void main(String[] args) {

        diffEqualsAndHashCode("abc", new String("abc"));

        Map<String, String> map = new HashMap<>();
        map.put("key", "value");

        System.out.println("use HashMap");

        System.out.println(map.get("key"));
        System.out.println(map.get(new Key("key")));
        System.out.println(map.get(new GuavaKey("key")));

        System.out.println("use ImmutableCollections.Map1");

        map=Map.of("key","v");
        System.out.println(map.get("key"));
        System.out.println(map.get(new Key("key")));
        System.out.println(map.get(new GuavaKey("key")));


        diffEqualsAndHashCode("key", new Key("key"));

        diffEqualsAndHashCode("key", new GuavaKey("key"));


    }

    private static void diffEqualsAndHashCode(Object source, Object that) {
        System.out.printf("%s hashcode = %d , %s hashcode = %d is equals : %s \n",
                source, source.hashCode(), that, that.hashCode(), (source.hashCode() == that.hashCode()));
        System.out.printf("%s,%s is equals : %s \n",
                source, that, that.equals(source));
        System.out.printf("%s,%s is == : %s \n",
                source, that, that == source);
    }


}

@AllArgsConstructor
class Key {
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof String) return String.valueOf(o).equals(name);
        Key key = (Key) o;
        return Objects.equals(name, key.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

@AllArgsConstructor
class GuavaKey {

    static HashFunction hashFunction = Hashing.murmur3_32();

    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof String) return String.valueOf(o).equals(name);
        Key key = (Key) o;
        return Objects.equals(name, key.name);
    }

    @Override
    public int hashCode() {
        Hasher hasher = hashFunction.newHasher().putString(this.name, Charsets.UTF_8);
        return hasher.hash().asInt();
    }
}