public class MyHashTable<K,V> {
    private class HashNode<K,V>{
        private K key;
        private V value;
        private HashNode<K,V> next;
        public HashNode(K key, V value){
            this.key=key;
            this.value=value;
        }
        @Override
        public String toString(){
            return "{"+key+" "+value+"}";
        }
    }
    private HashNode<K,V>[] chainArray;
    private int M;
    private int size;
    public MyHashTable(){
        this(11);
    }
    public MyHashTable(int M){
        this.M=M;
        this.chainArray=new HashNode[M];
        this.size=0;
    }
    public int hash(K key){
        return key.hashCode()%this.M;
    }
    public void put(K key, V value){

    }
    public V get(K key){
        int i=hash(key);
        HashNode<K,V> cursor = chainArray[i];
        while(cursor!=null && cursor.key!=key){
            cursor=cursor.next;
        }
        if(cursor==null){
            return null;
        }
        return cursor.value;
    }
    public V remove(K key){

    }
    public boolean contains(V value){

    }
    public K getKey(V value){

    }
}
