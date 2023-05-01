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
        return Math.abs(key.hashCode()%this.M);
    }
    public void put(K key, V value){
        int i=hash(key);
        HashNode<K,V> cursor=chainArray[i];
        HashNode<K,V> entry=new HashNode<>(key,value);
        if(cursor!=null){
            while(cursor.next!=null && cursor.key!=key){
                cursor=cursor.next;
            }
            if(cursor.key!=key){
                cursor.next=entry;
            }
            else{
                cursor=entry;
            }
        }
        else{
            chainArray[i]=entry;
        }
        this.size++;
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
        int i=hash(key);
        HashNode<K,V> cursor=chainArray[i];
        HashNode<K,V> prev=null;
        while(cursor!=null && cursor.key!=key){
            cursor=cursor.next;
        }
        if(cursor!=null){
            if(prev!=null){
                chainArray[i]=cursor.next;
            }
            else{
                prev.next=cursor.next;
            }
            this.size--;
        }
        else{
            return null;
        }
        return cursor.value;
    }
    public boolean contains(V value){
        for(int i=0;i<this.M;i++){
            HashNode<K,V> cursor=this.chainArray[i];
            while(cursor!=null){
                if(cursor.value.equals(value)){
                    return true;
                }
                cursor=cursor.next;
            }
        }
        return false;
    }
    public K getKey(V value){
        for(int i=0;i<this.M;i++){
            HashNode<K,V> cursor=this.chainArray[i];
            while(cursor!=null){
                if(cursor.value.equals(value)){
                    return cursor.key;
                }
                cursor=cursor.next;
            }
        }
        return null;
    }
    public void printBuckets(){
        for(int i=0;i<this.M;i++){
            HashNode<K,V> cursor=this.chainArray[i];
            while(cursor!=null){
                System.out.print(cursor.toString());
                cursor=cursor.next;
            }
            System.out.println();
        }
    }
    public int[] sizeOfBuckets(){
        int[] arr=new int[this.M];
        for(int i=0;i<this.M;i++){
            int len=0;
            HashNode<K,V> cursor=this.chainArray[i];
            while(cursor!=null){
                len++;
                cursor=cursor.next;
            }
            arr[i]=len;
        }
        return arr;
    }
}
