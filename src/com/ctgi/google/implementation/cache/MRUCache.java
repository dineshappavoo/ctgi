/**
 * 
 */
package com.ctgi.google.implementation.cache;

/**
 * @author Dany
 *
 */


import java.util.Map;
import java.util.LinkedHashMap;

/**
* MRU cache based on Linked Hash Map
*
*/
public abstract class MRUCache<K, V> {
    private final Map<K, V> cache;

    /**
     *
     * @param cacheSize cache size
     */
    public MRUCache ( int cacheSize ) {
        this .cache = new CacheLinkedHashMap<K, V> ( cacheSize ) ;        
    }

    /**
     * Get a value from the cache by a key. if the key is not in the cache the value will be retrieved using the
     * getValue method, then the value will be added to the cache
     *
     * @param key to look for in the chache
     * @return value from the cache
     */
    public V getValueFromCache ( K key ) {
        V value;
        synchronized ( this ) {
            value = cache.get ( key ) ;
        }
        if ( value == null ) {
            value = getValue ( key ) ;
            synchronized ( this ) {
                cache.put ( key, value ) ;
            }
            return value;
        }
        return value;
    }

    /**
     *
     * @param key to get vaue by
     * @return value to put in the cache
     */
    protected abstract V getValue ( K key ) ;

    private static class CacheLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private final int maxSize;

        public CacheLinkedHashMap ( int maxSize ) {
            // default load factor is 0.75
            super ( 0 , 0.75f , true ) ;
            this .maxSize = maxSize;
        }

        protected boolean removeEldestEntry ( Map.Entry eldest ) {
            return size () > maxSize;
        }
    }
    
    public static void main ( String [] args ) {
        MRUCache<String, String> cache = new MRUCache<String, String> ( 3 ) {
            protected String getValue ( String key ) {
                System.out.println ( key ) ;
                return key;
            }
        } ;
        cache.getValueFromCache ( "A" ) ;
        cache.getValueFromCache ( "B" ) ;
        cache.getValueFromCache ( "C" ) ;
        cache.getValueFromCache ( "D" ) ; // A will be removed from the cache
        cache.getValueFromCache ( "B" ) ; // B will be retrieved from the cache
        cache.getValueFromCache ( "A" ) ; // A will be added to the cache again
    }
}




