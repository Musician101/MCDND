package io.musician101.mcdnd.sponge.data.key;

import com.google.common.base.Objects;
import io.musician101.mcdnd.sponge.data.value.mutable.ListListValue;
import io.musician101.mcdnd.sponge.data.value.mutable.ListMapValue;
import io.musician101.mcdnd.sponge.data.value.mutable.MapListValue;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.key.Key;

@SuppressWarnings({"rawtypes", "unchecked"})
public class MCDNDKeyFactory {

    private MCDNDKeyFactory() {

    }

    public static <E> Key<ListListValue<E>> makeListListKey(final Class<E> valueClass, final DataQuery query) {
        return new Key<ListListValue<E>>() {

            private final int hash = Objects.hashCode(valueClass, valueClass, query);

            @Override
            public DataQuery getQuery() {
                return query;
            }

            @Override
            public Class<ListListValue<E>> getValueClass() {
                return (Class<ListListValue<E>>) (Class) MapListValue.class;
            }

            @Override
            public int hashCode() {
                return hash;
            }

            @Override
            public String toString() {
                return "Key{Value:ListListValue<" + valueClass.getSimpleName() + ">, Query: " + query.toString() + "}";
            }
        };
    }

    public static <E, V> Key<ListMapValue<E, V>> makeListMapKey(final Class<E> listKeyClass, final Class<V> valueClass, final DataQuery query) {
        return new Key<ListMapValue<E, V>>() {

            private final int hash = Objects.hashCode(listKeyClass, valueClass, query);

            @Override
            public DataQuery getQuery() {
                return query;
            }

            @Override
            public Class<ListMapValue<E, V>> getValueClass() {
                return (Class<ListMapValue<E, V>>) (Class) MapListValue.class;
            }

            @Override
            public int hashCode() {
                return hash;
            }

            @Override
            public String toString() {
                return "Key{Value:ListMapValue<" + listKeyClass.getSimpleName() + "," + valueClass.getSimpleName() + ">, Query: " + query.toString() + "}";
            }
        };
    }

    public static <K, E> Key<MapListValue<K, E>> makeMapListKey(final Class<K> keyClass, final Class<E> listValueClass, final DataQuery query) {
        return new Key<MapListValue<K, E>>() {

            private final int hash = Objects.hashCode(keyClass, listValueClass, query);

            @Override
            public DataQuery getQuery() {
                return query;
            }

            @Override
            public Class<MapListValue<K, E>> getValueClass() {
                return (Class<MapListValue<K, E>>) (Class) MapListValue.class;
            }

            @Override
            public int hashCode() {
                return hash;
            }

            @Override
            public String toString() {
                return "Key{Value:MapListValue<" + keyClass.getSimpleName() + "," + listValueClass.getSimpleName() + ">, Query: " + query.toString() + "}";
            }
        };
    }
}
